/*
 * Subset Sum Problem
 * 
 * 
 * Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 


Example 1:

Input:
N = 6
arr[] = {3, 34, 4, 12, 5, 2}
sum = 9
Output: 1 
Explanation: Here there exists a subset with
sum = 9, 4+3+2 = 9.
 */



class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        
        //tabulation method
        boolean[][] dp = new boolean[N+1][sum+1];
        
        
        for(int i =0;i<N+1;i++)  dp[i][0] = true;
        
        
        for(int i =1;i<N+1;i++){
            for(int j =1;j<sum+1;j++){
                int value = arr[i-1];
                if(value<=j && dp[i-1][j-value] == true) {
                    dp[i][j] = true;
                }else if(dp[i-1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[N][sum];
    }
}