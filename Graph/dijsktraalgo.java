import java.util.*;
class pair{
    int first ;
    int second;
    pair(int first,int second){
        this.first = first;
        this.second=second;
    }
}
public class dijsktraalgo {
    public static void main(String[] args) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        int V = 6;
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        addedge(0,1,2,adj);
        addedge(0,2,5,adj);
        addedge(1,4,3, adj);
        addedge(4,3,5, adj);
        addedge(2,3,5, adj);
        addedge(2, 5, 3, adj);
        addedge(3, 5, 2, adj);
        dijsktra(adj, V, 0);
       // System.out.println(ans);
    }
    public static void addedge(int u,int v,int weight,ArrayList<ArrayList<pair>> adj){
        adj.get(u).add(new pair(v, weight));
        adj.get(v).add(new pair(u, weight));

    }
    public static void dijsktra(ArrayList<ArrayList<pair>> adj,int V,int source){
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->a.second-b.second);
        int distance[] = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        pq.add(new pair(source, 0));
        distance[source]=0;
        while (!pq.isEmpty()) {
            pair p = pq.poll();
            int u = p.first;
            //int uw = p.second no need of that weight because while filling the distance array we are using node at current idx which is u
            //or adding the weight of next node
            for(pair s : adj.get(u)){
                int v = s.first;
                int vw = s.second;
                if(distance[u]+vw<distance[v]){
                    distance[v] = distance[u]+vw;
                    pq.add(new pair(v, distance[v]));
                }
            }
        }
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + distance[i]);
        }
    }
}
