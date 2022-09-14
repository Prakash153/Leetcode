Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the 
same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.
  
  
  
  Solution : 

Dutch national flag algorithm : 

three pointers for three items: left mid right 

three case : if lowest is at mid , swap with left  and increment both
             if highest is at mid , swap with right decrement right 
             if medium is at mid just increment mid
             
             
             
code: 
class Solution {
    public void sortColors(int[] nums) {
        //Dutch National Flag Algorithm
      int l=0;
        int mid=0;
        int r=nums.length-1;
        while(mid<=r){
            if(nums[mid]==0){
                int temp=nums[mid];
                nums[mid]=nums[l];
                nums[l]=temp;
                l++;
                mid++;
            }
            else if(nums[mid]==2){
                int temp=nums[mid];
                nums[mid]=nums[r];
                nums[r]=temp;
                r--;
            }
            else {
                mid++;
            }
        }
     } 
}

 
