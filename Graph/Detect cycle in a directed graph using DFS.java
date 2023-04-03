idea: the idea is to use two arrays

1. visited : this array tells that if the vertex is visited or not 
2. dfsvisited : this array tells if the vertex if visited in the current move or not. 
  
  
  code: 

class Solution {
      public  boolean dfs(int curr,boolean visited[],boolean[] path, ArrayList<ArrayList<Integer>> adj){
        visited[curr]=true;
        path[curr]=true;
        for(int nbr : adj.get(curr)){
            
             if(!visited[nbr]) 
           {
                if(dfs(nbr,visited,path,adj))return true;
                
            }
            else if(path[nbr] == true){
                return true;
            }
            
        }
        path[curr]=false;
        return false;
          
      }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        // code here
        boolean visited[]=new boolean[V];
        boolean[] path=new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i]) continue;
            if(dfs(i,visited,path,adj))return true;
}
        return false;
}
}
