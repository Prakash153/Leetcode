You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i
coins. The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you



Solution: 
we have to create perfect stairs with given number of coins : 
suppose we have been given 11 coins 
so the stairs can be: 
0         11 -1  = 10     1
0 0       10 - 2 = 8      2
0 0 0      8 - 3 = 5      3
0 0 0 0    5 - 4 = 1      4
0          1 - 1 = 0 
  
  
  so the perfect stairs we can create from 11 are 4
  
  the sum of natural numbers  is n*(n+1)/2 
  our answer should satisfy the condition k*(k+1)/2 <= n  , where k has to be the last number that satisfies the condition. (floor value)
  
  
  code: 


class Solution {
    public int arrangeCoins(int n) {
        long low = 0  ;
        long high = n  ; 
        int ans = 0 ; 
        while(low <= high){
            long mid = low + (high-low)/2; 
            long sum = mid*(mid+1)/2   ;   // sum of first n natural number
            if(sum <= n){
                low = mid+1;
                ans = (int)mid;
            }    
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
}
