package tries_dsaa;

import java.util.*;

class Solution{

    //creation
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false; //end of word check
    
     Node(){
        for(int i =0;i<26;i++){
            children[i] = null;
        }
    }
    
    }
    public static Node root = new Node();   

    public static void insert(String word){

        Node curr = root;
        for(int level =0;level<word.length();level++){
            int idx = word.charAt(level)- 'a';
            if(curr == null){
                curr.children[idx] = new Node();

            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }
   

    public static void main(String[] args) {
        String words[]  ={"the","a","there","any","thee"};

        for(int i =0;i<words.length;i++){
            insert(words[i]);

        }
        }
}