import java.util.HashMap;

// Definition
HashMap<String, Integer> map = new HashMap<>();

//Add items
map.put("str", 1);

// Get value
map.get("str");

// Update
map.put(key, value + 1);

// Remove (return int)
map.remove(key);
// Remove (return boolean)
map.remove(key, value);

// If contains key
map.containsKey(key);

// Put if absent
map.putIfAbsent(key, value);

// Get or default
map.getOrDefault(key, 0);

// If equal
m1.equals(m2);

// Accessing all values in the map
for (String s : map.keySet()) {
    System.out.println(map.get(s));
}

// Accessing key, value pairs in the map
for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    int key = entry.getKey();
    int value = entry.getValue();
}

// Iteration
Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();

while (it.hasNext()) {
    Map.Entry<Integer, Integer> entry = it.next();

    System.out.print(entry.getKey());
    System.out.print("->");
    System.out.println(entry.getValue());
}