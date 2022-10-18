You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) 
  that is a non-empty substring of num, or an empty string "" if no odd integer exists.

A substring is a contiguous sequence of characters within a string.
    
    solution : the idea  is the look for the rightmost odd digit(character)
    
    code:

class Solution {
    public String largestOddNumber(String num) {
        // if(num.charAt(num.length()-1)  % 2 == 1) return num; 
      
        for(int i = num.length() - 1  ; i >= 0 ; i--){
            if(num.charAt(i)%2 == 1){
                return num.substring(0,i+1);
            }
        }
        
        // if(num.charAt(0)%2 == 1)
            // return Character.toString(num.charAt(0));
        return "";
    }
}
