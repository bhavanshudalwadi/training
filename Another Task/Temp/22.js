let str1 = "bhavanshu";
let str2 = "dalwadhi";
let str3 = "chirag";

let res = "";

for(let i=0; i<str1.length; i++) {
    for(let j=0; j<str2.length; j++) {
        for(let k=0; k<str3.length; k++) {
            if((str1.charAt(i) === str2.charAt(j) && str1.charAt(i) == str3.charAt(k) && str2.charAt(j) == str3.charAt(k)) && !res.includes(str1.charAt(i))) {
                res += str1.charAt(i);
            }
        }
    }
}

console.log(res);