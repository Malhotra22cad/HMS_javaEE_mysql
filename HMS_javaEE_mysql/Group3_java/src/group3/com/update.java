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
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
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
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int patient_id=Integer.parseInt(request.getParameter("patient_id"));
		
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","groupProject","projectGroup");
		
		PreparedStatement ps=con.prepareStatement("SELECT patient_id, room_no, first_name, last_name, email_add, phone_number, city, street  FROM Patients WHERE patient_id ="+String.valueOf(patient_id));
		 ResultSet data = ps.executeQuery();
	
		 RequestDispatcher dispatcher = request.getRequestDispatcher("res_update.jsp");
		 while(data.next())
		 {	
		 request.setAttribute("patient_id", data.getInt("patient_id")); 
		 request.setAttribute("room_no", data.getInt("room_no")); 
		 request.setAttribute("first_name", data.getString("first_name"));
		 request.setAttribute("last_name", data.getString("last_name"));
		 request.setAttribute("email_add", data.getString("email_add"));
		 request.setAttribute("phone_number", data.getString("phone_number"));
		 request.setAttribute("city", data.getString("city"));
		 request.setAttribute("street", data.getString("street"));
		
		 }
		 dispatcher.forward( request, response );	
		 
		}catch (Exception e2) {System.out.println("error "+e2);}

		out.close();
		} 
	
	}


