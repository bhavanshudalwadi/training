import 'package:flutter/material.dart';

class TodoWidget extends StatelessWidget {
  const TodoWidget(
      {super.key,
      required this.userId,
      required this.id,
      required this.title,
      required this.completed});

  final num? userId;
  final num? id;
  final String? title;
  final bool? completed;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Card(
          child: Container(
        decoration: BoxDecoration(
          color: (completed!) ? Colors.greenAccent : Colors.redAccent,
        ),
        child: Padding(
          padding: const EdgeInsets.all(8.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text("User Id : $userId"),
              Text("Id : $id"),
              Text("Title : $title"),
              Text("Status : ${(completed!) ? "Completed" : "Pending"} "),
            ],
          ),
        ),
      )),
    );
  }
}
