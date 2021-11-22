public class Graph extends List {
	private class GraphObj{
		List[] Vert;
		int[] parent;
		int[] dist;
		int[] color; // -1 (unvisited), 0 (neighbor), 1(self)
	
	
		GraphObj(int v){
			Vert = new List[v+1];
			parent = new int[v+1];
			dist = new int[v+1];
			color = new int[v+1];
			for(int i=0;i<=v;i++){
				Vert[i] = new List();
				parent[i] = -1;
				dist[i] = -1;
				color[i] = -1;
			}
			
			
		}
	}
	
	private GraphObj src;
	private int last_src;
	private int edges;
	private int order;
	
	
	public Graph(int v){
		src = new GraphObj(v);
		last_src = -1;
		order = v;
		edges = 0;
	}

	// Access functions //
	int getSize(Graph G) {return edges;}
	int getOrder(Graph G) {return order;}
	int getSource(Graph G) {return last_src;}
	/*
	int getDist(Graph G, int u){
		if(u > order || u < 1) return -1;
		if(last_src == -1) return -1;
	}// Pre: 1<=u<=n=getOrder(G)

		
	int getFinish(Graph G, int u); // Pre: 1<=u<=n=getOrder(G)
	*/
	
	
	// Manipulation procedures //
	
	
	void addEdge(int u, int v){//Undirected Graph
		int n = order;
		if(u > 0 && u <= n && v > 1 && v <= n){
			src.Vert[v].prepend(u);
		}
	}//Pre: 1<=u<=n, 1<=v<=n 
	
	void BFS(int s){
		int check1, check2, check3;
		int disto = 0;
		if(s > order || s < 1) System.out.println("\n Unit can't be greater or less than the order...");
		
		check1 = s;
		last_src = s;
		check3 = 0;
		
		
		while(check3 <= order){
			// Prior to loop(s) assign source vertex information.
			src.color[check1] = 1;
			if(check1 == s) src.parent[check1] = -1;
			else src.parent[check1] = 1;
			src.dist = disto++;
			
			// 
			while(src.Vert[check]){
				check2 = src.Vert[check1].get();
				src.color[check2] = 0;
				src.parent[check2] = check1;
				src.dist = disto;
				src.Vert[check1] = src.Vert[check1].moveNext();
			}
			
			check3++;
			disto++;
		}
	}
	
	
/*
	int getParent(Graph G, int u){
		if(u < 1 && G.getOrder() < 1) return -1;
		
		
	}		// Pre: 1<=u<=n=getOrder(G) 
	
*/

/*
	public String toString(){
    	StringBuffer sb = new StringBuffer();
    	GraphObj N = src;
		int L=0;
		int M=0;
        for(M=0;M<order;M++){
			N.neighbors[L].moveFront();
			for(L=0;L<order;L++){
				sb.append(N.neighbors[L].get()+" ").append("\n");
				N.neighbors[L].moveNext();
			}
		}
    	return new String(sb);
    }
*/

}