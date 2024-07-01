import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:reasonable_store/apis/api_connection.dart';
import 'package:reasonable_store/auth/login_screen.dart';
import 'package:reasonable_store/utils/colors.dart';
import 'package:http/http.dart' as http;
import '../models/user.dart';

class SignUp extends StatelessWidget {
  // const SignUp({super.key});

  var formKey = GlobalKey<FormState>();
  var nameController = TextEditingController();
  var emailController = TextEditingController();
  var passwordController = TextEditingController();
  var isObscure = true.obs;

  addUser() async {
    User user = User(
      name: nameController.text.trim(),
      email: emailController.text.trim(),
      password: passwordController.text.trim(),
    );

    try {
      var res = await http.post(Uri.parse(API.signUp), body: user.toJson());

      if (res.statusCode == 200) {
        var resBody = jsonDecode(res.body);
        if (resBody['success'] == true) {
          Get.to(LogIn());
          Get.snackbar(
            "Successful",
            resBody['msg'],
            snackPosition: SnackPosition.TOP,
            colorText: Colors.white,
            borderRadius: 10,
            backgroundColor: Colors.green,
          );
          nameController.clear();
          emailController.clear();
          passwordController.clear();
        }else {
          Get.snackbar(
            "Failed",
            resBody['msg'],
            snackPosition: SnackPosition.TOP,
            colorText: Colors.white,
            borderRadius: 10,
            backgroundColor: Colors.deepOrange,
          );
        }
      }
    } catch (e) {
      print("Error :: $e");
      Get.snackbar(
        "Failed",
        "Something wants wrong",
        snackPosition: SnackPosition.TOP,
        colorText: Colors.white,
        borderRadius: 10,
        backgroundColor: Colors.deepOrange,
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    Size s = MediaQuery.of(context).size;

    return Scaffold(
      body: Container(
        decoration: BoxDecoration(
          gradient: LinearGradient(
            colors: [
              bgColor2,
              bgColor2,
              bgColor4,
            ],
          ),
        ),
        child: SafeArea(
          child: Padding(
            padding: const EdgeInsets.all(33.0),
            child: ListView(
              children: [
                sizeBox3(s),
                Text(
                  "Create\nyour account",
                  textAlign: TextAlign.left,
                  style: TextStyle(
                    fontWeight: FontWeight.bold,
                    fontSize: 25,
                    color: txtColor1,
                    height: 1.5,
                  ),
                ),
                sizeBox4(s),
                Form(
                  key: formKey,
                  child: Column(
                    children: [
                      myTextField(
                        "Name",
                        nameController,
                        "text",
                        false,
                      ),
                      myTextField(
                        "Email address",
                        emailController,
                        "text",
                        false,
                      ),
                      Obx(
                        () => myTextField(
                          "Password",
                          passwordController,
                          "password",
                          isObscure.value,
                        ),
                      ),
                      Align(
                        alignment: Alignment.centerRight,
                        child: Text(
                          "Forgot Password?",
                          textAlign: TextAlign.right,
                          style: TextStyle(
                            fontSize: 12,
                            color: txtColor1,
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
                sizeBox4(s),
                InkWell(
                  onTap: () {
                    if(formKey.currentState!.validate()) {
                      addUser();
                    }
                  },
                  child: Container(
                    width: s.width,
                    padding: const EdgeInsets.symmetric(vertical: 15),
                    decoration: BoxDecoration(
                      color: btnColor,
                      borderRadius: BorderRadius.circular(15),
                    ),
                    child: const Center(
                      child: Text(
                        "SIGN UP",
                        style: TextStyle(
                          fontWeight: FontWeight.bold,
                          color: Colors.white,
                          fontSize: 16,
                        ),
                      ),
                    ),
                  ),
                ),
                sizeBox4(s),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Container(
                      height: 2,
                      width: s.width * 0.2,
                      color: Colors.black12,
                    ),
                    Text(
                      "   Or continue with   ",
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        color: txtColor2,
                        fontSize: 16,
                      ),
                    ),
                    Container(
                      height: 2,
                      width: s.width * 0.2,
                      color: Colors.black12,
                    )
                  ],
                ),
                sizeBox4(s),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    socialIcon("images/google.png"),
                    socialIcon("images/apple.png"),
                    socialIcon("images/facebook.png"),
                  ],
                ),
                sizeBox4(s),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text(
                      "Already have account?",
                      style: TextStyle(
                        color: txtColor2,
                        fontWeight: FontWeight.bold,
                        fontSize: 15,
                      ),
                    ),
                    TextButton(
                      onPressed: () {
                        Get.to(LogIn());
                      },
                      child: const Text(
                        "Log In",
                        style: TextStyle(
                          color: Colors.blue,
                          fontWeight: FontWeight.bold,
                          fontSize: 15,
                        ),
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  SizedBox sizeBox4(Size s) {
    return SizedBox(height: s.height * 0.04);
  }

  SizedBox sizeBox3(Size s) {
    return SizedBox(height: s.height * 0.03);
  }

  Container socialIcon(String image) {
    return Container(
      padding: EdgeInsets.symmetric(horizontal: 32, vertical: 12),
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(12),
        border: Border.all(color: Colors.white, width: 2),
      ),
      child: Image.asset(
        image,
        height: 35,
      ),
    );
  }

  Container myTextField(String hint, TextEditingController controller,
      String inputType, bool obscure) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 0, vertical: 15),
      child: TextFormField(
        obscureText: obscure,
        controller: controller,
        validator: (val) => val == "" ? "Please Enter ${hint}" : null,
        decoration: InputDecoration(
          contentPadding:
              const EdgeInsets.symmetric(horizontal: 15, vertical: 15),
          fillColor: Colors.white,
          filled: true,
          border: OutlineInputBorder(
            borderSide: BorderSide.none,
            borderRadius: BorderRadius.circular(15),
          ),
          hintText: hint,
          hintStyle: const TextStyle(
            color: Colors.black45,
            fontSize: 19,
          ),
          suffixIcon: inputType == "password"
              ? Obx(
                  () => GestureDetector(
                    onTap: () {
                      isObscure.value = !isObscure.value;
                    },
                    child: Icon(
                      isObscure.value
                          ? Icons.visibility_off_outlined
                          : Icons.visibility_outlined,
                      color: Colors.black12,
                    ),
                  ),
                )
              : null,
        ),
      ),
    );
  }
}
