import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//import com.mysql.jdbc.PreparedStatement;
import java.sql.*;

public interface Connectivity {
    default Statement Connect() throws Exception{
    	try {
    		//Class.forName("com.mysql.jdbc.Driver");
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/products","root","adhyarujinal2000");
    	    Statement s = c.createStatement();
    		return s;
    	}catch(Exception e) {
    		throw e;
    	}
    }
    default PreparedStatement person() throws Exception{
    	try {
    		//Class.forName("com.mysql.jdbc.Driver");
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","adhyarujinal2000");
    		String sql = "insert into cus_info(sno, name, phno, items, totalcost, billno,Customer_Requests) values(?, ?, ?, ?, ?, ?, ?)";
    		PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
    		
    		return ps;
    	}catch(Exception e) {
    		throw e;
    	}
    }
    
    default Statement merge() throws Exception{
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","adhyarujinal2000");
    		Statement s = c.createStatement();
    		return s;
    	}catch(Exception e) {
    		throw e;
    	}
    }
}
