var arr1 = [12, 34, 67, 34, 89], arr2 = [34, 45, 89], ans = [];

arr1.filter(i => {
    var ele = arr2.find((item) => item === i);
    if(ele !== undefined) {
        if(ans.find((item) => item === ele) === undefined) {
            ans.push(ele);                        
        }
    }
})

console.log(ans);