import nltk
from nltk.stem import PorterStemmer
from nltk.tokenize import word_tokenize

def demonstrate_stemming():
    """
    Demonstrate the use of Porter Stemmer on various forms of the word 'program'
    """
    ps = PorterStemmer()
    
    # Test words showing different forms of 'program'
    words = [
        "program", "programs", "programmer", 
        "programming", "programmers"
    ]
    
    # Print original word and its stemmed form
    for word in words:
        print(f"{word:12} : {ps.stem(word)}")

if __name__ == "__main__":
    demonstrate_stemming()
