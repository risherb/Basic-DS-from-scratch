import java.util.*;

public class isCycleDirectedDFS {

    static boolean isCycle(int[] visited, int[] inRecursion, int u, List<List<Integer>> adj) {
        visited[u] = 1;
        inRecursion[u] = 1;

        for (int v : adj.get(u)) {
            if (visited[v] == 0) {
                if (isCycle(visited, inRecursion, v, adj))
                    return true;
            } else if (inRecursion[v] == 1) {
                return true;
            }
        }

        inRecursion[u] = 0;
        return false;
    }

    static boolean isCyclic(int V, List<List<Integer>> adj) {
        int[] visited = new int[V];
        int[] inRecursion = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (isCycle(visited, inRecursion, i, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);

        if (isCyclic(V, adj)) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle");
        }
    }
}
