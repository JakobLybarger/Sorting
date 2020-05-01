import java.util.Arrays;
import java.util.Random;

public class Tester {

    public static void main(String[] args){
        System.out.println();
        double start;
        double end;

        Integer[] arr = new Integer[10000];
        setArray(arr);

        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        start = System.currentTimeMillis();
        SortingMethods.selectionSort(arr2);
        end = System.currentTimeMillis();
        output(arr2, "Selection Sort", (end - start) / 1000);

        arr2 = Arrays.copyOf(arr, arr.length);
        start = System.currentTimeMillis();
        SortingMethods.bubbleSort(arr2);
        end = System.currentTimeMillis();
        output(arr2, "Bubble Sort", (end - start) / 1000);

        arr2 = Arrays.copyOf(arr, arr.length);
        start = System.currentTimeMillis();
        SortingMethods.insertionSort(arr2);
        end = System.currentTimeMillis();
        output(arr2, "Insertion Sort", (end - start) / 1000);

        arr2 = Arrays.copyOf(arr, arr.length);
        start = System.currentTimeMillis();
        SortingMethods.shellSort(arr2);
        end = System.currentTimeMillis();
        output(arr2, "Shell Sort", (end - start) / 1000);

        arr2 = Arrays.copyOf(arr, arr.length);
        start = System.currentTimeMillis();
        SortingMethods.mergeSort(arr2);
        end = System.currentTimeMillis();
        output(arr2, "Merge Sort", (end - start) / 1000);

        arr2 = Arrays.copyOf(arr, arr.length);
        start = System.currentTimeMillis();
        SortingMethods.heapSort(arr2);
        end = System.currentTimeMillis();
        output(arr2, "Heap Sort", (end - start) / 1000);

        arr2 = Arrays.copyOf(arr, arr.length);
        start = System.currentTimeMillis();
        SortingMethods.quickSort(arr2);
        end = System.currentTimeMillis();
        output(arr2, "Quicksort", (end - start) / 1000);
    }

    public static void output(Integer[] array, String method, double time){
        System.out.println(method + ":");
        System.out.println("============================================");
        System.out.printf("%d items%n", array.length);
        System.out.printf("%.2f seconds to sort%n", time);
        System.out.println("============================================\n");
    }

    public static void setArray(Integer[] arr){
        Random random = new Random();
        for(int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(1000);
        }
    }
}
