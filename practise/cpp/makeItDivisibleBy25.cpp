/*
1593
B. Make it Divisible by 25

-----

### Time Limit: 1 second

### Memory Limit: 256 megabytes

It is given a positive integer $n$. In $1$ move, one can select any single digit and remove it (i.e., one selects some position in the number and removes the digit located at this position). The operation cannot be performed if only one digit remains. If the resulting number contains leading zeroes, they are automatically removed.

**Examples:**

  * If one removes the $3$-rd digit from the number $32925$, the resulting number will be $3225$.
  * If one removes the first digit from the number $20099050$, the resulting number will be $99050$ (the two zeroes going next to the first digit are automatically removed).

What is the minimum number of steps to get a number such that it is divisible by $25$ and positive? It is guaranteed that, for each $n$ occurring in the input, the answer exists. It is guaranteed that the number $n$ has no leading zeros.

-----

### Input

The first line contains one integer $t$ ($1 \\le t \\le 10^4$) — the number of test cases. Then $t$ test cases follow.

Each test case consists of one line containing one integer $n$ ($25 \\le n \\le 10^{18}$). It is guaranteed that, for each $n$ occurring in the input, the answer exists. It is guaranteed that the number $n$ has no leading zeros.

-----

### Output

For each test case output on a separate line an integer $k$ ($k \\ge 0$) — the minimum number of steps to get a number such that it is divisible by $25$ and positive.

-----

### Example

**Input:**

```
5
100
71345
3259
50555
2050047
```

**Output:**

```
0
3
1
3
2
```

-----

**Note:**

  * In the first test case, it is already given a number divisible by $25$.
  * In the second test case, we can remove the digits $1$, $3$, and $4$ to get the number $75$.
  * In the third test case, it's enough to remove the last digit to get the number $325$.
  * In the fourth test case, we can remove the three last digits to get the number $50$.
  * In the fifth test case, it's enough to remove the digits $4$ and $7$.
*/
#include<bits/stdc++.h>
using namespace std;

int minSteps(string s, string end){
    int n = s.size();
    int pos1 = -1, pos2 = -1;
    for(int i=n-1;i>=0;i--){
        if(s[i]==end[1]){
            pos2 = i;
            for(int j=i-1;j>=0;j--){
                if(s[j]==end[0]){
                    pos1 = j;
                    return (pos2-pos1-1)+(n-pos2-1);
                }
            }
        }
    }
    return 1e9;
}

int main(){
    int t;
    cin >> t;
    while(t--){
        string s;
        cin >> s;
        int res = 1e9;
        res = min(res, minSteps(s, "00"));
        res = min(res, minSteps(s, "25"));
        res = min(res, minSteps(s, "50"));
        res = min(res, minSteps(s, "75"));
        cout << res << endl;
    }
}