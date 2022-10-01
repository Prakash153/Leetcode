Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 
  
  code: 

class Solution {
    public int[] sortedSquares(int[] nums) {
       int ans[] = new int[nums.length] ; 
        
        int left = 0; 
        int right = nums.length - 1 ; 
        for(int i = nums.length - 1 ; i >= 0; i--){
             if(Math.abs(nums[left])>nums[right]){
                ans[i]=nums[left]*nums[left];
            left++;
            }
            else{
                ans[i] = nums[right]*nums[right];
                right--;
            }
        }
        return ans;
    }
}
