package coursepicker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Alex Tozzi
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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = this.getServletContext();
		HttpSession session = request.getSession();
		/*
		University Requirements
		1	Cultural Diversity Requirement
		2	Environmental Literacy Requirement
		Franklin College Requirements
		10	Franklin College Foreign Language
		11	Franklin College Literature
		12	Franklin College Fine Arts/Philosophy/Religion
		13	Franlin College History
		14	Franklin CollegeSocial Sciences other than History
		15	Franklin College Biological Sciences
		16	Franklin College:Physical Sciences
		17	Franklin College Multicultural Requirement
		AREA I: Foundation Courses
		3	Core Curriculum I: Foundation Courses
		AREA II: Sciences
		4	Core Curriculum II: Physical Sciences
		5	Core Curriculum II: Life Sciences
		AREA III: Quantitative Reasoning
		6	Core Curriculum III: Quantitative Reasoning
		AREA IV: World Lang & Culture, Humanities & Arts
		7	Core Curriculum IV: World Languages and Culture
		8	Core Curriculum IV: Humanities and Arts
		AREA V: Social Sciences
		9	Core Curriculum V: Social Sciences
		AREA F/VI: Major Related Requirements
		18	Core CurriculumVI: Major related courses
		Major Requirements
		19	Computer Science Major Courses
		*/
		
