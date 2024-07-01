import 'package:dio/dio.dart';
import 'package:flutter_api_calls/endPoints.dart';
import 'package:flutter_api_calls/models/Album.dart';
import 'package:flutter_api_calls/models/Comment.dart';
import 'package:flutter_api_calls/models/Photo.dart';
import 'package:flutter_api_calls/models/Post.dart';
import 'package:flutter_api_calls/models/Todo.dart';
import 'package:flutter_api_calls/models/User.dart';

class ApiService {
  var dio;

  ApiService() {
    dio = Dio();
  }

  Future<List<Post>> getAllPosts() async {
    List<Post> posts = [];
    try {
      var response = await dio.get(ApiCall.postAll);
      if (response.statusCode == 200) {
        print(response.data);

        for (var post in response.data) {
          posts.add(Post.fromJson(post));
        }
      } else {
        print("not called");
      }
    } catch (e) {
      print(e);
    }
    return posts;
  }

  Future<List<Comment>> getAllComments() async {
    List<Comment> comments = [];
    try {
      var response = await dio.get(ApiCall.commentAll);
      if (response.statusCode == 200) {
        print(response.data);

        for (var comment in response.data) {
          comments.add(Comment.fromJson(comment));
        }
      } else {
        print("not called");
      }
    } catch (e) {
      print(e);
    }
    return comments;
  }

  Future<List<Album>> getAllAlbums() async {
    List<Album> albums = [];
    try {
      var response = await dio.get(ApiCall.albumAll);
      if (response.statusCode == 200) {
        // print(response.data);

        for (var album in response.data) {
          albums.add(Album.fromJson(album));
        }
      } else {
        print("not called");
      }
    } catch (e) {
      print(e);
    }
    return albums;
  }

  Future<List<Photo>> getAllPhotos() async {
    List<Photo> photos = [];
    try {
      var response = await dio.get(ApiCall.photosAll);
      if (response.statusCode == 200) {
        print(response.data);

        for (var photo in response.data) {
          photos.add(Photo.fromJson(photo));
        }
      } else {
        print("not called");
      }
    } catch (e) {
      print(e);
    }
    return photos;
  }

  Future<List<Todo>> getAllTodos() async {
    List<Todo> todos = [];
    try {
      var response = await dio.get(ApiCall.todoAll);
      if (response.statusCode == 200) {
        print(response.data);

        for (var todo in response.data) {
          todos.add(Todo.fromJson(todo));
        }
      } else {
        print("not called");
      }
    } catch (e) {
      print(e);
    }
    return todos;
  }

  Future<List<User>> getAllUsers() async {
    List<User> users = [];
    try {
      var response = await dio.get(ApiCall.userAll);
      if (response.statusCode == 200) {
        print(response.data);

        for (var user in response.data) {
          users.add(User.fromJson(user));
        }
      } else {
        print("not called");
      }
    } catch (e) {
      print(e);
    }
    return users;
  }
}
