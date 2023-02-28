You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
  
  
  
  Solution : 
the idea is to use greedy approach for solving this question. 
  
  we need to computer 3 variables : 

1. current reach :- this will tell that from element x we can go till x+i .......but we need to select the max elemetn x to get the farthest reach
2. farthest    :- for computing the max element that is farthest reach between element x and it's current reach 
3. jumpp       :- icrements each time we reach our current limit of jump. 
  
  for ex : 

      curr = 0 ; 
      farthest = 0; 
      jump = 0 ; 
i = 0 :-
farthest = Math.max(farthest,nums[i] + i ) 
         = (0,2+0) = 0 ;
(i == curr)  0 + 0 true 
{
  jump++
    curr  = farthest // we update current reach because we reach our current limit of jump for element x now we select the max element for max jumps. 
    
  }

i = 1 :- 
  
  farthest = (2,3+1) = 4 
  i == curr => 1 == 2 false 
  
i = 2 :- 
  
  farthest = (4,1+2) = 4 
  i == curr => 2 == 2 true 
  jump++ // we take the jump 
  curr = farthest // update the new current reach 
  
  i = 3 :-
    farthest = (4,1+3) = 4 
    i == curr => 3 == 4 false; 

return jump ; 



conclusion : by selecting the farthest and then updating the current reach we move forward
class Solution {
    public int jump(int[] nums) {
        int jumps = 0 ; 
        int farthest =0; 
        int current = 0 ; 
        for(int i = 0 ; i < nums.length -1 ; i++){
            farthest = Math.max(farthest,nums[i]+i);
            
            if(i == current){
               current = farthest; 
                jumps++;
            }
        }
        return jumps;
        
    }
}

  
