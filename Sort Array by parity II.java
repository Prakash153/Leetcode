#Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

#Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

#Return any answer array that satisfies this condition.


// solution: The idea is to use Hoare's partition method in which first we traverse the even indices to check if there is even element and same for odd indices. 
//           when we find the  elements at wrong places we swap the odd and even elements;


public int[] sortArrayByParityII(int[] A) {
        int even = 0, odd = 1;
        while(true){
            while(even < A.length && A[even] % 2 == 0) 
                even += 2;
            while(odd < A.length && A[odd] % 2 != 0)
                odd += 2;
            if(odd >= A.length || even >= A.length) return A;
			
 
            int temp = A[even];
            A[even] = A[odd];
            A[odd] = temp;
        }
    }
