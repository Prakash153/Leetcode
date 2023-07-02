Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses 
  the element in the next row that is either directly below or diagonally left/right. Specifically, 
the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

  code: 

Memoization + tabulation : 


class Solution {
    public int f(int i , int j , int mat[][], int dp[][]){
        if(j < 0 || j >= mat.length )
        return (int)1e9; 

        if(i == 0)
        return mat[0][j]; 

        if(dp[i][j] != -1)
        return dp[i][j]; 

        int up = mat[i][j] + f(i-1,j,mat,dp); 
        int ld = mat[i][j] + f(i-1,j-1,mat,dp); 
        int rd = mat[i][j] + f(i-1,j+1,mat,dp); 


        return dp[i][j] =  Math.min(up,Math.min(ld,rd));
    }
    public int minFallingPathSum(int[][] mat) {
          int n = mat.length ; 
         int dp [][] = new int [mat.length][n]; 
       


         for(int j = 0 ; j < mat.length ; j++ ){
             dp[0][j] = mat[0][j]; 
         }
         for(int i = 1 ; i < n ; i++){
             for(int j = 0 ; j < n ; j++){

        int up = mat[i][j] +  dp[i-1][j]; 
         int ld = mat[i][j];
        if(  j-1 >= 0)
         ld+=  dp[i-1][j-1]; 
         else 
         ld =  (int)1e9; 
         int rd = mat[i][j];
        if(j<n-1)
        rd+=  dp[i-1][j+1]; 
        else 
        rd =  (int)1e9; 
        dp[i][j] =  Math.min(up,Math.min(ld,rd));
             }
         }

int min = (int)1e9; 
         for(int j = 0; j < n ; j++){
               min = Math.min(min,dp[n-1][j]);
         }
         return min ;
    }
}
