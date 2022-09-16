Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

 
  
  code: 

class Solution {
    public int mySqrt(int x) {
        long low = 0 ; 
        long high = x ; 
        int ans = 0 ; 
        while(low <= high){
            long mid = low+(high-low)/2; 
            if(mid*mid <= x){
                ans = (int)mid ; 
                low = mid + 1;
            }
            else{
                high = mid - 1 ;
            }
        }
        return ans;
    }
}
