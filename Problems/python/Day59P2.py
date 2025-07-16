'''
Write a python program to find the nth prime number. 
The value of n should be input by the user.

Sample Input:
---------------
5

Sample Output:
-----------------
11
'''
import math

def is_prime(n):
    if n < 2:
        return False
    for i in range(2, int(math.isqrt(n)) + 1):
        if n % i == 0:
            return False
    return True

n = int(input())
count = 0
num = 1

while count < n:
    num += 1
    if is_prime(num):
        count += 1

print(num)