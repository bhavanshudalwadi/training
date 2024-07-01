function countChange(amount, coins) {
    const dp = new Array(amount + 1).fill(0);
    dp[0] = 1;

    for (const coin of coins) {
        for (let i = coin; i <= amount; i++) {
            dp[i] += dp[i - coin];
        }
    }

    return dp[amount];
}

const amount = 5;
const coins = [1, 2, 5];

const ways = countChange(amount, coins);

console.log(`Number of ways to make change for ${amount} using coins ${coins}: ${ways}`);
