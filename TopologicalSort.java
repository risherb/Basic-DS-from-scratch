import java.util.*;
public class TopologicalSort{
	static void tappu(int u, int[] visited, List<List<Integer>> adj, Stack<Integer> stack){
		visited[u] = 1;
		for (int v : adj.get(u)){
			if (visited[v] == 0){
				tappu(vs,visited,adj,stack);
			}
		}
		stack.push(u);
	}
	public static void main (String[] args){
		int V = 6;
		List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
		adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
		
		int[] visited = new int[V];
		Stack<Integer> stack = new Stack<>();
		for (int i=0; i<V ; i++){
			if (visited[i] == 0) tappu(i,visited,adj,stack);
		}
		
		while (!stack.isEmpty()){
			System.out.print(stack.pop());
		}
	}
}