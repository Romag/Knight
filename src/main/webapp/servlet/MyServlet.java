package servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.training.knight.*;


@WebServlet(name = "Knight", urlPatterns = {"/knight", "/equipprice", "/sortedequip",  })
public class MyServlet extends HttpServlet {
	private Knight knight;

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
		knight = new Knight();
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter(); 
		out.println("This is servlet doGET.");
		
		out.println("<br/>" + knight.showSortedByWeightEquipment());;
		
		out.println("<br/>" + knight.equipmentCost());
		
		displayEquipentWithinRange(req, out);
    }
	
	private void displayEquipentWithinRange(HttpServletRequest req, PrintWriter out) {
		int lowRange = -1;
		int highRange = -1;
		try {
			lowRange = Integer.parseInt(req.getParameter("lowRange"));
			highRange = Integer.parseInt(req.getParameter("highRange"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		out.println("<br/>" + knight.showEquipmentWithingPriceRange(lowRange, highRange));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
												throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("This is servlet doPOST.");
	}	
	
}
