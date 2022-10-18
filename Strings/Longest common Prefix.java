Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
  
  
Solution : 
The idea is to select the first word as prefix, and then compare it with each word and accordingly reduce the size of prefix. 
  
  
  code: 

class Solution {
    public String longestCommonPrefix(String[] s) {
        String Prefix = s[0];
        String p = Prefix;
        for(int i = 1 ; i < s.length ; i++){
            p = compare(p,s[i]); 
            if(p.length() == 0)
                return "";
        }
        return p;
    }
    
    public String compare(String prefix , String s){
        int i = 0 ; 
        int j = 0 ; 
        String p = "";
        while(i < prefix.length() && j < s.length()){
            if(prefix.charAt(i) == s.charAt(j)){
                p += prefix.charAt(i);
            }
            else {
                return p;
            }
            i++; 
            j++;
        }
        return p;
    }
}
