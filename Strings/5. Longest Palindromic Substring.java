Given a string s, return the longest 
palindromic
 
substring
 in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
  
  
  
  code: 
class Solution {
    public String longestPalindrome(String s) {
        // here we have two cases
        // either we have a palindrome string of odd or even length 
        // for odd length we have to fix such a character that is the middle
        // of the palindrome 
        // for even length we have to fix two middle character

        int st = 0 ; 
        int end = 0 ; 
        int longest = 1; 

        for(int i = 0 ; i < s.length() ; i++){
            // for odd 
            int left = i - 1 ; 
            int right = i + 1 ; 
     while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
     {
         left--; 
         right++;
     }
     int currLen = right - left + 1 ;
    if(currLen > longest){
        longest = currLen; 
        st = left+1 ; 
        end = right ;
    }
        }

         for(int i = 0 ; i < s.length() ; i++){
            // for even 
            int left = i ; 
            int right = i + 1 ; 
     while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
     {
         left--; 
         right++;
     }
     int currLen = right - left + 1 ;
    if(currLen > longest){
        longest = currLen; 
// left + 1 because after the above loop left & end will go out of the range of palindrome
// right-1 is not because in substring we have to sen i+1 string to get the string.
        st = left+1 ; 
        end = right ;
    }
        }

        return s.substring(st,end);
    }
}
