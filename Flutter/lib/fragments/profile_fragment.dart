import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:reasonable_store/auth/login_screen.dart';
import 'package:reasonable_store/controllers/user_controller.dart';
import 'package:reasonable_store/user_preferences/user_preferences.dart';
import 'package:reasonable_store/utils/colors.dart';

class ProfileFragment extends StatelessWidget {
  // const ProfileFragment({super.key});

  final UserController _user = Get.put(UserController());

  final List _optionProperties = [
    {"icon": Icons.location_on_rounded, "label": "Address"},
    {
      "icon": Icons.favorite_rounded,
      "label": "My Wishlist",
    },
    {
      "icon": Icons.people_rounded,
      "label": "About Us",
    },
    {
      "icon": Icons.star_rounded,
      "label": "Rate this app",
    },
    {
      "icon": Icons.logout_rounded,
      "label": "Log out",
    }
  ];

  logoutUser() async {
    var res = await Get.dialog(
      AlertDialog(
        backgroundColor: Colors.white,
        title: Text(
          "Logout",
          style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
        ),
        content: Text("Are you sure?\nYou want to logout?"),
        actions: [
          TextButton(onPressed: () => Get.back(), child: Text("No")),
          TextButton(
              onPressed: () => Get.back(result: "logout"), child: Text("Yes"))
        ],
      ),
    );
    if (res == "logout") {
      UserPrefs.removeUser().then((value) => Get.off(LogIn()));
    }
  }

  @override
  Widget build(BuildContext context) {
    Size s = MediaQuery.of(context).size;

    final List<Function> _optionActions = [
      logoutUser,
      logoutUser,
      logoutUser,
      logoutUser,
      logoutUser,
    ];

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
            child: Column(
          children: [
            ListTile(
              contentPadding:
                  EdgeInsets.symmetric(vertical: 50, horizontal: 16),
              leading: CircleAvatar(
                maxRadius: 35,
              ),
              title: Text(
                _user.user.name,
                style: TextStyle(fontSize: 20),
              ),
              subtitle: Text(
                _user.user.email,
                style: TextStyle(fontSize: 15),
              ),
              trailing: IconButton(
                onPressed: () {},
                icon: Icon(Icons.settings),
              ),
            ),
            Container(
              height: s.height * 0.5,
              child: Padding(
                padding: const EdgeInsets.all(16.0),
                child: Card(
                    elevation: 3,
                    child: ListView.separated(
                        itemCount: _optionProperties.length,
                        separatorBuilder: (context, index) => Divider(
                              height: 1,
                            ),
                        itemBuilder: (BuildContext context, int index) {
                          return ListTile(
                            onTap: () {
                              _optionActions[index]();
                            },
                            contentPadding: EdgeInsets.symmetric(
                              vertical: 10,
                              horizontal: 20,
                            ),
                            title: Text(
                              _optionProperties[index]["label"],
                              style: TextStyle(fontSize: 18),
                            ),
                            leading: Icon(_optionProperties[index]["icon"]),
                            trailing:
                                _optionProperties[index]["label"] != "Log out"
                                    ? Icon(
                                        Icons.arrow_forward_ios_rounded,
                                        size: 20,
                                      )
                                    : null,
                          );
                        })
                    // Column(
                    //   children: [
                    //     ListTile(
                    //       onTap: () {},
                    //       contentPadding: EdgeInsets.symmetric(vertical: 10, horizontal: 20),
                    //       title: Text("Address", style: TextStyle(fontSize: 18),),
                    //       leading: Icon(Icons.location_on_rounded),
                    //       trailing: Icon(Icons.arrow_forward_ios_rounded, size: 20,),
                    //     ),
                    //     Divider(height: 2, thickness: 1,),
                    //     ListTile(
                    //       onTap: () {},
                    //       contentPadding: EdgeInsets.symmetric(vertical: 10, horizontal: 20),
                    //       title: Text("My Wishlist", style: TextStyle(fontSize: 18),),
                    //       leading: Icon(Icons.location_on_rounded),
                    //       trailing: Icon(Icons.arrow_forward_ios_rounded, size: 20,),
                    //     ),
                    //     Divider(height: 2, thickness: 1,),
                    //     ListTile(
                    //       onTap: () {},
                    //       contentPadding: EdgeInsets.symmetric(vertical: 10, horizontal: 20),
                    //       title: Text("About Us", style: TextStyle(fontSize: 18),),
                    //       leading: Icon(Icons.location_on_rounded),
                    //       trailing: Icon(Icons.arrow_forward_ios_rounded, size: 20,),
                    //     ),
                    //     Divider(height: 2, thickness: 1,),
                    //     ListTile(
                    //       onTap: () {},
                    //       contentPadding: EdgeInsets.symmetric(vertical: 10, horizontal: 20),
                    //       title: Text("Rate this app", style: TextStyle(fontSize: 18),),
                    //       leading: Icon(Icons.location_on_rounded),
                    //       trailing: Icon(Icons.arrow_forward_ios_rounded, size: 20,),
                    //     ),
                    //     Divider(height: 2, thickness: 1,),
                    //     ListTile(
                    //       onTap: () {},
                    //       contentPadding: EdgeInsets.symmetric(vertical: 10, horizontal: 20),
                    //       title: Text("Log out", style: TextStyle(fontSize: 18),),
                    //       leading: Icon(Icons.location_on_rounded),
                    //       trailing: Icon(Icons.arrow_forward_ios_rounded, size: 20,),
                    //     ),
                    //   ],
                    // ),
                    ),
              ),
            )
          ],
        )),
      ),
    );
  }
}
