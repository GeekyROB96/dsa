/*
 * Topo sort by BFS
 */


 import java.util.*;
class Solution {
    
    public static void calculateInd(ArrayList<ArrayList<Integer>> adj, int V, int[] ind) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int e = adj.get(i).get(j);
                ind[e]++;
            }
        }
    }

    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] ans = new int[V];
        int[] ind = new int[V];
        
        calculateInd(adj, V, ind);
        
        Queue<Integer> q = new LinkedList<>(); // i always write queue :(

        for (int i = 0; i < ind.length; i++) {
            if (ind[i] == 0) q.add(i);
        }

        int index = 0; 

        while (!q.isEmpty()) {
            int curr = q.remove();
            ans[index++] = curr;  

            for (int i = 0; i < adj.get(curr).size(); i++) { 
                int e = adj.get(curr).get(i);
                ind[e]--;
                if (ind[e] == 0) q.add(e);
            }
        }

        return ans;
    }
}
