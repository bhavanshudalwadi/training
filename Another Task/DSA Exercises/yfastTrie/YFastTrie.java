package yfastTrie;

import java.util.*;

public class YFastTrie<T extends Comparable<T>> {
    private int universeSize;
    private TreeMap<T, TreeSet<Integer>> level0;
    private List<TreeMap<T, TreeSet<Integer>>> upperLevels;

    public YFastTrie(int universeSize) {
        this.universeSize = universeSize;
        this.level0 = new TreeMap<>();
        this.upperLevels = new ArrayList<>();
    }

    public void insert(T element) {
        if (level0.containsKey(element)) {
            return;
        }

        level0.put(element, new TreeSet<>(Collections.singletonList(1)));

        for (int i = 0; i < upperLevels.size(); i++) {
            TreeMap<T, TreeSet<Integer>> level = upperLevels.get(i);
            T predecessor = level.lowerKey(element);

            if (predecessor != null) {
                int prefix = level.get(predecessor).last() + 1;
                level.put(element, new TreeSet<>(Collections.singletonList(prefix)));
                break;
            }
        }
    }

    public boolean search(T element) {
        return level0.containsKey(element);
    }

    public void delete(T element) {
        if (!level0.containsKey(element)) {
            return;
        }

        int prefix = level0.get(element).pollFirst();

        for (int i = 0; i < upperLevels.size(); i++) {
            TreeMap<T, TreeSet<Integer>> level = upperLevels.get(i);

            if (level.get(element).size() == 1) {
                level.remove(element);
            } else {
                level.get(element).remove(prefix);
                break;
            }
        }

        if (level0.get(element).isEmpty()) {
            level0.remove(element);
        }
    }

    public T successor(T element) {
        T result = level0.higherKey(element);

        for (int i = 0; i < upperLevels.size(); i++) {
            TreeMap<T, TreeSet<Integer>> level = upperLevels.get(i);

            if (level.ceilingKey(element) != null) {
                result = level.ceilingKey(element);
                result = level0.ceilingKey(result);
                break;
            }
        }

        return result;
    }

    public T predecessor(T element) {
        T result = level0.lowerKey(element);

        for (int i = 0; i < upperLevels.size(); i++) {
            TreeMap<T, TreeSet<Integer>> level = upperLevels.get(i);

            if (level.floorKey(element) != null) {
                result = level.floorKey(element);
                result = level0.floorKey(result);
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        YFastTrie<Integer> yFastTrie = new YFastTrie<>(100);

        yFastTrie.insert(10);
        yFastTrie.insert(5);
        yFastTrie.insert(15);

        System.out.println("Search for 10: " + yFastTrie.search(10)); // true
        System.out.println("Search for 7: " + yFastTrie.search(7));   // false

        yFastTrie.delete(5);

        System.out.println("Search for 5 after deletion: " + yFastTrie.search(5)); // false

        System.out.println("Successor of 10: " + yFastTrie.successor(10));  // 15
        System.out.println("Predecessor of 15: " + yFastTrie.predecessor(15));  // 10
    }
}
