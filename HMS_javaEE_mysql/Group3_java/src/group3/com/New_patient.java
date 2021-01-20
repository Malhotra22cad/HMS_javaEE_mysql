package group3.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class New_patient
 */
@WebServlet("/New_patient")
public class New_patient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public New_patient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//int P_id=(int) Math.random();
		int patient_id=Integer.parseInt(request.getParameter("patient_id"));
		//P_id += P_id + (int) Math.random();
		int room_no=Integer.parseInt(request.getParameter("room_no"));
		String first_name=request.getParameter("first_name");
		String last_name=request.getParameter("last_name");
		//String email="ya6888malhotra@gami.com"; 
		String email_add=request.getParameter("email_add");
		String phone_number=request.getParameter("phone_number");
		String city=request.getParameter("city");
		String street=request.getParameter("street");
		String dept=request.getParameter("dept");
		//String department="bala";
		try{
	
		

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","groupProject","projectGroup");
		
		PreparedStatement ps=con.prepareStatement(
		"insert into Patients values(?,?,?,?,?,?,?,?,?)");

		ps.setInt(1,patient_id);
		ps.setInt(2,room_no);
		ps.setString(3,first_name);
		ps.setString(4,last_name);
		ps.setString(5,email_add);
		ps.setString(6,phone_number);
		ps.setString(7,city);
		ps.setString(8,street);
		ps.setString(9,dept);
		
		
		int i=ps.executeUpdate();
		if(i>0)
		out.print("<h2 style=\"color:white;\">!!!One new patient added successfully into the records...!!!</h2>");
		 RequestDispatcher rd=request.getRequestDispatcher("/new_patient.html");  
	        rd.include(request, response);

		}catch (Exception e)
		{
			System.out.println("error again "+e);}

		out.close();
		}
	}
