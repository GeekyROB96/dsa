/*
 * 
 * Alien Dictionary
 * 
 * 
 * Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.
 

Example 1:

Input: 
N = 5, K = 4
dict = {"baa","abcd","abca","cab","cad"}
Output:
1
Explanation:
Here order of characters is 
'b', 'd', 'a', 'c' Note that words are sorted 
and in the given language "baa" comes before 
"abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders
 */

 import java.util.*;
class Solution {
    public String findOrder(String[] dict, int N, int K) {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize the adjacency list
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the adjacency list based on the given dictionary
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];

            // Find the first different character and add it to the adjacency list
            for (int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        // Perform topological sort
        boolean[] visited = new boolean[K];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                topSortUtil(adj, i, visited, s);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append((char) ('a' + s.pop())); // Convert to char and append
        }

        return sb.toString();
    }

    private void topSortUtil(ArrayList<ArrayList<Integer>> adj, int curr, boolean visited[], Stack<Integer> s) {
        visited[curr] = true;

        for (int v : adj.get(curr)) {
            if (!visited[v]) {
                topSortUtil(adj, v, visited, s);
            }
        }

        s.push(curr);
    }
}
