'''
Write a python program to convert a decimal number to binary using both
1. Recursive method
2. Iterative method

Implement the methods in Solution class and return the binary number.

Sample Input:
---------------
10

Sample Output:
------------------
Binary (Recursive): 1010
Binary (Iterative): 1010
'''

def iterative(n):
    res = ""
    while n>0:
        res += (str)(n&1)
        n>>=1
    print(res[::-1])

def recursive(n):
    if n == 0:
        return ""
    else:
        return recursive(n // 2) + str(n % 2)

n = int(input())
iterative(n)
res = recursive(n)
print(res)