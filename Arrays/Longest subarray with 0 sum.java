Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.
  
  
  
  Solution : 
       [15,-2, 2,-8, 1, 7,10,23]
preSum  15 13 15  7  8 15 25 48
  
  if at any point the pre sum is same that means there is a subarray with zero sum 
  
  codE: 

class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        int preSum = 0 ; 
        HashMap<Integer,Integer> map = new HashMap<>() ; 
        int res = 0 ; 
        int len = 0 ; 
        for(int i = 0 ; i < arr.length ; i++){
            preSum += arr[i]; 
           if(!map.containsKey(preSum))
           {   
                map.put(preSum , i);
            //   len = i - map.get(preSum);
             
           }
           if(preSum == 0)
           len = i+1 ; 
           else 
           {
               len = i - map.get(preSum);
           }
           res = Math.max(res , len);
           
        }
        return res;
    }
}
