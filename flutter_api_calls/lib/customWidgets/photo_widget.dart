import 'package:flutter/material.dart';

class PhotoWidget extends StatelessWidget {
  const PhotoWidget(
      {super.key,
      required this.id,
      required this.albumId,
      required this.title,
      required this.url,
      required this.thumbnailUrl});

  final num? id;
  final num? albumId;
  final String? title;
  final String? url;
  final String? thumbnailUrl;

  /*
   {
    "albumId": 1,
    "id": 1,
    "title": "accusamus beatae ad facilis cum similique qui sunt",
    "url": "https://via.placeholder.com/600/92c952",
    "thumbnailUrl": "https://via.placeholder.com/150/92c952"
  },

   */
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Card(
        shadowColor: Colors.blueAccent,
        elevation: 2,
        child: Padding(
          padding: const EdgeInsets.all(8.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text("Album Id : $albumId"),
              Text("Id : $id"),
              Text("Title : $title"),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: [
                  Column(
                    children: [
                      Text("Image :"),
                      SizedBox(
                        width: 150,
                        height: 150,
                        child: Image.network(url!),
                      ),
                    ],
                  ),
                  Column(
                    children: [
                      Text("Thumbnail:"),
                      SizedBox(
                        width: 50,
                        height: 50,
                        child: Image.network(thumbnailUrl!),
                      ),
                    ],
                  ),
                ],
              )
            ],
          ),
        ),
      ),
    );
  }
}
