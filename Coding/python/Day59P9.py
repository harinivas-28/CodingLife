'''
Write python program to find and return minimum number of denominations – given 
an infinite supply of each denomination of {1, 2, 5, 10, 20, 50, 100, 200,500, 
2000} and a target value N

Sample Input: 
-------------
187

Sample Output: 
--------------
[100, 50, 20, 10, 5, 2]

'''
d = [1, 2, 5, 10, 20, 50, 100, 200,500, 2000]
n = int(input())
res = []
while n>0:
    for i in d[::-1]:
        if n>=i:
            times = n//i
            while times>0:
                res.append(i)
                times-=1
            n = n%i
print(res)
