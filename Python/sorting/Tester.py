from SortingMethods import *
import time
import random


def output(array, method, timeSpan):
    print(method + ":")
    print("============================================")
    print(str(len(array)) + " items")
    print(str(timeSpan) + " seconds to sort")
    print("============================================")


arr = []
for i in range(10000):
    arr.append(random.randint(0, 100))

arr2 = arr.copy()
start = time.time()
selection_sort(arr2)
end = time.time()
output(arr2, "Selection Sort", (end - start) / 1000)

arr2 = arr.copy()
start = time.time()
bubble_sort(arr2)
end = time.time()
output(arr2, "Bubble Sort", (end - start) / 1000)

arr2 = arr.copy()
start = time.time()
insertion_sort(arr2)
end = time.time()
output(arr2, "Insertion Sort", (end - start) / 1000)

arr2 = arr.copy()
start = time.time()
merge_sort(arr2)
end = time.time()
output(arr2, "Merge Sort", (end - start) / 1000)

arr2 = arr.copy()
start = time.time()
heap_sort(arr2)
end = time.time()
output(arr2, "Heap Sort", (end - start) / 1000)

arr2 = arr.copy()
start = time.time()
quick_sort(arr2)
end = time.time()
output(arr2, "Quick Sort", (end - start))
