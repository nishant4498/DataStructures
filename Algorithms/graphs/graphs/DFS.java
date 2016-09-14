/**
 * 
 */
package graphs;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Nishu
 *
 */
public class DFS {

	/**
	 * 
	 */
	
	private void dfs(Graph g, int v, boolean[] visited){
		Vertex[] adjLists = g.adjLists;
		visited[v] = true;
		System.out.println("visiting:" + adjLists[v].name);
		for (Neighbor nbr = adjLists[v].adjList ; nbr!= null; nbr = nbr.next ){
			if (!visited[nbr.vertexNum]){
				System.out.println(adjLists[v].name+ "-------" + adjLists[nbr.vertexNum].name);
				dfs(g, nbr.vertexNum, visited);
			}		
		}	
	}
	
	public  DFS(Graph g){
		Vertex[] adjLists = g.adjLists;
		// Creating a boolean array initializes all values to "false" by default.
		boolean[] visited = new boolean[adjLists.length];
		for (int v =0 ; v < visited.length; v++){		
			if(!visited[v]){
				System.out.println("STARTING AT  " + adjLists[v].name);
				dfs(g, v, visited);
			}
		}
	}
	
	public void print()
	{
		
	}
	
	public static void main (String args[]) throws FileNotFoundException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the input file name with graph vertices and edges:");
		//D:\workspace\git\DataStructures\Algorithms\graphs\graphs\GraphInput.txt
		String fileName = sc.next();
		sc.close();
		Graph g = new Graph(fileName);
		DFS d = new DFS(g);
		g.print();
		d.print();
	}

}
