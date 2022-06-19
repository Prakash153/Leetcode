Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b


// solution : 

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        // 1. Binary Search for possible possition
        int l = 0, r = n - 1, pos = 0;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(arr[m] <= x) {
                pos = m;
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }
        
        // 2. Window from i - k to i + k
        l = (pos - k < 0) ? 0 : pos - k;
        r = (pos + k >= n) ? n - 1 : pos + k;
        // 3. Shrink window to size k
        while(r - l + 1 != k) {
            if(Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) {
                l++;
            }
            else r--;
        }
        
        // 4. Our answer is from l to r
        List<Integer> ans = new ArrayList<>();
        for(int i = l; i <= r; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
