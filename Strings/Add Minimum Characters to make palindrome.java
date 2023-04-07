Given a string str, find the minimum characters to be added at front of the string to make it a palindrome.


Example 1:

Input:
str = ABCD
Output: 3
Explanation: The resultant string 
after adding 3 characters is DCBABCD.
The minimum possible answer is 3.
  
  
  
  code: 


class Solution
{
	public static int addMinChar(String s){
		//code here
		int i = 0 ; 
		int j = s.length() -1  , trim = j ; 
		int count =0;
		while(i < j){
		    if(s.charAt(i) == s.charAt(j)){
		        i++; 
		        j--;
		    }
		    
		    else{
		        count++;
		        i = 0 ; 
		        j = --trim;
		    }
		}
		return count;
	}
}
