import 'package:flutter/material.dart';
import 'package:flutter_api_calls/customWidgets/user_widget.dart';
import 'package:flutter_api_calls/service/apiService.dart';

class UserScreen extends StatefulWidget {
  const UserScreen({super.key});

  @override
  State<UserScreen> createState() => _UserScreenState();
}

class _UserScreenState extends State<UserScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: const Text("Users"),
      ),
      body: Center(
        child: FutureBuilder(
          future: ApiService().getAllUsers(),
          builder: (context, snapshot) {
            if (snapshot.hasData) {
              return ListView.separated(
                  itemBuilder: (context, index) {
                    return UserWidget(user: snapshot.data![index]);
                  },
                  separatorBuilder: (context, index) => Divider(),
                  itemCount: snapshot.data!.length);
            }

            if (snapshot.hasError) {
              return const Text("Unable to fetch data! Try again later");
            }

            return const CircularProgressIndicator(
              color: Colors.blueAccent,
            );
          },
        ),
      ),
    );
  }
}
