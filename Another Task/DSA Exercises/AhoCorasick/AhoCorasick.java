package AhoCorasick;

import java.util.*;

public class AhoCorasick {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        TrieNode fail;
        Set<String> patterns = new HashSet<>();
        boolean isEndOfPattern;

        public void addPattern(String pattern) {
            patterns.add(pattern);
        }
    }

    static void buildTrie(TrieNode root, String[] patterns) {
        for (String pattern : patterns) {
            TrieNode node = root;
            for (char c : pattern.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isEndOfPattern = true;
            node.addPattern(pattern);
        }
    }

    static void buildFailureFunction(TrieNode root) {
        Queue<TrieNode> queue = new LinkedList<>();

        for (TrieNode child : root.children.values()) {
            child.fail = root;
            queue.add(child);
        }

        while (!queue.isEmpty()) {
            TrieNode curr = queue.poll();

            for (Map.Entry<Character, TrieNode> entry : curr.children.entrySet()) {
                char c = entry.getKey();
                TrieNode child = entry.getValue();
                queue.add(child);

                TrieNode failNode = curr.fail;

                while (failNode != null && !failNode.children.containsKey(c)) {
                    failNode = failNode.fail;
                }

                child.fail = failNode != null ? failNode.children.getOrDefault(c, root) : root;
                child.patterns.addAll(child.fail.patterns);
            }
        }
    }

    static void search(TrieNode root, String text, List<String>[] occurrences) {
        TrieNode curr = root;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            while (curr != null && !curr.children.containsKey(c)) {
                curr = curr.fail;
            }

            curr = (curr != null) ? curr.children.getOrDefault(c, root) : root;

            for (String pattern : curr.patterns) {
                occurrences[pattern.length()].add(pattern);
            }
        }
    }

    static void ahoCorasick(String[] patterns, String text) {
        TrieNode root = new TrieNode();
        buildTrie(root, patterns);
        buildFailureFunction(root);

        List<String>[] occurrences = new ArrayList[text.length() + 1];
        for (int i = 0; i <= text.length(); i++) {
            occurrences[i] = new ArrayList<>();
        }

        search(root, text, occurrences);

        for (int i = 0; i <= text.length(); i++) {
            System.out.println("Occurrences of patterns with length " + i + ": " + occurrences[i]);
        }
    }

    public static void main(String[] args) {
        String[] patterns = {"he", "she", "his", "hers"};
        String text = "ushershe";

        ahoCorasick(patterns, text);
    }
}

