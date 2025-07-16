package CompanyQuestions;
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

public class minimumDistance {

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
