A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
  
  Solution : the idea is to apply binary search in column and in each iteration look for maximum value in row. 
  
  code: 

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length ;
        int m = mat[0].length ;
        int low = 0 ; 
        int high = m - 1 ; 
        while(low <= high){
            int mid = low +(high - low)/2; 
            int maxInRow = 0 ; 
            for(int i = 0 ; i < n ; i++){
                if(mat[maxInRow][mid] < mat[i][mid])
                    maxInRow = i ;
            }
            
            if(  (mid == 0 || mat[maxInRow][mid] >  mat[maxInRow][mid-1]) && 
                 (mid == m-1 ||  mat[maxInRow][mid] >  mat[maxInRow][mid+1])  )
                return new int[]{maxInRow,mid};
            
            else if(mid > 0 &&  mat[maxInRow][mid] < mat[maxInRow][mid-1] )
                high = mid - 1 ; 
            else 
                low = mid + 1;
        }
        return new int[]{-1,-1};
    }
}
