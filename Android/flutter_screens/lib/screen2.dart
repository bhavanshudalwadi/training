import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter_screens/product.dart';
import 'package:http/http.dart' as http;

class Screen2 extends StatelessWidget {
  List<Product> list = [];

  void fetchProducts() async {
    final apiUri = Uri.parse("https://dummyjson.com/products");
    final response = await http.get(apiUri);
    final body = response.body;
    list = jsonDecode(body)["products"];
  }

  Screen2() {
    fetchProducts();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text("Screen 2"),
      ),
      body: ListView.builder(
          itemCount: list.length,
          itemBuilder: (context, index) {
            return ListTile(
              leading: ExcludeSemantics(
                child: ClipRRect(
                  borderRadius: BorderRadius.circular(30),
                  child: Image.network(list[index].thumbnail!),
                ),
              ),
              title: Text("${list[index].brand!} ${list[index].title!}"),
              subtitle: Text("Category: ${list[index].category!}\n Description: ${list[index].description!}"),
              trailing: const Icon(Icons.arrow_forward_ios_rounded),
            );
          }),
    );
  }
}
