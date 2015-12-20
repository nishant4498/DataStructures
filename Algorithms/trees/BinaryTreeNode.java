public class BinaryTreeNode {
	private int data;
	private BinaryTreeNode leftNode;
	private BinaryTreeNode rightNode;
	/**
	 * 
	 */
	public BinaryTreeNode(int data) {
		this.data = data;
		this.leftNode = null;
		this.rightNode = null;
	}	

	public int getData(){
		return this.data;		
	}
	
	public BinaryTreeNode getLeftNode(){
		return this.leftNode;
	}
	
	public BinaryTreeNode getRightNode(){
		return this.rightNode;
	}
	
	public void setData(int data){
		this.data = data;		
	}
	
	public void setLeftNode(BinaryTreeNode lNode){
		this.leftNode = lNode;
	}
	
	public  void setRightNode(BinaryTreeNode rNode){
		this.rightNode = rNode;
	}

	@Override
	public String toString() {
		return "BinaryTreeNode [data=" + data + ", leftNode=" + leftNode + ", rightNode=" + rightNode + "]";
	}
	
	

}
