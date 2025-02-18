import nltk
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize

def remove_stopwords(text):
    try:
        stop_words = set(stopwords.words('english'))
        word_tokens = word_tokenize(text)
        filtered_tokens = [word for word in word_tokens if word.lower() not in stop_words]
        return word_tokens, filtered_tokens
    except Exception as e:
        print(f"Error: {e}")
        return [], []

if __name__ == "__main__":
    sample_text = "This is a sample sentence, showing off the stop words filtration."
    original, filtered = remove_stopwords(sample_text)
    print("Original tokens:", original)
    print("Filtered tokens:", filtered)
