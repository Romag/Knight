package ua.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.training.knight.*;


@WebServlet(name = "Knight", urlPatterns = {"/Knight"})
public class MyServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("Creating servlet.");
		
		super.init();
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroying servlet.");
		super.destroy();
	}

	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            												throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter(); 
		out.println("This is servlet doGET.");

    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
												throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
	}
	
	
}
