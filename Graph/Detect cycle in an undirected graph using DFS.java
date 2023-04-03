Solution : The idea is similar to dfs traversal , just the change is that parent node is added 
that tells that if the adjacent node is already visited and it is not equal to parent then there is a cycle. 
  
  
  
  code: 

class Solution {
    public boolean dfs(int node, int parentNode , boolean vis[] ,ArrayList<ArrayList<Integer>> adj ){
        vis[node] = true; 
        
        for(int adjacentNode : adj.get(node)){
            if(vis[adjacentNode] == false){
                if(dfs(adjacentNode , node, vis , adj)) 
                return true;
            }
            else if( adjacentNode != parentNode)
            return true;
        }
        return false;
    }
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
 boolean vis[] = new boolean[V+1]; 
 for(int i = 0 ; i < V ; i++){
     if(vis[i] == false){
         if(dfs(i,-1,vis,adj))
         return true;
     }
 }
 return false;
    }
}
