/**
 * CustomerController will be the MVC Controller.
 * @author Vincent Lee
 * @author Meghan Redwine
 */

package creditcard;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = this.getServletContext();
		
		//If request parameter is custID then forward Single customer
		if(request.getParameter("custID") != null) {
			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/CreditController");
			dispatcher.forward(request, response);
		}
		//If request parameter is NONE forward Customer list
		else {
			request.setAttribute("customerList", new CreditDAO().getCustomerList());
			
			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/customerList.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("imageURL").length() > 0) {
			new CreditDAO().addCustomer(request.getParameter("custName"), 
					request.getParameter("custAddr"), 
					request.getParameter("imageURL"), 
					Double.parseDouble(request.getParameter("creditLimit")));
			response.sendRedirect("/CreditCard/CustomerController");
		} else if (request.getParameter("imageURL").length() == 0) {
			new CreditDAO().addCustomer(request.getParameter("custName"), 
					request.getParameter("custAddr"), 
					null, 
					Double.parseDouble(request.getParameter("creditLimit")));
			response.sendRedirect("/CreditCard/CustomerController");
		} else {
			response.sendRedirect("/CreditCard/CustomerController");
		}
	}
}
