package graphs;

/*
 * 
 * DFS GRAPH
 * 
 * 
 * 
 */
import java.util.*;



 
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        boolean visited[] = new boolean[V];

        dfs(adj, ans, 0 ,visited);
        return ans;
    }
    
    void dfs( ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, int curr, boolean visited[]){
        
        
        ans.add(curr);
        visited[curr] = true;
        
        
        for(int edge: adj.get(curr)){
            
            if(!visited[edge])  dfs(adj,ans,edge,visited);
        }
    }
}