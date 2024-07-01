class User {
  int? id;
  String name;
  String email;
  String? password;
  String? timestamp;

  User({
    this.id,
    required this.name,
    required this.email,
    this.password,
    this.timestamp,
  });

  factory User.fromJson(Map<String, dynamic> json) {
    return User(
      id: json["id"],
      name: json["name"],
      email: json["email"],
      password: json["password"],
      timestamp: json["timestamp"] ?? "",
    );
  }

  Map<String, dynamic> toJson() => {
    'name': name,
    'email': email,
    'password': password,
  };

  Map<String, dynamic> toFullJson() => {
    'id': id,
    'name': name,
    'email': email,
    'password': password,
    'timestamp': timestamp,
  };
}
