import 'package:flutter/material.dart';
import 'package:flutter_api_calls/getxControllers/post_controller.dart';
import 'package:flutter_api_calls/screens/getx_screen2.dart';
import 'package:get/get.dart';

class GetxScreen1 extends StatelessWidget {
  const GetxScreen1({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Controller, Obs, Obx Demo"),
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Obx(
              () {
                print("called obx");
                return Text(PostController.text.toString());
              },
            ),
            ElevatedButton(
                onPressed: () => Get.to(GetxScreen2()),
                child: const Text("Screen 2"))
          ],
        ),
      ),
    );
  }
}
