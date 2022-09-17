Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
  
  
  
  code:

class Solution {
    public int countNegatives(int[][] grid) {
        
        int count = 0 ; 
        for(int i = 0 ; i < grid.length ; i++){
            count+= firstNegative(grid[i]);
        }
        return count;
    }
   public int firstNegative(int[] arr){
        int n = arr.length;
        // Binary Search
        int st = 0, en = n-1;
        while(st<=en){
            int mid = en - (en-st)/2;
            if(arr[mid]>=0){
                st = mid+1;
            } else{
                en = mid-1;
            }
        }
        return (n-1)-en;
    }
}
