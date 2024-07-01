class Node {
    constructor(char, frequency) {
        this.char = char;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }
}

class PriorityQueue {
    constructor() {
        this.queue = [];
    }

    enqueue(node) {
        this.queue.push(node);
        this.queue.sort((a, b) => a.frequency - b.frequency);
    }

    dequeue() {
        return this.queue.shift();
    }

    isEmpty() {
        return this.queue.length === 0;
    }
}

function buildHuffmanTree(text) {
    const frequencyMap = new Map();

    // Count the frequency of each character in the text
    for (const char of text) {
        frequencyMap.set(char, (frequencyMap.get(char) || 0) + 1);
    }

    // Build nodes for each character and enqueue them
    const priorityQueue = new PriorityQueue();
    for (const [char, frequency] of frequencyMap) {
        const node = new Node(char, frequency);
        priorityQueue.enqueue(node);
    }

    // Build the Huffman tree by dequeuing and combining nodes until only one node remains
    while (priorityQueue.queue.length > 1) {
        const leftNode = priorityQueue.dequeue();
        const rightNode = priorityQueue.dequeue();

        const parentNode = new Node(null, leftNode.frequency + rightNode.frequency);
        parentNode.left = leftNode;
        parentNode.right = rightNode;

        priorityQueue.enqueue(parentNode);
    }

    // The final remaining node is the root of the Huffman tree
    return priorityQueue.dequeue();
}

function buildHuffmanCodes(root, currentCode = "", codesMap = new Map()) {
    if (root) {
        if (root.char !== null) {
            codesMap.set(root.char, currentCode);
        }

        buildHuffmanCodes(root.left, currentCode + "0", codesMap);
        buildHuffmanCodes(root.right, currentCode + "1", codesMap);
    }

    return codesMap;
}

function encodeText(text, huffmanCodes) {
    let encodedText = "";

    for (const char of text) {
        encodedText += huffmanCodes.get(char);
    }

    return encodedText;
}

function decodeText(encodedText, root) {
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

const inputText = "hello world";
const huffmanTree = buildHuffmanTree(inputText);
const huffmanCodes = buildHuffmanCodes(huffmanTree);
const encodedText = encodeText(inputText, huffmanCodes);
const decodedText = decodeText(encodedText, huffmanTree);

console.log("Input Text:", inputText);
console.log("Huffman Codes:", huffmanCodes);
console.log("Encoded Text:", encodedText);
console.log("Decoded Text:", decodedText);
