class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    constructor() {
        this.head = null;
    }

    // Insert at the end of the list
    insert(data) {
        const newNode = new Node(data);

        if (!this.head) {
            this.head = newNode;
            newNode.next = this.head;
        } else {
            let current = this.head;
            while (current.next !== this.head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = this.head;
        }
    }

    // Delete a node with the given data
    delete(data) {
        if (!this.head) {
            return;
        }

        let current = this.head;
        let prev = null;

        // If the head needs to be deleted
        if (current.data === data) {
            while (current.next !== this.head) {
                current = current.next;
            }
            if (current === this.head) {
                this.head = null;
            } else {
                this.head = this.head.next;
                current.next = this.head;
            }
            return;
        }

        // Find the node to delete
        while (current.data !== data) {
            prev = current;
            current = current.next;

            // Node not found
            if (current === this.head) {
                return;
            }
        }

        // Remove the node
        prev.next = current.next;
    }

    // Display the elements in the circular linked list
    display() {
        if (!this.head) {
            console.log("Circular Linked List is empty.");
            return;
        }

        let current = this.head;

        do {
            console.log(current.data);
            current = current.next;
        } while (current !== this.head);
    }
}

// Example usage:

const circularList = new CircularLinkedList();

circularList.insert(1);
circularList.insert(2);
circularList.insert(3);

console.log("Initial Circular Linked List:");
circularList.display();

circularList.delete(2);
console.log("\nCircular Linked List after deleting 2:");
circularList.display();

circularList.insert(4);
console.log("\nCircular Linked List after inserting 4:");
circularList.display();
