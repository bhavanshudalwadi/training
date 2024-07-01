package xorLinkedList;

class Node {
    public int data;
     Node xorPointer; 

    public Node(int data) {
        this.data = data;
        this.xorPointer = null;
    }
}

public class XORLinkedList {
    private Node head; 

    public XORLinkedList() {
        this.head = null;
    }

    
    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.xorPointer = head; 

        if (head != null) {
            head.xorPointer = XOR(newNode, head.xorPointer);
        }

        head = newNode;
    }

    
    public void traverse() {
        Node current = head;
        Node prev = null;
        Node next;

        while (current != null) {
            System.out.print(current.data + " ");

            
            next = XOR(prev, current.xorPointer);

            
            prev = current;
            current = next;
        }
    }

    
    private Node XOR(Node a, Node b) {
        return (a == null) ? b : (b == null) ? a : null; 
    }

    public static void main(String[] args) {
        XORLinkedList xorList = new XORLinkedList();

        
        xorList.insert(1);
        xorList.insert(2);
        xorList.insert(3);
        xorList.insert(4);

        
        xorList.traverse();
    }
}

