Idea is to store node  and it's parent in the queue together.
code: 


class Solution {
    // Function to detect cycle in an undirected graph.
    class Node{
        int first , second; 
        Node(int first , int second){
            this.first = first; 
            this.second = second; 
        }
    }
     boolean checkForCycle( int s , boolean vis[] ,ArrayList<ArrayList<Integer>> adj )
    {
       Queue<Node> q =  new LinkedList<>(); //BFS
       q.add(new Node(s, -1));
       vis[s] =true;
       
       // until the queue is empty
       while(!q.isEmpty())
       {
           // source node and its parent node
           Node  n = q.poll();
           int node = n.first;
           int par = n.second;
           
           
           // go to all the adjacent nodes
           for(int it: adj.get(node))
           {
               if(vis[it]==false)  
               {
                   q.add(new Node(it, node));
                   vis[it] = true; 
               }
        
                // if adjacent node is visited and is not its own parent node
               else if(par != it) return true;
           }
       }
       
       return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean vis []= new boolean[V];
        for(int i = 0 ; i < V ; i++)
        {
            if(vis[i] == false){
                if(checkForCycle(i,vis,adj) == true)
                return true;
            }
        }
        return false;
    }
}
