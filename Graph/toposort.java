import java.util.*;

public class toposort {
    
    public static void main(String[] args) {
        int mat[][] = {{1,0},{0,1}};
       System.out.println(cyclic(mat,2));
    }
    public static boolean cyclic(int[][] mat, int v){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<v;i++){
            adj.get(mat[i][0]).add(mat[i][1]);
        }
        int indegree[] = new int[v];
        for(int i =0;i<v;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> pq = new LinkedList<>();
        
        for(int i =0;i<indegree.length;i++){
         if(indegree[i]==0) pq.add(i);
        }
        List<Integer> topo = new ArrayList<>();
        while(!pq.isEmpty()){
            int node = pq.poll();
            topo.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    pq.add(it);
                }
            }
        }
        if(topo.size()==v) return true;
        return false;
       
     
    }
}
