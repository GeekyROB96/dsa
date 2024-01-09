/*
 * 
 * PRE-REQUISITE TASKS
 * 
 * 
 * There are a total of N tasks, labeled from 0 to N-1. Some tasks may have prerequisites, for example to do task 0 you have to first complete task 1, which is expressed as a pair: [0, 1]
Given the total number of tasks N and a list of prerequisite pairs P, find if it is possible to finish all tasks.



Input: 
N = 4, P = 3
prerequisites = {{1,0},{2,1},{3,2}}
Output:
Yes
Explanation:
To do task 1 you should have completed
task 0, and to do task 2 you should 
have finished task 1, and to do task 3 you 
should have finished task 2. So it is possible.

 */

import java.util.*;
 
class Solution {
    public boolean isPossible(int N, int P, int[][] prerequisites) {
        boolean[] visited = new boolean[N];
        boolean[] recursionStack = new boolean[N];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++)
            adj.add(new ArrayList<>());

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            adj.get(course).add(pre);
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && detectCycle(adj, visited, i, recursionStack)) {
                return false;
            }
        }

        return true;
    }

   boolean detectCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int curr, boolean[] recursionStack) {
    visited[curr] = true;
    recursionStack[curr] = true;

    for (int neighbor : adj.get(curr)) {
        if (!visited[neighbor] && detectCycle(adj, visited, neighbor, recursionStack)) {
            return true;
        } else if (recursionStack[neighbor]) {
            return true;
        }
    }

    recursionStack[curr] = false;
    return false;
}
}