function isBuzzNumber(num) {
    return num % 7 === 0 || num % 10 === 7;
}

const number = 14;

console.log(isBuzzNumber(number));