Idea is to  BFS and instead of queue use PriorityQueue

code: 

class Pair
{
    int dist,node; 
    Pair(int dist,int node)
    {
        this.dist=dist;
        this.node=node;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        
        int [] distt=new int[V];
        Arrays.fill(distt,Integer.MAX_VALUE);
        
        distt[S]=0; 
 PriorityQueue<Pair> pq=new PriorityQueue<>((Pair a,Pair b)->a.dist!=b.dist?a.dist-b.dist:a.node-b.node);   // min-heap
        pq.add(new Pair(0,S));
        
        while(pq.size()>0)
        {
            Pair temp=pq.remove();
            
            int src=temp.node;
            int val=temp.dist;
            
            for(int i=0;i<adj.get(src).size();i++)
            {
                int weight=adj.get(src).get(i).get(1);
                int adjNode=adj.get(src).get(i).get(0);
                
                if(weight+val < distt[adjNode])
                  {
                      distt[adjNode]=weight+val;
                      pq.add(new Pair(distt[adjNode],adjNode));
                  }
            }
            
        }
        
        return distt;
        
    }
}
