Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
  
  
  Solution: the siolution is hidden in the three edge cases : 

1. when there are more than one  zeros in the array. 
2. when there are only one zero
3. when there are no zero.


code: 

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans[] = new int[nums.length]; 
        int tot_p = 1 ; 
        int count_0 = 0;
      
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0){
                count_0++;
                continue;
            }
            tot_p*=nums[i];
        }
        
        if(count_0 > 1)    // case 1         [0,0] , [0,4,0]
            return ans;
            
        if(count_0 == 1){                                 // case 2
            for(int i = 0 ; i < nums.length ; i++){   //  [-1,1,0,-3,3]
                if(nums[i] == 0)
                    ans[i] = tot_p;
                else
                ans[i] = 0;
            }
        }
        else{
            for(int i = 0 ; i < nums.length ; i++){        // case 3    [1,2,3,4]
                ans[i] = tot_p/nums[i];
            }
        }
        
        return ans;
        
        
    }
}
