Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows
in both arrays and you may return the result in any order.
  
  
  Solution : the idea is to sort both arrays and apply merge sort algorithm. 
    
    
    code: 
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list=new ArrayList();
        int i=0;
        int j=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]>nums2[j]){
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else{
                list.add(nums1[i]);
                //System.out.println(nums1[i]);
                i++;
                j++;
            }
        }
        int arr[]=new int[list.size()];
        for(int k=0;k<arr.length;k++){
            arr[k]=list.get(k);
        }
        return arr;
    }
}
