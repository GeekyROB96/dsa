public class min_sum_partition {
    

    public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum =0;
	    for(int a: arr){ sum+=a ;}
	    
	    int[][] dp = new int[n+1][sum/2+1];
	    
	    
	    for(int i =0;i<=n;i++){
	        for(int j=0;j<=sum/2;j++){
	            if(i==0|| j==0) dp[i][j] =0;
	            
	            else dp[i][j] = -1;
	        }
	    }
	    
	    
	    for(int i =1;i<=n;i++){
	        for(int j=1;j<=sum/2;j++){
	            
	            if(arr[i-1] > j)   dp[i][j] = dp[i-1][j];
	            
	            else        dp[i][j] = Math.max(arr[i-1] + dp[i-1][j- arr[i-1]], dp[i-1][j]);
	            
	            
	        }
	    }
	    
	    int sum1 = dp[n][sum/2];
	    int sum2 = sum - sum1;
	    
	    return Math.abs(sum1- sum2);
	    
	    
	} 
}
