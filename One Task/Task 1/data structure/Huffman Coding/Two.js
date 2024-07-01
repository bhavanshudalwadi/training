class Node {
    constructor(char, frequency) {
        this.char = char;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }
}

function decodeHuffman(encodedText, root) {
    let decodedText = "";
    let currentNode = root;

    for (const bit of encodedText) {
        if (bit === "0") {
            currentNode = currentNode.left;
        } else {
            currentNode = currentNode.right;
        }

        if (currentNode.char !== null) {
            decodedText += currentNode.char;
            currentNode = root;
        }
    }

    return decodedText;
}

// Example usage:

// Assume the same Huffman tree from the previous example
const huffmanTree = new Node(null, 11);
huffmanTree.left = new Node("l", 5);
huffmanTree.right = new Node(null, 6);
huffmanTree.right.left = new Node("o", 2);
huffmanTree.right.right = new Node(" ", 4);

const encodedText = "0011000100111011001100010011010101110010011101100011101101111000";

const decodedText = decodeHuffman(encodedText, huffmanTree);

console.log("Encoded Text:", encodedText);
console.log("Decoded Text:", decodedText);
