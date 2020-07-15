import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;

//import com.mysql.cj.jdbc.Statement;
//import java.sql.*;

public class Analysis_graphs {
	static Scanner scan = new Scanner(System.in);
    private static JDBCCategoryDataset dataset;
	static void ask() throws IOException {
		   String n;
			do {
				System.out.println();
				System.out.println("Select:");
				System.out.println("1. Dental");
				System.out.println("2. Bathing");
				System.out.println("3. Utilities");
				System.out.println("4. Dairy");
				System.out.println("5. Fruits");
				System.out.println("6. Vegetables");
				System.out.println("7. Kitchenware");
				System.out.println("8. Go back");
				System.out.println("9. Exit");
				n = scan.nextLine();
				switch(n) 
				{
				case "1" : view("   Dental  ");
				           break;
				           
				case "2" : view("  Bathing  ");
				           break;
				
				case "3" : view(" Utilities ");
		                   break;
		                   
				case "4" : view("   Dairy   ");
		                   break;
		                   
				case "5" : view("   Fruits  ");
		                   break;
		                   
				case "6" : view(" Vegetables");
		                   break;
		                   
				case "7" : view("Kitchenware");
		                   break;
		
				case "8" : ask();
					       break;
		                   
				case "9" : System.out.println();
						   System.out.println("Thank you for visiting");
		                   System.exit(0);
		                   
				default  : System.out.println("Please enter valid input : ");
				           break;
				}
			}while(!(n.equals("1"))&&!(n.equals("2")) && !(n.equals("3")) && !(n.equals("4")) && !(n.equals("5")) && !(n.equals("6")) && !(n.equals("7")) );
			
			System.out.println("The requested graph has been plotted.");
	   }
	
	static void view(String a) throws IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/products","root","adhyarujinal2000");
    		dataset = new JDBCCategoryDataset(c);
            dataset.executeQuery("SELECT Product_Name,Total_Sales from items WHERE Category = '"+a+"'");   
    	}catch(Exception e) {
    		System.out.println(e);
    	}
		JFreeChart barChart = ChartFactory.createBarChart(
                a,
                "Product",
                "Sales",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        ChartUtilities.saveChartAsPNG(new File("sales.png"), barChart, 800, 800);
    }
} 