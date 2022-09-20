You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.


Solution: 
the idea is using indexing and find the break point . 


left half : 
1st instance : even    i + 1
2nd instance : odd     i - 1


right half : 
1st instance : odd  
2nd instance : even 

we have to search according to the left half. 

code: 

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0 ; 
        if(nums.length == 1)
            return nums[0];
        int high = nums.length - 2 ; 
        while(low <= high){
        int mid = low + (high - low)/2 ; 
            if((mid%2 == 0 && nums[mid] == nums[mid + 1]) || (mid%2 == 1 && nums[mid] == nums[mid -1]))
                low = mid + 1 ; 
            else 
                high = mid - 1 ;
        }
        return nums[low];
    }
}
