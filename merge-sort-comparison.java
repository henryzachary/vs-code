import java.io.*;
import java.util.*;

public class MergeSortComparison {
    
    // merge sort 
    public static void mergeSort(int[] array) {
        // if the array has 0 or 1 elements, it is already sorted
        if (array.length <= 1) {
            return;
        }
        
        // calculate the midpoint of array
        int midpoint = array.length / 2;
        
        // split the array into two halves
        int[] leftArray = Arrays.copyOfRange(array, 0, midpoint);
        int[] rightArray = Arrays.copyOfRange(array, midpoint, array.length);
        
        // sorting the left and right halves
        mergeSort(leftArray);
        mergeSort(rightArray);
        
        // merge the sorted halves
        merge(leftArray, rightArray, array);
    }
    
    // merges two sorted arrays into a single array
    private static void merge(int[] leftArray, int[] rightArray, int[] resultArray) {
        int leftIndex = 0;
        int rightIndex = 0;
        int finalIndex = 0;
        
        // Compare elements from both arrays and merge them into the final array
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                resultArray[finalIndex++] = leftArray[leftIndex++];
            } else {
                resultArray[finalIndex++] = rightArray[rightIndex++];
            }
        }
        
        // Copy any remaining elements from the left array
        while (leftIndex < leftArray.length) {
            resultArray[finalIndex++] = leftArray[leftIndex++];
        }
        
        // Copy any remaining elements from the right array
        while (rightIndex < rightArray.length) {
            resultArray[finalIndex++] = rightArray[rightIndex++];
        }
    }
    
    // bubble sort 
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    
    // generates a random array of integers between 0 and 100
    public static int[] createRandomArray(int arrayLength) {
        Random random = new Random();
        int[] randomArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = random.nextInt(101); 
        }
        return randomArray;
    }
    
    //  merge sort and bubble sort on a randomly generated array and prints the sorted arrays
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get array length from user
        System.out.print("Enter the length of the array: ");
        int length = scanner.nextInt();
        
        // create random array
        int[] array = createRandomArray(length);
             
        // copy array for comparison
        int[] mergeSortArray = Arrays.copyOf(array, array.length);
        int[] bubbleSortArray = Arrays.copyOf(array, array.length);
        
        mergeSort(mergeSortArray);
        
        bubbleSort(bubbleSortArray);
        
        // print sorted arrays
        System.out.println("Merge Sort: " + Arrays.toString(mergeSortArray));
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleSortArray));
    }
}
