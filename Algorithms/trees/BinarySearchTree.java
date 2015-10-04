
public class BinarySearchTree {

	public BinarySearchTree() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Inserting nodes into a binary search tree.
	 */
	public BinaryTreeNode insertNode(BinaryTreeNode root , int data){
		
		if (root == null){
			root = new BinaryTreeNode(data);
		}
		
		else if (data <= root.getData()){
			root.setLeftNode(insertNode(root.getLeftNode() , data));
		}
		else{
			root.setRightNode(insertNode(root.getRightNode(), data));
		}
		
		return root;
	}
	
	public BinaryTreeNode deleteNode(BinaryTreeNode root , int data){
		
		BinaryTreeNode nodeToBeDeleted = searchNode(root, data);
		if (nodeToBeDeleted == null){
			System.out.println("Specified node could not be found in the tree!!");			
		}
		else{
			// TO DO -- Start writing code for deleting for all three conditions.
		}
		return nodeToBeDeleted;
	}
	
	private BinaryTreeNode searchNode(BinaryTreeNode root , int data){
		
		BinaryTreeNode currentNode = root;
		while(currentNode.getData() != data){			
			if(data < currentNode.getData()){
				currentNode = currentNode.getLeftNode();
			}
			else{
				currentNode = currentNode.getRightNode();				
			}
			
		}
		return currentNode;
	}
	
	public void PreOrder(BinaryTreeNode rootNode){		
		if(rootNode != null){
			System.out.println(rootNode.getData());
			PreOrder(rootNode.getLeftNode());
			PreOrder(rootNode.getRightNode());
		}
	}
	
	public void InOrder(BinaryTreeNode rootNode){
		if(rootNode != null){			
			InOrder(rootNode.getLeftNode());
			System.out.println(rootNode.getData());
			InOrder(rootNode.getRightNode());
		}
		
	}
	
	public void PostOrder(BinaryTreeNode rootNode){		
		if(rootNode != null){			
			PostOrder(rootNode.getLeftNode());
			PostOrder(rootNode.getRightNode());
			System.out.println(rootNode.getData());
		}
		
	}
	
	public static void main(String[] args){
		BinarySearchTree bst = new BinarySearchTree();
		BinaryTreeNode root = new BinaryTreeNode(10);
		bst.insertNode(root, 2);
		bst.insertNode(root, 7);
		bst.insertNode(root, 4);
		bst.insertNode(root, 8);
		bst.insertNode(root, 15);
		bst.insertNode(root, 20);
		bst.insertNode(root, 30);
		System.out.println("Inorder");
		bst.InOrder(root);
		System.out.println("Preorder");
		bst.PreOrder(root);
		System.out.println("Postorder");
		bst.PostOrder(root);		
		
	}

}
