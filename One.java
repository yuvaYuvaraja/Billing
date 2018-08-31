import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

interface BillFunctions				//Used interface to implement common function
{
	void deleteItem(int a);
	void edit(int a);
	void view();
	
}

public abstract class One implements BillFunctions{		
	int n = 10,total;
	public static String storeName;
	public static long contactNo;
	 ArrayList<Integer> itemCode = new ArrayList<Integer>(n); 
	 ArrayList<Integer> quantity = new ArrayList<Integer>(n);
	 ArrayList<Float> price = new ArrayList<Float>(n);
	 ArrayList<String> itemName = new ArrayList<String>();
	 public abstract void setData();
}

class Bill extends One			//Extented a abstract class and defined all functions
{
	private Scanner sn;
	public void setData()
	{
		System.out.println("Enter Code ,Name ,Price ,Quantity of the product");
		sn = new Scanner(System.in);
		try{								//Used inputmismatchException
			int a = sn.nextInt();
		String s = sn.next();	
		float c = sn.nextFloat();
		int b = sn.nextInt();
		itemCode.add(a);
		quantity.add(b);
		price.add(c);
		itemName.add(s);
		}
		catch(InputMismatchException exception){
			System.out.println(exception);
		}
	}
	public void deleteItem(int code)
	{
		int c = itemCode.indexOf(code);
		itemCode.remove(c);
		quantity.remove(c);
		price.remove(c);
		itemName.remove(c);
	}
	public void edit(int code)
	{
		int c = itemCode.indexOf(code);
		System.out.println("Enter  which to edit\n1.Code\t2.Quantity\t3.Price\t4.Name ");
		int a ;
		a=sn.nextInt();
		switch(a)
		{
		case 1 :int w;w=sn.nextInt();
				itemCode.set(c, w);
				break;
		case 2 :int e;e=sn.nextInt();
				quantity.set(c, e);
				break;
		case 3 :float r;r=sn.nextFloat();
				price.set(c, r);
				break;
		case 4 :String s;s=sn.next();
				itemName.set(c, s);
				break;
		default : System.out.println("INVALID");
		}
	}
	void putData()
	{
		for(int i=0;i<itemName.size();i++)
		System.out.println(i+1 + "\t"+itemCode.get(i)+"\t"+itemName.get(i)+"\t"+price.get(i)+"\t"+ quantity.get(i) );
	}
	public void view()					//Used Date and Time ie Used composition
	{
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date();
		System.out.println("          "+storeName+"\n"+formatter.format(date)+"\n-----------------------------------------"
				+ "\nS.No\tCode\tItem\tPrice\tQuantity\n-----------------------------------------");
		total = 0;
		  
		putData();
		for(int i=0;i<price.size();i++)
		{
			total += price.get(i) * quantity.get(i);
		}		
		System.out.println("-----------------------------------------\n\t    Payable Amount " + total+"\nContact no:"+contactNo);
	}	
}