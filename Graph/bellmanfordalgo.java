import java.util.ArrayList;
import java.util.Arrays;

public class bellmanfordalgo {
    public static void main(String[] args) {
        // Adjacency list to store edges in the form of [u, v, weight]
        ArrayList<int[]> adj = new ArrayList<>();
        int V = 6;

        addEdge(0, 1, 2, adj);
        addEdge(0, 2, -5, adj);
        addEdge(1, 4, -3, adj);
        addEdge(4, 3, 5, adj);
        addEdge(2, 3, 5, adj);
        addEdge(2, 5, -3, adj);
        addEdge(3, 5, 2, adj);

        int[] result = bellmanFord(adj, V, 0);
        if (result.length == 1 && result[0] == -1) {
            System.out.println("Graph contains negative weight cycle");
        } else {
            for (int dist : result) {
                System.out.println(dist);
            }
        }
    }

    public static void addEdge(int u, int v, int weight, ArrayList<int[]> adj) {
        adj.add(new int[]{u, v, weight});
    }

    public static int[] bellmanFord(ArrayList<int[]> adj, int V, int source) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Relax edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : adj) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }

        // Check for negative weight cycles
        for (int[] edge : adj) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                return new int[]{-1}; // Indicating that there is a negative weight cycle
            }
        }

        return distance;
    }
}
