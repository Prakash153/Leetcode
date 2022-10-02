Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, 
for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.
  
  
  code: 


class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
       int arr[]=new int[nums.length];
        int res[]=new int[nums.length];
        HashMap<Integer,Integer> hm=new HashMap<>();
        int k=0;
        for(int x: nums)
        {
            arr[k++]=x;
        }
        Arrays.sort(arr);
        k=0;
        hm.put(arr[0],0);
        for(int i=1;i<arr.length;i++)
        {
            int count=i;
            int j=i;
            while(j>0 && arr[j]==arr[j-1])
            {
                count--;
                j--;
            }
            hm.put(arr[i],count);
        }
        for(int i=0;i<res.length;i++)
        {
            res[i]=hm.get(nums[i]);
        }
        return res;
    }
}

 
