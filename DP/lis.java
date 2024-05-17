import java.util.ArrayList;

class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])  //TLE 3 CASES
    {
        // code here
              int ans =1;

        int n = a.length;
      int[] dp = new int[n];
      
      for(int i =0;i<n;i++){
          dp[i] = 1;
      }
      for(int i =1;i<n;i++){
          for(int j =0;j<i;j++){
              if(a[i]>a[j])
              {
                  dp[i] = Math.max(dp[i],dp[j]+1);
                            ans = Math.max(dp[i],ans);

              }
          }
      }
      
      
    
      return ans;
    }



    

    //Function to find length of longest increasing subsequence.
    static int longestSubsequenceBINARYSEARCH(int size, int a[]) // striver
    {
        // code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(a[0]);

        for (int i = 1; i < size; i++) {
            if (a[i] > ans.get(ans.size() - 1)) {
                ans.add(a[i]);
            } else {
                int idx = lowerBound(ans,a[i]);
                if (idx < 0) {
                    idx = -idx - 1;
                }
                ans.set(idx, a[i]);
            }
        }

        return ans.size();
        
    }
    
    static int lowerBound(ArrayList<Integer> list, int key) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) >= key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

} 