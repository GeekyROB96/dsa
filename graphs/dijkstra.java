/*
 * 
 * Dijkstra
 * 
 * 
 * Input:
V = 2
adj [] = {{{1, 9}}, {{0, 9}}}
S = 0
Output:
0 9
Explanation:

The source vertex is 0. Hence, the shortest 
distance of node 0 is 0 and the shortest 
distance from node 1 is 9.
 

Example 2:

Input:
V = 3, E = 3
adj = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}}
S = 2
Output:
4 3 0
Explanation:

For nodes 2 to 0, we can follow the path-
2-1-0. This has a distance of 1+3 = 4,
whereas the path 2-0 has a distance of 6. So,
the Shortest path from 2 to 0 is 4.
The shortest distance from 0 to 1 is 1 .
 */



 
class Solution
{
    
    
    static class Pair implements Comparable<Pair>{
        
        int n;
        int path;
        
        public Pair(int n, int path){
            
            this.n=n;
            this.path = path;
        }
        
        
        @Override
        
        public int compareTo(Pair p2){
            return this.path- p2.path;
        }
    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
     static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != S) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(S, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!visited[curr.n]) {
                visited[curr.n] = true;

                for (int i = 0; i < adj.get(curr.n).size(); i++) {
                    ArrayList<Integer> edge = adj.get(curr.n).get(i);
                    int v = edge.get(0);   
                    int wt = edge.get(1);  

                    if (dist[curr.n] != Integer.MAX_VALUE && dist[curr.n] + wt < dist[v]) {
                        dist[v] = dist[curr.n] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        return dist;
    }
}

