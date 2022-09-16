code: 


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int n = numbers.length;
        int sum = 0;
        int low = 0;
        int high = n-1;
        while(low < high){
            sum = numbers[low] + numbers[high];
            if(sum == target){
                return new int[] {low+1,high+1};
            }
            else if(sum < target){
                low++;
            }else{
                high--;
            }
        }
        return new int[] {};
    }
}
