import java.util.LinkedList;
import java.util.Queue;

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
	
	/*
	 * void revertTree(Node root){
		if(root == null){
		return root;
		}
		
		Node temp = root.left;
		root.left = revertTree(root.right);
		root.right = revretTree(temp)
		
		}
	 * 
	 */
	
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
			System.out.print(rootNode.getData() + " ");
			PreOrder(rootNode.getLeftNode());
			PreOrder(rootNode.getRightNode());
		}
	}
	
	public void InOrder(BinaryTreeNode rootNode){
		if(rootNode != null){			
			InOrder(rootNode.getLeftNode());
			System.out.print(rootNode.getData() + " ");
			InOrder(rootNode.getRightNode());
		}
		
	}
	
	public void PostOrder(BinaryTreeNode rootNode){		
		if(rootNode != null){			
			PostOrder(rootNode.getLeftNode());
			PostOrder(rootNode.getRightNode());
			System.out.print(rootNode.getData() + " ");
		}
		
	}
	
	/*
	 * This function finds the height of a binary tree. Height of a binary tree is equal to the the number of edges 
	 * in the longest path from root to a leaf node.
	 * Height = max depth e.g for root = Height = H , depth =0 where H is the max depth or height.
	 */
	public int height(BinaryTreeNode rootNode){
		if(rootNode == null){
			//Height of a empty tree is considered to be -1.
			return -1;
		}
		
		// Height is equal to 1 + maximum of the height of the left and the right subtree.
		return 1+ Math.max(height(rootNode.getLeftNode()), height(rootNode.getRightNode()) );
	}
	
	public void levelOrderTraversal(BinaryTreeNode rootNode){
		Queue<BinaryTreeNode> nodeList = new LinkedList<BinaryTreeNode>();
		if(rootNode == null){
			return;
		}
		nodeList.offer(rootNode);
		while(!nodeList.isEmpty()){
			BinaryTreeNode temp = nodeList.poll();
			System.out.print(temp.getData() + " ");
			if(temp.getLeftNode() != null){
				nodeList.offer(temp.getLeftNode());
			}
			if(temp.getRightNode() != null){
				nodeList.offer(temp.getRightNode());
			}
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
		bst.insertNode(root, 40);
		bst.insertNode(root, 11);
		System.out.println("Inorder");
		bst.InOrder(root);
		System.out.println();
		System.out.println("Preorder");
		bst.PreOrder(root);
		System.out.println();
		System.out.println("Postorder");
		bst.PostOrder(root);
		
		int height = bst.height(root);
		System.out.println();
		System.out.println("Height of tree=" + height);
		
		System.out.println("Level Order Traversal");
		bst.levelOrderTraversal(root);
		
	}

}
