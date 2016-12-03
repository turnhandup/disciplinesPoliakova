package main.java;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MySQLConn {
	public static void main(String[] args){ 
		try{
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/schedule", "root", "1212kolya1212");
			System.out.println("Connection to database is successful");
			String query = "SELECT * FROM disciplines";
			Statement stmt=(Statement) con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()){
				System.out.println("ID: "+ rs.getString("idDisciplines"));
				System.out.println("Name: "+ rs.getString("name"));
				System.out.println("Credits: "+ rs.getString("credits"));
			}
		} catch (Exception e){
			System.err.println(e);
		}
	}
}
