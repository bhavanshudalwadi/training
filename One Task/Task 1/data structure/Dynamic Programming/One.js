function fibonacci(n) {
    var F = new Array(n);
    F[0] = 0;
    F[1] = 1;
    for (var i = 2; i < n; i++) {
        F[i] = F[i - 1] + F[i - 2];
        // F[2] = F[1] + F[0];
        // F[3] = F[2] + F[1];
    }
    console.log(F);
    return F[n-1];
}

var n = parseInt(10);
console.log("Required fibonacci number is " + fibonacci(n));