/*
 * 
 * Unit Area of largest region of 1's

 * 
 * Given a grid of dimension nxm containing 0s and 1s. Find the unit area of the largest region of 1s.
Region of 1's is a group of 1's connected 8-directionally (horizontally, vertically, diagonally).
 

Example 1:

Input: grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1}}
Output: 5
Explanation: The grid is-
1 1 1 0
0 0 1 0
0 0 0 1
The largest region of 1's is colored
in orange.
 */


 
class Solution
{
    //Function to find unit area of the largest region of 1s.
    
    int count =0;
  
    public int findMaxArea(int[][] grid)
    {
        // Code here
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int result =0;
        
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    count =1;
                    dfs(grid,i,j,visited);
                    result = Math.max(count,result);
                }
            }
            
          
        }
          return result;
        
        
    }
    
     void dfs(int[][] m, int i, int j, boolean[][] visited){
        
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};
         
         
         visited[i][j] = true;
         
         
         for(int k =0;k<8;k++){
             if(isSafe(m,i+dx[k],j+dy[k],visited)){
                 
                 count++;
                 dfs(m,i+dx[k],j+dy[k],visited);    
             }
         }
        
    }
    
     boolean isSafe(int[][] m, int i, int j , boolean[][] visited){
        
        int row = m.length;
        int col = m[0].length;
        return ( (i>=0) && (i<row) && (j>=0)  && (j<col ) && m[i][j] == 1 && !visited[i][j] );
        
    }
}