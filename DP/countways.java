package DP;


/*
 * Count Ways
 * 
 * There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top (order does matter).


 */


 //recursion
 class Solution
 {
     //Function to count number of ways to reach the nth stair.
     int countWays(int n)
     {
         
         // your code here
         if(n == 0) return 1;
         
         if(n<0) return 0;
         
         
         return countWays(n-1) + countWays(n-2);
     }


     //memoization


     private static final int MOD = 1000000007;

    // Function to count the number of ways to reach the nth stair.
    int countWays2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return ways(n, dp);
    }

    int ways(int n, int[] dp) {
        if (n == 0) return 1;

        if (n < 0) return 0;

        if (dp[n] != -1) return dp[n];

        dp[n] = (ways(n - 1, dp) + ways(n - 2, dp)) % MOD;

        return dp[n];
    }



    //tabulation

    private static final int MOD = 1000000007;

     
     
    int countWays1(int n) {
        int[] dp = new int[n + 1];
        dp[0] =1 ;
        
        for(int i =1;i<=n;i++){
            if(i==1) dp[i] = dp[i-1];
            
            else    dp[i] = (dp[i-1]+ dp[i-2])%MOD;
        }
        
        return dp[n];
        //need tp d
    }



 }