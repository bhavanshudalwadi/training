package radixTree;

import java.util.HashMap;
import java.util.Map;

class RadixNode {
    private Map<Character, RadixNode> children;
    private boolean isEndOfWord;

    public RadixNode() {
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }

    public Map<Character, RadixNode> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}

public class RadixTree {
    private RadixNode root;

    public RadixTree() {
        this.root = new RadixNode();
    }

    public void insert(String word) {
        insertWord(root, word);
    }

    private void insertWord(RadixNode node, String word) {
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            RadixNode child = node.getChildren().get(currentChar);

            if (child == null) {
                child = new RadixNode();
                node.getChildren().put(currentChar, child);
            }

            node = child;
        }

        node.setEndOfWord(true);
    }

    public boolean search(String word) {
        return searchWord(root, word);
    }

    private boolean searchWord(RadixNode node, String word) {
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            RadixNode child = node.getChildren().get(currentChar);

            if (child == null) {
                return false;
            }

            node = child;
        }

        return node.isEndOfWord();
    }

    public static void main(String[] args) {
        RadixTree radixTree = new RadixTree();

        radixTree.insert("apple");
        radixTree.insert("app");
        radixTree.insert("apricot");
        radixTree.insert("banana");

        System.out.println("Search 'apple': " + radixTree.search("apple"));      
        System.out.println("Search 'app': " + radixTree.search("app"));          
        System.out.println("Search 'apricot': " + radixTree.search("apricot"));  
        System.out.println("Search 'banana': " + radixTree.search("banana"));    
        System.out.println("Search 'ap': " + radixTree.search("ap"));            
        System.out.println("Search 'ban': " + radixTree.search("ban"));          
    }
}
