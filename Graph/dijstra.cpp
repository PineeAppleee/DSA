#include <iostream>
#include <utility>
#include <vector>
#include <bits/stdc++.h>
using namespace std;
class solution{
    public:
    vector<int> dijkstra(int V,vector<vector<pair<int,int>>> &adj,int s){
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
        vector<int,INT_MAX> dist;
        pq.push({0,s});
        dist[s] = 0;
        while(!pq.empty()){
            int u = pq.top().second;
            int weight = pq.top().first;
            for(auto it : adj[u]){
                int v = it.first;
                int w= it.second;
                if(weight+w<dist[v]){
                    dist[v] = weight+w;
                    pq.push({weight+w,v});

                }
            }
        }
        return dist;

    }
};
int main(){
    int v = 3
   vector<vector<pair<int,int>>> adj(v+1);
   adj[0].push_back({1,2});
   adj[1].push_back({2,3});
   adj[0].push_back({3,5});
   adj[0].push_back({2,7});
   solution obj;
   vector<int> sol = obj.dijkstra(v,adj,0);
   for(int i=0;i<v+1;i++){
    cout<<sol[i]<<endl;
   }
}