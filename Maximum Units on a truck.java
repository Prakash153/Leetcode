You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. 
You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.



Example : 
Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
Output: 8
Explanation: There are:
- 1 box of the first type that contains 3 units.
- 2 boxes of the second type that contain 2 units each.
- 3 boxes of the third type that contain 1 unit each.
You can take all the boxes of the first and second types, and one box of the third type.
The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.



solution : 
The idea is to create another array for units of size of 1001 according to the constraints. Now 
according to the number od units place the number of boxes in the unit array at their indices , suppose there are 3 boxes of 3 units , so put 3 at index 3 at unit array


now start traversing from the last as we want maximum unit :
if 0 is present at any index of the unit array we can skip and if boxes are there we need to take the boxes as of trucksize of less 
so we take MIN of boxes and trucksize....suppose there are 7 boxes and truck size is fro 5 boxes we need to take only 5 box out of 7. 

now we get the units by multiplying Min and index of unit array. and also reduce number of boxes added to the unit from the trucksize


code : 
class Solution 
{
    public int maximumUnits(int[][] boxTypes, int truckSize) 
    {
        int [] unitCount = new int[1001];
        
        for (int [] boxType : boxTypes)
        {
            unitCount[boxType[1]] += boxType[0];   // getting the count of how many boxes are on particular unit 
        }
        
        int count = 0;
        
        for (int i = unitCount.length-1; i >= 0; i--)
        {
            if (unitCount[i] == 0) continue;
            
            int num = Math.min(unitCount[i], truckSize);   // checking if the number of boxes are more than trucksize
            count += num * i;
            truckSize -= num;
            if (truckSize == 0) break;
        }
        
        return count;
    }
}
