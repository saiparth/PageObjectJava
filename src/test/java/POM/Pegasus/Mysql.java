package POM.Pegasus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mysql {

	public static void main(String[] args) {
		System.out.println("-------- MySQL JDBC Connection Testing ------------");

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		}
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
		try 
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/repository", "root", "Omsairam*1");
			Statement stmt = connection.createStatement();
			ResultSet res = stmt.executeQuery("select * from logins");
			while (res.next()) 
			{
				String user = res.getNString("username");
				String pwd = res.getNString("password");
				System.out.println(user + "" + pwd);

			}
		} 
		catch (SQLException e) 
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
	}
}
