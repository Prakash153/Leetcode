Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single

space separating the words. Do not include any extra spaces.



Example: 

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.




Solution : the idea is to use trim and split method. and convert the string into an array of word strings. 

code: 
class Solution {
    public String reverseWords(String s) {
        String s1 [] = s.trim().split("\s+");      // \s removes single whitesace and \s+ is used to remove multiple whitespaces, 
        // split method returs string array of words
       // ["the","sky","is","blue"]
        String ans = "";
        for(int i = s1.length - 1; i >= 0 ; i--){
        // now reverse the words; 
            ans += s1[i]+" ";   //s1[3] = "blue" s1[2] = "is" s1[1] = "sky" s1[0] = "The"
        }
        
        return ans.trim();
    }
}
