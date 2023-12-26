/*
 * Prims
 * 
 * 
 * 
 * Given a weighted, undirected and connected graph of V vertices and E edges.
 *  The task is to find the sum of weights of the edges of the Minimum Spanning Tree. 
 * Given adjacency list adj as input parameters .
 *  Here adj[i] contains vectors of size 2, where the first integer in that vector denotes the end of the edge and the second integer denotes the edge weight.

 

Example 1:

Input:
3 3
0 1 5
1 2 3
0 2 1



Output:
4
Explanation:

The Spanning Tree resulting in a weight
of 4 is shown above.
 */


 
class Solution {

    public static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    static int spanningTree(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new Pair(v, weight));
            adj.get(v).add(new Pair(u, weight));
        }

        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int ans = 0;

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!visited[curr.v]) {
                visited[curr.v] = true;
                ans += curr.cost;
                for (Pair neighbor : adj.get(curr.v)) {
                    if (!visited[neighbor.v]) {
                        pq.add(neighbor);
                    }
                }
            }
        }

        return ans;
    }
}