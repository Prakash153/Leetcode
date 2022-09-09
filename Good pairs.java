// Given an array of integers nums, return the number of good pairs.

// A pair (i, j) is called good if nums[i] == nums[j] and i < j.
  
  
  
  // Solution :  the ideas to count the nummber of duplicates and calculate the possible pairs \
  
  
// code 1 : 
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                count += map.get(nums[i]);
                map.put(nums[i], map.get(nums[i])+1);
            }
            else{
                map.put(nums[i], 1);
            }
        }
        return count;
    }
}
  



// code 2 : 

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            int val = nums[i];
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        int good = 0;
        for(int key : map.keySet()){
            if(map.get(key) > 1){
                int val = map.get(key);
                val = val * (val - 1) / 2;
                good += val;
            }
        }
        return good;
    }
}
