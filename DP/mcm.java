
class Solution{
    static int matrixMultiplicationmemoization(int N, int arr[])
    {
        // code here
        
        int[][]  dp = new int[N][N];
        
        for(int i=0;i<N;i++)  Arrays.fill(dp[i],-1);
        
        
        return solve(arr,1,N-1,dp);
    }
    
    public static int solve(int[] arr, int i, int j, int[][] dp){
        
        if(i==j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int finalcost = Integer.MAX_VALUE;

        for(int k=i;k<=j-1;k++){
            int cost1 = solve(arr,i,k,dp);
            int cost2 = solve(arr,k+1,j,dp);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            
              finalcost = Math.min(finalcost,cost1+cost2+cost3);
        }
        
        return dp[i][j] = finalcost;
    }
}