import java.io.*;
import java.util.Scanner;

public class GraphTest{
	
	
	public static void main(String[] args) 
	{
		Graph G = new Graph(6);
		
		G.addEdge(1,2);
		G.addEdge(1,3);
		G.addEdge(2,1);
		G.addEdge(2,4);
		G.addEdge(2,5);
		G.addEdge(2,6);
		G.addEdge(3,1);
		G.addEdge(3,4);
		G.addEdge(4,2);
		G.addEdge(4,3);
		G.addEdge(4,5);
		G.addEdge(5,2);
		G.addEdge(5,4);
		G.addEdge(5,6);
		G.addEdge(6,2);
		G.addEdge(6,5);
		
		
		G.BFS(6);
		
	
		
		for(int i=0;i<6;i++){
			System.out.println("Node #"+(i+1));
			System.out.println("The node's parent is..." + G.getParent(i+1));
			System.out.println("The node's distant from the source is... " + G.getDist(i+1));
			
		}
		
	}
	
	
}