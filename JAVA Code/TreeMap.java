// Defination
TreeMap<T, T> treemap = new TreeMap<>();
TreeMap<T, T> treemap = new TreeMap<>(Collections.reverseOrder());

// Get first(lowest key)
T key = treemap.firstKey();


// Get last(highest key)
T key = treemap.lastKey();


// Get the key just less than k (The largest key just smaller than k), null if not exist
Integer key = treemap.lowerKey(k);


// Get the key just greater than k (The smallest key just greater than k), null if not exist
Integer key = treemap.higherKey(k);

// Ceiling => returns the least element greater or equal than the given element, null if not existing
Integer n = treemap.ceilingKey(element);

// Floor => returns the greatest element smaller or equal than the given element, null if not existing
Integer n = treemap.floorKey(element);