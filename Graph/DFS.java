You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use a recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.


  
  codE: 

TC: O(v+e)
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public void dfs( ArrayList<ArrayList<Integer>> adj, int s , boolean [] vis , ArrayList<Integer> ans){
        vis[s] = true; 
        
        ans.add(s); 
        for(int u : adj.get(s)){
            if(vis[u] == false){
                vis[u] = true;
                dfs(adj,u, vis , ans );
            }
        }
        return;
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[] = new boolean[V]; 
        ArrayList<Integer> ans = new ArrayList<>(); 
        dfs(adj,0,visited,ans);
        return ans ; 
    }
}
