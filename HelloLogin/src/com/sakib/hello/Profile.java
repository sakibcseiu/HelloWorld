package com.sakib.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.SeekableByteChannel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		
		PrintWriter out=resp.getWriter();
		req.getRequestDispatcher("index.html").include(req, resp);
		if (session!=null) {
			String name=(String)session.getAttribute("name");
			
			out.print("<br>Welcome "+name);
		}
		else {
			
			out.print("<br>First login<br>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	}
}
