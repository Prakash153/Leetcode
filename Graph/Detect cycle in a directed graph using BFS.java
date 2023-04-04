the idea is similar to implementation of topological sort using BFS algorithm. 
  the trick here is to compute the count variable. if count becomes equal no. of vertices then it is a acyclic graph else it is a cyclic graph. 
    
    
    code: 

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static boolean topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        
//         int topo [] = new int[V]; 
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
    int count = 0;
    while(!q.isEmpty()){
        int node = q.poll(); 
       count++; 
        
        for(int adjNode : adj.get(node)){
            indegree[adjNode]--;
            
            if(indegree[adjNode] == 0){
                q.offer(adjNode);
            }
        }
    }
      if(count == V) return false;
    return true;
    }
}
