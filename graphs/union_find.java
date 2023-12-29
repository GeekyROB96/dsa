/*
 * UNION FIND 
 * This problem is to implement disjoint set union. There will be 2 incomplete functions namely union and find. You have to complete these functions. 

Union: Join two subsets into a single set.
isConnected: Determine which subset a particular element is in. This can be used for determining if two elements are in same subset.

Example 1:

Input:
N = 5
q = 4
Queries = 
Union(1,3)
isConnected(1,2)
Union(1,5)
isConnected(3,5)
Output:
0
1
 */

 
    class Solution
    {
        //Function to merge two nodes a and b.
        
        public int findPar(int x, int[] par){
            if(x== par[x]) return x;
            
            return par[x]= findPar(par[x],par);
        }
        
        public void union_(int a, int b, int par[], int rank[])
        {
            // add your code here
            int parA= findPar(a,par);
            int parB = findPar(b,par);
            
            if(rank[parA] == rank[parB]){
                par[parB] = parA;
                rank[parA]++;
            }else if(rank[parA]<rank[parB]){
                par[parA] = parB;
                rank[parB]++;
            }else{
                par[parB] = parA;
                rank[parA]++;
            }
                
            }
            
        
    
        //Function to check whether 2 nodes are connected or not.
        public boolean isConnected(int a, int b, int par[], int rank[]) {
        return findPar(a, par) == findPar(b, par);
    }
    
    }