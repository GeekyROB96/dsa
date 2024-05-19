public class unique_bsts {
      //Function to return the total number of possible unique BST.
   static int numTrees(int n) {
    long[] dp = new long[n + 1];
  int mod = (int)1e9+7;
        
         dp[0] = 1;
        dp[1] = 1;
        
         for (int i = 2; i <= n; i++) {
             for (int j = 0; j < i; j++) {
                dp[i] =  (dp[i]+(dp[j] * dp[i-j-1]) % mod) % mod;
            }
        }
        
         return (int) dp[n];
    
}
}
