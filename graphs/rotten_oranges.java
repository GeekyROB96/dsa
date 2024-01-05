/*
 * 
 * 
 * Rotten Oranges
 * 
 * Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

We have to determine what is the earliest time after which all the oranges are rotten. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 
 

Example 1:

Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
Output: 1
Explanation: The grid is-
0 1 2
0 1 2
2 1 1
Oranges at positions (0,2), (1,2), (2,0)
will rot oranges at (0,1), (1,1), (2,2) and 
(2,1) in unit time.
Example 2:

Input: grid = {{2,2,0,1}}
Output: -1
Explanation: The grid is-
2 2 0 1
Oranges at (0,0) and (0,1) can't rot orange at
(0,3).
 */


 import java.util.*;
class Solution
{

    
 
    // Function to find minimum time required to rot all oranges.
    class Pair {
        int first = 0;
        int second = 0;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int orangesRotting(int[][] grid) {
        // Code here

        Queue<Pair> q = new LinkedList<>();

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }
        int r = grid.length;
        int c = grid[0].length;

        q.add(new Pair(-1, -1));

        while (!q.isEmpty()) {
            Pair temp = q.remove();

            int i = temp.first;
            int j = temp.second;

            if (i == -1 && j == -1) {
                if (!q.isEmpty()) {
                    count++;
                    q.add(new Pair(-1, -1));
                }
            } else {
                if ((i - 1) >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    q.add(new Pair(i - 1, j));
                }
                if ((j - 1) >= 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    q.add(new Pair(i, j - 1));
                }
                if ((i + 1) < r && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    q.add(new Pair(i + 1, j));
                }
                if ((j + 1) < c && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    q.add(new Pair(i, j + 1));
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return count;
    }
}