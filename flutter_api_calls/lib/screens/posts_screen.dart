import 'package:flutter/material.dart';
import 'package:flutter_api_calls/customWidgets/posts_widget.dart';
import 'package:flutter_api_calls/models/Post.dart';
import 'package:flutter_api_calls/service/apiService.dart';

class PostsScreen extends StatefulWidget {
  const PostsScreen({super.key});

  @override
  State<PostsScreen> createState() => _PostsScreenState();
}

class _PostsScreenState extends State<PostsScreen> {
  List<Post>? _postsList;

  @override
  void initState() {
    super.initState();
  }

  // Future getPosts() async {
  //   _postsList = await ApiService().getAllPosts();
  //
  //   setState(() {});
  // }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: const Text("Posts"),
      ),
      body: Center(
        child: FutureBuilder(
          future: ApiService().getAllPosts(),
          builder: (context, snapshot) {
            if (snapshot.hasData) {
              return ListView.separated(
                  itemBuilder: (context, index) {
                    return Container(
                      margin: const EdgeInsets.all(8),
                      child: PostWidget(
                          userId: snapshot.data![index].userId,
                          id: snapshot.data![index].id,
                          title: snapshot.data![index].title,
                          body: snapshot.data![index].body),
                    );
                  },
                  separatorBuilder: (context, index) => Divider(),
                  itemCount: snapshot.data!.length);
            }

            if (snapshot.hasError) {
              return Text("Unable to fetch data! Try again later");
            }

            return CircularProgressIndicator();
          },
        ),
      ),
    );
  }
}
