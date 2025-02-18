import matplotlib.pyplot as plt
from sklearn.datasets import make_blobs
from sklearn.model_selection import train_test_split
from sklearn.neural_network import MLPClassifier
from sklearn.metrics import accuracy_score

n_samples = 200
blob_centers = ([1, 1], [3, 4], [1, 3.3], [3.5, 1.8])
data, labels = make_blobs(n_samples=n_samples, centers=blob_centers, cluster_std=0.5, random_state=0)

train_data, test_data, train_labels, test_labels = train_test_split(data, labels, test_size=0.2)

clf = MLPClassifier(solver='lbfgs', alpha=1e-5, hidden_layer_sizes=(6,), random_state=1)
clf.fit(train_data, train_labels)

train_score = accuracy_score(clf.predict(train_data), train_labels)
test_score = accuracy_score(clf.predict(test_data), test_labels)
print("Score on train data: ", train_score)
print("Score on test data: ", test_score)

X = [[0., 0.], [0., 1.], [1., 0.], [1., 1.]]
y = [0, 0, 0, 1]

clf = MLPClassifier(solver='lbfgs', alpha=1e-5, hidden_layer_sizes=(5, 2), random_state=1)
clf.fit(X, y)

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

test_inputs = [[0, 0], [0, 1], [1, 0], [0, 1], [1, 1], [2., 2.], [1.3, 1.3], [2, 4.8]]
print("\nProbability predictions:")
print(clf.predict_proba(test_inputs))
