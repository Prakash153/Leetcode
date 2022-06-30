Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
In one move, you can increment or decrement an element of the array by 1.
Test cases are designed so that the answer will fit in a 32-bit integer.
  
  
  Example 1:

Input: nums = [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]


solution : the idea is to first sort the array and then get the middle element. 
  calculate the moves to make all the elments eqaul to middle element. 
  
  code: 

class Solution {
    public int minMoves2(int[] nums) {
      Arrays.sort(nums); 
        int l = 0; 
        int r = nums.length-1 ; 
        int moves = 0 ;
        int mid = r / 2;
        for(int i = 0 ; i < r + 1 ; i++){
           if(nums[mid] == nums[i]){
               continue;
           }
            moves += Math.abs(nums[mid] - nums[i]);
        }
        return moves;
    }
}
