import 'package:flutter/material.dart';
import 'package:flutter_api_calls/customWidgets/photo_widget.dart';
import 'package:flutter_api_calls/service/apiService.dart';

class PhotoScreen extends StatelessWidget {
  const PhotoScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: const Text("Photos"),
      ),
      body: Center(
        child: FutureBuilder(
          future: ApiService().getAllPhotos(),
          builder: (context, snapshot) {
            if (snapshot.hasData) {
              return ListView.builder(
                itemBuilder: (context, index) {
                  return PhotoWidget(
                      id: snapshot.data![index].id,
                      albumId: snapshot.data![index].albumId,
                      title: snapshot.data![index].title,
                      url: snapshot.data![index].url,
                      thumbnailUrl: snapshot.data![index].thumbnailUrl);
                },
              );
            }

            if (snapshot.hasError) {
              return const Text("Unable to fetch data! Try again later");
            }

            return const CircularProgressIndicator();
          },
        ),
      ),
    );
  }
}
