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
 * Servlet implementation class save
 */
@WebServlet("/save")
public class save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public save() {
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
		//int P_id=(int) Math.random();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
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
				//String street=request.getParameter("street");
				String dept=request.getParameter("dept");
		// int patient_id=Integer.parseInt(request.getParameter("patient_id"));
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","groupProject","projectGroup");
			
			PreparedStatement ps=con.prepareStatement("UPDATE Patients Set patient_id="+String.valueOf(patient_id)+", room_no="+String.valueOf(room_no)+", street = \'"+street+"\', phone_number=\'"+phone_number+"\', first_name=\'"+first_name+"\', last_name=\'"+last_name+"\', email_add=\'"+email_add+"\',  city=\'"+city+"\' WHERE patient_id ="+ String.valueOf(patient_id));
			
			 int i = ps.executeUpdate();
			 if(i!=0)
			 {out.print("updated");
			 RequestDispatcher rd =request.getRequestDispatcher("/view_patient.html");  
		        rd.include(request, response);}
			}catch (Exception e2) {System.out.println("error "+e2);}

			out.close();
			} 
		
	}


