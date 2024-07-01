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

    autocomplete(prefix) {
        let node = this.root;

        for (const char of prefix) {
            if (!node.children.has(char)) {
                return []; // Prefix not found
            }

            node = node.children.get(char);
        }

        return this.findWords(node, prefix);
    }

    findWords(node, prefix) {
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

const trie = new Trie();

trie.insert("apple");
trie.insert("app");
trie.insert("apricot");
trie.insert("banana");
trie.insert("bat");
trie.insert("batman");

const prefix = "ap";
const autocompleteSuggestions = trie.autocomplete(prefix);

console.log(`Autocomplete suggestions for '${prefix}':`);
console.log(autocompleteSuggestions);
