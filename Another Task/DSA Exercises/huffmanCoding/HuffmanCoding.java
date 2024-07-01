package huffmanCoding;

import java.util.HashMap;
import java.util.PriorityQueue;

class HuffmanNode implements Comparable<HuffmanNode> {
    char data;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        this.left = this.right = null;
    }

    @Override
    public int compareTo(HuffmanNode node) {
        return this.frequency - node.frequency;
    }
}

public class HuffmanCoding {

    
    private static HuffmanNode buildHuffmanTree(HashMap<Character, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();

        
        for (char key : frequencyMap.keySet()) {
            HuffmanNode node = new HuffmanNode(key, frequencyMap.get(key));
            priorityQueue.add(node);
        }

        
        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            HuffmanNode internalNode = new HuffmanNode('\0', left.frequency + right.frequency);
            internalNode.left = left;
            internalNode.right = right;

            priorityQueue.add(internalNode);
        }

        return priorityQueue.poll();
    }

    
    private static void generateHuffmanCodes(HuffmanNode root, String code, HashMap<Character, String> huffmanCodes) {
        if (root == null) {
            return;
        }

        if (root.data != '\0') {
            huffmanCodes.put(root.data, code);
        }

        generateHuffmanCodes(root.left, code + "0", huffmanCodes);
        generateHuffmanCodes(root.right, code + "1", huffmanCodes);
    }

    
    public static String compress(String input) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        HuffmanNode root = buildHuffmanTree(frequencyMap);

        HashMap<Character, String> huffmanCodes = new HashMap<>();
        generateHuffmanCodes(root, "", huffmanCodes);

        StringBuilder compressed = new StringBuilder();
        for (char c : input.toCharArray()) {
            compressed.append(huffmanCodes.get(c));
        }

        return compressed.toString();
    }

    
   


public static String decompress(String compressed, HuffmanNode root) {
    StringBuilder decompressed = new StringBuilder();
    HuffmanNode current = root;

    for (char bit : compressed.toCharArray()) {
        if (bit == '0') {
            if (current.left != null) {
                current = current.left;
            } else {
                break; 
            }
        } else if (bit == '1') {
            if (current.right != null) {
                current = current.right;
            } else {
                break; 
            }
        }

        if (current.left == null && current.right == null) {
            decompressed.append(current.data);
            current = root;
        }
    }

    
    if (current != null && current.left == null && current.right == null) {
        decompressed.append(current.data);
    }

    return decompressed.toString();
}




    public static void main(String[] args) {
        String input = "Huffman coding is a prefix-free binary code";
        System.out.println("Original: " + input);

        
        String compressed = compress(input);
        System.out.println("Compressed: " + compressed);

        
        HuffmanNode root = buildHuffmanTree(new HashMap<>()); 
        String decompressed = decompress(compressed, root);
        System.out.println("Decompressed: " + decompressed);
    }
}
