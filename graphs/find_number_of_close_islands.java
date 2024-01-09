/*
 * Find number of closed islands
 * 
 * 
 * Given a binary matrix mat[][] of dimensions NxM such that 1 denotes land and 0 denotes water. Find the number of closed islands in the given matrix.
An island is a 4-directional(up,right,down and left) connected part of 1's.

Note: A closed island is a group of 1s surrounded by only 0s on all the boundaries (except diagonals). In simple words, a closed island is an island whose none of the 1s lie on the edges of the matrix.

Example 1:

Input:
N = 5, M = 8
mat[][] = {{0, 0, 0, 0, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 0, 1}, 
           {0, 1, 0, 1, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 1, 0}, 
           {1, 0, 0, 0, 0, 1, 0, 1}}
Output:
2
Explanation:
mat[][] = {{0, 0, 0, 0, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 0, 1}, 
           {0, 1, 0, 1, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 1, 0}, 
           {1, 0, 0, 0, 0, 1, 0, 1}} 
There are 2 closed islands. The islands in dark are closed because they are completely surrounded by 0s (water). There are two more islands in the last column of the matrix, but they are not completely surrounded by 0s. Hence they are not closed islands. 
 */

 
class Solution {
public:
    int closedIslands(vector<vector<int>>& matrix, int N, int M) {
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {  // land
                    if (dfs(i, j, matrix, N, M)) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
      
private:
    bool dfs(int i, int j, vector<vector<int>>& matrix, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M)
            return false; // Not closed
        
        if (matrix[i][j] == 0)
            return true; // Closed here
        
        matrix[i][j] = 0; // Mark as visited
        
        bool left  = dfs(i, j - 1, matrix, N, M);
        bool right = dfs(i, j + 1, matrix, N, M);
        bool up    = dfs(i - 1, j, matrix, N, M);
        bool down  = dfs(i + 1, j, matrix, N, M);
        
        return left && right && up && down;
    } 
};