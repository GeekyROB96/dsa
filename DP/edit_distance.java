/*
 * 
 * Given two strings s and t. Return the minimum number of operations required to convert s to t.
The possible operations are permitted:

Insert a character at any position of the string.
Remove any character from the string.
Replace any character from the string with any other character.
 

Example 1:

Input: 
s = "geek", t = "gesek"
Output: 1
Explanation: One operation is required 
inserting 's' between two 'e's of s.
 */


 class Solution {
    public int editDistanceRecusrion(String s, String t) {
        // Code here
        
        return solve(s,t,s.length(),t.length());
    }
    
    int solve(String s1,String s2, int n, int m){
    
        if(n==0) return m;
        
        if(m == 0 ) return n;
        
        
        
        if(s1.charAt(n-1) == s2.charAt(m-1)) return solve(s1,s2,n-1,m-1);
        
        
        return Math.min(1 + solve(s1,s2,n,m-1) //insert
        , Math.min(1 + solve(s1,s2,n-1,m),//delete
        1 + solve(s1,s2,n-1,m-1)//replace
        ));
    }
    


    public int editDistancememoization(String s, String t) {
        // Code here
         int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        
        // Initialize dp array with -1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        
        return solve(s,t,s.length(),t.length(),dp);
    }
    
    int solve(String s1,String s2, int n, int m,int[][] dp){
    
        if(n==0) return m;
        
        if(m == 0 ) return n;
        
        if(dp[n][m]!=-1) return dp[n][m];
        
        if(s1.charAt(n-1) == s2.charAt(m-1)) return dp[n][m] =  solve(s1,s2,n-1,m-1,dp);
        
        
        return dp[n][m] = Math.min(1 + solve(s1,s2,n,m-1,dp) //insert
        , Math.min(1 + solve(s1,s2,n-1,m,dp),//delete
        1 + solve(s1,s2,n-1,m-1,dp)//replace
        ));
    }


    public int editDistancetabulation(String s1, String s2) {
        // Code here
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Initialize dp array
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;

        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],    // Remove
                                            Math.min(dp[i][j - 1],    // Insert
                                                     dp[i - 1][j - 1])); // Replace
                }
            }
        }

        return dp[n][m];
    
    }
    
}