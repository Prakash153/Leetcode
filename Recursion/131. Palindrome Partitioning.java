Given a string s, partition s such that every 
substring
 of the partition is a 
palindrome
. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]


Solution : the idea is to :
1. take the prefix of the string and partion is only if it is a palindromic string. 
2. add the prefix to the list and then pass the rest of the substring through i+1. 
3. remove the prefix from the list.
  
  code:
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>(); 
        ArrayList<String> list = new ArrayList<>(); 
        func(s,0,list,ans); 
        return ans;
    }
    public void func(String s , int index , List<String> list , List<List<String>> ans){
        if(index == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index ; i < s.length(); i++){
            if(isPalindrome(s,index,i)){
                list.add(s.substring(index,i+1));
                func( s,i+1,list,ans);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s , int left , int right){
        while(left <= right){
            if(s.charAt(left++) != s.charAt(right--))
            return false;
             
        }
        return true;
    }
}
