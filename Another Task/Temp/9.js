function isHarshadNumber(num) {
    const digitsSum = num.toString().split('').reduce((cnt, digit) => cnt + parseInt(digit), 0);
    return num % digitsSum === 0;
}

const number = 18;

console.log(isHarshadNumber(number));

// 18 / 1+8
// 18 % 9 = 0