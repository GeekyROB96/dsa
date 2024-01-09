/*
 * Detect cycle using DSU
 */

 import java.util.*;
class Solution {
    
    // Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] parent = new int[V];
        int[] rank = new int[V];
        
        for(int i = 0; i < V; i++) {
            parent[i] = i;
        }
        
        for(int u = 0; u < V; u++) {
            for(int v : adj.get(u)) { 
                if(u < v) {
                    int u_parent = find(u, parent);
                    int v_parent = find(v, parent);
                    
                    if(u_parent == v_parent) return 1;
                    
                    union(u, v, parent, rank);
                }
            }
        }
        return 0;
    }
    
    int find(int u, int[] parent) {
        if(u == parent[u]) return u;
        return parent[u] = find(parent[u], parent); 
    }
    
    void union(int u, int v, int[] parent, int[] rank) {
        int u_parent = find(u, parent);
        int v_parent = find(v, parent);
        
        if(rank[u_parent] == rank[v_parent]) {
            parent[v_parent] = parent[u_parent];
            rank[v_parent]++;
        } else if(rank[u_parent] > rank[v_parent]) {
            parent[v_parent] = u_parent;
            rank[u_parent]++;
        } else {
            parent[u_parent] = v_parent;
            rank[v_parent]++;
        }
    }
}
