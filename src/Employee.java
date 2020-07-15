import java.io.IOException;
import java.util.Scanner;

public class Employee {
	static Scanner sc = new Scanner(System.in); 
    static Store s = new Store();
    static Stock a = new Stock();
    static Analysis_graphs g = new Analysis_graphs();
    static Customer_rq cr = new Customer_rq();
    static String p = "12345678";
    
    public static void Print() throws IOException {
    	System.out.println();
    	System.out.println("****Welcome****");
        System.out.println();
        System.out.println("Please enter the Password : ");
        String p1 = sc.nextLine();
        if(p1.equals(p)) {
        	options();
        }
        else {
        	String n;
            do {
            	System.out.println();
            	System.out.println("1. To re-enter.");
            	System.out.println("2. Main Page");
            	System.out.println("3. Exit");
            	n = sc.nextLine();
            	switch(n) {
            	
            	case "1" : Print();
            	           break;
            	           
            	case "2" : StockManagement sb = new StockManagement();
            	           sb.print();
            	           break;
            	           
            	case "3" : System.out.println(); 
            			   System.out.println("Thank you for coming.Visit again soon.");    
                           System.exit(0);
                 
            	default : System.out.println("The number you entered is incorrect.Please try again.");
                          break;
            	}
            }while(n!="1" && n!="2" && n!="3");       		
        }
}
    static void options() throws IOException{
    	String n;
    	do {
    		System.out.println();
    		System.out.println("Enter your choice : ");
    		System.out.println("1. Stock Data");
    		System.out.println("2. Sales Analysis (Graphs)");
    		System.out.println("3. Updation and Out Of Stock");
    		System.out.println("4. Customer Requests");
    		System.out.println("5. Main Page");
    		System.out.println("6. Exit");
    		n = sc.nextLine();
    		switch(n) {
    		
    		case "1" :  a.view();
						break;
            			
    			
       		case "2" : g.ask();	
       				
       				   break;
       				   //System.out.println("Thank you for coming.Visit again soon.");    
       				   // System.exit(0);
	    	         
       		case "3" : s.ask();
       				   break;
       				   
       		case "4" : { 
       					cr.ask();
       					System.out.println();
       					break;
		          		}

       		case "5" : StockManagement sb = new StockManagement();
       				   sb.print();
       				   break;
       				   
       		case "6" : System.out.println();
       				   System.out.println("Thank you for coming");
       				   System.exit(0); 
       				   break;
       				   
    		 default : System.out.println("Enter a valid input.");
                       break;         
    		}
    	}while(n!="1" && n!="2" && n!="3" && n!="4" && n!="5" && n!="6");
    }
    
   static void call() throws IOException{
   	 String n;
   	 do {
   		 System.out.println();
   		 System.out.println("1. Proceed");
   		 System.out.println("2. Main page");
   		 System.out.println("3. Exit");
   		 n = sc.nextLine();
   		 switch(n) {
   		 case "1" : Print();
   		            break;
   		
   		 case "2" : StockManagement sb = new StockManagement();
   		            sb.print();
   		            break;
   		            
   		 case "3" : System.out.println();
   			        System.out.println("Thank you for coming.Visit again .");    
                    System.exit(0);
            
   		 default : System.out.println("The number you entered is incorrect.Please try again.");
                   break; 
   		 }
   	 }while(!(n.equals("1"))&&!(n.equals("2"))&&!(n.equals("3")));
   	 String e = sc.nextLine();
    }
	
}           