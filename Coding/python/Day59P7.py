'''
Problem: 
--------
Write a Python code to identify the nth largest number without 
sorting the array


Sample Input:
-------------
4 2
3 1 5 2

Sample Output:
--------------
3

'''
import heapq
n, k = map(int, input().split())
arr = list(map(int, input().split()))

if k>len(arr):
    print("K should be less than array size")
else:
    min_heap = []
    for num in arr:
        heapq.heappush(min_heap, num)
        if len(min_heap)>k:
            heapq.heappop(min_heap)
    print(min_heap[0])


