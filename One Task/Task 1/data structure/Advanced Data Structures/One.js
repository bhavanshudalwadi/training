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
        let current = this.root;

        for (const char of word) {
            if (!current.children.has(char)) {
                current.children.set(char, new TrieNode());
            }

            current = current.children.get(char);
        }

        current.isEndOfWord = true;
    }

    search(word) {
        let current = this.root;

        for (const char of word) {
            if (!current.children.has(char)) {
                return false;
            }

            current = current.children.get(char);
        }

        return current.isEndOfWord;
    }

    startsWith(prefix) {
        let current = this.root;

        for (const char of prefix) {
            if (!current.children.has(char)) {
                return false;
            }

            current = current.children.get(char);
        }

        return true;
    }
}

// Example usage:

const trie = new Trie();

trie.insert("apple");
trie.insert("app");
trie.insert("apricot");

console.log("Search 'apple':", trie.search("apple")); // true
console.log("Search 'app':", trie.search("app"));     // true
console.log("Search 'apricot':", trie.search("apricot")); // true
console.log("Search 'orange':", trie.search("orange")); // false

console.log("\nStarts with 'ap':", trie.startsWith("ap")); // true
console.log("Starts with 'ora':", trie.startsWith("ora")); // false
