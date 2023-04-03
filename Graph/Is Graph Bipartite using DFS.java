code: 


class Solution {
    public boolean checkForBipartite(int node , int color[] , int graph[][]){
        Queue<Integer> q = new LinkedList<Integer>(); 
        q.offer(node); 
        color[node] = 1; 

        while(!q.isEmpty()){
            int curr = q.poll(); 
            for(int adjNode : graph[curr]){
                if(color[adjNode] == -1){
                    color[adjNode] = 1 - color[curr]; 
                    q.offer(adjNode);
                }
                else if(color[adjNode] == color[curr]){
                        return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length ; 
        int color[] = new int[n]; 

        Arrays.fill(color,-1); 

        for(int i = 0 ; i < n ; i++){
            if(color[i] == -1){
                if(!checkForBipartite(i,color,graph))
                return false;
            }
        }
        return true;
    }
}
