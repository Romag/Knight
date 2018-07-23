package ua.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "LALALA", urlPatterns = {"/LALALA"})
public class MyServlet extends HttpServlet {
	
//	@Override
//	public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
//            throws IOException {
//		PrintWriter out = httpServletResponse.getWriter(); 
//		out.println("This is servlet doGET.");
//		
//		String firstName = httpServletRequest.getParameter("firstName");
//		String lastName = httpServletRequest.getParameter("lastName");
//		
//		out.println("Servlet received " + firstName + " " + lastName);
//    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		
		resp.setContentType("text/html;charset=utf-8");
		//resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("Servlet received " + firstName + " " + lastName);
	}
	
	
}
