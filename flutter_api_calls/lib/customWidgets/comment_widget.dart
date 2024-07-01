import 'package:flutter/material.dart';

class CommentWidget extends StatelessWidget {
  const CommentWidget(
      {super.key,
      required this.postId,
      required this.id,
      required this.name,
      required this.email,
      required this.body});

  final num? postId;
  final num? id;
  final String? name;
  final String? email;
  final String? body;
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Card(
          child: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text("Post Id : $postId"),
            Text("Id : $id"),
            Text("name : $name"),
            Text("Email : $email"),
            Text("Body : $body"),
          ],
        ),
      )),
    );
  }
}
