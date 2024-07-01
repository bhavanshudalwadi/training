package skipList;

class SkipListNode {
    int value;
    SkipListNode[] next;

    public SkipListNode(int value, int level) {
        this.value = value;
        this.next = new SkipListNode[level + 1];
    }
}


public class SkipList {
    private static final int MAX_LEVEL = 16; 
    private int level;
    private SkipListNode head;

    public SkipList() {
        this.level = 0;
        this.head = new SkipListNode(Integer.MIN_VALUE, MAX_LEVEL);
    }

    public boolean search(int target) {
        SkipListNode current = head;

        for (int i = level; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < target) {
                current = current.next[i];
            }
        }

        return current.next[0] != null && current.next[0].value == target;
    }

    public void insert(int value) {
        SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
        SkipListNode current = head;

        for (int i = level; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }
            update[i] = current;
        }

        int newLevel = randomLevel();
        if (newLevel > level) {
            for (int i = level + 1; i <= newLevel; i++) {
                update[i] = head;
            }
            level = newLevel;
        }

        SkipListNode newNode = new SkipListNode(value, newLevel);
        for (int i = 0; i <= newLevel; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
    }

    public void delete(int target) {
        SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
        SkipListNode current = head;

        for (int i = level; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < target) {
                current = current.next[i];
            }
            update[i] = current;
        }

        SkipListNode toDelete = current.next[0];
        if (toDelete != null && toDelete.value == target) {
            for (int i = 0; i <= level; i++) {
                if (update[i].next[i] != toDelete) {
                    break;
                }
                update[i].next[i] = toDelete.next[i];
            }

            while (level > 0 && head.next[level] == null) {
                level--;
            }
        }
    }

    private int randomLevel() {
        int level = 0;
        while (Math.random() < 0.5 && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }
    public static void main(String[] args) {
        
        SkipList skipList = new SkipList();

        
        skipList.insert(3);
        skipList.insert(6);
        skipList.insert(7);
        skipList.insert(9);
        skipList.insert(12);

        
        System.out.println("Contains 7: " + skipList.search(7)); 
        System.out.println("Contains 8: " + skipList.search(8)); 

        
        skipList.delete(7);

        
        System.out.println("Contains 7 after deletion: " + skipList.search(7)); 
    }
}
