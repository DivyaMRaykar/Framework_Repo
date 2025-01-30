package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility 
{
	Connection conn;
	public void getDbconnection(String url,String un,String pwd) throws Throwable
	{
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection(url,un,pwd);
		}catch (Exception e) {
		}
	}
	public void getDbconnection() throws Throwable
	{
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		}catch (Exception e) {
		}
	}
	
	public void closeDbconnection() throws Throwable
	{
		try {
		conn.close();
		}catch (Exception e) {
		}
	}
	
	public ResultSet executeSelectQuery(String query)
	{
		ResultSet result=null;
		try {
		Statement stat=conn.createStatement();
		result=stat.executeQuery(query);
		}catch (Exception e) {
		}
		return result;
	}
	
	public int executeNonSelectQuery(String query) throws Throwable
	{
		int result=0;
		try {
		Statement stat=conn.createStatement();
		result=stat.executeUpdate(query);
		}catch (Exception e) {
		}
		return result;
	}
}
