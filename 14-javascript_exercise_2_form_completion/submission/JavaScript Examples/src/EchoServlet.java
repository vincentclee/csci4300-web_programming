/**
 * This controller echos what the user input in formCheck.html.
 * @author Vincent Lee
 * @author Meghan Redwine
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class EchoServlet
 */
@WebServlet(name = "Echo", urlPatterns = { "/Echo" })
public class EchoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EchoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * Echoes all request parameter names and values”.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
		out.println("<title>Echo Servlet</title>");
		out.println("<link rel='stylesheet' href='csci4300.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Echo Servlet</h1>");
	    
		//Stores all the parameter names. 
		Enumeration<String> enumeration = request.getParameterNames();
		
		//Gets one parameter name and value(s) and displays on page.
		while (enumeration.hasMoreElements()) {
			String element = (String) enumeration.nextElement();
			out.println("<p>" + element + ": " + request.getParameter(element) + "</p>");
		}

		out.println("<p><a href=\"index.jsp\">Back to index page</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
}
