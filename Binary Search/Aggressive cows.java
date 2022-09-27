Very important question similar to koko eating bananas. 
  
  codestudio : 




code: 

import static java.lang.Integer.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Solution 
{
    public static boolean possible(ArrayList<Integer> stalls , int cows , int dist){
        int stall = stalls.get(0); 
        cows--;
        for(int i = 1 ; i < stalls.size(); i++ ){
            if(stalls.get(i)- stall >= dist){
                stall = stalls.get(i);
                cows--;
            }
            if(cows == 0)
                return true;
        }
        return false;
    }
    public static int aggressiveCows(ArrayList<Integer> stalls, int k) 
    {
       Collections.sort(stalls);
        int n = stalls.size() ;
        int low = 1; 
        int high = stalls.get(n-1)-1 ;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2 ; 
            if(possible(stalls,k,mid)){
                ans = mid;
                low = mid + 1;
            }
            else
                high = mid -1;
        }
        return ans;
    }
}
