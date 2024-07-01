import 'package:flutter_api_calls/models/Album.dart';
import 'package:hive/hive.dart';

//To get already opened box
class Boxes {
  static Box<Album> getAlbums() => Hive.box<Album>("albums");
}
