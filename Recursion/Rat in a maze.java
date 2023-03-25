Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination
at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination.
  The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at 
  a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.
  
  
  code:

class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        
        ArrayList<String> ans = new ArrayList<>();
        
        boolean[][] vis = new boolean[n][n];
        
        path(m,0,0,vis,ans,"");
        
        return ans;
    }
    
  static void path(int[][] m,int i,int j,boolean[][] vis,ArrayList<String> ans,String psf){
        
 if(i < 0 || j < 0 || i >=m.length || j>=m[0].length   	|| vis[i][j]==true || m[i][j]==0) 
            return ;
            
        if(i==m.length-1 && j==m.length-1){
            ans.add(psf);
        }
        
        vis[i][j]=true;
       
        
        path(m,i+1,j,vis,ans,psf+"D");//Down
        path(m,i,j-1,vis,ans,psf+"L");//Left   
        path(m,i,j+1,vis,ans,psf+"R");//Right
         path(m,i-1,j,vis,ans,psf+"U");//UP
        
        vis[i][j]=false;
      
    }
}
