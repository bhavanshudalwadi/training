import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:reasonable_store/controllers/user_controller.dart';
import 'package:reasonable_store/fragments/favorites_fragment.dart';
import 'package:reasonable_store/fragments/home_fragment.dart';
import 'package:reasonable_store/fragments/orders_fragment.dart';
import 'package:reasonable_store/fragments/profile_fragment.dart';

class DashboardFragment extends StatelessWidget {
  // const DashboardFragment({super.key});

  UserController _user = Get.put(UserController());

  List<Widget> _fragmentScreens = [
    HomeFragment(),
    FavoritesFragment(),
    OrdersFragment(),
    ProfileFragment()
  ];

  List _navigationButtonProperties = [
    {
      "active_icon": Icons.home_rounded,
      "non_active_icon": Icons.home_outlined,
      "label": "Home",
    },
    {
      "active_icon": Icons.favorite_rounded,
      "non_active_icon": Icons.favorite_border_rounded,
      "label": "Favorites",
    },
    {
      "active_icon": Icons.view_list_rounded,
      "non_active_icon": Icons.view_list_outlined,
      "label": "Orders",
    },
    {
      "active_icon": Icons.person,
      "non_active_icon": Icons.person_outline,
      "label": "Profile",
    }
  ];

  RxInt _navIndex = 0.obs;

  @override
  Widget build(BuildContext context) {
    return GetBuilder(
      init: UserController(),
      initState: (currentState) {
        _user.getUserInfo();
      },
      builder: (controller) {
        return Scaffold(
          body: SafeArea(
            child: Obx(() => _fragmentScreens[_navIndex.value]),
          ),
          bottomNavigationBar: Obx(
            () => Container(
              decoration: BoxDecoration(
                borderRadius: BorderRadius.only(
                    topRight: Radius.circular(30),
                    topLeft: Radius.circular(30)),
                boxShadow: [
                  BoxShadow(
                      color: Colors.black38, spreadRadius: 0, blurRadius: 3),
                ],
              ),
              child: ClipRRect(
                borderRadius: BorderRadius.only(
                  topLeft: Radius.circular(30.0),
                  topRight: Radius.circular(30.0),
                ),
                child: BottomNavigationBar(
                  currentIndex: _navIndex.value,
                  onTap: (value) {
                    _navIndex.value = value;
                  },
                  showSelectedLabels: true,
                  showUnselectedLabels: true,
                  selectedItemColor: Colors.black,
                  unselectedItemColor: Colors.black38,
                  items: List.generate(_fragmentScreens.length, (index) {
                    var navBtnProperty = _navigationButtonProperties[index];
                    return BottomNavigationBarItem(
                      backgroundColor: Colors.white,
                      icon: Icon(navBtnProperty["non_active_icon"]),
                      activeIcon: Icon(navBtnProperty["active_icon"]),
                      label: navBtnProperty["label"],
                    );
                  }),
                ),
              ),
            ),
          ),
        );
      },
    );
  }
}
