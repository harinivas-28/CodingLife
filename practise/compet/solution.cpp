#include <bits/stdc++.h> 
#define ll long long int
#define nl "\n"
#define Fast()                              \
    ios_base::sync_with_stdio(false);       \
    cin.tie(NULL);                          \
    cout.tie(NULL);

#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace std;
using namespace __gnu_pbds;

struct comp {
    // Operator() overloading
    bool operator()(const pair<ll, ll>& p1, const pair<ll, ll>& p2) {
        // new definition
        return p1.second < p2.second;
    }
};

template <typename T> using PQ = priority_queue<T>;
template <typename T> using QP = priority_queue<T, vector<T>, greater<T>>;
template <typename T> using ordered_set = tree<T, null_type, less<T>, rb_tree_tag, tree_order_statistics_node_update>;
template <typename T> using ordered_multiset = tree<T, null_type, less_equal<T>, rb_tree_tag, tree_order_statistics_node_update>;
template <typename T, typename R> using ordered_map = tree<T, R, less<T>, rb_tree_tag, tree_order_statistics_node_update>;
template <typename T, typename R> using ordered_multimap = tree<T, R, less_equal<T>, rb_tree_tag, tree_order_statistics_node_update>;

ll BigMod(ll b, ll p, ll m) {
    if (p == 0) return 1;
    if (p % 2 == 0) {
        ll s = BigMod(b, p / 2, m);
        return ((s % m) * (s % m)) % m;
    }
    return ((b % m) * (BigMod(b, p - 1, m) % m)) % m;
}

ll mod = 1e9 + 7;

void solve() {
    
}

int main() {
    Fast();
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    ll t;
    cin >> t;
    while (t--) solve();
}

