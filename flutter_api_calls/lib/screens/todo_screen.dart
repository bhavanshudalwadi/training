import 'package:flutter/material.dart';
import 'package:flutter_api_calls/customWidgets/todo_widget.dart';
import 'package:flutter_api_calls/service/apiService.dart';

class TodoScreen extends StatefulWidget {
  const TodoScreen({super.key});

  @override
  State<TodoScreen> createState() => _TodoScreenState();
}

class _TodoScreenState extends State<TodoScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: const Text("Todos "),
      ),
      body: Center(
        child: FutureBuilder(
          future: ApiService().getAllTodos(),
          builder: (context, snapshot) {
            if (snapshot.hasData) {
              return ListView.builder(
                itemBuilder: (context, index) {
                  return TodoWidget(
                      userId: snapshot.data![index].userId,
                      id: snapshot.data![index].id,
                      title: snapshot.data![index].title,
                      completed: snapshot.data![index].completed);
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
