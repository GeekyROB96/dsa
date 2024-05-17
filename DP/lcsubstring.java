
class lcsubstring{
    
    int reclcSubstring(String S1, String S2, int n, int m){
        // code here
        
       return lcSubStr(S1,S2,n,m,0,0,0);
        
    }
    
    int lcSubStr(String s1, String s2, int n, int m, int i, int j, int count) {
        // Base case
        if (i == n || j == m) {
            return count;
        }
        
        int c1 = count;
        if (s1.charAt(i) == s2.charAt(j)) {
            c1 = lcSubStr(s1, s2, n, m, i + 1, j + 1, count + 1);
        }
        
        int countWithoutMatch1 = lcSubStr(s1, s2, n, m, i + 1, j, 0);
        int countWithoutMatch2 = lcSubStr(s1, s2, n, m, i, j + 1, 0);
        
        return Math.max(count, Math.max(c1, Math.max(countWithoutMatch1, countWithoutMatch2)));
    }
}