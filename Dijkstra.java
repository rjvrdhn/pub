import java.util.Scanner;


public class Dijkstra {

	int graph[][];
	int numOfVertices;
	int shortestPaths[];
	
	Dijkstra(int numOfVertices)
	{
		this.numOfVertices = numOfVertices;
		graph = new int[numOfVertices][numOfVertices];
		for(int i = 0; i<numOfVertices; i++)
			for(int j = 0; j < numOfVertices; j++)
				graph[i][j] = 0;
			
        shortestPaths = new int[this.numOfVertices];
        for(int i = 0; i<this.numOfVertices; i++)
        	shortestPaths[i] = Integer.MAX_VALUE;        
	}
	
	void display(int src)
	{
		char source = (char)((char)src + 'A');
		for(int i = 0; i < this.numOfVertices; i++)
		{
			char destination = (char)((char)i + 'A');
			String sp = "";
			if(shortestPaths[i] == Integer.MAX_VALUE)
				sp = "INF";
			else
				sp = ""+shortestPaths[i];
			System.out.println("From Source: "+ source + " to "+destination+" = "+sp);
		}
	}
	
	int nextClosestVertex(Boolean visited[])
	{
		int ncv = -1;
		int shortPath = Integer.MAX_VALUE;
		
		for(int i = 0; i < this.numOfVertices; i++)
		{
			if(visited[i] == false && shortestPaths[i] <= shortPath)
			{
				shortPath = shortestPaths[i];
				ncv = i;
			}
		}
		
		return ncv;
	}
	
	void caluculateShortestPaths(int src)
	{
		Boolean visited[] = new Boolean[this.numOfVertices];
		for (int i = 0; i<this.numOfVertices; i++)
			visited[i] = false;
		shortestPaths[src] = 0;
		
		for(int i = 0; i<this.numOfVertices-1; i++)
		{
			//find the next shortest distanced node
			int ncv = nextClosestVertex(visited);
			visited[ncv] = true;
			
			//Next update all distances to neighbor vertices
			for(int eachV = 0; eachV < this.numOfVertices; eachV++)
			{
				if(!visited[eachV] && graph[ncv][eachV] !=0 && shortestPaths[ncv]!= Integer.MAX_VALUE && 
						shortestPaths[ncv]+graph[ncv][eachV] < shortestPaths[eachV])
				{
					shortestPaths[eachV] = shortestPaths[ncv] + graph[ncv][eachV];
				}
			}
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices: ");
		try {
			N = sc.nextInt();
			Dijkstra dj = new Dijkstra(N);
			
			while(true)
			{
				System.out.print("Enter source(alphabet) destination(alphabet) and distance OR stop: ");
				String next = sc.next();
				if(next.equals("stop"))
					break;
				int src = next.toUpperCase().charAt(0) - 'A';
				next = sc.next();
				int dst = next.toUpperCase().charAt(0) - 'A';
				int distance = sc.nextInt();
				
				if(src >= N || dst >= N)
				{
					System.out.print("Input error \n");
				}
				else
				{
					dj.graph[src][dst] = distance;
				}
				
			}
			
			System.out.print("Enter source: ");
			String strSource = sc.next();
			int source = strSource.toUpperCase().charAt(0) - 'A';
			if(source >= N)
				System.out.println("Souce is not range of vertices");
			else
			{
				dj.caluculateShortestPaths(source);
				dj.display(source);
			}
		}
		catch (Exception e)
		{
			System.out.print("Input error \n");
		}
		
		
	}

}
