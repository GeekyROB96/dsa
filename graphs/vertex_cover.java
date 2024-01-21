/*
 * 
 * Vertex Cover
 * Vertex cover of an undirected graph is a list of vertices such that every vertex not in the vertex cover shares 
 * their every edge with the vertices in the vertex cover. In other words,
 *  for every edge in the graph, atleast one of the endpoints of the graph should belong to the vertex cover.
 *  You will be given an undirected graph G, and your task is to determine the smallest possible size of a vertex cover.

Example 1:

Input:
N=5
M=6
edges[][]={{1,2}
           {4, 1},
           {2, 4},
           {3, 4},
           {5, 2},
           {1, 3}}
Output:
3
Explanation:
{2, 3, 4} forms a vertex cover
with the smallest size.

 */




 class Solution {
    public static int vertexCover(int n, int m, int[][] edges) {
        // code here
        
        HashSet<Integer> set = new HashSet<>();
        
        return min(n,m,edges,0,set);
    }
    
    private static int min(int n, int m, int[][] edges, int idx, HashSet<Integer> set){
        
        
        if(idx>=m) return 0;
        
        int v1 = edges[idx][0];
        int v2 = edges[idx][1];
        
        if(!set.contains(v1)  && !set.contains(v2)){
            
            set.add(v1);
            int first = 1+ min(n,m,edges,idx+1,set);
            set.remove(v1);
            
            set.add(v2);
            int second = 1+ min(n,m,edges,idx+1,set);
            set.remove(v2);
            
            return Math.min(first,second);
        }
        
        return min(n,m,edges,idx+1,set);
    }
}

//TC : O(M*2^N) - Since for every edges i do call twice in worst case.

//SC: O(N)  - Because of HashSet