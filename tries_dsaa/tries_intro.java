package tries_dsaa;

import java.util.*;

class Solution{

    // Trie Node definition
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false; // end of word check
    
        Node(){
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }
    
    // Trie root initialization
    public static Node root = new Node();   

    // Insert operation in Trie
    public static void insert(String word){  /// Tc - O(l)
        Node curr = root;
        for(int level = 0; level < word.length(); level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true; // Marking end of word
    }
   
    // Search operation in Trie
    public static boolean search(String key){
        Node curr = root;
        for(int level = 0; level < key.length(); level++){
            int idx = key.charAt(level) - 'a';
            if(curr == null || curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow; // Check if it is the end of a word
    } 

    // Main function for testing
    public static void main(String[] args) {
        String words[]  = {"the", "a", "there", "any", "thee"};

        // Inserting words into the Trie
        for(int i = 0; i < words.length; i++){
            insert(words[i]);
        }
    }
}
