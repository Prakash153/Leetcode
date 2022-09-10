Given an integer n, return any array containing n unique integers such that they add up to 0.

 

Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
Example 2:

Input: n = 3
Output: [-1,0,1]
Example 3:

Input: n = 1
Output: [0]


1. 

code: 

class Solution {
    public int[] sumZero(int n) {
        
        int arr[] = new int[n]; 
        if(n == 1){
         arr[0] = 0; 
        return arr;
    }
        if(n%2 == 0){
            int k = 1;
            for(int i = 0 ; i < n-1 ; i+=2){
                arr[i] = k; 
                arr[i+1]= (~(k-1));
                k++;
            }
        }
        else{
            arr[0] = n ;
            arr[1] = -( n/2 ); 
            arr[2] = -(n - n/2) ; 
            int k = 1;
            for(int i = 3 ;i < n - 1; i+=2){
                arr[i] = k ; 
                arr[i+1]= (~(k-1));
                k++;
                
            }
        }
        return arr;
    }
}


better //

code 2 : 
class Solution {
    public int[] sumZero(int n) {
        int [] arr = new int[n];
        int val = 1;
        int i = 0;
        if(n % 2 == 1){
            arr[0] = 0;
            i++;
        }
        
        while(i < n){
            int v1 = val;
            int v2 = -val;
            arr[i++] = v1;
            arr[i++] = v2;
            val++;
        }
        return arr;
    }
}



