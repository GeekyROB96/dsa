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

   
}