// remove-nth-node-from-end-of-list

// JS
var removeNthFromEnd = function(head, n) {
    let tail = head;
    let remove = head;
    let prev = null;

    while (n--) tail = tail.next
    
    while (tail) {
        tail = tail.next;
        prev = remove;
        remove = remove.next;
    }

    if (!prev) return remove.next
    prev.next = remove.next;

    return head;
};