//		request.setAttribute("coursesTree18", new CourseDAO().getCourseOfferingsTree(18));
//		request.setAttribute("coursesTree19", new CourseDAO().getCourseOfferingsTree(19));
//		request.setAttribute("selectedItems", session.getAttribute("selectedItems"));
		
		
		if (session.getAttribute("selectedItem") != null)
			request.setAttribute("selectedItem", session.getAttribute("selectedItem"));
		
		
		if (request.getParameter("page") != null) {
			if (request.getParameter("page").compareToIgnoreCase("university-requirements") == 0) {
				session.setAttribute("page", "university-requirements");
				session.setAttribute("jspfile", "/area-major.jsp");
				session.setAttribute("title", "University Requirements");
				
				if (session.getAttribute("coursesTree1") == null)
					session.setAttribute("coursesTree1", new CourseDAO().getCourseOfferingsTree(1));
				if (session.getAttribute("coursesTree2") == null)
					session.setAttribute("coursesTree2", new CourseDAO().getCourseOfferingsTree(2));
				
				request.setAttribute("coursesTree1", session.getAttribute("coursesTree1"));
				request.setAttribute("coursesTree2", session.getAttribute("coursesTree2"));
				
				
				//New ish testing
				ArrayList<LinkedHashMap<String, List<String>>> coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree1"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree2"));
				
				request.setAttribute("coursesTree", coursesTree);
				//End new ish
				
				
			} else if (request.getParameter("page").compareToIgnoreCase("franklin-college-requirements") == 0) {
				session.setAttribute("page", "franklin-college-requirements");
				session.setAttribute("jspfile", "/area-major.jsp");
				session.setAttribute("title", "Franklin College Requirements");
				
				if (session.getAttribute("coursesTree10") == null)
					session.setAttribute("coursesTree10", new CourseDAO().getCourseOfferingsTree(10));
				if (session.getAttribute("coursesTree11") == null)
					session.setAttribute("coursesTree11", new CourseDAO().getCourseOfferingsTree(11));
				if (session.getAttribute("coursesTree12") == null)
					session.setAttribute("coursesTree12", new CourseDAO().getCourseOfferingsTree(12));
				if (session.getAttribute("coursesTree13") == null)
					session.setAttribute("coursesTree13", new CourseDAO().getCourseOfferingsTree(13));
				if (session.getAttribute("coursesTree14") == null)
					session.setAttribute("coursesTree14", new CourseDAO().getCourseOfferingsTree(14));
				if (session.getAttribute("coursesTree15") == null)
					session.setAttribute("coursesTree15", new CourseDAO().getCourseOfferingsTree(15));
				if (session.getAttribute("coursesTree16") == null)
					session.setAttribute("coursesTree16", new CourseDAO().getCourseOfferingsTree(16));
				if (session.getAttribute("coursesTree17") == null)
					session.setAttribute("coursesTree17", new CourseDAO().getCourseOfferingsTree(17));
				
				request.setAttribute("coursesTree10", session.getAttribute("coursesTree10"));
				request.setAttribute("coursesTree11", session.getAttribute("coursesTree11"));
				request.setAttribute("coursesTree12", session.getAttribute("coursesTree12"));
				request.setAttribute("coursesTree13", session.getAttribute("coursesTree13"));
				request.setAttribute("coursesTree14", session.getAttribute("coursesTree14"));
				request.setAttribute("coursesTree15", session.getAttribute("coursesTree15"));
				request.setAttribute("coursesTree16", session.getAttribute("coursesTree16"));
				request.setAttribute("coursesTree17", session.getAttribute("coursesTree17"));
				
				
				//New ish testing
				ArrayList<LinkedHashMap<String, List<String>>> coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree10"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree11"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree12"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree13"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree14"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree15"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree16"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree17"));
				
				request.setAttribute("coursesTree", coursesTree);
				//End new ish
				
			} else if (request.getParameter("page").compareToIgnoreCase("area-i-foundation-courses") == 0) {
				session.setAttribute("page", "area-i-foundation-courses");
				session.setAttribute("jspfile", "/area-major.jsp");
				session.setAttribute("title", "AREA I: Foundation Courses");
				
				if (session.getAttribute("coursesTree3") == null)
					session.setAttribute("coursesTree3", new CourseDAO().getCourseOfferingsTree(3));
				
				request.setAttribute("coursesTree3", session.getAttribute("coursesTree3"));
				
				//New ish testing
				ArrayList<LinkedHashMap<String, List<String>>> coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree3"));
				
				request.setAttribute("coursesTree", coursesTree);
				//End new ish
				
			} else if (request.getParameter("page").compareToIgnoreCase("area-ii-sciences") == 0) {
				session.setAttribute("page", "area-ii-sciences");
				session.setAttribute("jspfile", "/area-major.jsp");
				session.setAttribute("title", "AREA II: Sciences");
				
				if (session.getAttribute("coursesTree4") == null)
					session.setAttribute("coursesTree4", new CourseDAO().getCourseOfferingsTree(4));
				if (session.getAttribute("coursesTree5") == null)
					session.setAttribute("coursesTree5", new CourseDAO().getCourseOfferingsTree(5));
				
				request.setAttribute("coursesTree4", session.getAttribute("coursesTree4"));
				request.setAttribute("coursesTree5", session.getAttribute("coursesTree5"));
				
				//New ish testing
				ArrayList<LinkedHashMap<String, List<String>>> coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree4"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree5"));
				
				request.setAttribute("coursesTree", coursesTree);
				//End new ish				
				
			} else if (request.getParameter("page").compareToIgnoreCase("area-iii-quantitative-reasoning") == 0) {
				session.setAttribute("page", "area-iii-quantitative-reasoning");
				session.setAttribute("jspfile", "/area-major.jsp");
				session.setAttribute("title", "AREA III: Quantitative Reasoning");
				
				if (session.getAttribute("coursesTree6") == null)
					session.setAttribute("coursesTree6", new CourseDAO().getCourseOfferingsTree(6));
				
				request.setAttribute("coursesTree6", session.getAttribute("coursesTree6"));
				
				//New ish testing
				ArrayList<LinkedHashMap<String, List<String>>> coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree6"));
				
				request.setAttribute("coursesTree", coursesTree);
				//End new ish
				
			} else if (request.getParameter("page").compareToIgnoreCase("area-iv-world-lang-culture-humanities-arts") == 0) {
				session.setAttribute("page", "area-iv-world-lang-culture-humanities-arts");
				session.setAttribute("jspfile", "/area-major.jsp");
				session.setAttribute("title", "AREA IV: World Lang & Culture, Humanities & Arts");
				
				if (session.getAttribute("coursesTree7") == null)
					session.setAttribute("coursesTree7", new CourseDAO().getCourseOfferingsTree(7));
				if (session.getAttribute("coursesTree8") == null)
					session.setAttribute("coursesTree8", new CourseDAO().getCourseOfferingsTree(8));
				
				request.setAttribute("coursesTree7", session.getAttribute("coursesTree7"));
				request.setAttribute("coursesTree8", session.getAttribute("coursesTree8"));
				
				
				//New ish testing
				ArrayList<LinkedHashMap<String, List<String>>> coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree7"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree8"));
				
				request.setAttribute("coursesTree", coursesTree);
				//End new ish	
				
			} else if (request.getParameter("page").compareToIgnoreCase("area-v-social-sciences") == 0) {
				session.setAttribute("page", "area-v-social-sciences");
				session.setAttribute("jspfile", "/area-major.jsp");
				session.setAttribute("title", "AREA V: Social Sciences");
				
				if (session.getAttribute("coursesTree9") == null)
					session.setAttribute("coursesTree9", new CourseDAO().getCourseOfferingsTree(9));
				
				request.setAttribute("coursesTree9", session.getAttribute("coursesTree9"));
				
				//New ish testing
				ArrayList<LinkedHashMap<String, List<String>>> coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree9"));
				
				request.setAttribute("coursesTree", coursesTree);
				//End new ish	
				
				
			} else if (request.getParameter("page").compareToIgnoreCase("area-f-vi-major-related-requirements") == 0) {
				session.setAttribute("page", "area-f-vi-major-related-requirements");
				session.setAttribute("jspfile", "/area-major.jsp");
				session.setAttribute("title", "AREA F/VI: Major Related Requirements");
				
				if (session.getAttribute("coursesTree18") == null)
					session.setAttribute("coursesTree18", new CourseDAO().getCourseOfferingsTree(18));
				
				request.setAttribute("coursesTree18", session.getAttribute("coursesTree18"));
				
				//New ish testing
				ArrayList<LinkedHashMap<String, List<String>>> coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree18"));
				
				request.setAttribute("coursesTree", coursesTree);
				//End new ish
				
			} else if (request.getParameter("page").compareToIgnoreCase("major-requirements") == 0) {
				session.setAttribute("page", "major-requirements");
				session.setAttribute("jspfile", "/area-major.jsp");
				session.setAttribute("title", "Major Requirements");
				
				if (session.getAttribute("coursesTree19") == null)
					session.setAttribute("coursesTree19", new CourseDAO().getCourseOfferingsTree(19));
				
				request.setAttribute("coursesTree19", session.getAttribute("coursesTree19"));
				
				//New ish testing
				ArrayList<LinkedHashMap<String, List<String>>> coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree19"));
				
				request.setAttribute("coursesTree", coursesTree);
				//End new ish
				
			} else if (request.getParameter("page").compareToIgnoreCase("schedule") == 0) {
				session.setAttribute("page", "schedule");
				session.setAttribute("jspfile", "/schedule.jsp");
				session.setAttribute("title", "My Schedule");
			} else if (request.getParameter("page").compareToIgnoreCase("welcome") == 0) {
				session.setAttribute("page", "welcome");
				session.setAttribute("jspfile", "/welcome.jsp");
				session.setAttribute("title", "UGA Course Picker");
			} else {
				session.setAttribute("page", "welcome");
				session.setAttribute("jspfile", "/welcome.jsp");
				session.setAttribute("title", "UGA Course Picker");
			}
		} else {
			session.setAttribute("page", "welcome");
			session.setAttribute("jspfile", "/welcome.jsp");
			session.setAttribute("title", "UGA Course Picker");
		}
		
		if (session.getAttribute("courses") != null)
			request.setAttribute("courses", session.getAttribute("courses"));
		else 
			session.setAttribute("courses", new ArrayList<String>());
		ctx.getRequestDispatcher(session.getAttribute("jspfile").toString()).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = this.getServletContext();
		HttpSession session = request.getSession();
		
		if (request.getParameter("userName") != null) {
			session.setAttribute("userName", request.getParameter("userName"));
			response.sendRedirect("/CoursePicker/CourseController?page=university-requirements");
		} else if (request.getParameter("addCourseCheckbox") != null) {
			
			String selected = request.getParameter("addCourseCheckbox");
			
			
			System.out.println(selected);

			
		
			
			session.setAttribute("selectedItem", selected);

			
			response.sendRedirect("/CoursePicker/CourseController?page=" + session.getAttribute("page"));
		}
		
		

		
		
