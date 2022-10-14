Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.
  
  
  
  
  code: 

class Solution {
    public int threeSumClosest(int[] nums, int target) {
     Arrays.sort(nums) ; 
        int diff = Integer.MAX_VALUE; 
        int ans = 0 ; 
        for(int i = 0 ; i < nums.length-2 ; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int lo = i + 1 , hi = nums.length - 1 , sum = 0 ; 
                while(lo < hi){
                    sum = nums[i] + nums[lo] + nums[hi]; 
                    if( sum == target) return sum ;
                    else if(Math.abs(sum - target) < diff){
                        diff = Math.abs(sum - target);
                     ans = sum ;   
                    }
                    
                    if(sum < target) lo++; 
                    else hi--;
                }
            }
        }
        return ans;
    }
}
