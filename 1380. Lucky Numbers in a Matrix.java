Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

 

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 
  
  
  code 1: 

class Solution {
    public boolean luckNum(int i , int j , int [][] mat,int max){

        for(i = 0 ; i < mat.length ; i++){
            if(mat[i][j] > max)
                return false;
        }
        return true;
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> al = new ArrayList<Integer>(); 
        int min = Integer.MAX_VALUE;
        int col = 0 ;
        for(int i = 0 ; i < matrix.length ; i++){
            min = Integer.MAX_VALUE;
            for( int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    col = j;
            }
                
            }
            if(luckNum(i,col,matrix , min)== true)
                al.add(matrix[i][col]);
            
        }
        return al;
    }
}'
  
  
  
  
  
  
  code 2: 
class Solution {
    public boolean luckNum(int i , int j , int [][] mat,int max){

        for(i = 0 ; i < mat.length ; i++){
            if(mat[i][j] > max)
                return false;
        }
        return true;
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> al = new ArrayList<Integer>(); 
        int min = Integer.MAX_VALUE;
        int col = 0 ;
        for(int i = 0 ; i < matrix.length ; i++){
            min = Integer.MAX_VALUE;
            for( int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    col = j;
            }
                
            }
            if(luckNum(i,col,matrix , min)== true)
                al.add(matrix[i][col]);
            
        }
        return al;
    }
}
