You are given an m x n integer array grid. There is a robot initially located at 
  the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right 
  corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot 
  takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.



// Memoization : 

class Solution {
    public int totPaths(int i , int j ,int n , int m , int grid[][],int [][]dp){
         if(i == n -1 && j == m-1 && grid[i][j] != 1)
        return 1 ; 

        if(i >= n || j >= m || grid[i][j] == 1 )
        return 0 ; 

        if(dp[i][j] != -1)
        return dp[i][j]; 
        
        int right = totPaths(i,j+1,n,m,grid,dp); 
        int down = totPaths(i+1,j,n,m,grid,dp); 

        return dp[i][j] = right+down;

    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        int dp[][] = new int [n][m]; 

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i],-1);
        }
        return totPaths(0,0,n,m,grid,dp);
    }
}





Tabulation : 


class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 

        int dp[][] = new int [n][m]; 
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1)
                dp[i][j] = 0 ; 

                else if(i == 0 && j == 0)
                dp[i][j] = 1 ; 

                else
                {   
                    int left = 0, up = 0 ; 
                if(i > 0) left = dp[i-1][j]; 
                if(j > 0) up   = dp[i][j-1]; 
                dp[i][j] = left + up ;   
                }
            }
        }
        return dp[n-1][m-1];
    }
}



 
