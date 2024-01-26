
/*
 * 
 * Partition equal subset sum
 * 
 * Given an array arr[] of size N, check if it can be partitioned into two parts such that the sum of elements in both parts is the same.

Example 1:

Input: N = 4
arr = {1, 5, 11, 5}
Output: YES
Explanation: 
The two parts are {1, 5, 5} and {11}.
 */


// User function Template for Java
class Solution{
    static int equalPartition(int N, int arr[])
    {
        int total = 0;

        for(int i = 0; i < arr.length; i++)
            total += arr[i];

        if(total % 2 != 0)
            return 0;

        boolean[][] dp = new boolean[N + 1][total + 1];

        for(int i = 0; i < N + 1; i++)
            dp[i][0] = true;

        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < total + 1; j++){

                int val = arr[i - 1];

                if(val <= j && dp[i - 1][j - val] == true)
                    dp[i][j] = true;
                else if(dp[i - 1][j] == true)
                    dp[i][j] = true;
            }
        }

        return dp[N][total / 2] == false ? 0 : 1; //total/2
    }
}
