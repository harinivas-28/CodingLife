/*
D. This Is the Last Time
time limit per test 2 seconds
memory limit per test 256 megabytes
You are given n
 casinos, numbered from 1
 to n
. Each casino is described by three integers: li
, ri
, and reali
 (li≤reali≤ri
). You initially have k
 coins.

You can play at casino i
 only if the current number of coins x
 satisfies li≤x≤ri
. After playing, your number of coins becomes reali
.

You can visit the casinos in any order and are not required to visit all of them. Each casino can be visited no more than once.

Your task is to find the maximum final number of coins you can obtain.

Input
The first line contains a single integer t
 (1≤t≤104
) — the number of test cases.

The first line of each test case contains two integers n
 and k
 (1≤n≤105
, 0≤k≤109
) — the number of casinos and the initial number of coins.

This is followed by n
 lines. In the i
-th line, there are three integers li
, ri
, reali
 (0≤li≤reali≤ri≤109
) — the parameters of the i
-th casino.

It is guaranteed that the sum of all n
 across all test cases does not exceed 105
.

Output
For each test case, output a single integer — the maximum number of coins you can obtain after optimally choosing the order of visiting the casinos.

Example
Input
5
3 1
2 3 3
1 2 2
3 10 10
1 0
1 2 2
1 2
1 2 2
2 2
1 3 2
2 4 4
2 5
1 10 5
3 6 5
Output
10
0
2
4
5
Note
In the first test case, you can first play at the 2
-nd casino. After that, you will have 2
 coins. Then you can play at the 1
-st casino, and the number of coins will increase to 3
. Finally, after playing at the 3
-rd casino, you will have 10
 coins — this is the maximum possible amount.

In the second test case, you have no money, so you cannot earn more.

In the fourth test case, it is beneficial to play at the 2
-nd casino right away and earn 4
 coins.
*/
#include<bits/stdc++.h>
using namespace std;

class Casino {
public:
	int l, r, coins;
	Casino(int _l, int _r, int _coins): l(_l), r(_r), coins(_coins) {
	}
	bool operator<(const Casino &other) const {
	    if(l!=other.l){
	        return l<other.l;
	    }
	    if(r!=other.r){
	        return r<other.r;
	    }
	    return coins<other.coins;
	}
	void displayDetails() const {
        std::cout << "Casino [l=" << l << ", r=" << r << ", coins=" << coins << "]" << std::endl;
    }
};

void printCasinos(const std::string& title, const std::vector<Casino>& casinos) {
    std::cout << "\n--- " << title << " ---" << std::endl;
    for (const auto& c : casinos) {
        c.displayDetails();
    }
}

void solve() {
	int n, k;
	cin >> n >> k;
	vector<Casino> v;
	for(int i=0; i<n; i++) {
		int l, r, c;
		cin >> l >> r >> c;
		v.emplace_back(Casino(l,r,c));
	}
// 	sort(v.begin(), v.end(), [](const Casino &a, const Casino &b){
// 	   if(a.l!=b.l){
// 	       return a.l<b.l;
// 	   } 
// 	   if(a.r!=b.r){
// 	       return a.r<b.r;
// 	   }
// 	   return a.coins<b.coins;
// 	});
    sort(v.begin(), v.end());
    printCasinos("Sorted using Comparator", v);
    int i =0;
    while(i<n && k>v[i].coins) i++;
    while(i<n && k>=v[i].l && k<=v[i].r){
        k = v[i].coins;
        i++;
    }
    cout<<k<<endl;
}

int main() {
	int t;
	cin >> t;
	while(t--) {
		solve();
	}
}