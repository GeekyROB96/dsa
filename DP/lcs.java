class LCS{

    public static int recLCS(String s1, String s2, int n, int m){


        if(n==0|| m==0) return 0;

        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return 1 +recLCS(s1,s2,n-1,m-1);
        }

        else{
            int ans1 = recLCS(s1,s2,n-1,m);
            int ans2 = recLCS(s1,s2,n,m-1);

            int ans = Math.max(ans1,ans2);

            return ans;
            
        }
    }




    public static int memLCS(String s1, String s2, int n, int m, int dp[][]){

        if(n==0||m==0) return 0;

        if(dp[n][m]!=-1) return dp[n][m];

        if(s1.charAt(n-1)== s2.charAt(m-1)){
            return dp[n][m] =  1 + memLCS(s1, s2, n-1, m-1, dp);
        }else{

            int ans1 = memLCS(s1,s2,n-1,m,dp);
            int ans2 = memLCS(s1,s2,n,m-1,dp);

            return dp[n][m] = Math.max(ans1,ans2);
        }

        
    }




    public static int tabLCS(String s1, String s2, int n, int m,int[][] dp){

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0||j==0) dp[i][j] = 0;
            }
        }



        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
}