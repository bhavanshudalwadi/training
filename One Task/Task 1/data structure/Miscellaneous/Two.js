let str = "maam";

if(str == str.split('').reverse().join('')) {
    console.log("String is palindrom");
}else{
    console.log("String is not palindrom");
}