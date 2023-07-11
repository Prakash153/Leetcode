Given an array of positive integers nums and a positive integer target, return the minimal length of a 
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1



  code : 


class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length , window = Integer.MAX_VALUE; 
        int start = 0 ,  end = 0 , curr = 0; 

        for(; end < n ; end++){
                curr+= nums[end]; 
                while(curr >= target)
                {
                    window = Math.min(window, end - start + 1);
                    curr -= nums[start]; 
                    start++;
                }
        }
        return window  == Integer.MAX_VALUE ? 0 : window;
    }
}
