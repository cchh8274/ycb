package com.ycb.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * 测试数据库连接
 * @author chenghui
 *
 */
public class JdbcTest {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载驱动
	        Connection conn = DriverManager.getConnection("jdbc:mysql://47.94.4.92:3306/ycb", "root", "root");			   
	        Statement stmt = (Statement) conn.createStatement();
		        ResultSet rs = stmt.executeQuery("SELECT sex, name FROM user");
		        //如果有数据，rs.next()返回true
		        while(rs.next()){
		            System.out.println(rs.getString("sex")+" 年龄："+rs.getInt("name"));
		        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
