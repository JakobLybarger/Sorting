import java.util.Arrays;

public class SortingMethods {

    /** Selection sort. This is an O(n^2) algorithm.
     *  @param array An unsorted array
     */
    public static <T extends Comparable<T>> void selectionSort(T[] array){
        for(int i = 0; i < array.length - 1; i++){
            for(int j = i + 1; j < array.length; j++){
                // If element at j is less than element
                // at i, then swap
                if(array[j].compareTo(array[i]) < 0){
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /** Bubble sort. O(n^2) algorithm.
     *  @param array A unsorted array
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] array){
        int pass = 1;
        boolean exchanges;
        do{
            exchanges = false;
            for(int i = 0; i < array.length - pass; i++){
                // If element at i is greater than element at i+1
                if(array[i].compareTo(array[i+1]) > 0){
                    // swap the elements at the indices
                    T temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;

                    // set exchanges to true so the do while loop
                    // is not exited
                    exchanges = true;
                }
            }
            pass++;
        }while(exchanges);
    }

    /** Insertion sort. O(n^2) algorithm.
     *  @param array The array to be sorted
     */
    public static <T extends Comparable<T>> void insertionSort(T[] array){
        for(int position = 1; position < array.length; position++){
            insertionSortInsert(array, position);
        }
    }

    /** Insertion sort insert method.
     *  @param array The array to insert into
     *  @param position The position of the item we are inserting
     */
    private static <T extends Comparable<T>> void insertionSortInsert(T[] array, int position){
        // Value at the position.
        T value = array[position];
        // Find the position where the value belongs, and shift every element
        // over to create an open index for that and place value there.
        while(position > 0 && value.compareTo(array[position - 1]) < 0){
            array[position] = array[position - 1];
            position--;
        }

        array[position] = value;
    }

    /** Shell sort. O(n^(3/2)) algorithm.
     *  @param array The array to be sorted
     */
    public static <T extends Comparable<T>> void shellSort(T[] array){
        // Gap between adjacent elements
        int gap = array.length / 2;
        while(gap > 0){
            for(int position = gap; position < array.length; position++){
                // Insert element at position in its sub-array
                shellSortInsertion(array, position, gap);
            }
            // Reset gap for next pass
            if(gap == 2){
                gap = 1;
            }
            else{
                gap = gap / 2;
            }
        }
    }

    /** Shell sort insertion method.
     *  @param array The array being inserted into
     *  @param position The position of the element to insert
     *  @param gap The gap between the elements in the sub-array being compared
     */
    private static <T extends Comparable<T>> void shellSortInsertion(T[] array, int position, int gap){
        // Element to insert
        T value = array[position];
        // Shift all values > value in sub-array down by gap
        while(position > gap - 1 && value.compareTo(array[position - gap]) < 0){
            // First element not shifted
            array[position] = array[position - gap];
            // Shift down
            position -= gap;
        }
        array[position] = value;
    }

    /** Merge sort. O(nlogn) algorithm.
     *  @param array The array to be sorted
     */
    public static <T extends Comparable<T>> void mergeSort(T[] array){
        if(array.length > 1){
            int half = array.length / 2;
            T[] left = Arrays.copyOf(array, half);
            T[] right = Arrays.copyOfRange(array, half, array.length);

            // sort left and right arrays
            mergeSort(left);
            mergeSort(right);

            // Merge the arrays
            merge(array, left, right);
        }
    }

    /** Merges the smaller arrays together into a larger array
     *  @param output The array items will be added to
     *  @param left The left sub-array
     *  @param right The right sub-array
     */
    private static <T extends Comparable<T>> void merge(T[] output, T[] left, T[] right){
        int o = 0; // Index for output array
        int l = 0; // Index for left array
        int r = 0; // Index for right array

        while(l < left.length && r < right.length){
            // If the element at index l in the left array
            // is less than the element at index r in the
            // right array add the element at index l of the
            // left array, else add the element at index r
            // of the right array
            if(left[l].compareTo(right[r]) < 0){
                output[o++] = left[l++];
            }
            else{
                output[o++] = right[r++];
            }
        }

        while(l < left.length){
            output[o++] = left[l++];
        }

        while(r < right.length){
            output[o++] = right[r++];
        }
    }

    /** Heap sort. O(nlogn) algorithm.
     *  @param array The array to be sorted
     */
    public static <T extends Comparable<T>> void heapSort(T[] array){
        buildHeap(array);
        sortHeap(array);
    }

    /** Transforms array into a heap.
     *  @param array The array to be transformed into a heap
     */
    private static <T extends Comparable<T>> void buildHeap(T[] array){
        int n = 1;
        while(n < array.length){
            n++;
            int child = n - 1;
            int parent = (child - 1) / 2; // Find parent
            // If element at parent greater than or equal to zero and less than
            // element child then swap elements
            while(parent >= 0 && array[parent].compareTo(array[child]) < 0){
                swap(array, parent, child);
                child = parent;
                parent = (child - 1) / 2;
            }
        }
    }

    /** Transforms a heap into a sorted array.
     *  @param array The array to be sorted
     */
    private static <T extends Comparable<T>> void sortHeap(T[] array){
        int n = array.length;
        while(n > 0){
            n--;
            swap(array, 0, n);

            int parent = 0;
            while(true){
                int leftChild = 2 * parent + 1;
                if(leftChild >= n){
                    break; // No more children
                }
                int rightChild = leftChild + 1;
                // Find the larger child
                int maxChild = leftChild;
                if (rightChild < n && array[leftChild].compareTo(array[rightChild]) < 0){
                    maxChild = rightChild;
                }

                // If parent is smaller than the largest child
                // swap parent and largest child
                if(array[parent].compareTo(array[maxChild]) < 0){
                    swap(array, parent, maxChild);
                    parent = maxChild;
                }
                else{
                    break;
                }
            }
        }
    }

    /** Quicksort wrapper method
     *  @param array The array to be sorted
     */
    public static <T extends Comparable<T>> void quickSort(T[] array){
        // Call quickSort recursive method
        quickSort(array, 0, array.length - 1);
    }

    /** Quicksort. O(nlogn) algorithm.
     *  @param array The array to be sorted
     *  @param first The first index
     *  @param last The last index
     */
    private static <T extends Comparable<T>> void quickSort(T[] array, int first, int last){
        if(first < last){
            int pivot = partition(array, first, last); // Obtain a partition
            quickSort(array, first, pivot - 1); // Sort left half of partition
            quickSort(array, pivot + 1, last); // Sort right half of partition
        }
    }

    /** Partitions the array so all of the elements on the left
     *  side of the partitions are smaller than the pivot and
     *  all of the values to the right are largest
     *  @param array The array to be partitioned
     *  @param first The low bound
     *  @param last The high bound
     */
    private static <T extends Comparable<T>> int partition(T[] array, int first, int last){

        threeSort(array, first, last);
        swap(array, first, (first + last) / 2);

        // Pivot value
        T piv = array[first];
        int up = first;
        int down = last;
        do{
            while((up < last) && piv.compareTo(array[up]) >= 0){
                up++;
            }

            while(piv.compareTo(array[down]) < 0){
                down--;
            }

            if(up < down){
                swap(array, up, down);
            }
        }while(up < down);

        swap(array, first, down);

        return down;
    }

    /** Places the first, middle, and last element of
     *  the array in order
     *  @param array The array
     *  @param first The index of the first element
     *  @param last The index of the last element
     */
    private static <T extends Comparable<T>> void threeSort(T[] array, int first, int last){
        int mid = (first + last) / 2;

        if(array[mid].compareTo(array[first]) < 0){
            swap(array, mid, first);
        }

        if(array[last].compareTo(array[mid]) < 0){
            swap(array, last, mid);
        }

        if(array[mid].compareTo(array[first]) < 0){
            swap(array, first, mid);
        }
    }

    /** Swaps two elements in an array
     *  @param array The array
     *  @param i Index of the first element
     *  @param j Index of the other element
     */
    private static <T extends Comparable<T>> void swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T>void printArray(T[] array){
        for(T item : array){
            System.out.printf("%s ", item);
        }
        System.out.println("\n");
    }
}

