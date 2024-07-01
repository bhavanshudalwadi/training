function isSubsetSum(nums, sum) {
    const dp = new Array(sum + 1).fill(false);

    dp[0] = true;

    for (let i = 0; i < nums.length; i++) {
        for (let j = sum; j >= nums[i]; j--) {
            dp[j] = dp[j] || dp[j - nums[i]];
        }
    }

    return dp[sum];
}

const nums = [3, 34, 4, 12, 5, 2];
const sum = 9;
console.log(isSubsetSum(nums, sum));

// 0 0 0 0 0 0 0 0 0 0
// 1               9

// 9 8 7 6 5 4 3
// X 
