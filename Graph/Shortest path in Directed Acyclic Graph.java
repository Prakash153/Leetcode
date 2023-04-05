code: 

class Solution {
    
class Pair {
    int node;
    int dis;
    Pair (int node, int dis) {
        this.node = node;
        this.dis = dis;
    }
}
    
    
    public void dfs(int node, int vis[] , Stack<Integer> st , List<List<Pair>> adj){
        vis[node] = 1 ; 
        for(Pair pair : adj.get(node)){
            if(vis[pair.node] == 0){
                dfs(pair.node, vis, st, adj);
            }
        }
        st.push(node);
    }
    
    
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		List<List<Pair>> adj = new ArrayList<>();
		for (int i = 0; i < N; i++) {
		    adj.add(new ArrayList<Pair>());
		}
		for (int i = 0; i < M; i++) {
		    adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
		}
		
		// For Topo Sort
	Stack<Integer> st = new Stack<>(); 
	int vis[] = new int[N]; 
	for(int i = 0 ; i < N ; i++){
	    if(vis[i] == 0){
	        dfs(i,vis,st,adj);
	    }
	}
	
	int dist[] = new int[N]; 
	Arrays.fill(dist,Integer.MAX_VALUE); 


   // Main operation 
   // since the source in question is 0 
   dist[0] = 0;
   while(!st.isEmpty()){
       int currNode = st.pop(); 
       if(dist[currNode] != Integer.MAX_VALUE ){
           for(Pair adjPair : adj.get(currNode)){
               if(dist[currNode] + adjPair.dis < dist[adjPair.node]){
                   dist[adjPair.node] = dist[currNode] + adjPair.dis;
               }
           }
       }
   }
	
	for(int i = 0 ; i < N ; i++){
	    if(dist[i] == Integer.MAX_VALUE){
	        dist[i] = -1;
	    }
	}
	 
	
		return dist;
}
}
