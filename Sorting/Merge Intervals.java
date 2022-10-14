Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of 
the non-overlapping intervals that cover all the intervals in the input.

  
  Solution : the idea is to frist sort the intervals according to the start time of each interval and then check 
  if the start time of next interval is less than the end time of previos interval for merging the intervals. 
    
    code: 

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        
        if(intervals.length == 0 || intervals == null) 
            return res.toArray(new int[0][]);
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int start = intervals[0][0];    // new interval start time
        int end = intervals[0][1];     // new interval end time
        
        for(int[] i : intervals) {
            if(i[0] <= end) {
                end = Math.max(end, i[1]);
            }
            else {
                res.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        res.add(new int[]{start, end});
       return res.toArray(new int[0][]);
    }
}
 
