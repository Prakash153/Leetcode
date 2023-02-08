You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.




code: 

class Solution {
    public boolean canJump(int[] nums) {
        // so here we can begin from the last index 
        // and check that fom that particular if we can reach the index 

        int index = nums.length -1 ;     
        for(int i = nums.length - 1 ; i >= 0 ; i--)
        {
            if(nums[i] + i >= index)  // checking if we can reach the 
            // required index to reach lat index ultimately
            // possible reduce the required value in index 

            index = i ; 
        }
        if(index == 0 ) return true;  // if we reach from last to first 
        return false; 

    }
}

