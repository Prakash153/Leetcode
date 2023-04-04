Topological sort: a topo sort of a graph is that if there is an edge u,v such that u comes before v then 
it is termed as topologial order. 
   Adjacency list : 

   0- 
   1-
   2-3
   3-1
   4-0,1
   5-0,2
  
  
  Solution : 
 The idea is to use stack data structre and out the vertex in the stack after all it's adjacent nodes have been visited. 
   now the trick here is
  
  code: 


class Solution
{
    
    public static void findTopoSort(int node ,boolean vis[] ,Stack<Integer> st,ArrayList<ArrayList<Integer>> adj){
        vis[node] = true; 
        
        for(int adjNode : adj.get(node)){
            if(vis[adjNode] == false){
                findTopoSort(adjNode,vis,st,adj);
            }
        }
        st.push(node);
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Stack<Integer> st = new Stack<>(); 
        
        boolean vis[] = new boolean [V]; 
        for(int i = 0 ; i < V ; i++){
            if(!vis[i] ){
                findTopoSort(i,vis,st,adj);
            }
        }
        
        int topo[] = new int[V]; 
        int i= 0;
        while(!st.isEmpty()){
            topo[i++] = st.pop();
        }
        return topo;
    }
}
