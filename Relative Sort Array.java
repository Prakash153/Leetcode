#Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
# Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do
# not appear in arr2 should be placed at the end of arr1 in ascending order.

  Solution: 1.The idea is tp create a Hashmap and put the elements or arr1 with their frequencie in map. 
            2. Now traverse the arr2 and look for the eleemnts of arr2 in map and replace them in arr1 according to the frequencies in the map. 
            3. for remaining elements copy them to list, sort them and then again copy them to arr1.
            


class Solution {
   public int[] relativeSortArray(int[] arr1, int[] arr2) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int x : arr1) map.put(x, map.getOrDefault(x,0)+1);

    int index = 0;
    for(int i=0; i<arr2.length; i++){
        int freq = map.get(arr2[i]); 
        for(int j=0; j<freq; j++) arr1[index++] = arr2[i];
        map.remove(arr2[i]);
    }
    
    // now add remaining to list to be sorted
    List<Integer> remaining = new ArrayList<>();
    for(Map.Entry <Integer, Integer> entry : map.entrySet()){
        for(int i=0; i<entry.getValue(); i++) remaining.add(entry.getKey());
    }
    
    Collections.sort(remaining);
    for(int i =0; i<remaining.size(); i++) arr1[index++] = remaining.get(i);
    
    return arr1;
}
}
