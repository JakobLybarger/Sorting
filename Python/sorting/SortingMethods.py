
def selection_sort(array):
    """ Selection sort. O(n^2) algorithm.
        Args:
            array: The array/list to be sorted
    """
    for i in range(len(array) - 1):
        for j in range(i + 1, len(array)):
            # If element at j is less than element
            # at i, then swap
            if array[j] < array[i]:
                swap(array, i, j)


def bubble_sort(array):
    """ Bubble sort. O(n^2) algorithm.
        Args:
            array: The array/list to be sorted
    """
    passes = 1
    exchanges = True
    while exchanges:
        exchanges = False
        for i in range(len(array) - 1):
            # If element at i is greater than
            # element at i+1
            if array[i] > array[i + 1]:
                # swap elements
                swap(array, i, i+1)
                # Set exchanges to true so the do
                # while loop is not exited
                exchanges = True
            passes += 1


def insertion_sort(array):
    """ Insertion sort. O(n^2) algorithm.
        Args:
            array: The array/list to be sorted
    """
    for i in range(len(array)):
        insertion_sort_insert(array, i)


def insertion_sort_insert(array, position):
    """ Insertion sort insert method.
        Args:
            array: The array/list to insert into
            position: The position of the item we are inserting
    """
    # Value at the position
    value = array[position]
    # Find the position where the value belongs, and shift
    # every element over to create an open index for that
    # and place value there
    while position > 0 and value < array[position - 1]:
        array[position] = array[position - 1]
        position -= 1

    array[position] = value


def shell_sort(array):
    """ Shell sort. O(n^(3/2)) algorithm.
        Args:
            array: The array/list to be sorted
    """
    # Gap between adjacent elements
    gap = int(len(array) / 2)
    while gap > 0:
        for position in range(gap, len(array)):
            # Insert element at position in its sub-array
            shell_sort_insertion(array, position, gap)

        # Reset gap for next pass
        if gap == 2:
            gap = 1
        else:
            gap = int(gap / 2)


def shell_sort_insertion(array, position, gap):
    # Element to insert
    value = array[position]
    # Shift all values > value in sub-array down by gap
    while position > gap-1 and value < array[position - gap]:
        # First element not shifted.
        array[position] = array[position - gap]
        # Shift down
        position -= gap

    array[position] = value


def merge_sort(array):
    """ Merge sort. O(nlogn) algorithm.
        Args:
            array: The array/list to be sorted
    """
    if len(array) > 1:
        half = len(array) // 2
        left = array[:half]
        right = array[half:]

        # Sort left and right arrays
        merge_sort(left)
        merge_sort(right)

        # Merge the arrays
        merge(array, left, right)


def merge(output, left, right):
    o = 0 # Index for output array
    l = 0 # Index for left array
    r = 0 # Index for right array

    while l < len(left) and r < len(right):
        # If the element at index l in the left array
        # is less than the element at index r in the
        # right array add the element at index l of the
        # left array, else add the element at index r
        # of the right array
        if left[l] < right[r]:
            output[o] = left[l]
            o += 1
            l += 1
        else:
            output[o] = right[r]
            o += 1
            r += 1

    # Add all left over elements in left array
    # to output array
    while l < len(left):
        output[o] = left[l]
        o += 1
        l += 1

    # Add all left over elements in right array
    # to output array
    while r < len(right):
        output[o] = right[r]
        o += 1
        r += 1


def heap_sort(array):
    """ Heap sort. O(nlogn) algorithm.
        Args:
            array: The array/list to be sorted
    """
    build_heap(array)
    sort_heap(array)


def build_heap(array):
    """ Transforms the array/list into a heap.
        Args:
            array: The array/list to be transformed into a heap
    """
    n = 1
    while n < len(array):
        n += 1
        child = n - 1
        parent = int((child - 1) / 2)
        # If element at parent greater than or equal to zero and less than
        # element at child then swap elements
        while parent >= 0 and array[parent] < array[child]:
            swap(array, parent, child)
            child = parent
            parent = int((child - 1) / 2)


def sort_heap(array):
    """ Transforms a heap into a sorted array.
        Args:
            array: The array/list to be sorted
    """
    n = len(array)
    while n > 0:
        n -= 1
        swap(array, 0, n)

        parent = 0
        while True:
            left_child = parent * 2 + 1
            if left_child >= n:
                break
            right_child = left_child + 1
            # Find larger child
            max_child = left_child
            if right_child < n and array[left_child] < array[right_child]:
                max_child = right_child

            # If parent is smaller than the largest child
            # swap parent and largest child
            if array[parent] < array[max_child]:
                swap(array, parent, max_child)
                parent = max_child
            else:
                break


def quick_sort(array):
    # Call quick_sort_helper recursive method
    quick_sort_helper(array, 0, len(array)-1)


def quick_sort_helper(array, first, last):
    if first < last:
        pivot = partition(array, first, last)
        quick_sort_helper(array, first, pivot-1)
        quick_sort_helper(array, pivot+1, last)


def partition(array, first, last):
    threesort(array, first, last)
    swap(array, first, int((first + last) / 2))

    value = array[first]  # Pivot value
    up = first
    down = last
    done = False

    while not done:
        while up <= last and value >= array[up]:
            up = up + 1

        while value < array[down]:
            down = down - 1

        if up < down:
            swap(array, up, down)
        else:
            # Put pivot value where it belongs
            swap(array, first, down)
            # Return the pivot value index
            return down


def threesort(array, first, last):
    mid = int((first + last) / 2)

    if array[mid] < array[first]:
        swap(array, mid, first)

    if array[last] < array[mid]:
        swap(array, last, mid)

    if array[mid] < array[first]:
        swap(array, mid, first)


def swap(array, i, j):
    array[i], array[j] = array[j], array[i]
