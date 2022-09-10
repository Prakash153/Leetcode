The array-form of an integer num is an array representing its digits in left to right order.

For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
  
  
  
  Solution: 

the idea is to add the last element of array to last digit of the K (follow the addition method), 
in addition method we have carry also, so we compute the carry accoringly. 
  suppose we have some value in carry after the addition so we need to add it to the list accordingly. 
  
  example : 
carry  1 0 0
       7 8 5 
    +  2 7 1   
  __________________
      10 5 6                                    we add the modulo of our sum to the list 
      
      
      
      5 + 1 + 0 = 6    al.add(6%10 = 6 )
      8 + 7 + 0 = 15   al.add(15%10 = 5)
      7 + 2 + 1 = 10   al.add(10%10 = 0)
  
  so 6,5 and 0 will be added to the list but one will be left in the carry. 
  
  to solve this we add another set of code to 
  k = k+ carry 
  while(k!=0){
  al.add(k%10)
  k/=10;
  }
  


code: 


class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> al = new ArrayList<>(); 
                   int carry = 0 ;
       for(int i = num.length - 1 ; i >= 0 ; i--){

           num[i] = num[i] + k%10 + carry; 
           al.add(num[i]%10); 
           carry = num[i]/10; 
           k/=10; 
           
       }
        k += carry ; 
        while(k != 0){
            al.add(k%10); 
            k/=10;
        }
        Collections.reverse(al);
        return al;
    }
}
  
  
