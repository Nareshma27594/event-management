

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.utility.JDBCUtility;


@WebServlet("/dat")
public class dat extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("birthdaytime"));
		response.getWriter().println("DateTime "+request.getParameter("birthday"));
		response.getWriter().println("DsTime "+request.getParameter("time"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date date = dateFormat.parse(request.getParameter("birthday")+" "+request.getParameter("time"));
			response.getWriter().println("try"+date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try(Connection connect = JDBCUtility.getConnection()){
			Date date = dateFormat.parse(request.getParameter("birthday")+" "+request.getParameter("time"));
			response.getWriter().println("try"+date);
			PreparedStatement pstmt = connect.prepareStatement("insert into dateWala values(?)");
			pstmt.setString(1, request.getParameter("birthday")+" "+request.getParameter("time"));
			System.out.println(pstmt.executeUpdate());
		}
		catch(Exception e) {
			System.out.println("error in djbv"+e);
		}
		
		
	}

}
