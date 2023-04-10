Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]''
  '
  
  
  code: 

class Solution {
    public void findAll(int op, int cl , String s , List<String> ans,int n){
        if(op == n && cl == n)
        {
            ans.add(s);
            return  ;
        }
            // first add (  bracket 
        if(op < n){
            findAll(op+1 , cl ,s+"(" , ans,n); 
        }
            //  after that only add ) bracket 
        if ( cl < op){
            findAll(op,cl+1, s+")",ans,n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        findAll(0,0,"",ans,n); 
        return ans ;
    }

}
