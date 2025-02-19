// https://leetcode.com/problems/lru-cache/submissions/1548116056/

// JS
class ListNode {
    constructor(key, val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class DLL {
    constructor() {
        this.head = new ListNode(-1, -1); // dummy head
        this.tail = new ListNode(-1, -1); // dummy tail
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    addNodeToFront(node){
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node
        this.head.next = node;
    }

    removeNode(node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    removeLastNode(){
        let lastNode = this.tail.prev;
        this.removeNode(lastNode)
        return lastNode;
    }
}


/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
    this.capacity = capacity;
    this.map = new Map();
    this.dll = new DLL();
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {

    // key doesnt exist
    if (!this.map.has(key)) return -1;

    // get node from map, and add to the font
    let node = this.map.get(key);
    this.dll.removeNode(node);
    this.dll.addNodeToFront(node);

    return node.val;
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {

    if (this.map.has(key)){
        // get node from map, update value, and add to the front
        let node = this.map.get(key);
        node.val = value;
        this.dll.removeNode(node);
        this.dll.addNodeToFront(node);
    }
    else {
        // create a new node and add to front
        let newNode = new ListNode(key, value);
        this.map.set(key, newNode);
        this.dll.addNodeToFront(newNode);

        // if the capacity exceeds, remove last node and delete key from map
        if (this.map.size > this.capacity){
            let lastNode = this.dll.removeLastNode();
            this.map.delete(lastNode.key)
        }
    }
};

/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

 // HashMap ensures O(1) lookup when getting the value
 // DLL maintains order of usage, head -> most used, tail -> least used
    // adding and removing nodes is O(1)