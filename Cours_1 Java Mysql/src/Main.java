import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;  

public class Main{  
	public static void main(String[] args) { 
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/class","root","");  
			
			//Statement stmt=con.createStatement();
			//int rs1=stmt.executeUpdate("insert into test (name) values ('test1')");  
			//ResultSet rs=stmt.executeQuery("select * from test");
			//stmt.executeUpdate(sql)
			
			PreparedStatement pr =con.prepareStatement("select * from Etudiants where id = ?");
			pr.setInt(1, 1);
			ResultSet rs = pr.executeQuery();

			while(rs.next()) 
			System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
			
			System.out.println("test success");
			con.close();
		}
		catch(Exception e){ 
			System.out.println(e);
		}  
	}  
}  