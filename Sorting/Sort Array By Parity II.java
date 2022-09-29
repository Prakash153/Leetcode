Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

Return any answer array that satisfies this condition.
  
  
  
  Solution: the idea is to traverse on even and odd index and check if the appropriate element is present or not. 
    
    code: 
class Solution {
   public int[] sortArrayByParityII(int[] A) {
        int even = 0, odd = 1;
        while(true){
            while(even < A.length && A[even] % 2 == 0) /*(1)*/
                even += 2;
            while(odd < A.length && A[odd] % 2 != 0) /*(2)*/
                odd += 2;
            if(odd >= A.length || even >= A.length) return A;
			
			/*(3)*/
            int temp = A[even];
            A[even] = A[odd];
            A[odd] = temp;
        }
    }
}
