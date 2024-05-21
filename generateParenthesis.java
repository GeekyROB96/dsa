/*
 * 
 * Given an integer N representing the number of pairs of parentheses, the task is to generate all combinations of well-formed(balanced) parentheses.


Example 1:

Input:
N = 3
Output:
((()))
(()())
(())()
()(())
()()()
 */


 class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
     LinkedList<String> list = new LinkedList<>();
        int op = 0 , cp =0;
        solve(n,op,cp,list,"");
        return list;

    }

    public void solve(int n, int op, int cp, LinkedList<String> list,String s){


        //bc

        if(op ==n & cp==n) {
            list.add(s);
            return;
        }

        if(op<n) 
            solve(n,op+1,cp,list,s+"(");
        if(cp<op)   
             solve(n,op,cp+1,list,s+")");


    }
}
