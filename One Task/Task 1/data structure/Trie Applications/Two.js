class TrieNode {
    constructor() {
        this.children = new Map();
        this.isEndOfWord = false;
    }
}

class Trie {
    constructor() {
        this.root = new TrieNode();
    }

    insert(word) {
        let node = this.root;

        for (const char of word) {
            if (!node.children.has(char)) {
                node.children.set(char, new TrieNode());
            }

            node = node.children.get(char);
        }

        node.isEndOfWord = true;
    }

    search(word) {
        let node = this.root;

        for (const char of word) {
            if (!node.children.has(char)) {
                return false; // Word not found
            }

            node = node.children.get(char);
        }

        return node.isEndOfWord;
    }

    suggestCorrections(prefix) {
        let node = this.root;

        for (const char of prefix) {
            if (!node.children.has(char)) {
                return []; // Prefix not found
            }

            node = node.children.get(char);
        }

        const suggestions = [];
        this._findAllWords(node, prefix, suggestions);
        return suggestions;
    }

    _findAllWords(node, currentWord, suggestions) {
        if (node.isEndOfWord) {
            suggestions.push(currentWord);
        }

        for (const [char, childNode] of node.children) {
            this._findAllWords(childNode, currentWord + char, suggestions);
        }
    }
}

// Example usage:

const spellChecker = new Trie();

// Build a dictionary
spellChecker.insert("apple");
spellChecker.insert("apricot");
spellChecker.insert("banana");
spellChecker.insert("bat");
spellChecker.insert("batman");

// Check if a word is spelled correctly
const wordToCheck = "aple";
const isSpelledCorrectly = spellChecker.search(wordToCheck);

console.log(`Is '${wordToCheck}' spelled correctly? ${isSpelledCorrectly ? 'Yes' : 'No'}`);

// Get suggestions for corrections
const misspelledWord = "aple";
const corrections = spellChecker.suggestCorrections(misspelledWord);

console.log(`Suggestions for corrections for '${misspelledWord}':`);
console.log(corrections);
