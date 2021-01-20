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
 * Servlet implementation class View_patient
 */
@WebServlet("/View_patient")
public class View_patient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_patient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			//int P_id=(int) Math.random();
			int patient_id=Integer.parseInt(request.getParameter("patient_id"));
			//P_id += P_id + (int) Math.random();
			//int room_no=Integer.parseInt(request.getParameter("room_number"));
			
			//String department="bala";
			try{
			

			

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","groupProject","projectGroup");
			
			PreparedStatement ps=con.prepareStatement("SELECT patient_id, room_no, first_name, last_name, email_add, phone_number, city, street, dept  FROM Patients WHERE patient_id ="+String.valueOf(patient_id));
			 ResultSet data = ps.executeQuery();
			 out.println("<br><br><body style=\"background-image:linear-gradient(rgba(0,0,0,0.2),rgba(0,0,0,0.4)),url(Images/bg4.jpg);background-position: center;\r\n" + 
			 		"	background-size: cover;\r\n" + 
			 		"	overflow-x: hidden;\r\n" + 
			 		"	position: relative;\"\"><center><h1>your details</h1><table style=\"background-color: #fff; color:#000;\">"
					 +"<th>"
					 +"<td>patient Id:-</td><td>room_no:-</td><td>first_name:-</td><td>last_name:-</td><td>email_add:-</td><td>phone_number:-</td><td>city:-</td><td>street:-</td>"
					 +"<td>dept:-</td></th><br>");
			 while(data.next())
			 {		out.print("<tr>");
			 out.print("<td></td>");
				  out.println("<td>"+ data.getInt("patient_id")+"</td>");
			 	   out.println("<td>"+ data.getInt("room_no")+"</td>");
			 	   out.println("<td>"+ data.getString("first_name")+"</td>");
			 	  out.println("<td>"+ data.getString("last_name")+"</td>");
			 	 out.println("<td>"+ data.getString("email_add")+"</td>");
			 	out.println("<td>"+ data.getString("phone_number")+"</td>");
			 	  out.println("<td>"+ data.getString("city")+"</td>");
			 	  out.println("<td>"+ data.getString("street")+"</td>");
			 	 out.println("<td>"+ data.getString("dept")+"</td>");
			 	 out.println("</tr>");
			 }
			 out.print("</table></center></body><br>");
			 out.print("<center><a href=\"index.html\"><button class=\"btn1\" href=\"index.jsp\" >Back To Home</button></a></center>");
			 RequestDispatcher rd=request.getRequestDispatcher("/view_patient.html");  
		       // rd.include(request, response);
			}catch (Exception e2) {System.out.println("error "+e2);}

			out.close();
			} 
		}
		
		
		
		


