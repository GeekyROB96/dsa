/*
 * 
 * Count digits grouping of number
 * 
 * 
 * Given a string str consisting of digits, you can divide it into sub-groups by separating the string into substrings. For example, "112" can be divided as {"1", "1", "2"}, {"11", "2"}, {"1", "12"}, and {"112"}.

A valid grouping can be done if you are able to divide sub-groups where the sum of digits in a sub-group is less than or equal to the sum of the digits of the sub-group immediately right to it. Your task is to determine the total number of valid groupings that could be done for a given string.

Example 1: 

Input: 
str = "1119"
Output: 
7
Explanation: 
One valid grouping is {"1", "11", "9"}.
Sum of digits of first sub-group ("1") is 1,
for the second sub-group ("11"), it is 2,
and for the third one ("9"), it is 9.
As the sum of digits of the sub-groups is 
in increasing order, it forms a valid grouping.
Other valid grouping are {"1", "119"}, {"1","1","19"}, 
{"1","1","1","9"}, {"11","19"}, {"111","9"} and {"1119"}
are six other valid groupings.
 */



 class Solution
 {
     public int TotalCount(String str)
     {
         // Code here
         int[][] dp = new int[str.length()][999];
         
        for(int i =0;i<str.length();i++) Arrays.fill(dp[i],-1);
         
        return  helper(0,str,0,dp);
     }
     
     public int helper(int idx, String s, int sum , int[][] dp){
         
         if(idx>=s.length()) return 1;
         
         
         if(dp[idx][sum] != -1) return dp[idx][sum];
         
         
         int curr =0;
         dp[idx][sum] = 0;
         
         
         for(int i= idx;i<s.length();++i){
             
             curr += (s.charAt(i)- '0');
             
             if(curr>= sum)  dp[idx][sum] += helper(i+1,s,curr,dp);
         }
         
         return dp[idx][sum];
     }
 }