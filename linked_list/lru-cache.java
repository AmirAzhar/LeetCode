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

// Java
class LRUCache {
    public Map<Integer, ListNode> map;
    public DLL dll;
    public int capacity;


    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.dll = new DLL();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        // key doesnt exist
        if (!this.map.containsKey(key)) return -1;

        // get the node from the map
        ListNode node = this.map.get(key);

        // move the node to the front since it has been used recently
        this.dll.removeNode(node);
        this.dll.addToFront(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // move the node to the front
            ListNode node = this.map.get(key);
            this.dll.removeNode(node);
            this.dll.addToFront(node);
            
            // update node val
            node.val = value;
        }
        else {
            // create new node
            ListNode newNode = new ListNode(key, value);

            // add to map
            this.map.put(key, newNode);

            // add node to front
            this.dll.addToFront(newNode);
        }
        
        // exceed capacity
        if (this.map.size() > capacity) {
            ListNode toRemove = this.dll.removeLastNode();
            this.map.remove(toRemove.key);
        }
        
    }
}

class ListNode {

    public int key;
    public int val;
    public ListNode prev;
    public ListNode next;

    public ListNode (int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class DLL {
    public ListNode head;
    public ListNode tail;

    public DLL() {
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    } 

    public void addToFront (ListNode node) {
        node.next = this.head.next; // point new node forward to old first node
        node.prev = this.head; // point new node backward to head
        this.head.next.prev = node; // point old first node backward to new node
        this.head.next = node; // point head forward to new node
    }

    public void removeNode(ListNode node) {
        node.prev.next = node.next; // point the prev node, to the node in front
        node.next.prev = node.prev; // point the node in front, to the previous node
    }

    public ListNode removeLastNode() {
        ListNode lastNode = this.tail.prev;
        this.removeNode(lastNode);
        return lastNode;
    }
}

// lru cache needs 2 things - map and DLL
// map is used to store key : node
    // this allows for quick access
    // easy to remove any nodes we want (if DLL alone, need traverse)
// we need a DLL
    // to allow for wuick inserts at the start
    // quick removal at the ends
    // key functions
        // addToFront
        // removeNode
        // removeLastNode
    // we can use dummy nodes for the heads and tails
        // this will help to simplify the logic
        // no need to keep handling for null checks