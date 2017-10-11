import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BST 
{	
	private int value;
	private BST lNode;
	private BST rNode;
	
	public int getValue() 
	{
		return value;
	}

	public void setValue(int value) 
	{
		this.value = value;
	}

	public BST getlNode() 
	{
		return lNode;
	}

	public void setlNode(BST lNode)
	{
		this.lNode = lNode;
	}

	public BST getrNode() 
	{
		return rNode;
	}

	public void setrNode(BST rNode) 
	{
		this.rNode = rNode;
	}

	public void insert(BST hNode, BST iNode)
	{
		if(iNode.getValue() <= hNode.getValue())
		{
			//insert on left side of the tree
			if(hNode.getlNode() == null)
			{
				hNode.setlNode(iNode);
			}
			else
			{
				insert(hNode.getlNode(), iNode);
			}
		}
		else
		{
			//insert to the right of the tree
			if(hNode.getrNode() == null)
			{
				hNode.setrNode(iNode);
			}
			else
			{
				insert(hNode.getrNode(), iNode);
			}
		}
		
	}
	
	public boolean find(int n)
	{
		boolean retVal = false;
		
		return retVal;
	}
	
	public void BFT(BST hNode)
	{
		Queue<BST> tracker = new LinkedList<BST>(); 
		tracker.add(hNode);
		while(!tracker.isEmpty())
		{
			BST cN = tracker.remove();
			System.out.print(" "+cN.getValue());
			if(cN.getlNode() != null)
				tracker.add(cN.getlNode());
			if(cN.getrNode() != null)
				tracker.add(cN.getrNode());
		}
	}

	
	public void DFT(BST hNode)
	{
		if(hNode == null)
			return;
		//in order traversal
		DFT(hNode.getlNode());
		System.out.print(" "+ hNode.getValue());
		DFT(hNode.getrNode());
		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST hNode = new BST();
		hNode.setValue(Integer.MIN_VALUE);
		hNode.setlNode(null);
		hNode.setrNode(null);
		Scanner sc = new Scanner(System.in);
		String input = "";
		while(true)
		{
			System.out.print("Enter number to insert or E to exit: ");
			input = sc.nextLine();
			
			if(input.equals("E"))
				break;
	
			try {
				int in = Integer.parseInt(input);

				if(hNode.getValue() == Integer.MIN_VALUE)
				{
					hNode.setValue(in);
				}
				else
				{
					BST iNode = new BST();
					iNode.setValue(in);
					iNode.setlNode(null);
					iNode.setrNode(null);
					
					hNode.insert(hNode, iNode);
				}
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.print("Input error \n");
				//e.printStackTrace();
			}
		}
		System.out.println("Bredth first travesal");
		hNode.BFT(hNode);
		System.out.println("\nDepth first traversal (in order)");
		hNode.DFT(hNode);
	}

}
