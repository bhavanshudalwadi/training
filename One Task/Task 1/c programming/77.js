import Heapify from "heapify";

const queue = new Heapify();
queue.push(1, 10);  // insert item with key=1, priority=10
queue.push(2, 5);  // insert item with key=2, priority=5
queue.pop();  // 2
queue.peek();  // 1
queue.peekPriority();  // 10