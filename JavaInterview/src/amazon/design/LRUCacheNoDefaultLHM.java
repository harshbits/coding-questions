package amazon.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. put(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 * <p>
 * Follow up: Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2 );
 * <p>
 * cache.put(1, 1); cache.put(2, 2); cache.get(1); // returns 1 cache.put(3, 3);
 * // evicts key 2 cache.get(2); // returns -1 (not found) cache.put(4, 4); //
 * evicts key 1 cache.get(1); // returns -1 (not found) cache.get(3); // returns
 * 3 cache.get(4); // returns 4
 *
 * @author hbhavsar
 */

// Implementation without LinkedHashMap

// Using Hash Map and Doubly linked list
public class LRUCacheNoDefaultLHM {

    public static void main(String[] args) {

    }

    private Map<Integer, DoubleLinkedNode> map;

    private int capacity;

    private DoubleLinkedNode head;

    private DoubleLinkedNode tail;

    public LRUCacheNoDefaultLHM(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        this.head.next = this.tail;
        this.head.prev = null;
        this.tail.next = null;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        DoubleLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addNodeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = map.get(key);
        if (node == null) {
            node = new DoubleLinkedNode();
            node.key = key;
            node.value = value;
            this.map.put(key, node);
            // Move to the top of the cache
            addNodeToHead(node);

            if (this.map.size() > capacity) {
                DoubleLinkedNode removedNode = removeNode(tail.prev);
                this.map.remove(removedNode.key);
            }
        } else {
            node.value = value;
            removeNode(node);
            addNodeToHead(node);
        }
    }

    private void addNodeToHead(DoubleLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private DoubleLinkedNode removeNode(DoubleLinkedNode nodeToBeRemoved) {
        DoubleLinkedNode node = nodeToBeRemoved;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    public class DoubleLinkedNode {
        DoubleLinkedNode next;
        DoubleLinkedNode prev;
        int key;
        int value;
    }

}
