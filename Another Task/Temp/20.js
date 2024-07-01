function josephus(n, k) {
    let index = 0;

    for (let i = 2; i <= n; i++) {
        index = (index + k) % i;
    }

    return index + 1;
}

const survivorPosition = josephus(7, 1);
console.log(survivorPosition);

// 1 = (0 + 1) % 2
// 2 = (1 + 1) % 3
// 3 = (2 + 1) % 4
// 4 = (3 + 1) % 5
// 5 = (4 + 1) % 6
// 6 = (5 + 1) % 7

// Win = 6 + 1