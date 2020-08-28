// Define array
int[] arr = new int[k];

// Initialize array
int[] array = {1, 2, 3};
int[] array = new int[]{1, 2, 3};

// Set array to a specific value, say 1
import java.util.Arrays;
Arrays.fill(array, 1);

// Get subarray
import java.util.Arrays;
Arrays.copyOfRange(array, lo, hi + 1);

// Array copy
int[] new_array = Arrays.copyOf(array, array.length);
int[] new_array = Arrays.copyOfRange(array, start, end);

// Array sort
Arrays.sort(arr);
// Array reverse sort (Only works for Integer[])
Arrays.sort(arr, Collections.reverseOrder());

// Binary search (array should be sorted)
// (not found -> negative num)
Arrays.binarySearch(arr, 5);


///////////////////////////////////////////////////////////////////////
// Define array list
ArrayList<Integer> list = new ArrayList<>();

// Init in one line
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));

// Add
list.add("...");
list.add(index, "...");

// Access
list.get(index);

// Index of
list.indexOf(element);

// Remove
list.remove(index);
list.clear();

// Change
list.set(index, "...");

// Size
list.size();

// Reverse
Collections.reverse(list);

// Loop
for (int i : list) {
    System.out.println(i);
}

// Sort
import java.util.Collections;
Collections.sort(list);

// Costom sort
Collections.sort(list, new Comparator<Integer>() {
    @Override
    public int compare(Integer a, Integer b) {
        // a should be before b, then return -1; otherwise, return 1
        
        // Ascend order
        return a - b;

        // Descend order
        return b - a;

        // Remains original order
        return 0;
    }
});

// Or
list.sort((a, b) -> b - a);
Collections.sort(list, Collections.reverseOrder());


// Get max value in list
Collections.max(list);


// SubList;
list.subList(start, end);

// Binary search (list should be sorted)
// (not found -> negative num)
Collections.binarySearch(list, 5);

///////////////////////////////////////////////////////////////////////
// Array => ArrayList
Integer[] arr = new Integer[]{1, 2, 3};
List<Integer> list = Arrays.asList(arr);

// ArrayList => Array
int[] arr = list.toArray(new int[n]);