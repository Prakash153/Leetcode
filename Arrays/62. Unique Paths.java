There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to
move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.


  Solution: the idea is create a 2D matrix.
  
  sice the robot can move in only 2 direction, from the (0,0) positon it can go till m and n in only 1 way. example 
  from (0,0) the robot can reach till (0,3  and (2,0)) in 1 way only. 
  at (1,3) the robot can reach in 4 ways. 
  the idea is to sum up the the next left and nect top element for the (i,j) position that tells the number of ways to reach that postion. 
  [(1) (1) (1) (1) ]
  [(1) (2) (3) (4) ]
  [(1) (3) (6) (10)]
  
  
  code: 
  class Solution {
    public int uniquePaths(int m, int n) {
        int grid[][]  = new int[m][n]; 
        for(int i  = 0 ; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0)
                grid[i][j] = 1 ;
                else
                grid[i][j] = grid[i][j-1] + grid[i-1][j];
            }
        }
        return grid[m-1][n-1];
}
}
