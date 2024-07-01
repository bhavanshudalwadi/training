import 'dart:convert';

import 'package:reasonable_store/models/user.dart';
import 'package:shared_preferences/shared_preferences.dart';

class UserPrefs {
  static Future<void> rememberUser(User userInfo) async {
    SharedPreferences preferences = await SharedPreferences.getInstance();
    String json = jsonEncode(userInfo.toFullJson());
    await preferences.setString("user", json);
  }

  static Future<User?> readUser() async {
    User? user;
    SharedPreferences preferences = await SharedPreferences.getInstance();
    String? json = preferences.getString("user");
    if (json != null) {
      Map<String, dynamic> userInfo = jsonDecode(json);
      user = User.fromJson(userInfo);
    }
    return user;
  }

  static Future<void> removeUser() async {
    SharedPreferences preferences = await SharedPreferences.getInstance();
    await preferences.remove("user");
  }
}
