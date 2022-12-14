Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]



Solutions : // using checked array type of map : 
// idea is to select element at index one, check if it marked in the map , if false then put it in list and mark if true , call for recursion 
// repeat the above process till the list becmomes equal to size of array, create ans and return 
// now the i pointer of the for loops moves ahead in the similar manner . 


1,2,3 : 
firstly 1 is select 
then 2 
then 3 
  1,2,3 
  return 
then 3 
  then 2 
  1,3,2
  return 
  return 
  
  2 is selected 
  then 1 is selected 
  then 3 
  2,1,3 
  return 
  then 3 is selected 
  then 1 
  2,3,1 
  return 
  return 
  
  3 is selected 
  then 2 is selected 
  then 1 
  3,2,1 
  return 
  1 selected 
  then 2 
  3,1,2 
  


code: 
class Solution {
    public void permutations(int nums[] , List<Integer> ds , List<List<Integer>> ans , boolean[] map){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(!map[i]){
                map[i] = true; 
                ds.add(nums[i]); 
                permutations(nums,ds,ans,map);
                map[i] = false; 
                ds.remove(ds.size() - 1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); 
        List<Integer> ds = new ArrayList<>(); 
        boolean map[] = new boolean[nums.length]; 
        permutations(nums, ds , ans , map); 
        return ans ;
    }
}


2nd method : 

swap method : less space complexity 

code: 
class Solution {
    public void permutations(int index , int [] nums , List<List<Integer>> ans ){
        if(index == nums.length-1 ){
            List<Integer> ds = new ArrayList<>(); 
            for(int i = 0 ; i < nums.length ; i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
        }

        for(int i = index ; i < nums.length ; i++){
            swap(i,index , nums); 
            permutations(index+1 , nums, ans); 
            swap(i, index , nums);
        }
    }
    public void swap (int i , int j , int [] nums){
        int temp = nums[i]; 
         nums[i] = nums[j]; 
         nums[j] = temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); 
        permutations(0 , nums , ans); 
        return ans ;
    }
}
