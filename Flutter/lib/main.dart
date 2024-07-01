import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:reasonable_store/auth/login_screen.dart';
import 'package:reasonable_store/fragments/dashboard_fragment.dart';
import 'package:reasonable_store/user_preferences/user_preferences.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Reasonable Store',
      theme: ThemeData(
        primarySwatch: Colors.lightGreen,
      ),
      home: FutureBuilder(
        future: UserPrefs.readUser(),
        builder: (context, dataSnapShot) {
          if(dataSnapShot.data == null) {
            return LogIn();
          }else {
            return DashboardFragment();
          }
        },
      ),
    );
  }
}
