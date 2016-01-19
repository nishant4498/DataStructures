public void levelOrderTraversal(Node root){
	Queue<Node> myQueue = new LinkedList<Node>();
	if(root == null){
		return;
	}
	myQueue.offer(root);
	while(!myQueue.isEmpty()){
		Node curr = myQueue.poll();
		if(!curr.leftChild == null){
			myQueue.offer(curr.leftChild);
		}
		if(!curr.rightChild == null){
			myQueue.offer(curr.rightChild);
		}
		System.out.println(curr.data);	
	}
}
/*
*This can be also done using level order traversal in the Binary tree.
*/
public int MaxInBinaryTree(Node root){
	int maxValue = Integer.MIN_VALUE;
	if(!root == null){
		int leftMax = MaxInBinaryTree(root.left);
		int rightMax = MaxInBinaryTree(root.right);
		
		if(leftMax > rightMax){
			maxValue = leftMax;
		}else{
			maxValue = rightMax;
		}
		
		if(root.data > maxValue){
			maxValue = root.data;
		}
	}
	
	return maxValue;
}

public static boolean findInBinaryTree(Node root,int data){
	if(root == null){
		return false;
	}
	if(root.data == data ){
		return true;
	}
	return findInBinaryTree(root.left , data) || findInBinaryTree(root.right,data);
}

public int sizeOfTree(Node root){
	if(root == null){
		return 0;
	}
	int leftCount = root.left == null? 0: sizeOfTree(root.left);
	int rightCount = root.right == null? 0 : sizeOfTree(root.right);
	
	return 1 + leftCount + rightCount;
}
/*
*	Check the code for deleting an element from a binary tree. Basically its equivalent to swapping that node with the last node of the tree
* and deleting that last node.
*/

public int findNumOfLeafNodes(Node root){
	Queue<Node> myQueue = new LinkedList<Node>();
	if(root == null){
		return;
	}
	myQueue.offer(root);
	int leafCount = 0;
	while(!myQueue.isEmpty()){
		Node temp = myQueue.poll();
		if(temp.left == null && temp.right == null){
			count++;
		}
		
		if(temp.left != null){
			myQueue.offer(temp.left);
		}
		
		if(!temp.right != null){
			myQueue.offer(temp.right);
		}	
	}
	return count;
}


/*
*	Structurally identical trees are the trees that have only the same structure but the content of the tree might be different.
*	Identical trees are same both in terms 
*/

public boolean areStructurallyIdenticalTrees(Node root1 , Node root2){
	if(root1 == null && root2 == null)
		return true; // If both are null return true
	if(root1 == null || root1 ==  null)
		return false; // In case just one of them is null then the two trees are not structurally identical.
	return isStructurallyIdenticalTree(root1.left , root2.left) && isStructurallyIdenticalTree(root1.right , root2.right);
}

public boolean areIdenticalTrees(Node root1 , Node root2){
	if(root1 == null && root2 == null)
		return true; // If both are null return true
	if(root1 == null || root1 ==  null)
		return false; // In case just one of them is null then the two trees are not structurally identical.
	return ( root1.data == root2.data && isStructurallyIdenticalTree(root1.left , root2.left) && isStructurallyIdenticalTree(root1.right , root2.right) );
}

/*
*	Diameter of a binary tree is the mas of these three 1) Diameter of the left subtree 2) Diameter of the right subtree
*	3) The longest path b/w the leaf nodes passing through the root of the tree
*/

public int diameterOfTree(Node root){
	if(root == null)
		return 0;
	//The path through the root is determined by the height of the left and right subtree.
	//Add 3 because height gives the path which is 1 less than the num of nodes. Thus 2 for left and right height and one more for the root node.
	int length1 = height(root.left) + height(root.right) + 3;
	
	//Path does not pass through the root
	int length2 = Math.max(diameterOfTree(root.left), diameterOfTree(root.right));	
	return Math.max(length1, length2);
}

//Height of binary tree
public int height(Node root){
	if(root == null)
		return -1;	
	return 1+ Math.max(height(root.left),height(root.right));
}

/*
*	Finding the level that has maximum sum in a binary tree
*/

public int findMaxSumAtAnyLevel(Node root){
	int currSum = 0, maxSum = 0;
	Queue<Node> myQueue = new LinkedList<Node>();
	
	if(root == null){
		return 0;
	}
	myQueue.offer(root);
	while(!myQueue.isEmpty()){
		Node temp = myQueue.poll();
		if(temp != null){
			if(temp.left!=null){
				myQueue.offer(temp.left);
			}
			if(temp.right!=null){
				myQueue.offer(temp.right);
			}
			
			currSum += temp.data;
		
		}else{
			if(currSum > maxSum){
				maxSum = currSum;
			}
			currSum = 0; // reset it for the next level
			if(!myQueue.isEmpty()){ // This step is important.
				myQueue.offer(null);
			}
		}	
	}
	return maxSum;
}

/*
*	Printing all paths from root to leaf in a Binary tree.
*	Use a path Array/ArrayList path[] to store current root to leaf path. Traverse from root to all leaves in top-down fashion. 
*	While traversing, store data of all nodes in current path in array path[]. When we reach a leaf node, print the path array
*/

public void printAllPathFromRootToLeaf(Node root){
	List<int> path = new ArrayList<int>();
	printPath(root , path);	
}

