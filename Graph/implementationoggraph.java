import java.util.*;
public class implementationoggraph{
public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    creategraph(list);
    ArrayList<Integer> list2 = dfsofarray(list, 5);
     for(int i =0;i<list2.size();i++){
        System.out.println(list2.get(i));
     }

}
public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> list,int v,ArrayList<Integer> bfs){
    Queue<Integer> pq = new LinkedList<>();
    //ArrayList<Integer> bfs = new ArrayList<>();
    boolean visited[] = new boolean[v];
    pq.add(0);
    visited[0] = true;
    while(!pq.isEmpty()){
        int node = pq.poll();
        bfs.add(node);

        for(int i : list.get(node)){
            if(!visited[i]){
                visited[i] = true;
                bfs.add(i);
            }
        }
    }
    return bfs;
}
public static void dfs(ArrayList<ArrayList<Integer>> list,ArrayList<Integer> dfsarray,boolean vis[],int node)
{
vis[node] = true;
dfsarray.add(node);

for(int x : list.get(node)){
    if(vis[x]==false){
        dfs(list,dfsarray,vis,x);
    }
}
}

public static void creategraph( ArrayList<ArrayList<Integer>> list){
    for(int i =0;i<5;i++){
        list.add(new ArrayList<>());
    }
    list.get(0).add(2);
    list.get(2).add(0);

    list.get(1).add(3);
    list.get(3).add(1);

    list.get(2).add(3);
    list.get(3).add(2);

    list.get(0).add(3);
    list.get(3).add(0);
     //implementationoggraph sl = new implementationoggraph();
}
public static ArrayList<Integer> dfsofarray(ArrayList<ArrayList<Integer>> adj,int v){
    boolean[] vis = new boolean[v];
    ArrayList<Integer> dfsarray = new ArrayList<>();
    int node = 0;
    vis[0] = true;
    dfs(adj,dfsarray,vis,node);
    return dfsarray;
}
}