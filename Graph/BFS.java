Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
Note: One can move from node u to node v only if there's an edge from u to v and find the
  BFS traversal of the graph starting from the 0th vertex, from left to right according to the graph. Also, 
  you should only take nodes directly or indirectly connected from Node 0 in consideration.
    
    
    
    code: 

TC: O(v+e)
added visited[] boolean array to traversal rest is same as BFS traversal of tree
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[] = new boolean[V]; 
        ArrayList<Integer> al = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>(); 
        visited[0] = true;  // to avoid cycles in graph 
        q.offer(0); 
        while(!q.isEmpty()){
            int u = q.poll();
            al.add(u); 
            for(int v : adj.get(u)){
                if(visited[v] == false){
                    visited[v] = true; 
                    q.offer(v); 
                }
            }
            
        }
        return al;
    }
}
