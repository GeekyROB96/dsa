package graphs;
import java.util.*;
public class bfs {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q  = new LinkedList<>();
        
        q.add(0);
        
        
        boolean visited[] = new boolean[V];
        
        
        visited[0] = true;
        
        while(!q.isEmpty()){
            int curr = q.remove();
            
            ans.add(curr);
            
            for(int val:adj.get(curr)){
                
                if(!visited[val]){
                    q.add(val);
                    visited[val] = true;
                }
            }
        }
        
        return ans;
    }
}
