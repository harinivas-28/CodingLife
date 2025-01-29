import nltk
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize

def remove_stopwords(text):
    """
    Remove stopwords from the given text
    Args:
        text (str): Input text to process
    Returns:
        tuple: Original tokens and filtered tokens
    """
    try:
        # Get English stop words
        stop_words = set(stopwords.words('english'))
        
        # Tokenize the text
        word_tokens = word_tokenize(text)
        
        # Filter out stopwords using list comprehension
        filtered_tokens = [
            word for word in word_tokens 
            if word.lower() not in stop_words
        ]
        
        return word_tokens, filtered_tokens
    
    except Exception as e:
        print(f"Error processing text: {e}")
        return [], []

if __name__ == "__main__":
    # Example text
    sample_text = """This is a sample sentence,
    showing off the stop words filtration."""
    
    # Process the text
    original, filtered = remove_stopwords(sample_text)
    
    # Display results
    print("Original tokens:", original)
    print("Filtered tokens:", filtered)
