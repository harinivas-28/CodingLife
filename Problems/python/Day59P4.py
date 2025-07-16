'''
Problem: Write a program to count each word's first index and total occurrences 
in a sentence.

Sample Input: 
apple banana apple orange banana apple

Sample Output:
apple -> first index: 0, count: 3
banana -> first index: 6, count: 2
orange -> first index: 19, count: 1

'''
from collections import defaultdict

s = input()
words = s.split()
dic = {}
idx = 0
for word in words:
    start_index = s.find(word, idx)
    if word not in dic:
        dic[word] = [start_index, 1]
    else:
        dic[word][1]+=1
    index = start_index + len(word)

for word, (first_idx,cnt) in dic.items():
    print(f"{word} -> first index: {first_idx}, count: {cnt}")
