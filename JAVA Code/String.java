// Substring
String s = "Hello World";
s.substring(0, 4)   // Get digit 0 to 3

// index of the head of a substring
s.indexOf("e");
s.indexOf("e", index);    // index of "e" from beginning index

// Read lines of strings from a file
for (String s : fr.lines()) {
    ...
}

// Compare two strings a and b (return boolean)
a.equals(b);
// Compare two strings a and b in alphabat order, return -1, 0, 1
a.compareTo(b);

// Trim (Removes redundant spaces at the front or end of the string)
String newStr = a.trim();



// To char array
char[] a = s.toCharArray();

// Char array to string
String s = String.valueOf(a);
String s = new String(a);

// Integer to string
import java.lang.Integer;

int a = 0;
String b = Integer.toString(a);
String b = String.valueOf(a);

// String to int
String a = "17";
int b = Integer.parseInt(a);

// Char to string
String a = Character.toString('a');

// Int to Char Array (ASCII)
char[] char_arr = Character.toChars(97);

// Split, return an array of strings seperated by ","
String[] sp = s.split(",");


// If string contains a char sequence
s.contains(".");

// Last index of a char
s.lastIndexOf('\t');


// Replace
String newstr = s.replace("Old part", "New part");


// Start with prefix string starting at idx
s.startWith(prefix, idx);




// String builder
import java.lang.StringBuilder;

// Create a mutable string
StringBuilder sb = new StringBuilder("Hello");

// Append
sb.append(" World");

// Get char
sb.charAt(index);

// Set char
sb.setCharAt(index, "a");

// Insert
sb.insert(5, " Around The ");

// Delete
sb.deleteCharAt(index);

// Reverse
sb.reverse();

// To string
sb.toString();

