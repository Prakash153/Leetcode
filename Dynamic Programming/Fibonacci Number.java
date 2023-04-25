code: 
TC: O(N); 
SC: O(N) + O(N); 
stack space + dp space
class Solution {
    public int f(int n,int []dp){
        if( n <= 1)  return n; 
        if(dp[n] != -1) return dp[n]; 

        return dp[n] = f(n-1,dp) + f(n-2,dp);
    }
    public int fib(int n) {
        int dp[] = new int[30+1]; 
        Arrays.fill(dp,-1);
        return f(n,dp);
        
    }
}
