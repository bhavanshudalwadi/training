import 'package:flutter/material.dart';
import 'package:get/get.dart';

class GetxSnackbarScreen extends StatelessWidget {
  const GetxSnackbarScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Getx Snackbar Demo"),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            ElevatedButton(
              onPressed: () {
                Get.snackbar(
                    "Getx Notification", "This is better then simple snackbar",
                    colorText: Colors.white,
                    backgroundColor: Colors.blueAccent,
                    icon: const Icon(Icons.notifications));
              },
              child: const Text("Snackbar"),
            )
          ],
        ),
      ),
    );
  }
}
