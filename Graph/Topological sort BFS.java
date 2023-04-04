


Solution : the idea is to use an indegree array. 
  get the indegrees of all the vertices or nodes. 
  
  if the indegree becomes 0 .. push it into the queue. 
    
    code: 


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        
        int topo [] = new int[V]; 
        Queue<Integer> q = new LinkedList<>(); 
        
        int indegree[] = new int[V];
        for(int i = 0 ; i < V ; i++){
        for(int adjNode : adj.get(i)){
            indegree[adjNode]++; 
        }
    }
    
    
    for(int i = 0 ; i < V ; i++){
        if(indegree[i] == 0){
            q.offer(i);
        }
    }
    int index = 0;
    while(!q.isEmpty()){
        int node = q.poll(); 
        topo[index++] = node; 
        
        for(int adjNode : adj.get(node)){
            indegree[adjNode]--;
            
            if(indegree[adjNode] == 0){
                q.offer(adjNode);
            }
        }
    }
    return topo;
    }
}
