Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 
codE: 
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>(); 
        int curr = 0 ; 
        int res = 0 ; 
        for(int i =0;i<nums.length ;i++){
            hs.add(nums[i]);
        }
        for(int i =0;i<nums.length ;i++){
            if(!hs.contains(nums[i]-1)){
                curr = 1;
            
            while(hs.contains(nums[i]+curr)){
                curr++;
            }
            }
            res = Math.max(curr, res);
        }
        return res;
    }
}
