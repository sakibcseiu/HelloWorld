package com.sakib.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		String name=req.getParameter("name");
		
		req.getRequestDispatcher("index.html").include(req, resp);
		
		if (name.equals("sakib")) {
			HttpSession ss=req.getSession();
			ss.setAttribute("name", name);
			out.print("<br>login correct");
		}
		else {
			out.print("<br>error login<br>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
		
		
	}
}
