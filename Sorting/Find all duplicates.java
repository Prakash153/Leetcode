Given an integer array nums of length n where all the integers of nums are in the range [1, n] and]
each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.
  
  
  code: 
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>(); 
        for(int n : nums){
            n = Math.abs(n); 
            if(nums[n-1] > 0) nums[n-1] *= -1 ; 
            else list.add(n);
        }
    return list;
    }
    
}

 
