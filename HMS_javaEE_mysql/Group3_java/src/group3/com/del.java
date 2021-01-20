package group3.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class del
 */
@WebServlet("/del")
public class del extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public del() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int patient_id=Integer.parseInt(request.getParameter("patient_id"));
		//P_id += P_id + (int) Math.random();
		//int room_no=Integer.parseInt(request.getParameter("room_number"));
		String first_name=request.getParameter("first_name");
		try{
			

			

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","groupProject","projectGroup");
			
			PreparedStatement ps=con.prepareStatement("delete  FROM Patients WHERE patient_id ="+String.valueOf(patient_id));
			 //ResultSet data = ps.executeQuery();
			ps.executeUpdate();
			 int i = ps.executeUpdate();
			 if (i==0)
			 {
				 out.println("<br><br><body style=\"background-image:linear-gradient(rgba(0,0,0,0.2),rgba(0,0,0,0.4)),url(Images/bg4.jpg);background-position: center;\r\n" + 
					 		"	background-size: cover;\r\n" + 
					 		"	overflow-x: hidden;\r\n" + 
					 		"	position: relative;\"\"><center><h1><br>Row has been deleted successfully.<br></h1>");
			 out.println("<br><center><a href=\"index.html\"><button class=\"btn1\" href=\"index.jsp\" >Back To Home</button></a></center><br>");
			 }
			 
			 
			}catch (Exception e2) {System.out.println("error "+e2);}

			out.close();
			} 
		
	

}