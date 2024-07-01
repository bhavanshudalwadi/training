function areAnagrams(word1, word2) {
    return word1.split('').sort().join('') === word2.split('').sort().join('');
}

function findAnagrams(inputWord, dictionary) {
    const anagrams = [];

    for (const word of dictionary) {
        if (areAnagrams(inputWord, word)) {
            anagrams.push(word);
        }
    }

    return anagrams;
}

// Example usage:

const dictionary = ["listen", "silent", "enlist", "tac", "cat", "act", "hello", "world"];
const inputWord = "silent";

const anagrams = findAnagrams(inputWord, dictionary);

console.log(`Anagrams of '${inputWord}':`);
console.log(anagrams);
