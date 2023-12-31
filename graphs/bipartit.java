/*
Bipartite Graph

Given an adjacency list of a graph adj  of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];

        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;

                while (!q.isEmpty()) {
                    int curr = q.remove();

                    for (int j = 0; j < adj.get(curr).size(); j++) {
                        int e = adj.get(curr).get(j);

                        if (color[e] == -1) {
                            color[e] = 1 - color[curr];
                            q.add(e);
                        } else if (color[e] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
