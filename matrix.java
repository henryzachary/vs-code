import java.io.*;
import java.util.*;

public class Matrix {

    public static void main(String[] args) {
        //creating the scanner
        Scanner scanner = new Scanner(System.in);
        
        //declaring variables to hold the matrices and the result of multiplication
        int[][] matrix1, matrix2, result;

        //check if there are two arguments
        if (args.length == 2) {

            //if two arguments are given, reads matrices 1 and 2
            String file1 = args[0];
            String file2 = args[1];
            matrix1 = readFile(file1);
            matrix2 = readFile(file2);
        } else {

            //if not args.length dne 2, user needs enter the size of square matrices
            System.out.println("Enter the size of the square matrices: ");
            int size = scanner.nextInt();
            
            //generates random square matrices based on int size
            matrix1 = generateRandMatrix(size);
            matrix2 = generateRandMatrix(size);

            //save the matrices to files matrix1.txt and matrix2.txt
            saveToFile(matrix1, "matrix1.txt");
            saveToFile(matrix2, "matrix2.txt");
        }

        //checks if the matrices are compatible for multiplication
        if (matrix1[0].length != matrix2.length) {
            System.out.println("Error: Matrices are not compatible for multiplication.");
            return;
        }

        //multiply the matrices and store the result
        result = multiply(matrix1, matrix2);

        //save the result matrix to file matrix3.txt
        saveToFile(result, "matrix3.txt");

        System.out.println("Matrix multiplication completed and result saved to matrix3.txt");
    }

    //reading a matrix from a file with parameter fileName
    private static int[][] readFile(String fileName) {

        //initializing a list to store the rows of the matrix
        List<List<Integer>> rows = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {

            //read each line from the file
            while (scanner.hasNextLine()) {

                //initializing a list to store the elements of a row
                List<Integer> row = new ArrayList<>();

                //split the line into individual elements
                String[] values = scanner.nextLine().split(" ");

                //convert the string elements to integers and add them to the row list
                for (String value : values) {
                    row.add(Integer.parseInt(value));
                }
                //add row to the list of rows
                rows.add(row);
            }
        } catch (FileNotFoundException e) {

            //print stack trace if the file is not found
            e.printStackTrace();
        }

        //initializing a 2D array to hold the matrix
        int[][] matrix = new int[rows.size()][];

        //convert the list of rows to a 2D array
        for (int i = 0; i < rows.size(); i++) {
            List<Integer> row = rows.get(i);
            matrix[i] = new int[row.size()];
            for (int j = 0; j < row.size(); j++) {
                matrix[i][j] = row.get(j);
            }
        }
        //return the matrix read from the file
        return matrix;
    }

    //save a matrix to a file
    private static void saveToFile(int[][] matrix, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            //write each element of the matrix to the file
            for (int[] row : matrix) {
                for (int i = 0; i < row.length; i++) {
                    writer.print(row[i]);

                    //add a space between elements except for the last element in a row
                    if (i != row.length - 1) {
                        writer.print(" ");
                    }
                }
                //start a new line after each row
                writer.println();
            }
        } catch (IOException e) {

            //print stack trace if an IOException occurs
            e.printStackTrace();
        }
    }

    //method to generate a random square matrix of a given size
    private static int[][] generateRandMatrix(int size) {

        //initializing a 2D array to hold the matrix
        int[][] matrix = new int[size][size];

        //create a random object to generate random numbers
        Random random = new Random();

        //fill the matrix with random integers from 0 to 9
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        //return the generated matrix
        return matrix;
    }

    //multiply two matrices
    private static int[][] multiply(int[][] matrix1, int[][] matrix2) {

        //get the dimensions of the matrices
        int m = matrix1.length;
        int n = matrix2[0].length;

        //initialize a 2D array to hold the result of multiplication
        int[][] result = new int[m][n];

        //perform matrix multiplication
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        // Return the result matrix
        return result;
    }
}
