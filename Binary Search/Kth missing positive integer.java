Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.

 
  
  Solution : 

1 2 3 4 5 10
0 1 2 3 4 5 
  

   at index 4 , 5 should be present =>( 5 - 4 - 1) = 0  , no iteger is missing
       1 2 3 4 9 10
       0 1 2 3 4 5 
if at index 4 , 9 is present => (9 - 4 - 1) = 4 , we infer  from this information that any 4 integers are missing before 9 "the 4 integers are 5,6,7,8" 
        suppose we have to find third missing positive number so at index 4 any number can be present among 5,6,7,8 we but since we want three => index + 3 = 4 + 3 = 7
     7th number is missing
     
     similarly for other cases.
                10 is present => (10 - 4 - 1) = 5 , 5 integers are missing
                 7 is present => (7 - 4 - 1)  = 2 , 2 integers are missing. 
  
  
       
       code: 
class Solution {
    public int findKthPositive(int[] arr, int k) {
      int low = 0 ; 
        int high = arr.length - 1 ; 
     
        while(low <= high){
            int mid = low+(high-low)/2; 
            search = arr[mid] - mid - 1;
            if(search >= k)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low + k;
    }
}

  
  
  
  
