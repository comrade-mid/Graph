import java.io.*;
import java.util.Scanner;

public class PathGen{
	
	public static void main(String[] args) throws IOException {
		
		Scanner in = null;//in, line, token arrays used for file content.
		PrintWriter out1 = new PrintWriter(new File(args[1]+".txt")); //Destination file for processed data..
		String line = null;
		String[] conFile = new String[100]; //Content of file
		String[] token = null;
		int n, silk, lineNumber = 0, i = 0, z=0;
		
		if(args.length < 2){
			System.out.println("Usage: Search <input file> <target1>...<>");
			System.exit(1);
		}
		
		//An array used to store arg[i+1] arguments for later search.
		String[] track = new String[args.length - 1];

		in = new Scanner(new File(args[0]));
	
	

		for(z = 0; z<args.length-1; z++){
			track[z] = args[z+1];
		}

//Tokenizes content from file.
		while(in.hasNextLine() ){
			line = in.nextLine().trim() + " ";
			token = line.split("\\s");
			n = token.length;
			for(i = 0; i<n; i++) conFile[lineNumber++] = token[i];     
		}
	
		in.close();//Closes file.
		
		//Given format that first line is the order of the Graph.
		Graph G = new Graph(Integer.valueOf(conFile[0]));
		
		// Loop to add non-directed edges to the graph. 
		//Leaves after.
		for(i=1;i<lineNumber;i+=2){
			if(Integer.valueOf(conFile[i]) != 0){
				G.addEdge(Integer.valueOf(conFile[i]),Integer.valueOf(conFile[i+1]));
			} else {
				break;
			}
		}
		
		//These help to generate and output data as necessary for each successive BFS order needed.
		List H = new List();
		String help2 = "";
		out1.println(G);
		
		
		//For-loop to loop for each shortest path + formatting for output file. Plus linear deletion methods.
		for(i+=2;i<lineNumber;i=i+2){
			if(Integer.valueOf(conFile[i]) != 0){
				G.BFS(Integer.valueOf(conFile[i]));
				G.getPath(H, Integer.valueOf(conFile[i+1]));
				
				help2 = help2 + "The distance from ";
				help2 = help2 + conFile[i] + " to " + conFile[i+1] + " is " + G.getDist(Integer.valueOf(conFile[i+1]));
				help2 = help2 + "\nA shortest " + conFile[i] + "-" + conFile[i+1] + " path is: ";
				
				
				out1.print(help2);
				out1.print(" "+H);
				while(H.length() > 0){
					H.moveFront();
					H.deleteFront();
				}
				help2 = "\n \n";
			} else {
				break;
			}
		}
		
		out1.close();
	}
	
}
