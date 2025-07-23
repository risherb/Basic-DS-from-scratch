import java.util.*;
public class DFS{
	public static void dfssearch(int u,List<Integer> result, boolean[] visited, Map<Integer,List<Integer>> adj){
		if (visited[u]) return;
		visited[u] = true;
		result.add(u);
		for (int v : adj.getOrDefault(u, new ArrayList<>())){
			if (!visited[v]){
				dfssearch(v,result,visited,adj);
			}
		}
		
		
	}
	public static List<Integer> dfsofgraph(int V, int[][] edges){
		Map<Integer, List<Integer>> adj = new HashMap<>();
		for (int[]edge : edges){
			adj.computeIfAbsent(edge[0], k->new ArrayList<>()).add(edge[1]);
			adj.computeIfAbsent(edge[1], k->new ArrayList<>()).add(edge[0]);
		}
		boolean[] visited = new boolean[V];
		List<Integer> result = new LinkedList<>();
		dfssearch(0,result,visited,adj);
		return result;
		
		
	}
	public static void main(String[] args){
		int V = 5;
		int[][] edges ={
            {0, 1},
            {0, 2},
            {1, 3},
            {2, 4}
        };
		List<Integer> result = dfsofgraph(V,edges);
		System.out.print(result);
		
	}
	
}