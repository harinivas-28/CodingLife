import numpy as np 
import pandas as pd 
from sklearn.metrics import confusion_matrix, accuracy_score, classification_report 
from sklearn.model_selection import train_test_split 
from sklearn.tree import DecisionTreeClassifier 

def importdata(): 
    data = pd.read_csv('balance-scale.data', sep=',', header=None) 
    print("Dataset Length: ", len(data)) 
    print("Dataset Shape: ", data.shape) 
    print("Dataset: ", data.head()) 
    return data 

def splitdataset(data): 
    X = data.values[:, 1:5] 
    Y = data.values[:, 0] 
    return train_test_split(X, Y, test_size=0.3, random_state=100) 

def train_classifier(X_train, y_train): 
    clf = DecisionTreeClassifier(criterion="gini", random_state=100, max_depth=3, min_samples_leaf=5) 
    clf.fit(X_train, y_train) 
    return clf 

def prediction(X_test, clf): 
    return clf.predict(X_test) 

def cal_accuracy(y_test, y_pred): 
    print("Confusion Matrix: ", confusion_matrix(y_test, y_pred)) 
    print("Accuracy : ", accuracy_score(y_test, y_pred) * 100) 
    print("Report : ", classification_report(y_test, y_pred)) 

def main(): 
    data = importdata() 
    X_train, X_test, y_train, y_test = splitdataset(data) 
    clf_gini = train_classifier(X_train, y_train) 
    print("Results Using Gini Index:") 
    y_pred_gini = prediction(X_test, clf_gini) 
    cal_accuracy(y_test, y_pred_gini) 

if __name__ == "__main__": 
    main()
