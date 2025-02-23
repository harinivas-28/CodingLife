import matplotlib.pyplot as plt
from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
from sklearn.neural_network import MLPClassifier
from sklearn.metrics import accuracy_score

# Load the Iris dataset
iris = load_iris()
data, labels = iris.data, iris.target

# Split the data into training and testing sets
train_data, test_data, train_labels, test_labels = train_test_split(data, labels, test_size=0.2, random_state=0)

# Train the MLPClassifier
clf = MLPClassifier(solver='lbfgs', alpha=1e-5, hidden_layer_sizes=(6,), random_state=1)
clf.fit(train_data, train_labels)

# Evaluate the classifier
train_score = accuracy_score(clf.predict(train_data), train_labels)
test_score = accuracy_score(clf.predict(test_data), test_labels)
print("Score on train data: ", train_score)
print("Score on test data: ", test_score)

# Print the weights and biases of the trained model
print("\nWeights between input and first hidden layer:")
print(clf.coefs_[0])
print("\nWeights between first hidden and second hidden layer:")
print(clf.coefs_[1])

for i in range(len(clf.coefs_)):
    for j in range(clf.coefs_[i].shape[1]):
        print(f"Layer {i}, Neuron {j}: {clf.coefs_[i][:,j]}")

print("\nBias values for first hidden layer:")
print(clf.intercepts_[0])
print("\nBias values for second hidden layer:")
print(clf.intercepts_[1])

# Test the classifier with some sample inputs
test_inputs = [[5.1, 3.5, 1.4, 0.2], [6.7, 3.1, 4.7, 1.5], [7.2, 3.6, 6.1, 2.5]]
print("\nProbability predictions:")
print(clf.predict_proba(test_inputs))
