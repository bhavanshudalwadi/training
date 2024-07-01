let str1 = "henil";
let str2 = "bhavanshu";
let res = "";

for(let i=0; i<str1.length; i++) {
    for(let j=0; j<str2.length; j++) {
        if((str1.charAt(i) === str2.charAt(j)) && !res.includes(str1.charAt(i))) {
            res += str1.charAt(i);
        }
    }
}

let max = Math.max(str1.length, str2.length);

console.log(max - res.length);