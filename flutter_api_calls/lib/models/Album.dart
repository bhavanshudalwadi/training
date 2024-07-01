/// userId : 1
/// id : 1
/// title : "quidem molestiae enim"
import 'package:hive/hive.dart';

part 'Album.g.dart';

@HiveType(typeId: 0)
class Album extends HiveObject {
  Album({
    num? userId,
    num? id,
    String? title,
  }) {
    _userId = userId;
    _id = id;
    _title = title;
  }

  Album.fromJson(dynamic json) {
    _userId = json['userId'];
    _id = json['id'];
    _title = json['title'];
  }

  @HiveField(0)
  num? _userId;

  @HiveField(1)
  num? _id;

  @HiveField(2)
  String? _title;

  Album copyWith({
    num? userId,
    num? id,
    String? title,
  }) =>
      Album(
        userId: userId ?? _userId,
        id: id ?? _id,
        title: title ?? _title,
      );
  num? get userId => _userId;
  num? get id => _id;
  String? get title => _title;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['userId'] = _userId;
    map['id'] = _id;
    map['title'] = _title;
    return map;
  }
}
