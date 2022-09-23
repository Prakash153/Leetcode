The frequency of an element is the number of times it occurs in an array.

You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.

Return the maximum possible frequency of an element after performing at most k operations.
  
  
  
  Solution : 
very great pattern, similar to koko eating banana. 
  
  so the idea is to use binary search and window sliding technique. 
  
  why binary search ? 
  -> look in an array of size n maximum frequency of any element can be n and minimum freqeuncy can be 1. 
  -> so our answer lies between 1 - n where the, answer denotes window size that is how many duplicates are present after performing the operations. 
  
  
  why sliding window ?
  -> look, in a sorted array. [1 2 3 4 ], the best approach to make all element same can be by making all the elements before 4 , equal to 4. 
  -> window size can either be 4 (size of array), or 1 <= windowsize <= n. 
  -> suppose window size is 3. so ther are two subarrays ... 1 2 3 and 2 3 4. with 3 size . so in first subarray we try to make all elements equal to three
  and in subarray to we try to make all element eqaul to 4. 
  -> the maximum operation required to make all element equal to 3 and 4 in both array will be 
   i) (3-1) + (3-2) = 3*2  - (1+2) = 6 - 3 = 3. 
  ii) (4-2) + (4-3) = 4*2 - (3+2)  = 8 - 5 = 3.   // here 4*2 (2 is window size )
    
  -> if our maximum operation to make all elements equal in the window array satisfies the condition of given operation , then we look for greater window 
  through binary search, and if not then we look smaller window. 
    
    
    
    code: 

class Solution {
    
    public boolean possible (int [] nums , int mid,int k){
        int windowSum = 0 ;
        int totSum = 0 ; 
        for(int i = 0; i < mid; i++){
            windowSum += nums[i];  //   prefixSum 
        }
        totSum = nums[mid - 1]*mid ; 
        if(totSum - windowSum <= k)   // total operation required to make all elemetns equal in array
            return true; 
        
        int j = 0 ;
        for(int i = mid ; i < nums.length ; i++){
            totSum = 0;
            windowSum -= nums[j]; 
            windowSum += nums[i]; 
            totSum = nums[i]*mid; 
            if(totSum - windowSum <= k)
                return true;
            
            j++;
        }
        return false;
    }
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);    // sorting the array so that sliding window works effectively.
        int n = nums.length ; 
        int low = 1 ; 
        int high = n ;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low )/2;    // mid is window size
            if(possible(nums,mid,k)){
                ans = mid; 
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        return ans;
    }
}
