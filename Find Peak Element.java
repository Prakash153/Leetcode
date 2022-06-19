# A peak element is an element that is strictly greater than its neighbors.
# Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
# You may imagine that nums[-1] = nums[n] = -∞.
# You must write an algorithm that runs in O(log n) time.
  
  
  //Solution : The idea is to apply binary search in the array :- there are three possibilities : 
  //           1.  nums[mid] is peak element i.e it is greater than both right and left element. 
  //           2.  nums[mid-1] is greater than nums[mid] and nums[mid+1] is less than nums[mid]. so we search in left half. 
  //           3.  nums[mid+1] is greater than nums[mid] and nums[mid-1] is less than nums[mid]. so we search in right half.

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0 ; 
        int high = nums.length - 1 ; 
        while(low<=high){
    int mid = (low+high)/2; 
   if((mid == 0 || nums[mid]>=nums[mid-1]) && (mid == nums.length-1 || nums[mid]>=nums[mid+1]) ){
                return mid ;
   }
            else if(mid > 0 && nums[mid - 1 ]>=nums[mid]){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
