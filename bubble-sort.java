import java.io.*;
import java.util.*;

public class ArrayOperations {
    
    // create & return an array of random integers between 0 and 100
    public static int[] createRandomArray(int arrayLength) {
        Random random = new Random();
        int[] randomArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = random.nextInt(101);
        }
        return randomArray;
    }
    
    // write the array to the file, with each line containing one integer in the array
    public static void writeArrayToFile(int[] array, String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (int num : array) {
                writer.write(Integer.toString(num));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // read the integers to an array, and return the array
    public static int[] readFileToArray(String filename) {
        List<Integer> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
    
    // sort the array uing bubble sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j] > array[j+1]) {
                    // swap arr[j+1] and arr[i]
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // get array length from user
        System.out.print("Enter the length of the array: ");
        int length = scanner.nextInt();
        
        // create random array
        int[] randomArray = createRandomArray(length);
        System.out.println("Random Array generated: " + Arrays.toString(randomArray));
        
        // write random array to file
        writeArrayToFile(randomArray, "random_array.txt");
        System.out.println("Random Array written to file 'random_array.txt'");
        
        // Read array from file
        int[] readArray = readFileToArray("random_array.txt");
        System.out.println("Array read from file: " + Arrays.toString(readArray));
        
        // Sort array using bubble sort
        bubbleSort(readArray);
        System.out.println("Array after sorting: " + Arrays.toString(readArray));
        
        scanner.close();
    }
}
