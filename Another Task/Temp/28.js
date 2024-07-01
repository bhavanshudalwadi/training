function longestPalindromicSubstring(s) {
    const transformedString = s.split('').join('#');
    const n = transformedString.length;

    const p = new Array(n).fill(0);
    let center = 0;
    let right = 0;

    for (let i = 1; i < n - 1; ++i) {
        const mirror = 2 * center - i;

        if (i < right) {
            p[i] = Math.min(right - i, p[mirror]);
        }

    
        let a = i + (1 + p[i]);
        let b = i - (1 + p[i]);

        while (transformedString[a] === transformedString[b]) {
            p[i]++;
            a++;
            b--;
        }

    
    
        if (i + p[i] > right) {
            center = i;
            right = i + p[i];
        }
    }


    let maxLen = 0;
    let centerIndex = 0;

    for (let i = 1; i < n - 1; ++i) {
        if (p[i] > maxLen) {
            maxLen = p[i];
            centerIndex = i;
        }
    }


    const start = Math.floor((centerIndex - maxLen) / 2);
    return s.slice(start, start + maxLen);
}

const inputString = "babad";
console.log(longestPalindromicSubstring(inputString));
