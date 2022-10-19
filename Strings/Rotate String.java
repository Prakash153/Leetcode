Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
 

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
 
  Solution : the idea is to rotate n-1 times and return true if at any instance the string becomes equals to goal 
  
  My code : 
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
            return false ; 
        if(s.equals(goal))
            return true; 
        char ch = s.charAt(0) ; 
        int k = 0 ; 
        while(k < s.length()){
            
            String st = "";
            for(int i = 1; i < s.length() ; i ++){
                st += s.charAt(i);
            }
            st += ch; 
            if(st.equals(goal))
                return true; 
            k++;
            s = st; 
            ch = st.charAt(0);
        }
        return false;
    }
}





Best Solution : 
class Solution {
    public boolean rotateString(String s, String goal) {
        
        if(s.length() == goal.length() && (s+s).contains(goal)){
            return true;
        }
        
        return false;
    }
}
