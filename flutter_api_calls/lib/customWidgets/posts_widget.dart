import 'package:flutter/material.dart';

class PostWidget extends StatelessWidget {
  const PostWidget(
      {super.key,
      required this.userId,
      required this.id,
      required this.title,
      required this.body});

  final num? userId;
  final num? id;
  final String? title;
  final String? body;

  @override
  Widget build(BuildContext context) {
    return Card(
      child: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text("User Id : $userId"),
            Text("Id : $id"),
            Text("Title : $title"),
            Text("Body : $body")
          ],
        ),
      ),
    );
  }
}