//		//PickerDAO dao = new PickerDAO();
//
//		if (request.getParameter("coreCurriculumNumber")!= null) { //check null info first
//
//			//TODO possibly have one page handle all core reqs dynamically, rather than 6 pages?
//
//			if (request.getParameter("coreCurriculumNumber").equalsIgnoreCase("1")) { //goto core page 1
//				ctx.getRequestDispatcher("/core1.jsp").forward(request, response);
//				return;
//			}
//
//			else if (request.getParameter("coreCurriculumNumber").equalsIgnoreCase("2")) { //goto core page 2
//				ctx.getRequestDispatcher("/core2.jsp").forward(request, response);
//				return;
//			}
//
//			else if (request.getParameter("coreCurriculumNumber").equalsIgnoreCase("3")) { //goto core page 3
//				ctx.getRequestDispatcher("/core3.jsp").forward(request, response);
//				return;
//			}
//
//			else if (request.getParameter("coreCurriculumNumber").equalsIgnoreCase("4")) { //goto core page 4
//				ctx.getRequestDispatcher("/core4.jsp").forward(request, response);
//				return;
//			}
//
//			else if (request.getParameter("coreCurriculumNumber").equalsIgnoreCase("5")) { //goto core page 5
//				ctx.getRequestDispatcher("/core5.jsp").forward(request, response);
//				return;
//			}
//
//			else if (request.getParameter("coreCurriculumNumber").equalsIgnoreCase("6")) { //goto core page 6
//				ctx.getRequestDispatcher("/core6.jsp").forward(request, response);
//				return;
//			}
//
//			else{ //invalid core number, default to index
//				ctx.getRequestDispatcher("/index.jsp").forward(request, response);
//				return;
//			}
//		}
//
//		if(!(request.getParameter("courseSection").equals("--Select Course--"))) { //check empty input
//
//			//add course to schedule
//
//			//TODO handle all possible conflicts - same course, same time, overlaps, etc, need server side error handling?
//			//possible to check here depending on structure of other code
//
//			//the course is only stored in the session, so there should be no need to store anything in the DB
//			//session.setAttribute("courseList", courseList object);
//
//			ctx.getRequestDispatcher("/schedulePage.jsp").forward(request, response);
//			return;
//		}
//
//
//		else if(request.getParameter("courseSection").equals("--Select Course--")) { //no course selected, just do nothing or display a message
//			//possible to handle this with javascript instead?
//			//will leave server side handling implemented for now just in case
//			request.setAttribute("error", "You must select a course to be added");
//			ctx.getRequestDispatcher("/schedulePage.jsp").forward(request, response);
//			return;
//		}
//
//		if (request.getParameter("schedulePageFlag") != null) { //check null input
//
//			if (request.getParameter("schedulePageFlag").equals("true")){ //go straight to schedule page
//
//				ctx.getRequestDispatcher("/schedulePage.jsp").forward(request, response);
//				return;
//			}
//		}
//
//		//last chance handling, if no other flags present, go straight to main page
//		ctx.getRequestDispatcher("/index.jsp").forward(request, response);
//		return;
	}
}

