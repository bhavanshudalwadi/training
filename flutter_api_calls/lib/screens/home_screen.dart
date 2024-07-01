import 'package:flutter/material.dart';
import 'package:flutter_api_calls/screens/album_screen.dart';
import 'package:flutter_api_calls/screens/getx_snackbar.dart';
import 'package:flutter_api_calls/screens/photo_screen.dart';
import 'package:flutter_api_calls/screens/todo_screen.dart';
import 'package:flutter_api_calls/screens/user_screen.dart';
import 'package:get/get.dart';

import 'comments_screen.dart';
import 'local_album_screen.dart';
import 'posts_screen.dart';

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          backgroundColor: Theme.of(context).colorScheme.inversePrimary,
          title: Text(widget.title),
        ),
        drawer: Drawer(
          child: Column(
            children: [
              const DrawerHeader(
                  child: Column(
                children: [
                  Text("Jainil Dalwadi"),
                  CircleAvatar(
                    foregroundImage: NetworkImage(
                        "https://playcontestofchampions.com/wp-content/uploads/2021/11/champion-iron-man-infinity-war-720x720.jpg"),
                    maxRadius: 45,
                  )
                ],
              )),
              ListTile(
                leading: const Icon(Icons.post_add),
                title: const Text("Posts"),
                subtitle: const Text("100 Posts"),
                onTap: () {
                  Navigator.push(
                      context,
                      MaterialPageRoute(
                          builder: (context) => const PostsScreen()));
                },
              ),
              ListTile(
                leading: const Icon(Icons.comment),
                title: const Text("Comments"),
                subtitle: const Text("500 Comments"),
                onTap: () {
                  Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => const CommentsScreen(),
                      ));
                },
              ),
              ListTile(
                leading: const Icon(Icons.photo_album_outlined),
                title: const Text("Album"),
                subtitle: const Text("100 Albums"),
                onTap: () {
                  Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => const AlbumScreen(),
                      ));
                },
              ),
              ListTile(
                leading: const Icon(Icons.photo_size_select_actual_outlined),
                title: const Text("Photos"),
                subtitle: const Text("5000 Photos"),
                onTap: () {
                  Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => const PhotoScreen(),
                      ));
                },
              ),
              ListTile(
                leading: const Icon(Icons.calendar_today_outlined),
                title: const Text("Todos"),
                subtitle: const Text("200 Todos"),
                onTap: () {
                  Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => const TodoScreen(),
                      ));
                },
              ),
              ListTile(
                leading: const Icon(Icons.person),
                title: const Text("Users"),
                subtitle: const Text("10 Users"),
                onTap: () {
                  Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => const UserScreen(),
                      ));
                },
              ),
              ListTile(
                leading: const Icon(Icons.photo_album_outlined),
                title: const Text("Local Album"),
                subtitle: const Text("100 Albums"),
                onTap: () {
                  Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => const LocalAlbumScreen(),
                      ));
                },
              ),
              const Divider(),
              const Text(
                "GetX Usage",
                style: TextStyle(
                    fontSize: 15,
                    fontWeight: FontWeight.bold,
                    color: Colors.black54),
              ),
              ListTile(
                leading: const Icon(Icons.photo_album_outlined),
                title: const Text("Getx Snackbar Demo"),
                onTap: () {
                  Get.to(const GetxSnackbarScreen());
                },
              ),
              ListTile(
                leading: const Icon(Icons.photo_album_outlined),
                title: const Text("Getx Controller Demo"),
                onTap: () {
                  Get.toNamed("/screen1");
                },
              ),
            ],
          ),
        ),
        body: const Center(
          child: Text("API Calls"),
        ));
  }
}
