import java.sql.ResultSet;
import java.util.*;

//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;

/*import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;*/

//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;

import java.sql.*;

public class Product implements Connectivity {
	static Product p = new Product();
	static Customer cus = new Customer();
	static Scanner scan = new Scanner(System.in);
	static int i;
	static int nos;
	static int Totalcost = 0;
    static String c = "";
    static int bill;
    
	static void Table(String x)
	{
		try {
			Statement s = (Statement) p.Connect();
			ResultSet r = s.executeQuery("select * from items WHERE Category = '"+x+"'");
			System.out.println("SRNO.  CATEGORY     PRODUCT NAME     ID       MRP       QUANTITY        DOM         DOE     " );
		    while(r.next()) {
		    	if(r.getInt("Current_Stock") > r.getInt("Threshold_Stock")) {
		    		System.out.println(""+r.getInt("SrNo")+"    "+r.getString("Category")+" "+r.getString("Product_Name")+"   "+r.getInt("ID")+"      "+r.getString("MRP")+"     "+r.getString("Quantity")+"     "+r.getString("DOM")+"     "+r.getString("DOE"));
			    } 
		    }
	    }catch(Exception e) {
	    	System.out.println(e);
	     }
	}
	static void Table() {
		try {
			Statement s = (Statement) p.Connect();
			ResultSet r = s.executeQuery("select *from items");
			System.out.println("SRNO.  CATEGORY     PRODUCT NAME   ID       MRP       QUANTITY        DOM         DOE     INITIAL STOCK   CURRENT STOCK    THRESHOLD STOCK    TOTAL SALES" );
		    while(r.next()) {
		    		System.out.println(""+r.getInt("SrNo")+"    "+r.getString("Category")+" "+r.getString("Product_Name")+"   "+r.getInt("ID")+"      "+r.getString("MRP")+"     "+r.getString("Quantity")+"     "+r.getString("DOM")+"     "+r.getString("DOE")+"        "  +r.getInt("Initial_Stock")+"            "+ r.getInt("Current_Stock")+"               "+r.getInt("Threshold_Stock")+ "                "+r.getInt("Total_Sales"));
		    } 
	    }catch(Exception e) {
	    	System.out.println(e);
	    }
	}
    static void validate_id(String a) {
    	try {
    		Statement s = (Statement) p.Connect();
			ResultSet r = s.executeQuery("select * from items WHERE Category = '"+a+"'");
			System.out.println("SRNO.  CATEGORY     PRODUCT NAME   ID       MRP       QUANTITY        DOM         DOE     INITIAL STOCK   CURRENT STOCK    THRESHOLD STOCK    TOTAL SALES" );
		    while(r.next()) {
		    		System.out.println(""+r.getInt("SrNo")+"    "+r.getString("Category")+" "+r.getString("Product_Name")+"   "+r.getInt("ID")+"      "+r.getString("MRP")+"     "+r.getString("Quantity")+"     "+r.getString("DOM")+"     "+r.getString("DOE")+"        "  +r.getInt("Initial_Stock")+"            "+ r.getInt("Current_Stock")+"               "+r.getInt("Threshold_Stock")+ "                "+r.getInt("Total_Sales"));
		    }
	    }catch(Exception e) {
	    	System.out.println(e);
	     }
	}
	static void validate_id(String a, int id) {
		try {
			Statement s = (Statement) p.Connect();
			ResultSet r = s.executeQuery("select * from items where ID = '"+id+"'and Category = '"+a+"' and Current_Stock>Threshold_Stock");
			if(!r.next()) {
				System.out.println("Enter valid ID : ");
				i = scan.nextInt();
				validate_id(a,i);
			}
			else {
				i = id;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	static void validate_n(int n) {
		try {
			Statement s = (Statement) p.Connect();
			ResultSet r = s.executeQuery("select * from items where ID = '"+i+"'");
				while(r.next()) {
					if(n>r.getInt("Current_Stock"))
					{
			    		System.out.println("Avaliable Stock : "+ r.getInt("Current_Stock"));
			    		System.out.print("Please re-enter the Quantity : ");
			    		int nos = scan.nextInt();
			    		validate_n(nos);
				    }		
				    else if(n <= r.getInt("Current_Stock")) {
				    //	Statement s1 = (Statement) p.Connect();
						//s1.executeUpdate("Update items set Current_Stock = Current_Stock - '"+n+"' WHERE ID = '"+i+"'");					    
						//nos = n;
				    	nos = n;
				    }
		          }
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static void Update() {
		try {
			Statement s1 = (Statement) p.Connect();
			s1.executeUpdate("Update items set Current_Stock = Current_Stock - '"+nos+"' WHERE ID = '"+i+"'");	
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static int bn() {
		try {
			Statement s = (Statement) p.merge();
			ResultSet r = s.executeQuery("select sno from cus_info order by sno desc limit 1");
			while(r.next()) {
				int sno = r.getInt("sno");
				//System.out.println(sno);
				bill = sno+1;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return bill;
	}
	
	static void cost() {
		int cost = 0;
		//System.out.println("yo");
		try {
			Statement s1 = (Statement) p.Connect();
			ResultSet r = s1.executeQuery("select Product_Name, MRP from items WHERE ID = '"+i+"'");
			while(r.next()) {
		    	String t = r.getString("MRP");
		    	int mrp = Integer.parseInt(t.substring(4));
				cost = nos*mrp;
				c = c + r.getString("Product_Name") + "-" + nos +"-"+cost+"; ";
				Totalcost = Totalcost + cost;
		    }
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println();
		System.out.println("** Your cart(Product_Name-Quantity in units-cost) **");
	    System.out.println(c);
	    System.out.println("Total cost : " + Totalcost);
		//return c;
	}
	
	static void cart(int sno, String name, String phno, String cr) {
		try {
			PreparedStatement p1 = (PreparedStatement )p.person();
		    p1.setInt(1, sno);
		    p1.setString(2, name);
		    p1.setString(3, phno);
		    p1.setString(4, c);
		    p1.setInt(5, Totalcost);
		    p1.setInt(6, sno);
		    p1.setString(7, cr);
		    p1.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		c = "";
		Totalcost = 0;
	}
	
	static void receipt(int billno) {
		try {
			Statement s = (Statement) p.merge();
			ResultSet r = s.executeQuery("select *from cus_info where billno = '"+billno+"'");
			System.out.println();
			System.out.println("****Your bill is displayed below.****");
			System.out.println("BILL_NO  NAME     PHONE_NUMBER   TOTAL_COST    PRODUCT_NAME-QUANTITY-COST ");
			while(r.next()) {
				System.out.println("  "+ r.getInt("billno")+"     "+r.getString("name")+"     "+r.getString("phno")+"      "+r.getInt("totalcost")+"      "+r.getString("items"));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
    
}