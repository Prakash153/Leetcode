28. Find the Index of the First Occurrence in a String
Easy
3.1K
150
Companies
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
  
  
  code: 
class Solution {
    public int strStr(String hayStack, String needle) {
       if(hayStack.contains(needle)){
           return hayStack.indexOf(needle);
       }
       return -1;
    }
}

//  int n = hayStack.length(); 
//         int m = needle.length(); 

//         for(int i = 0 ; i < n-m+1 ; i++){
//            int j = 0  ; 
//            while(j < m && hayStack.charAt(i+j) == needle.charAt(j)){
//                j++;
//                if(j >= m)
//                return i;
//            } 

//         }
//         return -1;
