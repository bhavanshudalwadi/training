void main() {
    var name = "Bhavanshu";
    print(name);
    print("My name is " + name);
    print("My name is $name");
    print("My name is ${name}");

    final age;          // run rime const
    age = 67;
    print(age);

    const age2 = 78;    // compile time const
    print(age2 + 10);
    print(age2 % 2);

    // types in dart
    String fname = "bhavanshu";
    print(fname);

    int val = 67;
    bool isTrue = true;
    double rate = val + 0;
    print(rate);

    int? newVal;        // type anotation
    print(newVal);

    // use of functions
    print(greet("Henil"));
    print(greet(55));

    final greeting = greetTwo("Chirag");
    print(greeting);
}

// functions in dart
greet(name) {
    return "Hello!, $name";
}

String greetTwo(String name) {
    return "Hello!, $name";
}

