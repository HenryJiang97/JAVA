TreeSet<T> treeset = new TreeSet<>();

// Add
treeset.add(n);

// Ceiling => returns the least element greater or equal than the given element, null if not existing
Integer n = treeset.ceiling(element);

// Floor => returns the greatest element smaller or equal than the given element, null if not existing
Integer n = treeset.floor(element);

// Higher => returns the least element in this set strictly greater than the given element, null if not existing
Integer n = treeset.higher(element);

// Lower => returns the greatest element in this set strictly less than the given element, null if not existing
Integer n = treeset.lower(element);