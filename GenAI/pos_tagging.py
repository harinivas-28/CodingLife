import nltk
# nltk.download('punkt_tab')
# nltk.download('averaged_perceptron_tagger_eng')
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize, sent_tokenize

def analyze_text(text=None):
    stop_words = set(stopwords.words('english'))
    sample_text = (
        "Sukanya, Rajib and Naba are my good friends. "
        "Sukanya is getting married next year. "
        "Marriage is a big step in one's life. "
        "It is both exciting and frightening. "
        "But friendship is a sacred bond between people. "
        "It is a special kind of love between us. "
        "Many of you must have tried searching for a friend "
        "but never found the right one."
    )
    sentences = sent_tokenize(sample_text)
    tagged_words = []
    for sentence in sentences:
        words = word_tokenize(sentence)
        filtered_words = [word for word in words if word not in stop_words]
        tagged_words.extend(nltk.pos_tag(filtered_words))
    return tagged_words

if __name__ == "__main__":
    tagged_text = analyze_text()
    print(tagged_text)
