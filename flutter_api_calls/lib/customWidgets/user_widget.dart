import 'package:flutter/material.dart';
import 'package:flutter_api_calls/models/User.dart';

class UserWidget extends StatelessWidget {
  const UserWidget({super.key, required this.user});

  /*
  {
    "id": 1,
    "name": "Leanne Graham",
    "username": "Bret",
    "email": "Sincere@april.biz",
    "address": {
      "street": "Kulas Light",
      "suite": "Apt. 556",
      "city": "Gwenborough",
      "zipcode": "92998-3874",
      "geo": {
        "lat": "-37.3159",
        "lng": "81.1496"
      }
    },
    "phone": "1-770-736-8031 x56442",
    "website": "hildegard.org",
    "company": {
      "name": "Romaguera-Crona",
      "catchPhrase": "Multi-layered client-server neural-net",
      "bs": "harness real-time e-markets"
    }
  },
   */

  final User? user;
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Card(
          child: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text("Id : ${user!.id}"),
            Text("Name : ${user!.name}"),
            Text("Username : ${user!.username}"),
            Text("Email : ${user!.email}"),
            Text(
                "Address : ${user!.address!.suite},${user!.address!.street}, ${user!.address!.city}, ${user!.address!.zipcode}"),
            Text("Lat : ${user!.address!.geo!.lat}"),
            Text("Lng : ${user!.address!.geo!.lng}"),
            Text("Phone : ${user!.phone}"),
            Text("Website : ${user!.website}"),
            Text(
                "Company : ${user!.company!.name} - ${user!.company!.catchPhrase} - ${user!.company!.bs}"),
          ],
        ),
      )),
    );
  }
}
