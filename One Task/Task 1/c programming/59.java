class Node { 
    int value; 
    Node next; 
  
    Node(int value) { 
        this.value = value; 
    }

    static void displayCLL(Node head) {
        Node current = head;
        do{ 
            System.out.print(current.value+" ");  
            current = current.next;
        }while(current != head);
    } 
}

class FiftyNine {
    public static void main(String args[]) {
        Node one = new Node(3); 
        Node two = new Node(5); 
        Node three = new Node(9); 
        
        one.next = two; 
        two.next = three; 
        three.next = one; 

        Node.displayCLL(two);
    }
}