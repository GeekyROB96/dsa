/*
 * 
 * TOPOLOGICAL SORT
 * 
 * 
 * Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.


 */

 import java.util.*;
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] ans = new int[V];
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[V];
        
        for(int i =0;i<V;i++){
            if(!visited[i]){
                topsortUtil(adj,i,visited,s);
            }
        }
        int idx=0;
        while(!s.isEmpty()){
            ans[idx++] = s.pop();
        }
        return ans;
    }
    
    public static void topsortUtil(ArrayList<ArrayList<Integer>> adj, int curr, boolean visited[], Stack<Integer> s){
        
        visited[curr] = true;
        
        for(int neigh: adj.get(curr)){
            if(!visited[neigh]) topsortUtil(adj,neigh,visited,s);
        }
        
        s.push(curr);
    }
}