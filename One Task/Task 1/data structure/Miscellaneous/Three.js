let str = "bhavanshu";
let hashTbl = new Array(26).fill(0);

for(let i=0; i<str.length; i++) {
    console.log((str.charCodeAt(i) - 'a'.charCodeAt(0)) + " ");
    hashTbl[str.charCodeAt(i) - 'a'.charCodeAt(0)]++;
}

let max = Math.max(...hashTbl);

