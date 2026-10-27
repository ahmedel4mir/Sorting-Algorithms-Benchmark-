
package sortingalgorithmsbenchmark;
import java.util.Arrays;
import java.util.Random;
public class SortingAlgorithmsBenchmark {


    public static void main(String[] args) {
 int nSize = 100000; 
        
        System.out.println("Generating data and running algorithms, please wait...\n");

       
        int[] originalRandom = generateRandomArray(nSize);
        int[] originalReversed = generateReversedArray(nSize);
        int[] originalPartial = generatePartiallySortedArray(nSize);
        int[] originalSorted = generateSortedArray(nSize);

      
        System.out.printf("%-20s | %-18s | %-18s | %-18s | %-18s%n", 
                "Algorithm", "Random", "Reversely Sorted", "Partially Sorted", "Fully Sorted");
        System.out.println("------------------------------------------------------------------------------------------------------------------");

     
        long[] selectionTimes = runSelectionSortTests(originalRandom, originalReversed, originalPartial, originalSorted);
        printRow("Selection Sort", selectionTimes);

     
        long[] insertionTimes = runInsertionSortTests(originalRandom, originalReversed, originalPartial, originalSorted);
        printRow("Insertion Sort", insertionTimes);
        
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("Benchmark completed successfully!");
    }


    
    public static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n);
        }
        return arr;
    }

    public static int[] generateReversedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        return arr;
    }

    public static int[] generatePartiallySortedArray(int n) {
        int[] arr = generateSortedArray(n);
        Random rand = new Random();
        int swaps = (int) (n * 0.2);
        for (int i = 0; i < swaps; i++) {
            int idx1 = rand.nextInt(n);
            int idx2 = rand.nextInt(n);
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }
        return arr;
    }

    public static int[] generateSortedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

   
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    
    
    public static long[] runSelectionSortTests(int[] r, int[] rev, int[] p, int[] s) {
        long[] times = new long[4];
        int[] test;

        test = Arrays.copyOf(r, r.length);
        long start = System.nanoTime();
        selectionSort(test);
        long end = System.nanoTime();
        times[0] = (end - start) / 1000;

        test = Arrays.copyOf(rev, rev.length);
        start = System.nanoTime();
        selectionSort(test);
        end = System.nanoTime();
        times[1] = (end - start) / 1000;

        test = Arrays.copyOf(p, p.length);
        start = System.nanoTime();
        selectionSort(test);
        end = System.nanoTime();
        times[2] = (end - start) / 1000;

        test = Arrays.copyOf(s, s.length);
        start = System.nanoTime();
        selectionSort(test);
        end = System.nanoTime();
        times[3] = (end - start) / 1000;

        return times;
    }

    public static long[] runInsertionSortTests(int[] r, int[] rev, int[] p, int[] s) {
        long[] times = new long[4];
        int[] test;

        test = Arrays.copyOf(r, r.length);
        long start = System.nanoTime();
        insertionSort(test);
        long end = System.nanoTime();
        times[0] = (end - start) / 1000;

        test = Arrays.copyOf(rev, rev.length);
        start = System.nanoTime();
        insertionSort(test);
        end = System.nanoTime();
        times[1] = (end - start) / 1000;

        test = Arrays.copyOf(p, p.length);
        start = System.nanoTime();
        insertionSort(test);
        end = System.nanoTime();
        times[2] = (end - start) / 1000;

        test = Arrays.copyOf(s, s.length);
        start = System.nanoTime();
        insertionSort(test);
        end = System.nanoTime();
        times[3] = (end - start) / 1000;

        return times;
    }

    
    public static void printRow(String name, long[] times) {
        System.out.printf("%-20s | %-15d us | %-15d us | %-15d us | %-15d us%n", 
                name, times[0], times[1], times[2], times[3]);
    }
    
}
