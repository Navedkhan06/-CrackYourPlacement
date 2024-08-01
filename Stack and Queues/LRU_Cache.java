class LRUCache {
    private final int capacity;
    private final HashMap<Integer, Integer> cache;
    private final LinkedHashSet<Integer> usage;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.usage = new LinkedHashSet<>();
    }
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // Move the accessed key to the end to show that it was recently used
        usage.remove(key);
        usage.add(key);
        return cache.get(key);
    }
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Remove the old key to update its position in usage
            usage.remove(key);
        } else if (cache.size() >= capacity) {
            int lruKey = usage.iterator().next();
            usage.remove(lruKey);
            cache.remove(lruKey);
        }
        cache.put(key, value);
        usage.add(key);
    }
}