import java.io.*;
import java.util.*;

class file {
    public static void main(String[] args) {
        String read_path = args[0];
        String write_path = args[1];

        // Read data from file with path
        try {
            File read_file = new File(read_path);

            Scanner scn = new Scanner(read_file);

            while (scn.hasNext()) {
                System.out.println(scn.nextInt());
            }

            scn.close();
            
        } catch (Exception e) {
            System.out.println("Error");
        }


        // Write data to a file
        try {
            File write_file = new File(write_path);

            PrintWriter printWriter = new PrintWriter(write_file);

            // Print 2 * 3 matrix to the file
            int[][] matrix = new int[][]{{0, 0, 0}, {1, 2, 3}, {3, 2, 1}};

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    printWriter.print(matrix[i][j]);
                    printWriter.printf("\t");
                }
                printWriter.println();
            }

            printWriter.close();

        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}