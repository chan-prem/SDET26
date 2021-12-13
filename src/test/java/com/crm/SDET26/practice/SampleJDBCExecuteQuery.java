package com.crm.SDET26.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
	public static void main(String[] args) throws SQLException {
		
	//Step1: REgister to database-Driver(import from cj.jdbc) import new Driver from (javasql)
	// Driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
	//Step2: get connection from Databse - provide db name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet26", "root", "root");
		
	//Step3: issue create statement
		Statement stat = con.createStatement();
		
	//step4: execute a query -provide table name
		ResultSet result = stat.executeQuery("select  * from empInfo;");
		
		//since I don't know the range, I go with while loop. 
			while(result.next())
			{
			System.out.println(result.getString(1)+ " " + result.getString(2) + " " + result.getString(3));
			}
		
		
//step 5: close the database
		con.close();
	}

}
