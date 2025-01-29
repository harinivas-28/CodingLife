import matplotlib.pyplot as plt
from sklearn.datasets import make_blobs
from sklearn.model_selection import train_test_split
from sklearn.neural_network import MLPClassifier
from sklearn.metrics import accuracy_score

# Generate sample data
n_samples = 200
blob_centers = ([1, 1], [3, 4], [1, 3.3], [3.5, 1.8])
data, labels = make_blobs(n_samples=n_samples,
                         centers=blob_centers,
                         cluster_std=0.5,
                         random_state=0)

# Visualize the data
colours = ('green', 'orange', "blue", "magenta")
fig, ax = plt.subplots()
for n_class in range(len(blob_centers)):
    ax.scatter(data[labels==n_class][:, 0],
              data[labels==n_class][:, 1],
              c=colours[n_class],
              s=30,
              label=str(n_class))
plt.show()
# Split the data
train_data, test_data, train_labels, test_labels = train_test_split(data,
                                                                    labels,
                                                                    test_size=0.2)

# Train the model
clf = MLPClassifier(solver='lbfgs',
                    alpha=1e-5,
                    hidden_layer_sizes=(6,),
                    random_state=1)
clf.fit(train_data, train_labels)

# Evaluate the model
predictions_train = clf.predict(train_data)
predictions_test = clf.predict(test_data)

train_score = accuracy_score(predictions_train, train_labels)
test_score = accuracy_score(predictions_test, test_labels)
print("Score on train data: ", train_score)
print("Score on test data: ", test_score)

# XOR problem example
X = [[0., 0.], [0., 1.], [1., 0.], [1., 1.]]
y = [0, 0, 0, 1]

clf = MLPClassifier(solver='lbfgs',
                    alpha=1e-5,
                    hidden_layer_sizes=(5, 2),
                    random_state=1)

clf.fit(X, y)

# Inspect network weights
print("\nWeights between input and first hidden layer:")
print(clf.coefs_[0])
print("\nWeights between first hidden and second hidden layer:")
print(clf.coefs_[1])

# Print weights for each layer and neuron
for i in range(len(clf.coefs_)):
    number_neurons_in_layer = clf.coefs_[i].shape[1]
    for j in range(number_neurons_in_layer):
        weights = clf.coefs_[i][:,j]
        print(f"Layer {i}, Neuron {j}: {weights}")

# Print bias values
print("\nBias values for first hidden layer:")
print(clf.intercepts_[0])
print("\nBias values for second hidden layer:")
print(clf.intercepts_[1])

# Make predictions
test_inputs = [[0, 0], [0, 1], [1, 0], [0, 1],
               [1, 1], [2., 2.], [1.3, 1.3], [2, 4.8]]
result = clf.predict(test_inputs)
prob_results = clf.predict_proba(test_inputs)
print("\nProbability predictions:")
print(prob_results)
