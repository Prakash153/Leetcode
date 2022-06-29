There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. 
\You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if 
you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique



example : 
Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.



solution : 
the idea is to create two variables surplus and deficit. 
surplus stores the extra gas and deficit stores the  gas requeired to tour the whole circular gas station. 
if surplus is greater  or equal to the absolute of defict we return the starting point  of where surplus began. 

dry run : 

gas  [1 2 3 4 5 ]
cost [3 4 5 1 2 ]

at i = 0 :  surplus += gas[i] - cost[i] = 1 - 3 = -2 
            surplus < 0 ; 
            deficit = deficit + surplus = 0 - 2 = -2
            surplus = 0 
            start = 1 
at i = 1 :  surplus += gas[i] - cost[i] = 2 - 4 = 2
            surplus < 0 ;
             deficit = deficit + surplus = -2 - 2 = -4
             surplus = 0;
             start = 2
at i = 2 :  surplus += gas[i] - cost[i] = 3 - 5 = -2
            surplus < 0 ;
             deficit = deficit + surplus = -4 - 2 = -6
             surplus = 0;
             start = 3
at i = 3 :  surplus += gas[i] - cost[i] = 4 - 1 = 3
at i = 4 :  surplus += gas[i] - cost[i] = 3 + 5 - 2 = 6
  
  
  
  at the end we get : 
  start = 3 
  surplus = 6
  deficit = -6 
  
  6 >= 6 true return  3 
  
  

  
           

code : 

]

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int start = 0 ; 
        int surplus = 0 ; 
        int deficit = 0 ; 
        for(int i = 0 ; i< gas.length ; i++){
            surplus += gas[i] - cost[i];
            if(surplus < 0){
                start = i + 1;
                deficit += surplus ; 
                surplus = 0 ;
            }
        }
        return (surplus >= Math.abs(deficit)) ? start : -1;  
    }
}
