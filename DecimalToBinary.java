import java.util.Scanner;

public class DecimalToBinary 
{
	
	public String decimalToBinary(String in)
	{
		String bin = "";
		StringBuilder sb = new StringBuilder();
		try
		{
			int num = Integer.parseInt(in);
			while(num>0)
			{
				bin = bin + num%2;
				num = num/2;
			}
		}
		catch(Exception e)
		{
			System.out.print("error\n");
		}
		
		if(!bin.isEmpty())
		{
			sb.append(bin);
			sb.reverse();
			bin = sb.toString();
		}
		return bin;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		String in;
		String bin;
		Scanner sc = new Scanner(System.in);
		DecimalToBinary db = new DecimalToBinary();
		while(true)
		{
			System.out.print("Please enter a number or e to exit: ");
			in = sc.next();
			if(in.equals("e"))
				break;
			bin = db.decimalToBinary(in);
			System.out.print("Result: "+bin+"\n");
		}

	}

}
