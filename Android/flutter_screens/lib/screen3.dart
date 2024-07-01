import 'package:flutter/material.dart';
import 'package:flutter_screens/student.dart';

class Screen3 extends StatelessWidget {

  List<Student> list = [
    Student(name: "Bhavnshu Dalwadi", age: 21, img: "https://cdn.iconscout.com/icon/free/png-256/free-boy-avatar-4-1129037.png?f=webp"),
    Student(name: "Jainil Dalwadi", age: 21, img: "https://static.vecteezy.com/system/resources/previews/002/002/297/non_2x/beautiful-woman-avatar-character-icon-free-vector.jpg"),
    Student(name: "Henil Chimpani", age: 23, img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUOsi2NgD5X4AhZTlBe3abpNa25GDiDtSMa3tpmYh6XCBUn2ULSzYcODgpr2pEp-tX1Jk&usqp=CAU"),
    Student(name: "Deep Padsala", age: 78, img: "https://cdn.icon-icons.com/icons2/3708/PNG/512/girl_female_woman_person_people_avatar_icon_230018.png"),
    Student(name: "Chintu Panchal", age: 26, img: "https://cdn.icon-icons.com/icons2/1879/PNG/512/iconfinder-8-avatar-2754583_120515.png"),
  ];




  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text("Screen 3"),
      ),
      body: GridView.builder(itemCount: list.length, gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 2), itemBuilder: (context, index) {
        return Card(
          child: Stack(
            children: [
              Image.network('${list[index].img}',width: 250,height: 300),
              Positioned(
                bottom: 5,
                left: 5,
                child: Text('${list[index].name}',style: const TextStyle(fontWeight: FontWeight.bold, color: Colors.black)),
              ),
              Positioned(
                bottom: 5,
                right: 5,
                child: Text('${list[index].age}',style: TextStyle(fontWeight: FontWeight.bold,color: Colors.black)),
              ),
            ],
          ),
        );
      })
    );
  }
}
