package leetcode.uber.design;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DesignLRUCache {

	public static void main(String[] args) {
		new DesignLRUCache().test();
		
	}
	
	
	public void test() {
		LRUCache cache = new LRUCache(3);

		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		
		
	}
	
	
	class LRUCache {

		private DoubleLinkedNode head;

		private DoubleLinkedNode tail;

		private int capacity;

		// current length of the LRU cache
		private int length = 0;

		private Map<Integer, DoubleLinkedNode> map;
		
		public LRUCache(int capacity) {
			this.capacity = capacity;
			// map size can not exceed the default size
			// add load factor to 1, as we will not need to double the hashmap size.
			this.map = new HashMap<>(capacity, 1f);
		}
		
		public LRUCache(int capacity, boolean threadSafe) {
			this.capacity = capacity;
			// map size can not exceed the default size
			// add load factor to 1, as we will not need to double the hashmap size.
			
			// if thread safe in necessary, then it will initialize as Concurrent hash map.
			if(threadSafe) {
				this.map = new ConcurrentHashMap<>(capacity, 1f);	
			}else {
				this.map = new HashMap<>(capacity, 1f);
			}
			
		}

		public int get(int key) {
			
			if (map.containsKey(key)) {
				DoubleLinkedNode node = map.get(key);
				if (node == head) {
					return node.value;
				}
				// update the node location
				// put it as head
				removeNode(node);
				setNewHead(node);
				return node.value;

			}
			
			return -1;
		}

		public void put(int key, int value) {

			if (map.containsKey(key)) {

				DoubleLinkedNode node = map.get(key);
				node.value = value;

				// Remove head
				removeNode(node);

				// add new head
				setNewHead(node);

			} else {

				// if key is not present,
				// create new head
				DoubleLinkedNode node = new DoubleLinkedNode(key, value);
				if (length < capacity) {
					// add / update new head
					setNewHead(node);
					
					// update length
					length++;
				}
				// if map length exceeds the capacity
				// remove the last node.
				else {
					// remove from the map
					map.remove(tail.key);

					// point to previous element
					tail = tail.prev;
					if (tail != null) {
						// sent next element to null
						tail.next = null;
					}

					// add / update new head
					setNewHead(node);
				}

				// Record new entry
				map.put(key, node);
			}
		}
		
		
		private void setNewHead(DoubleLinkedNode node) {
			if (node == null) {
				return;
			}

			node.next = head;
			node.prev = null;

			if (head != null) {
				head.prev = node;
			}
			head = node;
			if (tail == null) {
				tail = node;
			}

		}
		
		private void removeNode(DoubleLinkedNode node) {
			if (node == null) {
				return;
			}

			DoubleLinkedNode cur = node;
			DoubleLinkedNode prev = cur.prev;
			DoubleLinkedNode next = cur.next;
 
			// handle previous element
			if (prev != null) {
				prev.next = next;
			} else {
				head = next;
			}

			// handle next element 
			if (next != null) {
				next.prev = prev;
			} else {
				tail = prev;
			}
		}

	}
	
	
	public class DoubleLinkedNode {
		
		DoubleLinkedNode next;
		
		DoubleLinkedNode prev;
		
		int key;
		
		int value;

		public DoubleLinkedNode(int key, int value) {
			super();
			this.key = key;
			this.value = value;
		}
		
	}
	
	
}
