Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.
  
  
  // Solution : youtube pepcoding 
  code: 


class Solution {
    public void setZeroes(int[][] mat) {
        int n = mat.length ; 
        int m = mat[0].length ;
        
        boolean row = false , col = false;
        for(int i = 0 ; i < n ; i++) if(mat[i][0] == 0) col = true;
        for(int j = 0 ; j < m ; j++) if(mat[0][j] == 0) row = true;
        
        for(int i = 1 ; i < n ; i++){
            for(int  j = 1; j < m ; j++){
                if(mat[i][j] == 0)
                {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }
        
        
        for(int i=1 ; i < n ; i++ ){
            if(mat[i][0]==0){
                for(int j = 0 ; j < m ; j++)
                    mat[i][j] = 0;
            }
        }
        for(int j = 1 ; j < m ; j++){
            if(mat[0][j]==0){
                for(int i = 0 ; i < n ; i++)
                    mat[i][j] = 0 ;
            }
        }
        
        if(row)
        {
            for(int j = 0 ;j < m ; j++ )
                mat[0][j] = 0;
        }
        if(col){
            for(int i = 0 ; i < n ; i++)
                mat[i][0] = 0;
        }
    }
}
