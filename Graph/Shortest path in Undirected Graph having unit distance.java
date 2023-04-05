code: 


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) adj.add(new ArrayList<>());
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int dist [] = new int[n]; 
        
        Arrays.fill(dist,Integer.MAX_VALUE); 
        
        Queue<Integer> q = new LinkedList<>(); 
        
        q.offer(src); 
        dist[src] = 0; 
        
        while(!q.isEmpty()){
            int node = q.poll(); 
            for(int adjNode : adj.get(node)){
                if(dist[node] + 1 < dist[adjNode]){
                    dist[adjNode] = dist[node] +1 ;
                    q.offer(adjNode);
                }
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            if(dist[i] == Integer.MAX_VALUE)
            dist[i] = -1;
        }
        return dist;
    }
}
