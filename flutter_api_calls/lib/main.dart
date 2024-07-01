import 'package:flutter/material.dart';
import 'package:flutter_api_calls/models/Album.dart';
import 'package:flutter_api_calls/screens/album_screen.dart';
import 'package:flutter_api_calls/screens/comments_screen.dart';
import 'package:flutter_api_calls/screens/getx_screen1.dart';
import 'package:flutter_api_calls/screens/getx_screen2.dart';
import 'package:flutter_api_calls/screens/getx_snackbar.dart';
import 'package:flutter_api_calls/screens/home_screen.dart';
import 'package:flutter_api_calls/screens/photo_screen.dart';
import 'package:flutter_api_calls/screens/posts_screen.dart';
import 'package:flutter_api_calls/screens/todo_screen.dart';
import 'package:flutter_api_calls/screens/user_screen.dart';
import 'package:get/get.dart';
import 'package:hive/hive.dart';
import 'package:path_provider/path_provider.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  var directory = await getApplicationDocumentsDirectory();
  Hive.init(directory.path);

  Hive.registerAdapter(AlbumAdapter());

  await Hive.openBox<Album>('albums');

  runApp(const MyApp());
}

//Main Screen with drawer
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      title: 'Flutter API Calls',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.blueAccent),
        useMaterial3: true,
      ),
      home: MyHomePage(title: "Api Cakks"),
      initialRoute: '/home',
      unknownRoute: GetPage(
          name: '/notfound',
          page: () => const UnknownRouteScreen()), //like 404 page in web
      getPages: [
        GetPage(
            name: '/home', page: () => const MyHomePage(title: "Api Calls")),
        GetPage(name: '/album', page: () => const AlbumScreen()),
        GetPage(name: '/comment', page: () => const CommentsScreen()),
        GetPage(name: '/post', page: () => const PostsScreen()),
        GetPage(name: '/photo', page: () => const PhotoScreen()),
        GetPage(name: '/todo', page: () => const TodoScreen()),
        GetPage(name: '/user', page: () => const UserScreen()),
        GetPage(name: '/snackbar', page: () => const GetxSnackbarScreen()),
        GetPage(
            name: '/screen1',
            page: () => const GetxScreen1(),
            transition: Transition.fadeIn),
        GetPage(
            name: '/screen2',
            page: () => GetxScreen2(),
            transition: Transition.fadeIn,
            transitionDuration: Duration(seconds: 2)),
      ],
    );
  }
}

class UnknownRouteScreen extends StatelessWidget {
  const UnknownRouteScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: Center(
        child: Text("Unknown Page"),
      ),
    );
  }
}
