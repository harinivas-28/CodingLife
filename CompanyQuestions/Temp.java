package CompanyQuestions;

public class Temp {
}
/*
AnnaMike loves Physics! Recently, he learned about Elastic Collisions. A perfectly
elastic collision is the one where the total momentum of the colliding bodies does
not change after the collision. A very important property of elastic collisions,
that AnnaMike observed is that, if the 2 colliding bodies have equal masses, their
velocities will be exchanged after the collision.

AnnaMike decided to conduct an experiment to demonstrate this property.
He bought N balls, all having equal masses, and a long board having length L
(in meters). He placed the balls at different positions on the board, placing
the ith ball at a distance of Ai, measured from the left end (in meters).

At time t=0, he gave different velocities to each of the balls. The ith ball
received a velocity equal to Vi (in meters per second). (Vi ≠ 0, for any i).
A negative velocity indicates that the ball was pushed to the left, while a
positive velocity is the one that is directed towards right.

AnnaMike was immensely happy to see the large number of collisions that happened
on the board. But, the balls soon started to fall off the board (from both the ends),
and finally there was no ball left. He is now interested to know : At what time
did the last ball fall? Will you help him?

NOTE:
-----
- A ball will fall off the board when it is moving towards left and reaches x = 0,
or when it is moving towards right and reaches x = L.
(x is measured from the left end of the board)

- It is guaranteed that eventually all the balls will fall off the board.

Input Format:
-------------
Line-1: Two space separated integers N,L, number of balls and length
Line-2: N space seprated integers, positions of balls
Line-3: Direction of balls left(-1) or right(1)

Output Format:
-------------
An integer output


Sample Input-1:
---------------
4 4
0 1 3 4
1 1 -1 -1

Sample Output-1:
----------------
4


Sample Input-2:
---------------
4 6
2 3 4 5
1 -1 1 -1

Sample Output-2:
----------------
5


=== testcases ===
case =1
input =4 4
0 1 3 4
1 1 -1 -1
output =4

case =2
input =4 6
2 3 4 5
1 -1 1 -1
output =5

case =3
input =2 3
1 2
1 -1
output =2

case =4
input =2 3
1 2
-1 1
output =1

case =5
input =6 7
0 2 3 4 5 7
1 1 1 1 1 1
output =7

case=6
input =6 7
1 2 3 4 5 6
-1 -1 -1 -1 -1 -1
output =6

case =7
input =3 5
1 2 3
-1 1 -1
output =3

case =8
input =3 5
1 2 3
1 1 -1
output =4

*/

import java.util.Scanner;

public class ElasticCollision {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of balls and the length of the board
        int N = scanner.nextInt();
        int L = scanner.nextInt();

        // Read the positions of the balls
        int[] positions = new int[N];
        for (int i = 0; i < N; i++) {
            positions[i] = scanner.nextInt();
        }

        // Read the directions of the balls
        int[] directions = new int[N];
        for (int i = 0; i < N; i++) {
            directions[i] = scanner.nextInt();
        }

        // Calculate the time for each ball to fall off the board
        int maxTime = 0;
        for (int i = 0; i < N; i++) {
            int timeToFall = 0;
            if (directions[i] == 1) { // Moving to the right
                timeToFall = L - positions[i];
            } else { // Moving to the left
                timeToFall = positions[i];
            }
            if (timeToFall > maxTime) {
                maxTime = timeToFall;
            }
        }

        // Print the time when the last ball falls off the board
        System.out.println(maxTime);

        scanner.close();
    }
}
/*
In the near future, human engineers have realized that the optimal model for
organizing infrastructure in cities is the fully connected graph.
Kura recently moved into the town of Koenigsberg. Its a small town that consists
of only 4 houses, for each of its inhabitants.

As the new arrival, Kura discovers that he has three neighbors: Leon, Lieb and Hamil.
Also, he finds a map of the town in your house. It looks like this in
a weighted graph format: Kura's house is marked as h, Leon's house is marked
as a, Lieb's house is marked as b, and Hamil's house is marked as c and
ha, hb, hc, ab, bc & ca represent the repective distances between the houses.

From the map, Kura was able to determine that the distance from any place ' x '
on the map to a place ' y ' on the map is same as the distance from ' y ' to ' x '.
After spending the day unpacking, Kura decided to visit 2 of his neighbors.
Since, he has limited energy to walk, you must help Kura determine
the minimum distance he must walk to meet any 2 of his neighbors and come back home.
He doesn't mind visiting the same neighbor or passing the same road multiple times.
The only goal is to minimize the total distance traveled.


Input Format:
-------------
space separated 6 integers representing ha, hb, hc, ac,ab,bc

Output Format:
--------------
A single number representing minimum distance that kura needs to travel to
visit any 2 of his neighbors and return home.

Constraints:
------------
1<=ha,hb,hc,ac,ab,bc<= 10^12

Sample input:
-------------
3 2 8 8 1 4

Sample output:
--------------
6


=== TESTCASES ===
case =1
input =3 2 8 8 1 4
output =6

case =2
input =9 18 27 36 45 54
output =54

case =3
input =1 2 3 4 5 6
output =6

case =4
input =10 56 34 78 108 94
output =88

case =5
input =89 34 76 76 109 59
output =169

case =6
input =10 100 1000 20 50 100
output =160

*/

import java.util.Scanner;

public class MinimumDistance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the distances
        int ha = scanner.nextInt();
        int hb = scanner.nextInt();
        int hc = scanner.nextInt();
        int ac = scanner.nextInt();
        int ab = scanner.nextInt();
        int bc = scanner.nextInt();

        // Calculate all possible paths and find the minimum distance
        int distance1 = ha + hb + ab;
        int distance2 = 2 * (ha + hb);
        int distance3 = ha + hc + ac;
        int distance4 = 2 * (ha + hc);
        int distance5 = hb + hc + bc;
        int distance6 = 2 * (hb + hc);

        int minDistance = Math.min(distance1,
                Math.min(distance2,
                        Math.min(distance3,
                                Math.min(distance4,
                                        Math.min(distance5, distance6)))));

        // Print the minimum distance
        System.out.println(minDistance);

        scanner.close();
    }
}
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

