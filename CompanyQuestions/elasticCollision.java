package CompanyQuestions;
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

public class elasticCollision {

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

