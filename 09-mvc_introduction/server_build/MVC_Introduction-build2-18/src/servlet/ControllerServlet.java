/*
 * Controller Servlet is used to decide which page to send the user to once a button is pressed
 */
package servlet;

import helpers.StringReverser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/Controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Determines which page to send the user to
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext ctx = this.getServletContext();
		HttpSession session = request.getSession();
		
		//If a username is given, forwards user to hello.jsp
		if(request.getParameter("userName") != null)
		{
			String userName = request.getParameter("userName");
			request.setAttribute("userName", userName);
			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/Hello");
			dispatcher.forward(request, response);
		}
		//If username has already been given and string is given, forwards user to reverse.jsp
		else if((request.getParameter("string") != null) && (session.getAttribute("userName") != null))
		{
			String origStr = request.getParameter("string");
			request.setAttribute("originalString", origStr);
			
			String reverse = StringReverser.reverseIt(origStr);
			request.setAttribute("reverseString", reverse);
			
			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/reverse.jsp");
			dispatcher.forward(request, response);
		}
		//If no username is given, forwards to index.jsp
		else
		{
			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
