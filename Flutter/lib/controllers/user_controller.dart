import 'package:get/get.dart';
import 'package:reasonable_store/models/user.dart';
import 'package:reasonable_store/user_preferences/user_preferences.dart';

class UserController extends GetxController {
  Rx<User> _user = User(name: '', email: '').obs;

  User get user => _user.value;

  getUserInfo() async {
    User? localUser = await UserPrefs.readUser();
    _user.value = localUser!;
  }
}