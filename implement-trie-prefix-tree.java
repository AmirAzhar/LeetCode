// https://leetcode.com/problems/implement-trie-prefix-tree/submissions/1548187497/

// JS
class TrieNode {
    constructor(val) {
        this.children = {}; // kv pair where k is the char and v is a node
        this.isEnd = false; // to indiciate if it is the end of a word
    }
}

var Trie = function() {
    this.root = new TrieNode();
};

/** 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
    let node = this.root;

    for (const char of word){
        // char is not a child of the root
        if (!node.children[char]) node.children[char] = new TrieNode();

        // go to child node
        node = node.children[char]
    }

    node.isEnd = true;
};

/** 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
    let node = this.root;

    for (const char of word){
        // char not in children, fail
        if (!node.children[char]) return false;

        // go to child node
        node = node.children[char];
    }

    // only return if its a compleet word, not prefix
    return node.isEnd;
};

/** 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
    let node = this.root;

    for (const char of prefix){
        // char not in children, fail
        if (!node.children[char]) return false;

        // go to child node
        node = node.children[char];
    }

    return true;
};

/** 
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */