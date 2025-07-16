'''
Write python code for a method which takes a String (a sentence) as input 
and returns a Map. The Map key is String (word in the String) and 
value is frequency of the word in the given sentence.
(In the words ignore any special characters)

Sample Input:
-------------
Java is fun, and Ja#va@ is powerful 

Sample Output:
--------------
java: 2
is: 2
fun: 1
and: 1
powerful: 1
'''
import re
from collections import defaultdict

def word_freq(sentence):
    cleaned = re.sub(r'[^a-zA-Z\s]', '', sentence).lower()
    words = cleaned.split()
    freq_map = defaultdict(int)
    for word in words:
        freq_map[word] += 1
    return dict(freq_map)

sentence = input()
res = word_freq(sentence)
for word, freq in res.items():
    print(f"{word}: {freq}")
