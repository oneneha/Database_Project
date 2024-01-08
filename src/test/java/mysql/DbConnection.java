package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce1", "root", "root");

		Statement stmt = con.createStatement();

		ResultSet result = stmt.executeQuery("select * from eproduct1;");

		while (result.next()) {

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			System.out.println("Price of the profuct " + result.getDouble("price"));
		}

		System.out.println("=======================================================================");


		//Insert new data in to the eproduct1 table.

		stmt.executeUpdate("insert into  eproduct1 (name,price,date_added) values('Television',1500.00,now())");
		result = stmt.executeQuery("select * from eproduct1;");
		while (result.next()) {

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			System.out.println("Price of the product " + result.getDouble("price"));
		}
		
		System.out.println("============================================================");
		
		//Delete data in to the eproduct1 table.

		stmt.executeUpdate("delete from eproduct1 where name='Television';");
		result = stmt.executeQuery("select * from eproduct1;");
		while (result.next()) {
			

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			System.out.println("Price of the product " + result.getDouble("price"));
		}
		
		
		//Update data in to the eproduct1 table.

		stmt.executeUpdate("update eproduct1 set price='6000.00' where name='Mobile'");
		result = stmt.executeQuery("select * from eproduct1;");
		while (result.next()) {
			

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			System.out.println("Price of the product " + result.getDouble("price"));
		}

		
		con.close();

	}
}
