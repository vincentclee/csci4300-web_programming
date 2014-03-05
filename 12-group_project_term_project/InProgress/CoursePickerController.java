package auction;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * @author Alex Tozzi
 * Servlet implementation class AuctionController
 */

@WebServlet("/Auction")
public class CoursePickerController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public CoursePickerController() {
		super();	 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = this.getServletContext();
		HttpSession session = request.getSession();

		//PickerDAO dao = new PickerDAO();

		if( ... ) != null){ // do anything other than welcome page

			//STUFF

			//ctx.getRequestDispatcher("/page.jsp").forward(request, response);
			return;
		} 
		else { //view main page

			ctx.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = this.getServletContext();
		HttpSession session = request.getSession();
		//PickerDAO dao = new PickerDAO();

		if (request.getParameter("coreCurriculumNumber")!= null) { //check null info first

			//TODO possibly have one page handle all core reqs dynamically, rather than 6 pages?

			if (request.getParameter("coreCurriculumNumber").equalsIgnoreCase("1")) { //goto core page 1
				ctx.getRequestDispatcher("/core1.jsp").forward(request, response);
				return;
			}

			else if (request.getParameter("coreCurriculumNumber").equalsIgnoreCase("2")) { //goto core page 2
				ctx.getRequestDispatcher("/core2.jsp").forward(request, response);
				return;
			}

			else if (request.getParameter("coreCurriculumNumber").equalsIgnoreCase("3")) { //goto core page 3
				ctx.getRequestDispatcher("/core3.jsp").forward(request, response);
				return;
			}

			else if (request.getParameter("coreCurriculumNumber").equalsIgnoreCase("4")) { //goto core page 4
				ctx.getRequestDispatcher("/core4.jsp").forward(request, response);
				return;
			}

			else if (request.getParameter("coreCurriculumNumber").equalsIgnoreCase("5")) { //goto core page 5
				ctx.getRequestDispatcher("/core5.jsp").forward(request, response);
				return;
			}

			else if (request.getParameter("coreCurriculumNumber").equalsIgnoreCase("6")) { //goto core page 6
				ctx.getRequestDispatcher("/core6.jsp").forward(request, response);
				return;
			}

			else{ //invalid core number, default to index
				ctx.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
		}

		if(!(request.getParameter("courseSection").equals("--Select Course--"))) { //check empty input

			//add course to schedule

			//TODO handle all possible conflicts - same course, same time, overlaps, etc, need server side error handling?
			//possible to check here depending on structure of other code

			//the course is only stored in the session, so there should be no need to store anything in the DB
			//session.setAttribute("courseList", courseList object);

			ctx.getRequestDispatcher("/schedulePage.jsp").forward(request, response);
			return;
		}


		else if(request.getParameter("courseSection").equals("--Select Course--")) { //no course selected, just do nothing or display a message
			//possible to handle this with javascript instead?
			//will leave server side handling implemented for now just in case
			request.setAttribute("error", "You must select a course to be added");
			ctx.getRequestDispatcher("/schedulePage.jsp").forward(request, response);
			return;
		}

		if (request.getParameter("schedulePageFlag") != null) { //check null input

			if (request.getParameter("schedulePageFlag").equals("true")){ //go straight to schedule page

				ctx.getRequestDispatcher("/schedulePage.jsp").forward(request, response);
				return;
			}
		}

		//last chance handling, if no other flags present, go straight to main page
		ctx.getRequestDispatcher("/index.jsp").forward(request, response);
		return;
	}
}

