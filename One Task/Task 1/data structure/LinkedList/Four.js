class ListNode {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

function hasCycle(head) {
    if (!head || !head.next) {
        return false;
    }

    let slow = head;
    let fast = head.next;

    while (fast && fast.next) {
        if (slow === fast) {
            return true; // Cycle detected
        }

        slow = slow.next;
        fast = fast.next.next;
    }

    return false; // No cycle found
}

// Example usage:

// Creating a linked list with a cycle
const node1 = new ListNode(1);
const node2 = new ListNode(2);
const node3 = new ListNode(3);
const node4 = new ListNode(4);
const node5 = new ListNode(5);

node1.next = node2;
node2.next = node3;
node3.next = node4;
node4.next = node5;
node5.next = node2; // Creating a cycle

const hasCycleResult = hasCycle(node1);

if (hasCycleResult) {
    console.log("The linked list has a cycle.");
} else {
    console.log("The linked list does not have a cycle.");
}
