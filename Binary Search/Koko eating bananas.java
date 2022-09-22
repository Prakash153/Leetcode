Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas
from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.
  
  
  Solution : the questions states that return the minimum speed wich which KOKO can finish all the bananas. 
 we can use binary search here as the minimum speed can be 1 ans max can be piles[i]. 
    so we start from mid of 1 and piles[i]; 
now, check if the speed satisfies the condition of hours, is yes, look for minimum , if no look for greater speed. 
  
  
  code: 


class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int m=1;
     for(int i=0;i<piles.length;i++){//finding max element.. 0(n)
          m=Math.max(m,piles[i]);
     }   
        int l=1,r=m;
       while(l<r){
           int mid=(l+r)/2;
           int s=0,i=0;
          while(i<piles.length){   //we check if middle element follows the condition
               if(piles[i]%mid==0){
				s+=piles[i]/mid;
			}else{
				s+=(piles[i]/mid) + 1;
              }
           i++;
          }
              if(s<=h){  //if sum< needed new range=l...mid
                 r=mid; 
              }else{   //if mid does not follow condition then our range now=mid+1...r
                  l=mid+1;    
              }    
       } 
        return r;
}
}
  
  
