code: 


class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
        return new int[0][]; 
        ArrayList<int[]> merged = new ArrayList<>(); 
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]); 

        int [] mergeInterval = intervals[0]; 
        for(int i = 1 ; i < intervals.length ; i++){
            int[] interval = intervals[i]; 
            if(interval[0] <= mergeInterval[1]){
                mergeInterval[1] = Math.max(interval[1],mergeInterval[1] ); 
            }
            else {
                merged.add(mergeInterval); 
                mergeInterval = interval;
            }
        }
        merged.add(mergeInterval);
return merged.toArray(new int[0][]);
    }
}
