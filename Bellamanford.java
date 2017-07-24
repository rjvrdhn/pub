import java.util.ArrayList;

// one class needs to have a main() method
public class HelloWorld
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    Graph myGraph = new Graph(5, 5);
   // System.out.print(myGraph);
  }
}

public class Edge
{
  private int source, destination, distance;
  
  public Edge() 
  {
    source =0;
    destination=0;
    distance=0;
  }
  
  public void SetSource(int src)
  {
    source = src;
  }
  public int GetSource()
  {
    return source;
  }
  public void SetDestination(int dest)
  {
    destination = dest;
  }
  public int GetDestination()
  {
    return destination;
  }
  public void SetDistance(int dist)
  {
    distance = dist;
  }
  public int GetDistance()
  {
    return distance;
  }
}


public class Graph
{
  private ArrayList<Edge> edges;
  private int V;
  private int E;
  public Graph(int nOfV, int nOfE)
  {
    V = nOfV;
    E = nOfE;
    edges = new ArrayList<Edge>(nOfE);
  }
  public int GetNumberOfVertices()
  {
    return V;
  }
  public ArrayList<Edge> GetEdges()
  {
    return edges;
  }
  public void SetEdge(int index, Edge newEdge)
  {
    edges.set(index, newEdge);
  }
}

public class Bellmanford
{
  private Graph myGraph;
  private int[] distances;
  private Initialize(int nOfV)
  {
    for(int i = 0; i<nOfV; i++)
    {
      distances[i] = 0;
    }
  }
  public Bellmanford()
  {
    // Read input from commandline and construct Graph
  }
  public void Run()
  {
    // Algorithm goes here
  }
  public void Display()
  {
    // Display results from here
  }
  public boolean DetectNegativeLoops()
  {
    boolean retValue = false;
    
    return retValue;
  }
}
