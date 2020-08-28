// Definition
LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();


// Init    fillRatio(float), order(true or false, if follow last access order)
map = new LinkedHashMap<Integer, Integer>(capacity, fillRatio, order) {
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
};


// Remove eldest entry
@Override
protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
    return size() > capacity;
}