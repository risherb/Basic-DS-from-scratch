import java.util.*;

public class BFS {

    public static void bfssearch(int u, List<Integer> result, boolean[] visited, Map<Integer, List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        visited[u] = true;
        q.add(u);

        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

    public static List<Integer> bfsofgraph(int V, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]); // undirected
        }

        boolean[] visited = new boolean[V];
        List<Integer> result = new ArrayList<>();

        bfssearch(0, result, visited, adj);
        return result;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 3},
            {2, 4}
        };

        List<Integer> result = bfsofgraph(V, edges);
        System.out.println(result); 
	}
}
