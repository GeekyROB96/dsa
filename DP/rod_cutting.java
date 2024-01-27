public class rod_cutting {
    
}

class Solution{
    public int cutRod(int price[], int n) {
        int[] len = new int[price.length + 1];

        for (int i = 0; i < len.length; i++) {
            len[i] = i;
        }

        int[][] dp = new int[price.length + 1][n + 1];

        for (int i = 0; i < price.length + 1; i++) {
            dp[i][0] = 0; // Initialization when j is 0
        }

        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = 0; // Initialization when i is 0
        }

        for (int i = 1; i < price.length + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (len[i] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - len[i]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[price.length][n];
    
}

}