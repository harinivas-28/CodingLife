// #include <bits/stdc++.h>
// using namespace std;

// // Round 1005
// // A
// int main() {
// 	long long t ; 
// 	cin >> t; 
// 	while(t--)
// 	{
// 	    long long n ;
// 	    cin >> n ; 
// 	    string s ; 
// 	    cin >> s; 
// 	    long long cnt = 0 ; long long x = 1;
// 	    for(long long i = 0 ;i<n;i++)
// 	    {
// 	        if((s[i]- '0') == x ){
// 	        cnt++;
// 	        x = 1-x;}
// 	    }
// 	    cout << cnt << endl;
// 	}
// }

// // B
 
// void solve(int tt)
// {
//     int n;
//     cin >> n;
//     vi a(n);
//     cin >> a;
//     vi f(n + 1);
//     for (int i = 0; i < n; i++)
//     {
//         f[a[i]]++;
//     }
//     int flag = 1;
//     for (int i = 0; i < n; i++)
//     {
//         if (f[i + 1] == 1)
//             flag = 0;
//     }
//     if (flag)
//     {
//         cout << 0 << endl;
//         return;
//     }
//     int ans = 0, ans_l, ans_r;
//     int j = 0;
//     for (int i = 0; i < n; i++)
//     {
//         if (f[a[i]] == 1)
//         {
//             j = max(j, i);
//             while (j + 1 < n && f[a[j + 1]] == 1)
//             {
//                 j++;
//             }
//             if (j - i + 1 > ans)
//             {
//                 ans_l = i + 1, ans_r = j + 1;
//                 ans = j - i + 1;
//             }
//         }
//     }
//     cout << ans_l << " " << ans_r << endl;
// }
 
// int main()
// {
//     ios_base::sync_with_stdio(false);
//     cin.tie(NULL);
//     int tt = 1;
//     cin >> tt;
//     while (tt--)
//     {
//         solve(tt);
//     }
// }

// // C
// #include<bits/stdc++.h>
// using namespace std;
// #define int long long
// #define sz(x) static_cast<int>((x).size())
// #define all(x) begin(x), end(x)
// const int mod = 1e9 + 7;


// void solve(){

//     int n;
//     cin >> n;

//     vector<int> a(n);
//     for (auto &x : a) cin >> x;

//     vector<int> p(n);
//     for (int i = 0; i < n; i++){
//         p[i] = (i > 0 ? p[i - 1] : 0) + (a[i] > 0 ? a[i] : 0);
//     }

//     vector<int> s(n);
//     for (int i = n - 1; i >= 0; i--){
//         s[i] = (i < n - 1 ? s[i + 1] : 0) + (a[i] < 0 ? abs(a[i]) : 0);
//     }

//     int ans = 0;
//     for (int i = 0; i < n; i++){
//         ans = max(ans, p[i] + s[i]);
//     }

//     cout << ans << '\n';

// }


// signed main(){
 
//     ios::sync_with_stdio(0);
//     cin.tie(0);
//     int t = 1;
//     cin >> t;
//     while(t--) solve();
// }

// // D
// #include<bits/stdc++.h>
// using namespace std;
// #define int long long
// int a[1000009];
// int qz[1000009];
// int nxt[200009][32];
// void _main(){
// 	int n,q;
// 	cin>>n>>q;
// 	for(int i=1;i<=n;i++){
// 		cin>>a[i];
// 		qz[i]=(a[i]^qz[i-1]);
// 	}
// 	for(int i=1;i<=n;i++){
// 		for(int j=0;j<=30;j++){
// 			nxt[i][j]=nxt[i-1][j];
// 		}
// 		int z;
// 		z=__lg(a[i]);
// 		for(int j=z;j>=0;j--){
// 			nxt[i][j]=i;
// 		}
// 	}
// 	a[0]=(1ll<<30);
// 	while(q--){
// 		int x;
// 		cin>>x;
// 		int s;
// 		s=n+1;
// 		while(x>=a[s-1]){
// 			x^=a[s-1];
// 			s--;
// 			int z;
// 			z=nxt[s-1][__lg(x)];
// 			x^=(qz[s-1]^qz[z]);
// 			s=z+1;
// 		}
// 		cout<<n-s+1<<" ";
// 	}
// 	cout<<endl; 
// }
// signed main(){
// 	int t;
// 	cin>>t;
// 	while(t--){
// 		_main();
// 	}
// 	return 0;
// }

