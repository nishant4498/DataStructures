/**
 * 
 */
package graphs;

/**
 * @author Nishu
 * Implementation  of an "UNDIRECTED" Graph using adjacency matrix
 */
public class AdjacencyMatrix {
	
	private int vertexCount;
	private boolean adjMatrix[][];
	
	public AdjacencyMatrix(int vertexCount) {		
		this.vertexCount = vertexCount;
		adjMatrix = new boolean[vertexCount][vertexCount];
	}	
	
	public void addEdge(int i, int j){
		if((i >= 0 && i < vertexCount) && (j>= 0 && j < vertexCount) )
		{			
			adjMatrix[i][j] = true;
			adjMatrix[j][i] = false;
		}
		
	}
	
	public void removeEdge(int i, int j){
		if ((i >= 0 && i < vertexCount) && (j >= 0 && j <vertexCount))
		{
			adjMatrix[i][j] = false;
			adjMatrix[j][i] = false;
		}
	}
	
	public boolean isEdge(int i, int j){
		
		boolean result = false;
		if ((i >= 0 && i < vertexCount) && (j >= 0 && j <vertexCount))
		{
			result = adjMatrix[i][j];
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Java!!I am back.");

	}

}
