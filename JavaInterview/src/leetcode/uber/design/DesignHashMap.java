package leetcode.uber.design;

import java.util.HashMap;
import java.util.Map;

public class DesignHashMap {

	public static void main(String[] args) {

//		CustomMap<Integer, Integer> cMap = new CustomMap<>();
		
		new DesignHashMap().test();
	}
	
	
	public void test() {
		CustomMap<Integer, Integer> cMap = new CustomMap<>();
		cMap.put(1, 1);
		
		System.out.println(cMap.get(1));
	}
	

	class CustomMap<K, V> {

		// 2 ^ 4 => 16
		int DEFAULT_INIT_SIZE = 1 << 4;

		float DEFAULT_LOAD_FACTOR = 0.75f;

		int size = 0;

		Entry<K, V>[] entries;

		@SuppressWarnings("unchecked")
		public CustomMap() {
			this.entries = new Entry[DEFAULT_INIT_SIZE];
		}

		public void put(K key, V value) {
			int hashCode = hash(key);
			int hashIndex = hashCode % entries.length;

			Entry<K, V> entry = entries[hashIndex];

			while (entry != null) {
				if (entry.key == key) {
					entry.value = value;
					entry.hash = hashCode;
					return;
				}
				entry = entry.next;
			}

			// get tail of the entry
			Entry<K, V> tail = getTail(entry);
			if (tail == null) {
				entries[hashIndex] = new Entry<>(key, value);
				entries[hashIndex].hash = hashCode;
			} else {
				tail.next = new Entry<>(key, value);
				tail.next.hash = hashCode;
			}
			size++;
			// If the size of the matrix passes default load factor size,
			// rehash the map
			if (size > entries.length * DEFAULT_LOAD_FACTOR) {
				entries = rehashing(entries);
			}
		}

		public V get(K key) {
			Entry<K, V> e;
			return (e = getEntry(hash(key))) == null ? null : e.value;
		}

		// Get Value from map
		private Entry<K, V> getEntry(int hash) {
			int hashIndex = hash % entries.length;
			Entry<K, V> entry = entries[hashIndex];

			while (entry != null) {
				if (entry.hash == hash) {
					return entry;
				}
				entry = entry.next;
			}
			return null;
		}
		
		// remove an element
		public void remove(K key) {

			int hash = hash(key);
			int hashIndex = hash % entries.length;

			Entry<K, V> entry = entries[hashIndex];
			if (entry != null && entry.hash == hash) {
				entries[hashIndex] = entry.next;
				return;
			}
			while (entry != null && entry.next != null) {
				if (entry.next.hash == hash) {
					entry.next = entry.next.next;
				}
				entry = entry.next;
			}
		}
		

		// get tail of the entry value
		private Entry<K, V> getTail(Entry<K, V> entry) {

			if (entry == null) {
				return entry;
			}

			while (entry.next != null) {
				entry = entry.next;
			}
			return entry;
		}

		// for key == null, we use index 0.
		// 0th index or array is always reserved for the null keys.

		private int hash(Object key) {
			int h;
			return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
		}

		// Rehashing method
		@SuppressWarnings("unchecked")
		private Entry<K, V>[] rehashing(Entry<K, V>[] entries) {

			Entry<K, V>[] newEntries = new Entry[entries.length * 2];

			for (Entry<K, V> entry : entries) {

				while (entry != null) {
					int hashIndex = entry.hash % newEntries.length;
					// get tail of the entry
					Entry<K, V> tail = getTail(newEntries[hashIndex]);

					if (tail == null) {
						newEntries[hashIndex] = entry;
					} else {
						tail.next = entry;
					}
					entry = entry.next;
				}
			}
			return newEntries;
		}

	}

	class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;
		// cache the hash value.
		int hash;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

}
