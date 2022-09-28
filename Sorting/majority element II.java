Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
  
  Solution : if a array is divided into 3 parts, the number of majority elements in the array can be at most 2. 
  the idea is similar to moore's voting algorithm, just the difference is we are trying to find two majority elements. And the prominent idea is that
    if an element is in majority other elements cannot cut it's votes.
    
    code: 

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = Integer.MIN_VALUE , num2 = Integer.MIN_VALUE , c1  = 0 , c2 = 0 ; 
        for(int i = 0 ; i < nums.length ; i++){
            if(num1 == nums[i])
                c1++; 
            else if(num2 == nums[i])
                c2++; 
            else if(c1 == 0){
                num1 = nums[i]; 
                c1 = 1 ;
            }
            else if(c2 == 0){
                num2 = nums[i]; 
                c2 = 1;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1= 0 ;c2 = 0;
        
        ArrayList<Integer> list = new ArrayList<>(); 
        for(int i = 0 ; i < nums.length ; i++){
            if(num1 == nums[i])
                c1++; 
            if(num2 == nums[i])
                c2++;
        }
        
        if(c1 > nums.length/3) list.add(num1); 
        if(c2 > nums.length/3) list.add(num2);
        
        return list;
    }
}
