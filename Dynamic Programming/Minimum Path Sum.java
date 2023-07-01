Given a m x n grid filled with non-negative numbers, find a path from top left to bottom
  right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.


  
// Memoization 

code: 
class Solution {
    public int minSum(int i ,int j , int [][] grid,int dp[][]){
         

        if(i == 0 && j == 0)
        {
            return grid[0][0] ; 
        }

        if(i < 0 || j < 0)
        {
            return (int)1e9;
        }
    if(dp[i][j] != -1)
    return dp[i][j];
         int up  = grid[i][j]+ minSum(i-1,j,grid,dp); 
        int left = grid[i][j] + minSum(i,j-1,grid,dp); 
       

     
        return dp[i][j] = Math.min(left,up);
    }
    public int minPathSum(int[][] grid) {
           int n = grid.length ; 
        int m = grid[0].length ; 
        int dp [][] = new int [n][m];
        return minSum(n-1,m-1,grid,dp); 
    }
}
