package PYQ;
import java.util.*;
/*
Question 3 – Tree Puzzle
Shifu was good at solving problems involving trees.so one day as a challenge Master Oogway gave him a problem.He gave Shifu the post-order and in-order traversals of a tree and asked him to tell the elements in a sequential order present between two levels of that tree whose index he had provided himself.

Input Specification:
--------------------
 input1: The in-order traversal array of the tree
 input2: The post-order traversal array of the tree
 input3: The lower level 'l'
 input4: The higher level 'h'

Output Specification:
--------------------
 Return the array representing the elements between input3 and input4 levels of the tree.

Example 1:
----------
input1: [2, 1, 3]
input2: [2, 3, 1]
input3: 1
input4: 2
Output: [1, 2, 3]


Explanation:
-------------
The tree is:


    1
   / \
  2   3


and the nodes between Levels 1 and 2 are 1, 2 and 3.

Example 2:
----------
input1: [4, 2, 5, 1, 6, 3, 7]
input2: [4, 5, 2, 6, 7, 3, 1]
input3: 2
input4: 3

Output: [2, 3, 4, 5, 6, 7]


Explanation:
------------
Here,the tree will be:


        1
       / \
      2   3
     / \ / \
    4  5 6  7


and the nodes between Levels 2 and 3 are 2, 3, 4, 5, 6, 7.
 */
public class TreePuzzle {
}
