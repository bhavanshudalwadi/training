let str = "banana";
let arr = [];

for(let i=0; i<str.length; i++) {
    arr.push({ id: i, str: str.substring(i, str.length) });
}

arr.sort((a, b) => a.str.localeCompare(b.str));

console.log(arr);