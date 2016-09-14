package coding;

public class GraphTraversalSample {
	
	
	/*public void dfs(Node root){
		if(root == null) return;
		System.out.println(root.data);
		root.visited = true;
		for(Node n : root.adjacent){
			if(!n.visited){
				dfs(n);
			}
		}
	}*/
	
	/*public void bfs(Node root){
		Queue<Node> myQueue = new LinkedList<>();
		myQueue.offer(root);
		
		while(!myQueue.isEmpty()){
			Node curr = myQueue.poll();
			curr.visited = true;
			System.out.println(curr.data);
			if(Node n : curr.adjacent){
				myQueue.offer(n);
			}
		}
	}*/
}
