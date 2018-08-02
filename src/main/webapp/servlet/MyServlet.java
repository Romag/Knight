package servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.command.Command;
import servlet.command.EquipmentWithinRangeCommand;
import servlet.command.TotalCostCommand;
import ua.training.knight.*;


@WebServlet(name = "Knight", urlPatterns = {"/knight", "/totalcost", "/sortedequip", "/withinrange" })
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
		Map<String, Command> services = initCommands(req);
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter(); 
		
		Command command = services.get(req.getRequestURI());
		out.print(command.execute());

    }
	
	private void displayEquipentWithinRange(HttpServletRequest req, PrintWriter out) {
		int lowRange = 0;
		int highRange = 0;
		try {
			lowRange = Integer.parseInt(req.getParameter("lowRange"));
			highRange = Integer.parseInt(req.getParameter("highRange"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		out.println("<br/>" + knight.showEquipmentWithingPriceRange(lowRange, highRange));
	}

	private Map<String, Command> initCommands(HttpServletRequest req) {
		Map<String, Command> result = new HashMap<>();
		result.put("/JET_task_1/totalcost", new TotalCostCommand(knight));
		result.put("/JET_task_1/sortedequip", new TotalCostCommand(knight));
		result.put("/JET_task_1/withinrange", new EquipmentWithinRangeCommand(knight, Integer.parseInt((String) req.getAttribute("lowRange")), Integer.parseInt((String) req.getAttribute("highRange"))));
		
		return result;
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
