package com.servlet.formApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FormServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("nm");
		String place = req.getParameter("pl");
		System.out.println(name+"is from"+place);
		
		//getWriter() --->ServletResponse
		//ref ---> PrintWriter
		
		    PrintWriter  out =res.getWriter();
		    out.println("<html>"
		    		+"<body bgcolor='blue'>"
		    		+"<h1>user detaills:->"+name+"from"+place
		    		+"</h1></body></html>");
		    
		    //jdbc code 
		    
		    try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=12345");
			    PreparedStatement pstmt = con.prepareStatement("insert into form_details.info values(?,?)");
			    pstmt.setString(1, name);
			    pstmt.setString(2, place);
			    pstmt.executeUpdate();
		    } catch (Exception e) {
				// TODO Auto-generated catch block
		    	System.out.println("hii");
				e.printStackTrace();
			}
	}

}
