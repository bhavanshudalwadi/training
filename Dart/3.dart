import "dart:io";

void main() {
  int char = 'A'.codeUnitAt(0);

  for(int i=1; i<=5; i++) {
    for(int j=1; j<=i; j++) {
      stdout.write(String.fromCharCode(char) + " ");
      char++;
    }
    print('');
  }
}