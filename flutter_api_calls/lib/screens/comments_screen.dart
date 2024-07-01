import 'package:flutter/material.dart';
import 'package:flutter_api_calls/customWidgets/comment_widget.dart';
import 'package:flutter_api_calls/service/apiService.dart';

class CommentsScreen extends StatefulWidget {
  const CommentsScreen({super.key});

  @override
  State<CommentsScreen> createState() => _CommentsScreenState();
}

class _CommentsScreenState extends State<CommentsScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: const Text("Comments"),
      ),
      body: Center(
        child: FutureBuilder(
          future: ApiService().getAllComments(),
          builder: (context, snapshot) {
            if (snapshot.hasData) {
              return ListView.separated(
                  itemBuilder: (context, index) {
                    return Container(
                        margin: const EdgeInsets.all(8),
                        child: CommentWidget(
                          postId: snapshot.data![index].postId,
                          id: snapshot.data![index].id,
                          name: snapshot.data![index].name,
                          email: snapshot.data![index].email,
                          body: snapshot.data![index].body,
                        ));
                  },
                  separatorBuilder: (context, index) => Divider(),
                  itemCount: (snapshot.data!.length > 0) ? 50 : 0);
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
