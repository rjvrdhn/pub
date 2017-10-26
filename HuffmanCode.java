import java.util.Iterator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Scanner;

/**
 * 
 */


public class HuffmanCode {
    
    PriorityQueue<Node> tree = new PriorityQueue<>((n1, n2) -> (n1.posb < n2.posb) ? -1 : 1);
    TreeMap<String, String> hCodes = new TreeMap<>();
    
    public static class Node {
        String ch;
        int posb;
        Node left, right;
        
        Node()
        {
        	this.ch = "";
        	this.posb =0;
        	this.left = null;
        	this.right=null;
        }

        Node(String ch, int posb) {
            this.ch    = ch;
            this.posb  = posb;
            this.left  = null;
            this.right = null;
        }
        
        Node(Node n1, Node n2)
        {
        	this.posb = n1.posb + n2.posb;
            ch = n1.ch + n2.ch;
            if (n1.posb < n2.posb) {
                this.right = n2;
                this.left = n1;
            } else {
                this.right = n1;
                this.left = n2;
            }
        }

        boolean isLeaf() {
            return (left == null) && (right == null);
        }

    }
    
    public boolean isOutOfPossibilityBound()
    {
    	boolean retVal = false;
    	
    	int tPosb = 0;
    	
    	Iterator<Node> iter = tree.iterator();
    	while (iter.hasNext()) {
    	    Node current = iter.next();
    	    tPosb = tPosb+current.posb;
    	}
    	if(tPosb>100)
    		retVal = true;
    	
    	return retVal;
    }
    

    public void buildHuffmanTree()
    {
    	while (tree.size() > 1)
    	{
    		Node n = new Node(tree.poll(), tree.poll());
            tree.add(n);
    	}
    }
    
    public void createHuffmanCodes(Node n1, String code)
    {
    	if(n1 == null)
    		return;
    	
    	// At this point all leaf nodes should be our character 
    	if(n1.isLeaf())
    	{
    		hCodes.put(n1.ch, code);
    	}
    	else {
    		if(n1.right != null)
        	{
        		code = code+"1";
        		createHuffmanCodes(n1.right, code);
        	}
        	
        	if(n1.left != null)
        	{
        		code = code+"0";
        		createHuffmanCodes(n1.left, code);
        	}
    	}
    	
    }
    
    public void display()
    {
    	for(Entry<String, String> entry : hCodes.entrySet()) {
    		  String ch = entry.getKey();
    		  String code = entry.getValue();

    		  System.out.println(ch + " => " + code);
    	}
    }
    
    public static void main(String[] args) {
    	int nOfC = -1;
    	boolean reachedTotalPossibility = false;
    	Scanner sc = new Scanner(System.in);
    	
    	HuffmanCode hc = new HuffmanCode();
    	
    	try {
    		
    		System.out.print("Enter number of codes: ");
    		nOfC = sc.nextInt();
    	}
    	catch (Exception e)
    	{
    		System.out.print("Input Error!\n");
    	}
    	
    	if(nOfC>0)
    	{
    		int tEntries = 0;
    		while(true)
    		{
    			System.out.print("Enter a character and possibility: ");
    			try {
    				String str = sc.next();
    				String cha = ""+str.charAt(0);
    				int possibility = sc.nextInt();
    				hc.tree.add(new HuffmanCode.Node(cha, possibility));
    				tEntries++;
    				if(hc.isOutOfPossibilityBound())
    				{
    					reachedTotalPossibility = true;
    					System.out.println("Total possibility can not be more than 100, qutting!");
    					break;
    				}
    				if(tEntries == nOfC)
    					break;
    			}
    			catch(Exception e)
    			{
    				System.out.print("Invalid input! \n");
    			}
    		}
    		
    		
    		if(!reachedTotalPossibility)
    		{
    			hc.buildHuffmanTree();
    	    	hc.createHuffmanCodes(hc.tree.peek(), "");
    	    	hc.display();
    		}
    		
    		
    	}
    	else
    	{
    		System.out.println("Number of codes can not be lessthan or equal to 0");
    	}
    	
    	
    
//    	HuffmanCode.Node n1 = new HuffmanCode.Node("a", 32);
//    	HuffmanCode.Node n2 = new HuffmanCode.Node("b", 21);
//    	HuffmanCode.Node n3 = new HuffmanCode.Node("c", 1);
//    	HuffmanCode.Node n4 = new HuffmanCode.Node("d", 9);
//    	HuffmanCode.Node n5 = new HuffmanCode.Node("e", 8);
//    	
//    	hc.tree.add(n1);
//    	hc.tree.add(n2);
//    	hc.tree.add(n3);
//    	hc.tree.add(n4);
//    	hc.tree.add(n5);
//    	
//    	hc.buildHuffmanTree();
//    	hc.createHuffmanCodes(hc.tree.peek(), "");
//    	hc.display();
    	
    	return;
        
    }

}
