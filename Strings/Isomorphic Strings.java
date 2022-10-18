Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the 
order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
  
  
  code: 

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> hm = new HashMap<>();
        if(s.length()!=t.length())
            return false;
        
        for(int i=0;i<s.length();i++)
        {
            // case 1: if duplicates chars are present
            // check they are mapped with the same value 
            if(hm.containsKey(s.charAt(i)))
            {
                if(hm.get(s.charAt(i))!=t.charAt(i))
                    return false;
            }
            // case 2: if duplicates are not present
            // and the distict character is mapped with a value which is already mapped before
            // i.e duplicates are present in second string 
            else if(hm.containsValue(t.charAt(i)))
                    return false;
            
            // case 3 : if distinct elements are present just  map them 
            else
                hm.put(s.charAt(i),t.charAt(i));
        }  
        return true;
    }
}
