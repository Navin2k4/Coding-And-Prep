package custom_datastructures;

public class MyMap<K, V> {

    private static final int SIZE = 10;

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public MyMap() {
        buckets = new Entry[SIZE];
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % 10);
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        Entry<K, V> newNode = new Entry<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public V get(K key) {
        int index = getIndex(key);
        Entry<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) return head.value;
            head = head.next;
        }

        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        Entry<K, V> head = buckets[index];
        Entry<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }

    }

    public MyMap<K, V> cloneMap() {
        MyMap<K, V> cloned = new MyMap<>();
        for (int i = 0; i < SIZE; i++) {
            Entry<K, V> head = buckets[i];
            while (head != null) {
                cloned.put(head.key, head.value);
                head = head.next;
            }
        }
        return cloned;
    }
}
