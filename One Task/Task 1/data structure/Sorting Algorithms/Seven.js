let arr = [5, 7, 5, 2, 1, 1];

let cnt = new Array(Math.max(...arr)+1).fill(0);
// 0 1 2 3 4 5 6 7
// 0 2 1 0 0 2 0 1

for(var i=0; i<arr.length; i++) {
   cnt[arr[i]]++;
}

for(var i=0; i<cnt.length; i++) {
   if(cnt[i] != 0) {
      for(var j=0; j<cnt[i]; j++) {
         console.log(i);
      }
   }
}