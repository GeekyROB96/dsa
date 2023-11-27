package tries_dsaa;
  import java.util.*;



/*
 Given a string A and a dictionary of n words B, find out if A can be segmented into a space-separated sequence of dictionary words. 


Example 1:

Input:
n = 12
B = { "i", "like", "sam", "sung", "samsung",
"mobile","ice","cream", "icecream", "man",
"go", "mango" }, A = "ilike"
Output: 1
Explanation: The string can be segmented as
"i like".
 */




public class word_break {
  

class Solution
{
    static class Node {
        Node[] children;
        boolean eow; // Flag to indicate end of word

        Node() {
            children = new Node[26];
            eow = false;
        }
    }

    static Node root;

    // Function to insert a word into the Trie
    public static void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true; // Mark the end of the word
    }

    // Function to search for a word in the Trie
    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';

            if (curr == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return curr != null && curr.eow;
    }

    // Function to check if a string can be segmented into dictionary words
    public static boolean wordbreak(String key) {
        if (key.length() == 0) return true;

        for (int i = 1; i <= key.length(); i++) {
            // Check if the substring from the beginning up to index i is in the dictionary
            // and recursively check the remaining substring
            if (search(key.substring(0, i)) && wordbreak(key.substring(i))) return true;
        }

        return false;
    }

    public static int wordBreak(String A, ArrayList<String> B) {
        // Initialize the Trie
        root = new Node();

        // Insert all dictionary words into the Trie
        for (String word : B) {
            insert(word);
        }

        // Check if the input string can be segmented
        if (wordbreak(A)) {
            return 1; // String can be segmented
        } else {
            return 0; // String cannot be segmented
        }
    }
}

    
}
