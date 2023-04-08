
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> q = new ArrayDeque<>(); 
        Map<Node,Node> map = new HashMap<>(); 
        q.offer(node); 
        map.put(node, new Node(node.val, new ArrayList<>())); 

        while(!q.isEmpty()){
            Node currNode = q.poll();

            for(Node adjNode : currNode.neighbors){
                if(!map.containsKey(adjNode)){
                    map.put(adjNode, new Node(adjNode.val, new ArrayList<>()));
                    q.offer(adjNode);
                }
                map.get(currNode).neighbors.add(map.get(adjNode));
            }
        }
        return map.get(node);
    }
}
