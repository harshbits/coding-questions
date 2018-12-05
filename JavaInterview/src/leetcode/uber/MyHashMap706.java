package leetcode.uber;

public class MyHashMap706 {

	public static void main(String[] args) {

		MyHashMap706 hashMap = new MyHashMap706();
		hashMap.put(1, 1);
		hashMap.put(2, 2);
		System.out.println(hashMap.get(1)); // returns 1
		System.out.println(hashMap.get(3)); // returns -1 (not found)
		hashMap.put(2, 1); // update the existing value
		System.out.println(hashMap.get(2)); // returns 1
		hashMap.remove(2); // remove the mapping for 2
		System.out.println(hashMap.get(2)); // returns -1 (not found)
	}
	
	
	// 2 ^ 4 => 16
	int DEFAULT_INIT_SIZE = 1 << 4;

	float DEFAULT_LOAD_FACTOR = 0.75f;

	int size = 0;

	Entry[] entries;

	/** Initialize your data structure here. */
	public MyHashMap706() {
		this.entries = new Entry[DEFAULT_INIT_SIZE];
	}

	public void put(int key, int value) {
		int hashCode = hash(key);
		int hashIndex = hashCode % entries.length;

		Entry entry = entries[hashIndex];

		while (entry != null) {
			if (entry.key == key) {
				entry.value = value;
				entry.hash = hashCode;
				return;
			}
			entry = entry.next;
		}

		// get tail of the entry
		Entry tail = getTail(entry);
		if (tail == null) {
			entries[hashIndex] = new Entry(key, value);
			entries[hashIndex].hash = hashCode;
		} else {
			tail.next = new Entry(key, value);
			tail.next.hash = hashCode;
		}
		size++;
		// If the size of the matrix passes default load factor size,
		// rehash the map
		if (size > entries.length * DEFAULT_LOAD_FACTOR) {
			entries = rehashing(entries);
		}
	}

	public int get(int key) {
		Entry e;
		return (e = getEntry(hash(key))) == null ? -1 : e.value;
	}

	// Get intalue from map
	private Entry getEntry(int hash) {
		int hashIndex = hash % entries.length;
		Entry entry = entries[hashIndex];

		while (entry != null) {
			if (entry.hash == hash) {
				return entry;
			}
			entry = entry.next;
		}
		return null;
	}

	// get tail of the entry value
	private Entry getTail(Entry entry) {

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

	private int hash(int key) {
//		int h;
//		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
		return key;
	}

	// Rehashing method
	private Entry[] rehashing(Entry[] entries) {

		Entry[] newEntries = new Entry[entries.length * 2];

		for (Entry entry : entries) {

			while (entry != null) {
				int hashIndex = entry.hash % newEntries.length;
				// get tail of the entry
				Entry tail = getTail(newEntries[hashIndex]);

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

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {

		int hash = hash(key);
		int hashIndex = hash % entries.length;

		Entry entry = entries[hashIndex];
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

}

class Entry {
	int key;
	int value;
	Entry next;
	// cache the hash value.
	int hash;

	public Entry(int key, int value) {
		this.key = key;
		this.value = value;
	}
}