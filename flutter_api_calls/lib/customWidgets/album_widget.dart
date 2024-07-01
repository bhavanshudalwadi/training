import 'package:flutter/material.dart';

class AlbumWidget extends StatelessWidget {
  const AlbumWidget(
      {super.key, required this.id, required this.userId, required this.title});

  final num? id;
  final num? userId;
  final String? title;

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
          ],
        ),
      ),
    );
  }
}
