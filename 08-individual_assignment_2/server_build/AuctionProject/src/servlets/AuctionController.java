/**
 * Auction Controller determines which item gets displayed on the page.
 * @author Vincent Lee
 */

package servlets;

import helper.AuctionHelper;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuctionController
 */
@WebServlet("/AuctionController")
public class AuctionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuctionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = this.getServletContext();
		HttpSession session = request.getSession();
		session.setAttribute("clock", false);
	
		
		Object[] itemData;
		//Checks for null customer ID, sets if not null
		if (request.getParameter("itemID") != null && request.getParameter("categoryID") != null) {
			session.setAttribute("itemID", request.getParameter("itemID"));
			session.setAttribute("categoryID", request.getParameter("categoryID"));
			session.setAttribute("addCategory", false);
			session.setAttribute("addItem", false);
			itemData = new AuctionHelper().getItemProperties(Integer.parseInt(request.getParameter("categoryID")), Integer.parseInt(request.getParameter("itemID")));	
		} 
		//Go to first item on default.
		else {
			session.setAttribute("itemID", 1);
			session.setAttribute("categoryID", 1);
			itemData = new AuctionHelper().getItemProperties(1, 1);
		}
		
		//Items to be sent back to JSP page.
		request.setAttribute("listingName", itemData[1]);
		request.setAttribute("imageURL", itemData[2]);
		request.setAttribute("description", itemData[3]);
		request.setAttribute("availability", itemData[4]);
		request.setAttribute("startingBid", Double.parseDouble(itemData[5].toString()));
		request.setAttribute("currentBid", Double.parseDouble(itemData[6].toString()));
		request.setAttribute("endDate", itemData[8]);
		request.setAttribute("categoryTree", new AuctionHelper().getCategoryTree());
		request.setAttribute("nameHighest", itemData[9]);
		request.setAttribute("emailHighest", itemData[10]);
		request.setAttribute("name", session.getAttribute("name"));
		request.setAttribute("email", session.getAttribute("email"));
		request.setAttribute("loginFailed", session.getAttribute("loginFailed"));
		
		//Check for whether applicable to display addItem page
		if (session.getAttribute("addItem") != null) {
			request.setAttribute("addItem", session.getAttribute("addItem"));
			request.setAttribute("categoryName", session.getAttribute("categoryName"));
		}
		//Check for whether applicable to display addCategory page
		if (session.getAttribute("addCategory") != null)
			request.setAttribute("addCategory", session.getAttribute("addCategory"));
		
		//Packages items and sends to the page selected, whether admin or item.
		RequestDispatcher dispatcher = null;
		if (session.getAttribute("admin") != null) {
			if (session.getAttribute("admin").toString().equalsIgnoreCase("true")) {
				request.setAttribute("username", session.getAttribute("username"));
				
				dispatcher = ctx.getRequestDispatcher("/admin.jsp");
			} else
				dispatcher = ctx.getRequestDispatcher("/item.jsp");
		} else
			dispatcher = ctx.getRequestDispatcher("/item.jsp");
		
		//Send the request.
		dispatcher.forward(request, response);
		
		//Sets error conditions back to false, so when a user refreshes, it goes away.
		session.setAttribute("error", false);
		session.setAttribute("loginFailed", false);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//Login Request
		if (request.getParameter("username") != null && request.getParameter("password") != null) {
			session.setAttribute("username", request.getParameter("username"));
			session.setAttribute("password", request.getParameter("password"));
			
			//Remove any user session data.
			session.setAttribute("name", null);
			session.setAttribute("email", null);
			
			if (new AuctionHelper().validateUser(request.getParameter("username"), request.getParameter("password"))) {
				session.setAttribute("admin", true);
			} else {
				session.setAttribute("loginFailed", true);
			}
			
			response.sendRedirect("/AuctionProject/AuctionController");
		} 
		//Bid on item request
		else if (request.getParameter("bid") != null && request.getParameter("name") != null && request.getParameter("email") != null) {
			session.getAttribute("itemID");
			session.getAttribute("categoryID");
			
			session.setAttribute("name", request.getParameter("name"));
			session.setAttribute("email", request.getParameter("email"));
			
			boolean error = new AuctionHelper().placeBid(Integer.parseInt(session.getAttribute("categoryID").toString()), Integer.parseInt(session.getAttribute("itemID").toString()), Double.parseDouble(request.getParameter("bid")), request.getParameter("name"), request.getParameter("email"));
			session.setAttribute("error", !error);
			
			response.sendRedirect("/AuctionProject/AuctionController?itemID=" + session.getAttribute("itemID") + "&categoryID=" + session.getAttribute("categoryID"));
		} 
		//Signout Request
		else if (request.getParameter("signout") != null) {
			//Remove any user session data.
			session.setAttribute("username", request.getParameter("username"));
			session.setAttribute("password", request.getParameter("password"));
			
			session.setAttribute("name", null);
			session.setAttribute("email", null);
			
			//Un-do admin user.
			session.setAttribute("admin", false);
			
			response.sendRedirect("/AuctionProject/AuctionController");
		} 
		//Add Category request
		else if (request.getParameter("addCategory") != null) {
			session.setAttribute("addCategory", true);
			session.setAttribute("addItem", false);
			response.sendRedirect("/AuctionProject/AuctionController");
		} 
		//Add Item request
		else if (request.getParameter("addItem") != null) {
			session.setAttribute("addItem", true);
			session.setAttribute("addCategory", false);
			session.setAttribute("categoryNumber", request.getParameter("categoryNumber"));
			session.setAttribute("categoryName", request.getParameter("categoryName"));
			response.sendRedirect("/AuctionProject/AuctionController");
		} 
		//Add category name to database, and return to normal layout.
		else if (request.getParameter("addCategoryFinal") != null) {
			new AuctionHelper().addCategory(request.getParameter("addCategoryFinal"));
			session.setAttribute("addCategory", false);
			response.sendRedirect("/AuctionProject/AuctionController");
		} 
		//Add item to database, and return to normal layout.
		else if (request.getParameter("itemName") != null && 
				request.getParameter("listingName") != null && 
				request.getParameter("imageURL") != null && 
				request.getParameter("description") != null && 
				request.getParameter("availability") != null && 
				request.getParameter("startingBid") != null && 
				request.getParameter("duration") != null) {
			new AuctionHelper().addItem(request.getParameter("itemName"), 
					request.getParameter("listingName"), 
					request.getParameter("imageURL"), 
					request.getParameter("description"), 
					request.getParameter("availability"), 
					Double.parseDouble(request.getParameter("startingBid")), 
					Integer.parseInt(request.getParameter("duration")), 
					Integer.parseInt(session.getAttribute("categoryNumber").toString()));
			
			session.setAttribute("addItem", false);
			response.sendRedirect("/AuctionProject/AuctionController");
		} 
		//Cancel request, to return to normal layout.
		else if (request.getParameter("cancel") != null) {
			session.setAttribute("addCategory", false);
			session.setAttribute("addItem", false);
			
			response.sendRedirect("/AuctionProject/AuctionController");
		} 
		//If all fail, just return to normal layout.
		else {
			response.sendRedirect("/AuctionProject/AuctionController");
		}
	}
}
