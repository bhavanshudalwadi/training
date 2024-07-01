import 'package:flutter/material.dart';
import 'package:flutter_api_calls/getxControllers/post_controller.dart';
import 'package:get/get.dart';

class GetxScreen2 extends StatefulWidget {
  GetxScreen2({super.key});

  @override
  State<GetxScreen2> createState() => _GetxScreen2State();
}

class _GetxScreen2State extends State<GetxScreen2> {
  final _formKey = GlobalKey<FormState>();

  var textController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: const Text("Controller"),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Form(
                key: _formKey,
                child: Column(
                  children: [
                    Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: TextFormField(
                        controller: textController,
                        keyboardType: TextInputType.text,
                        decoration: const InputDecoration(
                            icon: Icon(Icons.message),
                            hintText: "Enter some text",
                            labelText: "Text",
                            border: OutlineInputBorder(
                                borderRadius:
                                    BorderRadius.all(Radius.circular(20)))),
                        validator: (value) {
                          if (value!.isEmpty) {
                            return "Empty String is not allowed";
                          }
                        },
                      ),
                    ),
                    ElevatedButton(
                        onPressed: () {
                          if (_formKey.currentState!.validate()) {
                            // try {
                            //   Get.snackbar(
                            //           "Text ", textController.text.toString(),
                            //           colorText: Colors.white,
                            //           backgroundColor: Colors.greenAccent)
                            //       .show();
                            // } catch (e) {
                            //   print(e);
                            // }

                            PostController()
                                .setText(textController.text.toString());
                            print("helo");
                            Get.back();
                          }
                        },
                        child: const Text("Change and route back"))
                  ],
                ))
          ],
        ),
      ),
    );
  }
}
