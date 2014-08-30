package se.hazelius.dev.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demolib.DemoLib;
import se.hazelius.dev.demo.messagelib.MessageIF;
import se.hazelius.dev.demo.messagelib.JavaMessage;

public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1933123960656851478L;
	private MessageIF mLib;

	@Override
	public void init() throws ServletException {
		try{
			mLib = new DemoLib();
		} catch (UnsatisfiedLinkError e){
			mLib = new JavaMessage();
		}
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String tokenString = req.getParameter("token");
		long token = Integer.valueOf(tokenString);
		String message = mLib.getMessage(token);
		req.setAttribute("message", message);

		req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);


	}
}
