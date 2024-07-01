function isPalindrome(str) {
    const cleanedStr = str.toLowerCase().replace(/[^a-z0-9]/g, '');
    console.log(cleanedStr);
    const reversedStr = cleanedStr.split('').reverse().join('');
    console.log(reversedStr);
    return cleanedStr === reversedStr;
}

const inputString = "A man, a plan, a canal, Panama!";

console.log(isPalindrome(inputString));