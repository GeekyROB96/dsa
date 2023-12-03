package tries_dsaa;

/*
 * 
 * Count of distinct substrings


 Given a string of length N of lowercase alphabet characters. The task is to complete the function countDistinctSubstring(), which returns the count of total number of distinct substrings of this string.

Input:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. Each test case contains a string str.

Output:
For each test case in a new line, output will be an integer denoting count of total number of distinct substrings of this string.

User Task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function countDistinctSubstring().

Constraints:
1 ≤ T ≤ 10
1 ≤ N ≤ 1000

Example(To be used only for expected output):
Input:
2
ab
ababa

Output:
4
10

Exaplanation:
Testcase 1: For the given string "ab" the total distinct substrings are: "", "a", "b", "ab".
 */




 class GfG {
    static class Node {
        Node[] children = new Node[26];
        boolean eow; 
    }

    public static int countNodes(Node root) {
        if (root == null) return 0;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) count += countNodes(root.children[i]);
        }
        return count + 1;
    }

    public static void insert(String word, Node root) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static int countDistinctSubstring(String st) {
        Node root = new Node(); // Initialize the root node for each test case
        for (int i = 0; i < st.length(); i++) {
            String suffix = st.substring(i);
            insert(suffix, root);
        }
        return countNodes(root);
    }

}
