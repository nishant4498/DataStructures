package graphs;

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.Scanner;

public class Graph {
	Vertex[] adjLists;
	
	public Graph(String file) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(file));
		
		String graphType = sc.next();
	    boolean undirected = true;
		
		if(graphType.equals("directed")){
			undirected = false;
		}
		
		
		adjLists = new Vertex[sc.nextInt()];
		//read vertices
		
		for (int v =0; v < adjLists.length ; v++){
			adjLists[v] = new Vertex (sc.next(),null);			
		}
		
		//read edges
		
		while(sc.hasNext()){
			int v1 = indexForName(sc.next());
			int v2 = indexForName (sc.next());
			
			adjLists[v1].adjList = new Neighbor(v2, adjLists[v1].adjList);
			if (undirected){
				adjLists[v2].adjList = new Neighbor(v1, adjLists[v2].adjList); 			
			}
		
		}	
		
		sc.close();
		
	}
	
	int indexForName (String name){
			for (int v=0;v< adjLists.length; v++){
				if (adjLists[v].name.equals(name)){
					return v;
				}
			}
			return -1;
		}
	
	
	public void print(){
		System.out.println("\nPrinting the Graph in the adjacency List Representation");
		for(int v=0;v < adjLists.length; v++){
			System.out.println(adjLists[v].name);
			for (Neighbor nbr = adjLists[v].adjList;nbr!= null;nbr = nbr.next){
				System.out.println("---->" + adjLists[nbr.vertexNum].name);
			}
			System.out.println();
		}
	
	}

}