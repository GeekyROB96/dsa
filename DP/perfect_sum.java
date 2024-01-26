/*
 * 
 * Given an array arr of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

Note: Answer can be very large, so, output answer modulo 109+7.

Example 1:

Input: 
N = 6
arr = [5, 2, 3, 10, 6, 8]
sum = 10
Output: 
3
Explanation: 
{5, 2, 3}, {2, 8}, {10} are possible subsets.
 */


 //memoization

    
class Solution{

    private int MOD = 1000000007;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int[][] dp = new int[n][sum+1];
	    
	    
	    //dp is already initialized with 0
	   for(int nums[]:dp) Arrays.fill(nums,-1);
	    
	    return memdp(arr,n,sum,0,dp);
	    
	} 
	
	public int memdp(int[] arr, int n, int sum,int i, int[][] dp){
	    
	    if(sum<0) return 0;
	    
	    if(i>=arr.length){
	        if(sum == 0) return 1;
	        else return 0;
	    }
	    
	    if(dp[i][sum] !=-1) return dp[i][sum];
	    
	    int taken = 0;
	    
	    if(arr[i]<=sum) taken = memdp(arr,n,sum-arr[i],i+1,dp);
	    int not = memdp(arr,n,sum,i+1,dp);
	    
	    return dp[i][sum] = (taken+not)%MOD;
	    
	    
	   
	}



 
    public void printDP(int[][] dp, int n, int sum) {
        System.out.println("Dynamic Programming Table:");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public int perfectSum1(int arr[], int n, int sum) {
        // Initializing the dp table
        int[][] dp = new int[n + 1][sum + 1];
    
        // Base case: There is one way to get a sum of 0, i.e., by choosing an empty subset
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
    
        // Filling up the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                // If the current element is greater than the current sum, exclude it
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Include the current element
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - arr[i - 1]]) % MOD;
                }
            }
        }
    
        // Print the dp table
        printDP(dp, n, sum);
    
        // Returning the result
        return dp[n][sum];
    }
    
}   