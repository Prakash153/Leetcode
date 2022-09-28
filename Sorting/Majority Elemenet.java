Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
  
  
  Solution : the idea is to use moore's voting algorithm. 
    steps: 
 1. we consider the first element as majority element and for it's support vote is also 1. 
 2. we start our loop from 2nd element and check if the element is same as majority element then we increase the vote by 1, if it is different we decrease the vote.   
 3. decreasing the vote because other elements nullify its  the vote of majority element.
 4. if vote becomes 0 for the majority element we reset the majority element with current element and vote as 1. 
   
   
   code: 
class Solution {
   public int majorityElement(int[] nums) {
        int maj=0;
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[maj]==nums[i]){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                maj=i;count=1;
            }
        }
        count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==nums[maj]){
                count++;
            }
        }
        return (count>nums.length/2)?nums[maj]:-1;
    }
}
