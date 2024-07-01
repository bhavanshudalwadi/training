import 'package:flutter_api_calls/endPoints.dart';
import 'package:flutter_api_calls/models/Photo.dart';
import 'package:get/get.dart';
import 'package:http/http.dart' as http;

class PostController extends GetxController {
  static var text = "".obs;

  RxString getText() {
    return text;
  }

  void setText(String inputText) {
    text.value = inputText;
    print(text);
  }

  Future<List<Photo>> getAllPhotos() async {
    List<Photo> photos = [];
    try {
      var response = await http.get(Uri.parse(ApiCall.photosAll));
      if (response.statusCode == 200) {
        print(response.body);

        // for (var photo in response.body) {
        //   photos.add(Photo.fromJson(photo));
        // }
      } else {
        print("not called");
      }
    } catch (e) {
      print(e);
    }
    return photos;
  }
}
