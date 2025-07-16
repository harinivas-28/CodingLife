'''

Problem: 
Write Python code to identify if given two strings are Anagrams 
(strings that contain same set of alphabets)

Sample Input: 
-------------
listen silent

Sample Output: 
--------------
true

'''
s1, s2 = input().split()
print(sorted(s1) == sorted(s2))
