import java.io.IOException;
//import com.mysql.jdbc.Statement;
import java.sql.*;
import java.util.*;

public class queries {
	public static void main(String []args) {
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/examapp","root","xy98ab01");
			Statement stmt = c.createStatement();
			/*ResultSet rs = stmt.executeQuery("select * from Department D where D.dno in (select branch.dno from branch group by branch.dno having count(branch.dno)>3);");
			while (rs.next()) {
				System.out.println(" " + rs.getInt("dno")+"          "+rs.getString("dname"));
				}*/
			/*ResultSet rs = stmt.executeQuery("select * from Department D where D.dno in (select c.dno from course as c group by c.dno having count(c.dno)>6);");
			while (rs.next()) {
				System.out.println(" " + rs.getInt("dno")+"          "+rs.getString("dname"));
				}*/
			/*ResultSet rs = stmt.executeQuery("select * from course c where c.ccode in (select b.ccode from branch_course as b group by b.ccode having count(b.bcode)>3);");
			while (rs.next()) {
				System.out.println(" " + rs.getString("ccode")+" "+rs.getString("cname")+" " +rs.getInt("credits")+"  "+ rs.getInt("dno"));
				}*/
			ResultSet rs = stmt.executeQuery("select * from student where rollno in (select e.rollno from enrolls as e group by grade having count(e.grade='S')>2);");
			while (rs.next()) {
				System.out.println(" " + rs.getInt("rollno")+"  "+rs.getString("name")+" "+rs.getDate("dob")+" " +rs.getString("gender")+"  "+ rs.getDate("doa")+" " + rs.getInt("rollno")+"\n");
				}
			c.close();
			sc.close();
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
