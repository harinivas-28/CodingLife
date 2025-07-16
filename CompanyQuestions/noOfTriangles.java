package CompanyQuestions;
/*
You are given a triangular assortment of size N, where:
N is an even integer representing the total number of rows.
The triangles are arranged in a diamond-shaped structure with:
The number of triangles in each row increasing up to row N/2,
Then decreasing from row N/2 + 1 to N.
Each triangle is assigned a unique ID, starting from 1 at the top, and
increasing left-to-right within a row and top-to-bottom across rows.
Two triangles are adjacent if they share a common edge.


Given a triangular grid of size N, generate the adjacency list representation
of the structure. That is, for each triangle ID, output the list of triangle IDs to
which it is directly connected (i.e., triangles sharing a common edge with it).

Input Format:
        -------------
An even integer N (2 ≤ N ≤ 20), representing the number of rows in the diamond.

Output Format:
        --------------
For each triangle ID from 1 to (N × N / 2), print:
Triangle X -> [list of adjacent triangle IDs]
The adjacency list must reflect the physical edge-sharing in the diamond layout.

Sample Input:
        -------------
        4

Sample Output:
        ---------------
        1 -> [3]
        2 -> [3, 5]
        3 -> [1, 2, 4]
        4 -> [3, 7]
        5 -> [2, 6]
        6 -> [5, 7, 8]
        7 -> [4, 6]
        8 -> [6]



        case =1
input =2
output =1 -> [2]
        2 -> [1]

        case =2
input =4
output =1 -> [3]
        2 -> [3, 5]
        3 -> [1, 2, 4]
        4 -> [3, 7]
        5 -> [2, 6]
        6 -> [5, 7, 8]
        7 -> [4, 6]
        8 -> [6]

        case =3
input =6
output =1 -> [3]
        2 -> [3, 6]
        3 -> [1, 2, 4]
        4 -> [3, 8]
        5 -> [6, 10]
        6 -> [2, 5, 7]
        7 -> [6, 8, 12]
        8 -> [4, 7, 9]
        9 -> [8, 14]
        10 -> [5, 11]
        11 -> [10, 12, 15]
        12 -> [7, 11, 13]
        13 -> [12, 14, 17]
        14 -> [9, 13]
        15 -> [11, 16]
        16 -> [15, 17, 18]
        17 -> [13, 16]
        18 -> [16]

        case =4
input =8
output =1 -> [3]
        2 -> [3, 6]
        3 -> [1, 2, 4]
        4 -> [3, 8]
        5 -> [6, 11]
        6 -> [2, 5, 7]
        7 -> [6, 8, 13]
        8 -> [4, 7, 9]
        9 -> [8, 15]
        10 -> [11, 17]
        11 -> [5, 10, 12]
        12 -> [11, 13, 19]
        13 -> [7, 12, 14]
        14 -> [13, 15, 21]
        15 -> [9, 14, 16]
        16 -> [15, 23]
        17 -> [10, 18]
        18 -> [17, 19, 24]
        19 -> [12, 18, 20]
        20 -> [19, 21, 26]
        21 -> [14, 20, 22]
        22 -> [21, 23, 28]
        23 -> [16, 22]
        24 -> [18, 25]
        25 -> [24, 26, 29]
        26 -> [20, 25, 27]
        27 -> [26, 28, 31]
        28 -> [22, 27]
        29 -> [25, 30]
        30 -> [29, 31, 32]
        31 -> [27, 30]
        32 -> [30]
*/

public class noOfTriangles {
}
