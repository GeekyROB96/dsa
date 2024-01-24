
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         
         if(W==0 || n==0) return 0;
         
         
         if(wt[n-1]<=W){
             
             int ans1 = val[n-1] + knapSack(W-wt[n-1],wt,val,n-1);
             
             int ans2 = knapSack(W,wt,val,n-1);
             
             int max = Math.max(ans1,ans2);
             return max;
         }
         else return knapSack(W,wt,val,n-1);
    } 





    //MEMOIZATION


     //Function to return max value that can be put in knapsack of capacity W.
     static int knapSack1(int W, int wt[], int val[], int n) 
     { 
          // your code here 
          int[][] dp = new int[n+1][W+1];
          
          for (int i = 0; i <= n; i++) {
              Arrays.fill(dp[i], -1);
          }
          
          return knapSackdp(W, wt, val, n, dp);
     } 
     
     
     static int knapSackdp(int W, int wt[], int val[], int n, int[][] dp) 
     { 
          // your code here 
          
          if (W == 0 || n == 0) return 0;
          
          
          if (dp[n][W] != -1) return dp[n][W];
          
          if (wt[n-1] <= W) {
              
              int ans1 = val[n-1] + knapSackdp(W - wt[n-1], wt, val, n-1, dp);
              
              int ans2 = knapSackdp(W, wt, val, n-1, dp);
              
              dp[n][W] = Math.max(ans1, ans2);
              return dp[n][W];
          }
          else {
              dp[n][W] = knapSackdp(W, wt, val, n-1, dp);
              return dp[n][W];
          } 
     }






     //Tabulation



     static int knapSack2(int W, int wt[], int val[], int n) 
     { 
         int[][] dp = new int[n+1][W+1];
         
         // Initialize the dp array
         for(int i = 0; i <= n; i++) {
             for(int j = 0; j <= W; j++) {
                 if(i == 0 || j == 0) {
                     dp[i][j] = 0;
                 }
                 else {
                     dp[i][j] = -1;
                 }
             }
         }
         
         for(int i = 1; i <= n; i++) {
             for(int j = 1; j <= W; j++) {
                 if(wt[i-1] > j) {
                     dp[i][j] = dp[i-1][j];
                 }
                 else {
                     dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                 }
             }
         }
         
         return dp[n][W];
     } 
}