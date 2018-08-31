import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

	static Scanner sn;
	public static void main(String[] args) {
		int choice,x;
		sn = new Scanner(System.in);
		System.out.println("Welcome to instant Bill counter\n\nEnter your store name and Contact number\n");
		Bill b=new Bill();
		try{
		One.storeName=sn.nextLine();
		One.contactNo=sn.nextLong();
		}
		catch(InputMismatchException exception){
			System.out.println(exception);
		}
		while(true){
			System.out.println("1.Add item\t2.View\t3.Edit\t4.Delete item\t5.Print\nEnter your choice");
			choice = sn.nextInt();
			switch(choice)
			{
			case 1 :b.setData();
					break;
			case 2 :b.view();
					break;
			case 3 :System.out.println("Enter the S.No to edit");
					x = sn.nextInt();
					b.edit(x);
					break;
			case 4 :System.out.println("Enter the S.No of item to be deleted");
					x = sn.nextInt();
					b.deleteItem(x);
					break;
			case 5 :b.view();
					System.exit(0);
			default : System.out.println("Default");
			}
		}
		
		
		
	}

}
