Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

 

Example 1:



Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).
Example 2:



Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1
Example 3:

Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2
 

Constraints:

1 <= grid.length, grid[0].len



code: 

class Solution {
    public boolean dfs(int row , int col , int grid[][]){
        if(row == 0 || col == 0 || row == grid.length -1 || col == grid[0].length -1 ) 
        
      {
          if(grid[row][col] == 1)
          return true;
          else
          return false;
      }

        if(grid[row][col] == 1)
        return true;
         
         grid[row][col] = 1; 

         boolean left  = dfs(row,col-1 ,grid);     
         boolean top =  dfs(row-1,col,grid);  
         boolean right =dfs(row,col+1,grid);   
         boolean down = dfs(row+1,col,grid);     
         return left && top && right && down; 
    }
 
    public int closedIsland(int[][] grid) {
        int ans=0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0; j < grid[0].length ; j++){
                if( grid[i][j] == 0 ){
                   if(dfs(i,j,grid))
                   ans++;             }
            }
        }
        return ans;
    }
}
