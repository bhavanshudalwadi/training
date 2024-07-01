import 'package:flutter/material.dart';

class Screen1 extends StatelessWidget {
  // const Screen1({super.key});

  List list = [
    {"name": "Bhavanshu", "age": 34, "desc": "He is cool guy"},
    {"name": "Jainil", "age": 89, "desc": "He is cool guy"},
    {"name": "Henil", "age": 20, "desc": "He is cool guy"},
    {"name": "Deep", "age": 10, "desc": "He is cool guy"},
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text("Screen 1"),
      ),
      body: ListView.builder(
          itemCount: list.length,
          itemBuilder: (context, index) {
            return ListTile(
              leading: ExcludeSemantics(
                child: ClipRRect(
                  child: Image.network("https://picsum.photos/250?image=9"),
                  borderRadius: BorderRadius.circular(30),
                ),
              ),
              title: Text(
                  list[index]["name"] + " " + list[index]["age"].toString()),
              subtitle: Text(list[index]["desc"]),
              trailing: const Icon(Icons.arrow_forward_ios_rounded),
            );
          }),
    );
  }
}
