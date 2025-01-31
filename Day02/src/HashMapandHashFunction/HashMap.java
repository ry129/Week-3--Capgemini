package sampleproblemsforhashmapshashfunctions;


import java.util.LinkedList;

class HashMap<K, V> {

    // Array of linked lists for separate chaining
    private LinkedList<Entry<K, V>>[] table;
    private static final int SIZE = 16; // Initial size of the hash map

    public HashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Entry class to hold key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Hash function to calculate index
    private int hash(K key) {
        return key.hashCode() % SIZE;
    }

    // Insert or update a key-value pair
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update value if key already exists
                return;
            }
        }

        bucket.add(new Entry<>(key, value)); // Add new entry if key is not found
    }

    // Retrieve the value for a given key
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null; // Return null if key is not found
    }

    // Delete a key-value pair by key
    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry); // Remove the entry if key is found
                return;
            }
        }
    }

    // Print the hash map (for debugging)
    public void print() {
        for (int i = 0; i < SIZE; i++) {
            if (!table[i].isEmpty()) {
                for (Entry<K, V> entry : table[i]) {
                    System.out.println(entry.key + " = " + entry.value);
                }
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        System.out.println("Value for 'Two': " + map.get("Two"));

        map.remove("Two");

        System.out.println("After removing 'Two':");
        map.print();
    }
}

