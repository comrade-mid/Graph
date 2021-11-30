import java.io.*;
import java.util.Scanner;

public class GraphTest{
	
	
	public static void main(String[] args) 
	{
		Graph G = new Graph(6);
		
		G.addEdge(1,2);
		G.addEdge(1,3);
		G.addEdge(2,4);
		G.addEdge(2,5);
		G.addEdge(2,6);
		G.addEdge(3,4);
		G.addEdge(4,5);
		G.addEdge(5,6);
		
		
		G.BFS(5);
		
		for(int i=1;i<7;i++){
			System.out.println("Node #"+i);
			
				System.out.print("The node's parent is... #"+G.getParent(i)+"\n");
				System.out.print("The node's distance to source is... #"+G.getDist(i));
			
			System.out.print("\n");
		}
		
		System.out.println("\n \n");
		G.BFS(3);
		
		for(int i=1;i<7;i++){
			System.out.println("Node #"+i);
			
				System.out.print("The node's parent is... #"+G.getParent(i)+"\n");
				System.out.print("The node's distance to source is... #"+G.getDist(i));
			
			System.out.print("\n");
		}
		
		
		
		System.out.print(G);
		
		List Test = new List();
		System.out.println("Here's the current status of Test " + Test);
		G.getPath(Test, 1);
		
		System.out.println("Here's the current status of Test " + Test);
		
	}
	
	
}
