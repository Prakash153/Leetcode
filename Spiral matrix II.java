Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
  
  Solution: same concept as used in spiral matrix 
  
  code: 

class Solution {
    public int[][] generateMatrix(int n) {
        int mat[][] = new int [n][n]; 
        
int l = 0 , r = n-1 , t = 0 , b = n-1 , d = 1 ,k=1; 
        while(l <= r && t <= b && k <= n*n ){
            // direction 1 
            if(d == 1){
                for(int i = l; i <= r ; i++){
                    mat[t][i] = k++;
                }
                t++;
                d = 2 ;
            }
            // direction 2
            if(d == 2){
                for(int i = t; i <= b ; i++){
                    mat[i][r] = k++;
                }
                r--;
                d = 3 ;
            }
            // direction 3 
            if(d == 3){
                for(int i = r; i >= l ; i--){
                    mat[b][i] = k++;
                }
                b--;
                d = 4 ;
            }
            // direction 4 
            if(d == 4){
                for(int i = b; i >= t ; i--){
                    mat[i][l] = k++;
                }
                l++;
                d = 1 ;
            }
        }
        return mat;
    }
}
