Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
  
  
  
  code: 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>(); 
        int res = 0 ; 
        int len = 0 ;
        for(int i = 0,j=0 ; i < s.length() && j<s.length();j++){
            if(hs.contains(s.charAt(j))){
                while(s.charAt(i) != s.charAt(j)){
                    hs.remove(s.charAt(i));
                    i++;
                }
                i++;
                // len = j-i+1;
            }
            else{
              
               hs.add(s.charAt(j));
                len = j-i + 1; 
            }
         
            res = Math.max(len,res);
              System.out.print(res);
        }
        return res;
        
    }
}
