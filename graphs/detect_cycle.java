package graphs;

import java.util.*;
/*
 * 
 * Input:  
V = 5, E = 5
adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} 
Output: 1
Explanation: 

1->2->3->4->1 is a cycle.
 */
public class detect_cycle {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && detectCycle(adj, visited, i, -1)) {
                return true;
            }
        }
        return false;
    }

    public boolean detectCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int curr, int parent) {
        visited[curr] = true;

        for (int neighbor : adj.get(curr)) { //this can help in reducing time limit
            if (!visited[neighbor]) {
                if (detectCycle(adj, visited, neighbor, curr)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }
    
}
