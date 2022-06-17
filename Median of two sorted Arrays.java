# Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

# The overall run time complexity should be O(log (m+n)).  
  
  

class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
          if(a.length >  b.length){
             return findMedianSortedArrays(b,a);
         }
      int n = a.length,  m = b.length;
      int s = 0, e=n;
      while( s<=e){
          int i1 =(s+e)/2;
          int i2 = (n+m+1)/2 - i1;
          int min1 = (i1 == n) ? Integer.MAX_VALUE : a[i1];
          int max1 = (i1 == 0) ? Integer.MIN_VALUE : a[i1-1];
          int min2 = (i2 == m) ? Integer.MAX_VALUE : b[i2];
          int max2 = (i2 == 0) ? Integer.MIN_VALUE : b[i2-1];
          if(max1 <= min2 && max2 <= min1){
              if((n+m)%2 == 0){
                  return ((double)((Math.max(max1,max2)+Math.min(min1,min2)))/2);
              }
              else{
                  return (double)Math.max(max1,max2);
              }
          }
          if(max1 > max2){
              e = i1 - 1;
          }
          else{
              s = i1 + 1;
          }
      }
      return -1;
    }
}
