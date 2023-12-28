/*
 * 
 * 787. Cheapest Flights Within K Stops
 
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 */


 class Solution {

    public class Edge {
    int src;
    int dest;
    int wt;

    public Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
}


    public class Info{

        int vertex;
        int cost;
        int stops;

        public Info(int vertex,int cost, int stops){
        
        this.vertex = vertex;
        this.cost =cost;
        this.stops =stops;
        }
    }

    public void create(int flights[][], ArrayList<Edge> graph[]){
        for(int i =0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }


        for(int i =0;i<flights.length;i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src,dest,wt);
            graph[src].add(e);
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        //cheapest flight within k stops

        ArrayList<Edge> graph[] = new ArrayList[n];
        create(flights, graph);
        Queue<Info> q = new LinkedList<>();
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr.stops > k) break;

            for (Edge neighbor : graph[curr.vertex]) {
                int dest = neighbor.dest;
                int wt = neighbor.wt;

                if (curr.cost + wt < dist[dest]) {
                    dist[dest] = curr.cost + wt;
                    q.add(new Info(dest, dist[dest], curr.stops + 1));
                }
            }
        }

        return (dist[dst] == Integer.MAX_VALUE) ? -1 : dist[dst];
    }

}