
/*
 * Given an array of positive integers. Find the maximum length of Bitonic subsequence. 
A subsequence of array is called Bitonic if it is first strictly increasing, then strictly decreasing.
 

Example 1:

Input: 
n = 5
nums = [1, 2, 5, 3, 2]
Output: 
5
Explanation: 
The sequence {1, 2, 5} is
increasing and the sequence {3, 2} is 
decreasing so merging both we will get 
length 5.
 */


 class Lbs {
    public static int LongestBitonicSequence(int n, int[] a) {
        // code here
        
                if (n == 0) return 0;

        
         int[] lis = new int[n];
        int[] lds = new int[n];

        // Each element is an increasing subsequence of length 1 by itself
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            lds[i] = 1;
        }

        // Fill LIS array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Fill LDS array
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (a[i] > a[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // Calculate the maximum value of lis[i] + lds[i] - 1
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (lis[i] > 1 && lds[i] > 1) {
                max = Math.max(max, lis[i] + lds[i] - 1);
            }
        }

        return max;
    
    
    }
}

