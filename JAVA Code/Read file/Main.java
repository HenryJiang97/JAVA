import java.util.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // For storing integers later
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("Input the file path: ");

        // Get file path
        Scanner path = new Scanner(System.in);
        String p = path.nextLine();


        try {
            // Scan the file
            Scanner fileScanner = new Scanner(new File(p));
            
            // Add every integers in the file to the list
            while (fileScanner.hasNextInt())
                list.add(fileScanner.nextInt());

        } catch (Exception e) {
            System.out.println("Error!!!");
        }
        

        System.out.println(list);               // Print the result list
    }
}