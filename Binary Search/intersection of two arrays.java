Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result
must be unique and you may return the result in any order.
  
  
  
  Solution : the idea is to select an element from one array and search it in other array through binary searcb if present add id to hashset . 
    
    code: 
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (BinarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;   
    }
    public boolean BinarySearch(int[] nums,int target){
    int start=0;
        int end=nums.length-1;
        int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target<nums[mid]){
                end=mid-1;
            }
            if(target>nums[mid]){
                start=mid+1;
            }
            if(target==nums[mid]){
                return true;
            }
        }
        return false; 
    }
}
