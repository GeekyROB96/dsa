//pack

/*
 * Given an array of words, find all shortest unique prefixes to represent each word in the given array. Assume that no word is prefix of another.

Example 1:

Input: 
N = 4
arr[] = {"zebra", "dog", "duck", "dove"}
Output: z dog du dov
 */



class Node {
    Node[] children = new Node[26];
    boolean eow = false;
    int freq = 0;  

    public Node() {
        for (int i = 0; i < children.length; i++) {
            children[i] = null;
        }
        
    }
}

class Solution {

    static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
            curr.freq++; 
        }

        curr.eow = true;
    }

    public static String buildPrefix(String str){
        
        
        Node current = root;
        StringBuilder sb = new StringBuilder();
        
        
        for(int i =0;i< str.length();i++){
            char ch = str.charAt(i);
            int idx = str.charAt(i) - 'a';
            sb.append(ch);
            
            if(current.children[idx].freq == 1) break;
            
            current = current.children[idx];
        }
        
        return sb.toString();
        
        
    }
      static String[] findPrefixes(String[] arr, int n) {
        root = new Node();
        String[] result = new String[n];
        
        for(int i = 0 ; i < n ; i++) {
            insert(arr[i]);
        }
        
        for(int i = 0 ; i < n ; i++) {
            result[i] = buildPrefix(arr[i]);
        }
        
        return result;
   }
     
   
}

