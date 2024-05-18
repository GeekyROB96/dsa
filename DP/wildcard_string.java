class Solution {
    public boolean isMatch(String wild, String pattern) {
        

         boolean[][] dp = new boolean[wild.length()+1][pattern.length()+1];
    
        int n = wild.length();
        int m = pattern.length();
        

        for(int i=0;i<n;i++) dp[i][0] = false;
        
                        dp[0][0] = true;

        
        for(int j=1;j<=m;j++) {
            if(pattern.charAt(j-1) == '*')
                dp[0][j] = dp[0][j-1];
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(wild.charAt(i-1)== pattern.charAt(j-1) ||  pattern.charAt(j-1) == '?')   dp[i][j] = dp[i-1][j-1];
           
           else if(pattern.charAt(j-1)=='*') dp[i][j] = dp[i-1][j]||dp[i][j-1];
           
           else dp[i][j] = false;
            }
        }
        
        
        return dp[n][m];
    }
}