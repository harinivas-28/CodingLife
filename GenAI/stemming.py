import nltk
from nltk.stem import PorterStemmer
from nltk.tokenize import word_tokenize

def demonstrate_stemming():
    ps = PorterStemmer()
    words = [
        "program", "programs", "programmer", 
        "programming", "programmers"
    ]
    for word in words:
        print(f"{word:12} : {ps.stem(word)}")

if __name__ == "__main__":
    demonstrate_stemming()
