# Given an integer array nums and an integer k, return the kth largest element in the array.

# Note that it is the kth largest element in the sorted order, not the kth distinct element.

    // lomuto partition method is used here 
class Solution {
    public int findKthLargest(int[] nums, int k) {
         k = nums.length - k ;  // converting it to kth smallest element 
        int res = quickSelect(nums,0,nums.length-1,k);
        return res;
    }
    public int quickSelect(int nums[],int l , int r , int k){
         
        while(l<=r){
            int p = partition(nums,l,r);
            if(p == k ){
                return nums[p];
            }
            else if (p > k){
              r = p - 1;
            }
            else{
                l= p + 1;
            }
        }
        return -1;
    }
    public int partition(int nums[],int l , int h){
        int pivot = nums[h];
        int i = l - 1; 
        for(int j = l ;j<=h - 1 ; j++){
            if(nums[j] <  pivot){
                i++;
                int temp  = nums[j];
                nums[j] = nums[i];
                nums[i]= temp;
            }
        }
        int temp = nums[i+1];
        nums[i+1] = nums[h];
        nums[h] = temp;
        return i+1;
    }
}