public void printPath(Node root , List<int> path){
	if(root == null){
		return;
	}
	path.add(root.data);
	if(root.left == null &&  root.right == null){
		printList(path);
	}
	else{
		printPath(root.left , path);
		printPath(root.right , path);
	}
}

public void printList(List<int> path){
	for(int data: path){
		System.out.print(data + " ");
	}
	System.out.println();
}

/*
*	Check the existance of a path with a given sum.
*	The idea is to subtract the current node data from the given sum before calling its children recursively 
*	to see if the sum is 0 when we reach the leat node
*/

public boolean hasPathWithAGivenSum(Node root, int sum){
	if(root == null){
		return false;
	}
	if(root.left == null && root.right == null && sum == root.data){
		return true;
	}
	else{
		return hasPathWithAGivenSum(root.left , sum - root.data) || hasPathWithAGivenSum(root.right , sum - root.data);
	}
}

/*
*	Finding the sum of all nodes of a binary tree.
*	This is recursive approach.
*	Can also be found using doing a level order traversal and add each element to the sum while taking out of queue.
*/

public int findSumOfAllNodes(Node root){
	if(root == null)
		return 0;
	else
		return  (root.data + findSumOfAllNodes(root.left) + findSumOfAllNodes(root.right));

}

/*
*	Mirror of a binary tree.
*/

public void MirrorOfTree(Node root){
	if(root == null){
		return;
	}
	MirrorOfTree(root.left);
	MirrorOfTree(root.right);
	Node temp = root.left;
	root.left = root.right;
	root.right = temp;
}

/*
*	Check if two trees are mirror of one another.	
*/

public boolean isMirrorOfOther(Node root1 , node root2){
	if(root1 == null && root2 == null){
		return true;
	}	
	if(root1 == null || root2 == null){
		return false;
	}	
	if(root1.data != root2.data){
		return false;
	}	
	return isMirrorOfOther(root1.left,root2.right) && isMirrorOfOther(root1.right,root2.left);
	
	/* The last two conditions can also be written as
	return (root1.data == root2.data) && isMirrorOfOther(root1.left,root2.right) && isMirrorOfOther(root1.right,root2.left);*/
}

/*
*	Build binary tree given its Inorder and Preorder traversals.
* 	For Algorithm refer karumamnchi Page 155.
*	The idea is - The first element in PreOrder array is the root of the tree. Find this element in the inorder array and it divides the nodes into
*	left and right subtree.Recursively repeat the process for the left and right children.
*/

public Node buildBinaryTree(int[] preOrder , int[] inOrder){
	if(preOrder.length == 0 || preOrder.length != inOrder.length){
		return false;
	}
	return buildTree(preOrder , 0 , preOrder.length-1 , inOrder , 0 , inOrder.length-1);
}

public Node buildTree(int[] preOrder, int preStart, int preEnd , int[] inOrder , int inStart, int inEnd){
	if(preStart > preEnd || inStart > inEnd){
		return;
	}
	
	int data = preOrder[preStart]; // This is the root element of the tree.
	Node newNode = new Node(data);
	
	int offset = inStart;
	
	// Find the position of the root elemnet in the inOrder array.
	for(;offset < inEnd ; offset++){
		if(inOrder[offset] == data){
			break;
		}
	}
	/*
	* 	Offset gives the position the root element in the inOrder array.  
	*	offset - inStart = number of nodes in left subtree.
	*/
	
	newNode.left = buildTree(preOrder, preStart + 1, preStart + offset - inStart , inOrder , inStart, offset-1); // Call the function for the left subtree.
	newNode.right = buildTree(preOrder, preStart + offset - inStart + 1, preEnd , inOrder , offset + 1 , inEnd); // Call the function for the right subtree.
	
	return newNode;
}

/*
*	Print the ancestors of a given node
*/

public boolean printAncestors(Node root , Node target){
	if(root == null){
		return false;
	}
	if(root.data == target.data){
		retutn true;
	}
	if(	printAncestors(root.left , target) || printAncestors(root.right , target)){
		System.out.println(root.data);
		return true;
	}
	return false;	
}

/*
*	Find the least common ancestors of a two given nodes
*/

public Node FindLCA(Node root , Node a , Node b){
	

}

/*
*	Do a level order traversal in a Graph.
*
*/

public boolean searchPathInGraph(Graph g, Node start , Node end){
	if(start == end) return true;
	
	
	if(start == null || end == null){
		return false;
	}
	
	//For BFS use queue
	Queue myQueue = new LinkedList<Node>();
	myQueue.offer(start);
	
	/*
	* For DFS just use stack
	* Stack<Node> myStack = new Stack<Node>(); 
	*/
	
	while(!myQueue.empty()){
		Node curr = myQueue.poll();
		for(Node v: curr.neighbours()){
			if(v.state != "visited"){
				myQueue.offer(v);
			}
		}
		if(curr == end){
			return true;
		}
	}
	return false;
}

/*
* Given a sorted array(increasing) with unique integer elements , write an algorithm to find binary tree of minimum height.
*/

public TreeNode createMinimalBST(int array[]){
	return createMinimalBST(array,0,array.length-1);
}

TreeNode createMinimalBST(int[] arr , start , end){
	if(start > end) return null;
	
	int mid = (start + end)/2;
	
	TreeNode root = new TreeNode(arr[mid]);
	root.left = createMinimalBST(arr,0 , mid -1);
	root.right = createMinimalBST(arr , mid+1 , end);
	
	return root;
}
