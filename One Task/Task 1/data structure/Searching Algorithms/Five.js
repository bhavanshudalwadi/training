function search(nums, x) {
    let low = 0;
    let high = nums.length - 1;     // 5 = 6 - 1
    let delta = -1;

    if(x < nums[low] || x > nums[high]) {       //18 < 5 || 18 > 27 ==> false
        return -1;
    }

    while (low < high) {                                        // 0 < 5  true                                      3 < 5        
        delta = (x - nums[low]) / (nums[high] - nums[low]);     // 0.59 = (18 - 5) / (27 - 5)                       0 = (18 - 18) / (27 - 18)
        index = low + Math.floor((high - low) * delta);         // 2 = 0 + Math.floor(5 * 0.59)  =>  2 = 0 + 2.95   3 = 3 + Math.floor(2 * 0)  => 3 = 3 + 0

        if (nums[index] === x) {
            return index;                                                                                         // 3
        }else if(nums[index] < x) {
            low = index + 1;                                    // 3 = 2 + 1
        } else {
            high = index - 1;
        }
    }

    return -1;
}

const nums = [5, 10, 14, 18, 22, 27];
console.log(search(nums, 18));