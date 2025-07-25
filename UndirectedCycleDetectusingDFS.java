import java.util.*;

public class UndirectedCycleDetectusingDFS{

    public static boolean dfs(int u, List<List<Integer>> adj, boolean[] visited, int parent) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (v == parent) continue;
            if (visited[v]) return true;
            if (dfs(v, adj, visited, u)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 5;  // Number of nodes (0 to 4)

        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 4},
            {4, 1}  // This introduces a cycle
        };

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        boolean hasCycle = false;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, -1)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        System.out.println("Cycle Detected: " + hasCycle);
    }
}
