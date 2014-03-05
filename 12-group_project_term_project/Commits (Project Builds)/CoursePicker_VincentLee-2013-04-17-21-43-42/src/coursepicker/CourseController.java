package coursepicker;

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
 * Servlet implementation class CourseController
 */
@WebServlet("/CourseController")
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = this.getServletContext();
		HttpSession session = request.getSession();
		
		request.setAttribute("coursesTree18", new CourseDAO().getCourseOfferingsTree(18));
		request.setAttribute("coursesTree19", new CourseDAO().getCourseOfferingsTree(19));
		request.setAttribute("selectedItems", session.getAttribute("selectedItems"));
		
		RequestDispatcher dispatcher = ctx.getRequestDispatcher("/courses.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String[] selected = request.getParameterValues("18");
		for (int i = 0; i < selected.length; i++)
			System.out.println(selected[i]);
		
	
		
		session.setAttribute("selectedItems", selected);
		

		
		response.sendRedirect("/CoursePicker/CourseController");
	}

}
