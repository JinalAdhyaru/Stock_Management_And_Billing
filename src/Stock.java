import java.io.IOException;
import java.util.Scanner;

public class Stock {
	static Scanner scan = new Scanner(System.in);
	static Product p = new Product();
	static String s;
	static String a1;
	
	static void view() throws IOException{
		p.Table();
		System.out.println();
		System.out.println("Would you like to search a category(Y/N) : ");
		do {
		s = scan.nextLine();
		if(s.equals("Y") || s.equals("y"))
			search();
		else if(s.equals("N") || s.equals("n"))
			ask();
		else
			System.out.println("Would you like to search a category(Y/N) : ");
		}while((!(s.equals("Y"))) && (!(s.equals("y"))) && (!(s.equals("N"))) && (!(s.equals("n"))));
	}

static void search() throws IOException{
	
	//System.out.println("Would you like to search a category(Y/N) : ");
	//s = scan.nextLine();
	    System.out.println(); 
		System.out.println("Enter category : ");
		String a = scan.nextLine();
		if(a.equals("Dental"))
			a1 = "   Dental  ";
		else if(a.equals("Bathing"))
			a1 = "  Bathing  ";
		else if(a.equals("Utilities"))
			a1 = " Utilities ";
		else if(a.equals("Dairy"))
			a1 = "   Dairy   ";
		else if(a.equals("Fruits"))
			a1 = "   Fruits  ";
		else if(a.equals("Vegetables"))
			a1 = " Vegetables";
		else if(a.equals("Kitchenware")) 
			a1 = "Kitchenware";
		else {
			System.out.println("Enter valid category ");
			search();
		}
		System.out.println("    ****" + a1 + "****");
		p.validate_id(a1);	
		ask();
	
	 
	}


static void ask() throws IOException{
	String n;
	do {
		System.out.println();
		System.out.println("Select:");
		System.out.println("1. Menu");
		System.out.println("2. Exit");
		n = scan.nextLine();
		switch(n) 
		{
		case "1" : Employee e = new Employee();
		           e.options();
		           break;
		case "2" : System.out.println();
			       System.out.println("Thank you for visiting.");
		           System.exit(0);
		default  : System.out.println("Please enter a valid input : ");
		           break;
		}
	}while(!(n.equals("1"))&&!(n.equals("2")));	
}
}