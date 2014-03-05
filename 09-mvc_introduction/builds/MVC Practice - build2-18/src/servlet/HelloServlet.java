package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * "Hello World" Servlet that also stores user name in session
 * 
 */
@WebServlet("/Hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
    }

	/**
	 * Responds with cheery message
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head><title>Servlet Hello</title></head>");
		out.println("<body><h1>Hello</h1></body>");
		out.println("<body><p>Welcome, " +userName +". </p></body>");
		out.println("<p><a href=\"index.jsp\">Back to index page</a></p>");
		out.println("</html>");
		
		ServletContext ctx = this.getServletContext();
		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
