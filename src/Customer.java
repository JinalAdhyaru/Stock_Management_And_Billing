import java.io.IOException;
import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer{
	
	    static String s ; 
	    static int id;
	    static int n;
	    static Product c = new Product();
		private static String name;
		private static String phno;
		static int sno = 0;
	    static Scanner sc = new Scanner(System.in);
	    
	    public static void Details() {
	    	System.out.println();
	    	sno = c.bn();
	    	//System.out.println("Bill No.-" + sno);
	    	System.out.println("Enter your name :");
	    	name = sc.nextLine();
	    	System.out.println("Enter your Phone Number : ");
	    	String p = sc.nextLine();
	    	validate(p);
	    }
	    
	    static void validate(String s) {
			Pattern p = Pattern.compile("\\d{10}");
	    	Matcher m = p.matcher(s);
	    	if(m.matches()) {
	    		phno = s;
	    	}
	    	else {
	    		System.out.println("Please enter a valid Phone Number : ");
	    		phno = sc.nextLine();
	    		validate(phno);
	    	}
		}

	    /*static void input() {
			String a = sc.nextLine();
			set(a);
		}*/
	    
	    /*static void set(String s) {
	    	Pattern p = Pattern.compile("\\d{10}");
	    	Matcher m = p.matcher(s);
	    	if(m.matches())
	    		s = phno;
	    	else {
	            System.out.println("Please enter valid Phone Number : ");
	    		input();    		
	    	}
	    }*/
	    
	    static void Display() throws IOException{
	        String n;
	        do{
	        	System.out.println();
	            System.out.println("Select the item you would like to buy.");
	            System.out.println("1. Daily Uses");
	            System.out.println("2. Food");
	            System.out.println("3. Crockery");
	            //System.out.println("4. Go back to the main page.");
	            System.out.println("4. Exit ");
	            n = sc.nextLine();
	            System.out.println();
	            switch(n)
	            {
	                    case "1" : System.out.println("Welcome to the Daily Uses Section.");
	                               DailyUses();
	                               break;

	                    case "2" : System.out.println("Welcome to the Food Section.");
	                               Food(); 
	                               break;

	                    case "3" : System.out.println("Welcome to the Crockery Section.");
	                               Crockery(); 
	                               break;

	                    /*case "4" : StockManagement s = new StockManagement();
	                               s.print();
	                               break;*/

	                    case "4" : System.out.println();
	                    		   System.out.println("Thank you for coming.Visit again soon.");    
	                               System.exit(0);

	                    default : System.out.println("The number you entered is incorrect.Please try again.");
	                              break; 
	            } 
	        }while(!(n.equals("1"))&&!(n.equals("2"))&&!(n.equals("3"))&&!(n.equals("4")));
	        /*System.out.print(sc.nextLine());
	        System.out.println("Do you want ot continue(Y/N) ?");
	        n1 = sc.nextLine();
	        if(n1.equals("Y")||n1.equals("y"))
	            Display();
	        else
	            System.out.println("Thank you for coming.Visit again .");
	            System.exit(0);*/
	    }
	     static void ask() throws IOException{
	    	 String n;
	    	 do {
	    		 System.out.println();
	    		 System.out.println("1. Proceed");
	    		 System.out.println("2. Main page");
	    		 System.out.println("3. Exit");
	    		 n = sc.nextLine();
	    		 switch(n) {
	    		 
	    		 case "1" : Details();
	    			        Display();
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
	    	 }while(!(n.equals("1"))&&!(n.equals("2"))&&!(n.equals("3")));
	     }
		 static void DailyUses() throws IOException{
	        String n;
	        System.out.println();
	        do{
	            System.out.println("Select the item you would like to buy.");
	            System.out.println("1. Dental");
	            System.out.println("2. Bathing");
	            System.out.println("3. Utilities");
	            System.out.println("4. Menu");
	            System.out.println("5. Exit");
	            n = sc.nextLine();
	            switch(n)
	            {
	                    case "1" : Dental();
	                               break;

	                    case "2" : Bathing();
	                               break;

	                    case "3" : Utilities();
	                               break;

	                    case "4" : Display();
	                               break;
	                               
	                    case "5" : System.out.println();
	                    		   System.out.println("Thank you for coming.");
				                   System.exit(0);
				                   
	                    default : System.out.println("The number you entered is incorrect.Please try again.");
	                              break; 
	                    } 
	        }while(!(n.equals("1"))&&!(n.equals("2"))&&!(n.equals("3"))&&!(n.equals("4")));
	    }
		
		static void Food() throws IOException {
	    	String n;
	    	System.out.println();
	        do{
	        	System.out.println("Select the item you would like to buy.");
	            System.out.println("1. Dairy");
	            System.out.println("2. Fruits");
	            System.out.println("3. Vegetables");
	            System.out.println("4. Menu");
	            System.out.println("5. Exit");
	            n = sc.nextLine();
	            switch(n)
	            {
	                    case "1" : Dairy();
	                               break;

	                    case "2" : Fruits();
	                               break;

	                    case "3" : Vegetables();
	                               break;
	                    
	                    case "4" : Display();
	                               break;
	                    
	                    case "5" :  System.out.println();
	                    			System.out.println("Thank you for coming.");
		                            System.exit(0);
		                   
	                    default : System.out.println("The number you entered is incorrect.Please try again.");
	                              break; 
	            }
	        }while(!(n.equals("1"))&&!(n.equals("2"))&&!(n.equals("3"))&&!(n.equals("4")));

		}
		
		static void Dental() throws IOException{
			s = "   Dental  ";
			System.out.println();
			System.out.println("****DENTAL****");
			System.out.println();
			c.Table(s);
			show(s);
		}
		static void Bathing() throws IOException {
			s = "  Bathing  ";
			System.out.println();
			System.out.println("****BATHING****");
			System.out.println();
			c.Table(s);
			show(s);
		}
		static void Utilities() throws IOException {
			s = " Utilities ";
			System.out.println();
			System.out.println("****UTILITIES****");
			System.out.println();
			c.Table(s);
			show(s);
		}
		static void Dairy() throws IOException {
			s = "   Dairy   ";
			System.out.println();
			System.out.println("****DAIRY****");
			System.out.println();
			c.Table(s);
			show(s);
		}	
		static void Fruits() throws IOException {
			s = "   Fruits  ";
			System.out.println();
			System.out.println("****FRUITS****");
			System.out.println();
			c.Table(s);
			show(s);
		}
		static void Vegetables() throws IOException {
			s = " Vegetables";
			System.out.println();
			System.out.println("****VEGETABLES****");
			System.out.println();
			c.Table(s);
			show(s);
		}
	    static void Crockery() throws IOException {
			s = "Kitchenware";
			System.out.println();
			System.out.println("****KITCHENWARE****");
			System.out.println();
			c.Table(s);
			show(s);
		}
	    static void stocks(int i) {
	    	n = sc.nextInt();
	    	c.validate_n(n);
	    }
	    static void show(String a) throws IOException {
			String f;
			
			do {
				System.out.println();
			System.out.print("Would you like to continue (Y/N) : ");
			f = sc.nextLine();
			if(f.equals("Y")||f.equals("y"))
			{
				System.out.println("Enter Product ID : ");
			    id = sc.nextInt();
			    c.validate_id(a, id);
			    System.out.println("Enter Quantity in units :");
			    n = sc.nextInt();
			    c.validate_n(n);
			    end();
			    //String e = sc.nextLine();
			    show();
			}
			if(f.equals("N")||f.equals("n")){
				show();
			}
			
	    }while(!(f.equals("Y"))&& !(f.equals("y"))&&!(f.equals("N"))&&!(f.equals("n")));
	   }
			    /*c.cart(name,phno, id, id);//to be completed.
			    String e = sc.nextLine();
			    show();
			}
			if(f.equals("N")||f.equals("n")){
				String n;
				do {
					System.out.println("Select:");
					System.out.println("1. Menu");
					System.out.println("2. Exit");
					n = sc.nextLine();
					switch(n) 
					{
					case "1" : Display();
					           break;
					case "2" : System.out.println("Thank you for coming.");
					           System.exit(0);
					default  : System.out.println("Please enter a valid input : ");
					           break;
					}
				}while(!(n.equals("1"))&&!(n.equals("2")));
			}
			
	    }while(!(f.equals("Y"))&& !(f.equals("y"))&&!(f.equals("N"))&&!(f.equals("n")));
	    }*/
	    
	    static void end() throws IOException {
	    	String n;
	    	c.cost();
	    	do {
	    		System.out.println();
	    		System.out.println("Choose :");
				System.out.println("1. Add to cart");
				System.out.println("2. Get Bill");
				System.out.println("3. Exit");
				String e = sc.nextLine();
				n = sc.nextLine();
				String a = "";
				switch(n) 
				{
				case "1" : {
					        c.Update();
					        Display();
					       }
				           break;
				       
				case "2" :{ 
					       //c.cost();
					       String cr = request();
					       c.cart(sno, name, phno, cr);
					       c.receipt(sno);
					       System.out.println();
					       System.out.println("Thank you for visiting");
				           System.exit(0); 
					      }
				          break;
					    
	 			case "3" : System.out.println();
	 					   System.out.println("Thank you for visiting.");
				           System.exit(0);
				           
				default  : System.out.println("Please enter a valid input : ");
				           break;
				}
			}while(!(n.equals("1"))&&!(n.equals("2"))&&!(n.equals("3")));	
	    }
	    
	    static String request() {
			System.out.println("Would you like to Pre-order any product :  ");
			String l = sc.nextLine();
			return l;
		}
  
	    
	    static void show() throws IOException{
	    	String n;
			do {
				System.out.println();
				System.out.println("Select:");
				System.out.println("1. Menu");
				System.out.println("2. Exit");
				n = sc.nextLine();
				switch(n) 
				{
				case "1" : Display();
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