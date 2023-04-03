idea: the idea is to change the color before sending into recursion calls and hadnle the first call explicitly

code: 

class Solution
{
    public boolean dfs(int node , int color[] ,  ArrayList<ArrayList<Integer>>adj){
        if(color[node] == -1) color[node] = 1; 
        
        for(int adjNode : adj.get(node)){
            if(color[adjNode] == -1){
                color[adjNode] = 1 - color[node];
                if(!dfs(adjNode,color,adj))
                return false;
            }
            else if(color[adjNode] == color[node])
            return false;
        }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int color [] = new int [V]; 
        Arrays.fill(color,-1); 
        for(int i = 0 ; i < V ; i++){
            if(color[i] == -1){
                if(!dfs(i,color,adj))
                return false;
            }
        }
        return true;
    }
}
