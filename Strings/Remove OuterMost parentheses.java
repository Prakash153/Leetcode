A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.

For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split
it into s = A + B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.

Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
  
  Example: 
Example 1:

Input: s = "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
Example 2:

Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
Example 3:

Input: s = "()()"
Output: ""
Explanation: 
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
  
  
  
  Solution: the idea is to record the count of left braces and when a right brace is found try to neutralise the count of left brace. when the 
  count becomes 0. add it to the ans;

 



code: 
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder(); 
        int level = 0 ; 
        for(int i = 0 ; i< s.length(); i++){
            if(s.charAt(i)=='(')
                level++;
            if(level >= 2)    // because the outer bracket can only be 1. so if there are more than 1 left braces then it means there are inner braces
                sb.append(s.charAt(i));
            if(s.charAt(i)==')')
                level--;
        }
        return sb.toString();
    }
}
