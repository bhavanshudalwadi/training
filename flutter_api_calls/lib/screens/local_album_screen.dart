import 'package:flutter/material.dart';
import 'package:flutter_api_calls/boxes/boxes.dart';
import 'package:flutter_api_calls/customWidgets/album_widget.dart';
import 'package:flutter_api_calls/models/Album.dart';
import 'package:hive_flutter/hive_flutter.dart';

class LocalAlbumScreen extends StatefulWidget {
  const LocalAlbumScreen({super.key});

  @override
  State<LocalAlbumScreen> createState() => _LocalAlbumScreenState();
}

class _LocalAlbumScreenState extends State<LocalAlbumScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          backgroundColor: Theme.of(context).colorScheme.inversePrimary,
          title: const Text("Albums "),
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.delete_forever_outlined),
          onPressed: () {
            if (Boxes.getAlbums().length != 0) {
              Boxes.getAlbums().clear();
              ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text("Deleted all data")));
            } else {
              ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text("No Data to delete")));
            }
          },
        ),
        body: ValueListenableBuilder<Box<Album>>(
          valueListenable: Boxes.getAlbums().listenable(),
          builder: (context, value, child) {
            if (Boxes.getAlbums().values.isEmpty) {
              return const Center(child: Text("Data is not available"));
            }

            return ListView.separated(
                itemBuilder: (context, index) {
                  return AlbumWidget(
                      id: value.getAt(index)!.id,
                      userId: value.getAt(index)!.userId,
                      title: value.getAt(index)!.title);
                },
                separatorBuilder: (context, index) => Divider(),
                itemCount: (value.length > 0 && value.length > 10) ? 10 : 0);
          },
        ));
  }
}
