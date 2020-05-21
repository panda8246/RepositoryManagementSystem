package com.oxhpjk.jxc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;




public class hello {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/jxc?useSSL=false&serverTimezone=GMT" +
//		            "&allowPublicKeyRetrieval=true";
			String url = "jdbc:mysql://localhost:3306/jxc?useSSL=false&serverTimezone=GMT&allowPublicKeyRetrieval=true";
			String user = "root";
			String password = "123";
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement sta = conn.createStatement();
			String sql = "select * from t_user";
			ResultSet rts = sta.executeQuery(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
