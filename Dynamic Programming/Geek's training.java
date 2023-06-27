Geek is going for n days training program, he can perform any one of these three activities 
  Running, Fighting, and Learning Practice. Each activity has some point on each day. as Geek wants
  to improve all his skills, he can't do the same activity on two consecutive days, help Geek to maximize his 
  merit points as we were given a 2D array of n*3 points corresponding to each day and activity.

the idea is to start from last day and go till day 0 , on nth day we can pick maximum point's task not equal to task picked on (n-1)th day 


  code: 


class Solution{
    public int earnPoints(int day , int last , int [][] points,int [][] dp){
        if(day == 0){
            int maxi = 0 ; 
            for(int task = 0 ; task < 3 ; task++){
                if(task != last)
                maxi = Math.max(maxi,points[0][task]);
            }
            return maxi;
        }
        
         if(dp[day][last] != -1)
         return dp[day][last];   
        
        int maxi = 0 ; 
        
        for(int task = 0 ; task < 3 ; task++){
                
                if(task != last) {
                int point = points[day][task] + earnPoints(day - 1 , task,points,dp); 
                maxi = Math.max(point,maxi);
                 
            }
        }

        return dp[day][last] = maxi;
    }
    public int maximumPoints(int points[][],int N){
        //code here
        int dp [][] = new int[N][4]; 
        for(int i = 0; i<N ; i++){
            Arrays.fill(dp[i],-1);
        }
        
  return earnPoints(N-1,3,points,dp);
    }
}



// Tabular method : 

class Solution{
   
    public int maximumPoints(int points[][],int N){
        //code here
        int dp [][] = new int[N][4]; 
         dp[0][0] = Math.max(points[0][1] ,points[0][2]);
          dp[0][1] = Math.max(points[0][0] ,points[0][2]);
           dp[0][2] = Math.max(points[0][0] ,points[0][1]);
            dp[0][3] = Math.max( points[0][0], Math.max(points[0][1] ,points[0][2]));
            
            
            for(int day = 1 ; day < N; day ++){
                for(int last = 0 ; last < 4 ; last++){
                    int maxi = 0 ; 
                    for(int task = 0 ; task < 3 ; task++){
                        if(task != last){
                            int point = points[day][task] + dp[day-1][task]; 
                            dp[day][last] = Math.max(dp[day][last], point);
                        }
                    }
                }
            }
        
  return dp[N-1][3];
    }
}


// space optimized method :


class Solution{
   
    public int maximumPoints(int points[][],int N){
        //code here
        int prev[] = new int [4];
 
        prev[0] = Math.max(points[0][1] ,points[0][2]);
         prev[1] = Math.max(points[0][0] ,points[0][2]);
          prev[2] = Math.max(points[0][0] ,points[0][1]);
        prev[3] = Math.max( points[0][0], Math.max(points[0][1] ,points[0][2]));
            
            
            for(int day = 1 ; day < N; day ++){
                int temp[] = new int [4];
                for(int last = 0 ; last < 4 ; last++){
                    int maxi = 0 ; 
                    for(int task = 0 ; task < 3 ; task++){
                        if(task != last){
                            int point = points[day][task] +  prev[task]; 
                          temp[last] = Math.max(temp[last], point);
                        }
                    }
                }
                prev = temp;
            }
        
  return  prev[3];
    }
}
