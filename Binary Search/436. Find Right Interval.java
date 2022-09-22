You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

The right interval for an interval i is an interval j such that startj >= endi and startj is minimized. Note that i may equal j.

Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.

 
  
  Solution : 

the question says that there are n number of intervals with a start and end point 
we have to find right interval for each interval. 
  the right interval for a particular interval will be : 
example right interval for [4,5] among the intervals [5,6],[10,8],[7,9]

right interval for [4,5] are all but the minimum is [5,6] 
here we see that the end of a particular interval should be smaller than the right interval's start. the start of right interval should be minimum (ceil). 
  
  
  we can solve this problem in nlogn time by, passing the target as end point of intervals ans sorted array of start points . and apply binary search. 
  
  
  code: 


class Solution {
    public int[] findRightInterval(int[][] intervals) {
        Map<Integer,Integer> map = new HashMap<>(); 
        int n = intervals.length;
        int [] start = new int[n] ;
        for(int i = 0 ; i < n ; i++){
            map.put(intervals[i][0],i);
            start[i] = intervals[i][0];
        }
        Arrays.sort(start);
        int ans[] = new int [n]; 
        for(int i = 0 ; i < n ; i++){
            int key = binarySearch(start,intervals[i][1]); 
            if(key == n)
                ans[i] = -1 ; 
            else if(key == 0)
            {
                if(intervals[i][1] <= start[0])
                    ans[i] = map.get(start[0]);
                else
                    ans[i] = -1;
            }
            else{
                ans[i] = map.get(start[key]);
            }
        }
        return ans;
    }
    public int binarySearch(int arr[] , int target){
        int low = 0 ; 
        int high = arr.length - 1 ; 
        while(low <= high){
            int mid = low + (high-low)/2 ; 
            if(arr[mid] <target)
                low = mid + 1 ;
            else 
                high = mid - 1;
            
        }
        return low ;
    }
}
