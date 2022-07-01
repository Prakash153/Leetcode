Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.
  
  
  Example : 
Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]


solution : using pre_sum technique. 
  we will use remainder theorum .    presum arr[0,i] = ka + b ; 
                                     presum arr[0,j] = kc + d;

presum arr[i,j] = k(a-c) + b-d ; 
for the presum of i,j to be multiple of k , b and d has to be equal.
  
  so the idea is if after moduling two numbers from k there remainders are same. then there difference is divisible by k. 
    we put the remainders into the hashmap and if we enocunter the same remainder then we have found a subarray divisible by k . 
      if the remainder is  negative .. we need to get a positive remainder by getting its mod.    7n - r = 7n' + (7-r); 
         7n - r = 7n' + (7-r);
        7n - 5 = 7n - 5 + 7 - 7 
        7n - 5 = 7(n-1) + (7 - 5 )
        hence we can get the mod of remainder by adding k to it. 
        
    code : 
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        int ans = 0 , remainder = 0 , pre_sum = 0 ; 
        map.put(0,1);
        for(int i  = 0; i < nums.length ; i++){
         pre_sum += nums[i];
            remainder = pre_sum % k; 
            if(remainder < 0)
                remainder += k ;
            if(map.containsKey(remainder))
            {
                ans += map.get(remainder);
                map.put(remainder, map.get(remainder)+1);
            }
            else{
                map.put(remainder,1);
            }
        }
        return ans;
    }
}
                                
  
