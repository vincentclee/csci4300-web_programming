package creditcard;

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
 * Servlet implementation class CreditController
 */
@WebServlet("/CreditController")
public class CreditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = this.getServletContext();
		HttpSession session = request.getSession();
		
		if(request.getParameter("custID") != null) {
			session.setAttribute("custID", request.getParameter("custID"));
		}

		request.setAttribute("customer", new CreditDAO().getCustomer(Integer.parseInt(session.getAttribute("custID").toString())));
		
		RequestDispatcher dispatcher = ctx.getRequestDispatcher("/customer.jsp");
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(request.getParameter("merchantName") != null && request.getParameter("merchantCity") != null && request.getParameter("merchantState") != null && request.getParameter("purchaseAmount") != null) {
			new CreditDAO().addPurchase(request.getParameter("merchantName"), request.getParameter("merchantCity"), request.getParameter("merchantState"), Double.parseDouble(request.getParameter("purchaseAmount")), Integer.parseInt(session.getAttribute("custID").toString()));
			response.sendRedirect("/CreditCard/CreditController");
		} else {
			//TODO Send error message
			response.sendRedirect("/CreditCard/CreditController");
		}
	}
}