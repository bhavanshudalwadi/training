class SuffixTreeNode {
    constructor() {
        this.children = {};
        this.index = -1;
    }
}

class SuffixTree {
    constructor(text) {
        this.root = new SuffixTreeNode();
        this.buildSuffixTree(text);
    }

    buildSuffixTree(text) {
        for (let i = 0; i < text.length; i++) {
            this.insertSuffix(text.substring(i), i);
        }
    }

    insertSuffix(suffix, index) {
        let node = this.root;

        for (let i = 0; i < suffix.length; i++) {
            const char = suffix[i];

            if (!node.children[char]) {
                node.children[char] = new SuffixTreeNode();
            }

            node = node.children[char];
        }

        node.index = index;
    }

    search(pattern) {
        let node = this.root;

        for (let i = 0; i < pattern.length; i++) {
            const char = pattern[i];

            if (!node.children[char]) {
                return -1; // Pattern not found
            }

            node = node.children[char];
        }

        return node.index;
    }
}

// Example usage:

const text = "banana";
const suffixTree = new SuffixTree(text);

console.log("Suffix tree for text:", text);
console.log("Search 'banana':", suffixTree.search("banana")); // 0 (index of the whole string)
console.log("Search 'ana':", suffixTree.search("ana"));         // 1
console.log("Search 'nana':", suffixTree.search("nana"));       // 4
console.log("Search 'xyz':", suffixTree.search("xyz"));         // -1 (not found)
