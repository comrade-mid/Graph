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
	
	int getParent(int u){
		
		if(u < 1 || u > order){
			System.out.println("Unit is not within graph. Please choose a correct node."); 
			return -1;
		} else {
			return src.parent[u];
		}
	}		// Pre: 1<=u<=n=getOrder(G) 
	
	
	int getDist(int u){
		
		if(u < 1 || u > order) {
			System.out.println("Unit is not within graph. Please choose a correct node.");
			return -1;
		} else {
			return src.dist[u];
		}
	}// Pre: 1<=u<=n=getOrder(G)

	/*	
	int getFinish(Graph G, int u); // Pre: 1<=u<=n=getOrder(G)
	*/
	
	
	// Manipulation procedures //
	
	
	void addEdge(int v, int u){//Undirected Graph
		int n = order;
		if(u > 0 && u <= n && v > 0 && v <= n){
			src.Vert[v].prepend(u);
		}
	}//Pre: 1<=u<=n, 1<=v<=n 
	
	
	
	void clear(){
		for(int i=0;i<=order;i++){
			src.Vert[i].clear();
			src.color[i] = -1;
			src.dist[i] = -1;
			src.parent[i] = -1;
		}
		
	}
	
	void BFS(int s){
		
		int[] check = new int[3]; 
		List L = new List();
		last_src = s;
		if(s > order || s < 1){
			System.out.println("\n Input can't be greater or less than the order...");
		} else {
			
			L.prepend(s);
			src.dist[s] = 0;
			src.parent[s] = -1;
			src.color[s] = 1;
			
			
			
			while(L.length() !=0){
				check[0] = L.get();
				L.deleteFront();
				L.moveFront();
				src.color[check[0]] = 1;
				src.Vert[check[0]].moveFront();
				for(check[1]=0;check[1] < src.Vert[check[0]].length() ;check[1]++){
					
					check[2] = src.Vert[check[0]].get();
					src.Vert[check[0]].moveNext();
					
					if(src.color[check[2]] < 0){
						if(src.parent[check[2]] < 0) src.parent[check[2]] = check[0];
						src.color[check[2]] = 0;
						
						if(src.dist[check[2]] < 0){
							if(src.parent[check[2]] == s) src.dist[check[2]] = 1;
							else src.dist[check[2]] = src.dist[src.parent[check[2]]] + 1;
						}
						if(src.color[check[2]] != 1) L.append(check[2]);
					}
				}
			}
		}
	}
	
/*
	public String toString(){
    	StringBuffer sb = new StringBuffer();
    	GraphObj N = src;
		int L=0;
		int M=0;
        for(M=0;M<order;M++){
			sb.append(M+":");
			N.Vert[M].moveFront();
			for(L=0;L<N.Vert[L].length();L++){
				sb.append(" ").append(N.Vert[L].get()+" ");
				N.Vert[L].moveNext();
			}
		}
    	return new String(sb);
    }
*/
}
