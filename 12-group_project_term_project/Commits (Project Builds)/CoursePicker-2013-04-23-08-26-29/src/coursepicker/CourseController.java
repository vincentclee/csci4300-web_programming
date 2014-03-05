package coursepicker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
 * Servlet implementation class CourseController
 * @author Alex Tozzi
 */
@WebServlet("/CourseController")
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * @author Alex Tozzi
	 */
	public CourseController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @author Alex Tozzi
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = this.getServletContext();
		HttpSession session = request.getSession();
		
		if (request.getParameter("page") != null) {
			if (request.getParameter("page").compareToIgnoreCase("university-requirements") == 0) {
				session.setAttribute("page", "university-requirements");
				session.setAttribute("jspfile", "/area-major.jsp");
				session.setAttribute("title", "University Requirements");
				
				if (session.getAttribute("coursesTree1") == null || session.getAttribute("coursesTree2") == null) {
					session.setAttribute("coursesTree1", new CourseDAO().getCourseOfferingsTree(1));
					session.setAttribute("coursesTree2", new CourseDAO().getCourseOfferingsTree(2));
				}
				
				ArrayList<LinkedHashMap<String, List<String>>> coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree1"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree2"));
				
				ArrayList<String> requirements = new ArrayList<String>();
				requirements.add("Cultural Diversity Requirement");
				requirements.add("Environmental Literacy Requirement");
				
				//Session Variables
				session.setAttribute("coursesTree", coursesTree);
				
				//Request Variables
				request.setAttribute("coursesTree", coursesTree);
				request.setAttribute("requirementsList", requirements);
			} else if (request.getParameter("page").compareToIgnoreCase("franklin-college-requirements") == 0) {
				session.setAttribute("page", "franklin-college-requirements");
				session.setAttribute("jspfile", "/area-major.jsp");
				session.setAttribute("title", "Franklin College Requirements");
				
				if (session.getAttribute("coursesTree10") == null || session.getAttribute("coursesTree11") == null || 
						session.getAttribute("coursesTree12") == null || session.getAttribute("coursesTree13") == null || 
						session.getAttribute("coursesTree14") == null || session.getAttribute("coursesTree15") == null || 
						session.getAttribute("coursesTree16") == null || session.getAttribute("coursesTree17") == null) {
					session.setAttribute("coursesTree10", new CourseDAO().getCourseOfferingsTree(10));
					session.setAttribute("coursesTree11", new CourseDAO().getCourseOfferingsTree(11));
					session.setAttribute("coursesTree12", new CourseDAO().getCourseOfferingsTree(12));
					session.setAttribute("coursesTree13", new CourseDAO().getCourseOfferingsTree(13));
					session.setAttribute("coursesTree14", new CourseDAO().getCourseOfferingsTree(14));
					session.setAttribute("coursesTree15", new CourseDAO().getCourseOfferingsTree(15));
					session.setAttribute("coursesTree16", new CourseDAO().getCourseOfferingsTree(16));
					session.setAttribute("coursesTree17", new CourseDAO().getCourseOfferingsTree(17));
				}
				
				ArrayList<LinkedHashMap<String, List<String>>> coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree10"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree11"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree12"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree13"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree14"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree15"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree16"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree17"));
				
				ArrayList<String> requirements = new ArrayList<String>();
				requirements.add("Foreign Language");
				requirements.add("Literature");
				requirements.add("Fine Arts/Philosophy/Religion");
				requirements.add("History");
				requirements.add("Social Sciences other than History");
				requirements.add("Biological Sciences");
				requirements.add("Physical Sciences");
				requirements.add("Multicultural Requirement");
				
				//Session Variables
				session.setAttribute("coursesTree", coursesTree);
				
				//Request Variables
				request.setAttribute("coursesTree", coursesTree);
				request.setAttribute("requirementsList", requirements);
			} else if (request.getParameter("page").compareToIgnoreCase("area-i-foundation-courses") == 0) {
				session.setAttribute("page", "area-i-foundation-courses");
				session.setAttribute("jspfile", "/area-major.jsp");
				session.setAttribute("title", "AREA I: Foundation Courses");
				
				if (session.getAttribute("coursesTree3") == null)
					session.setAttribute("coursesTree3", new CourseDAO().getCourseOfferingsTree(3));
				
				ArrayList<LinkedHashMap<String, List<String>>> coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree3"));
				
				ArrayList<String> requirements = new ArrayList<String>();
				requirements.add("Core Curriculum I: Foundation Courses");
				
				//Session Variables
				session.setAttribute("coursesTree", coursesTree);
				
				//Request Variables
				request.setAttribute("coursesTree", coursesTree);
				request.setAttribute("requirementsList", requirements);
			} else if (request.getParameter("page").compareToIgnoreCase("area-ii-sciences") == 0) {
				session.setAttribute("page", "area-ii-sciences");
				session.setAttribute("jspfile", "/area-major.jsp");
				session.setAttribute("title", "AREA II: Sciences");
				
				if (session.getAttribute("coursesTree4") == null || session.getAttribute("coursesTree5") == null) {
					session.setAttribute("coursesTree4", new CourseDAO().getCourseOfferingsTree(4));
					session.setAttribute("coursesTree5", new CourseDAO().getCourseOfferingsTree(5));
				}
				
				ArrayList<LinkedHashMap<String, List<String>>> coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree4"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree5"));
				
				ArrayList<String> requirements = new ArrayList<String>();
				requirements.add("Core Curriculum II: Physical Sciences");
				requirements.add("Core Curriculum II: Life Sciences");
				
				//Session Variables
				session.setAttribute("coursesTree", coursesTree);
				
				//Request Variables
				request.setAttribute("coursesTree", coursesTree);
				request.setAttribute("requirementsList", requirements);
			} else if (request.getParameter("page").compareToIgnoreCase("area-iii-quantitative-reasoning") == 0) {
				session.setAttribute("page", "area-iii-quantitative-reasoning");
				session.setAttribute("jspfile", "/area-major.jsp");
				session.setAttribute("title", "AREA III: Quantitative Reasoning");
				
				if (session.getAttribute("coursesTree6") == null)
					session.setAttribute("coursesTree6", new CourseDAO().getCourseOfferingsTree(6));
				
				ArrayList<LinkedHashMap<String, List<String>>> coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree6"));
				
				ArrayList<String> requirements = new ArrayList<String>();
				requirements.add("Core Curriculum III: Quantitative Reasoning");
				
				//Session Variables
				session.setAttribute("coursesTree", coursesTree);
				
				//Request Variables
				request.setAttribute("coursesTree", coursesTree);
				request.setAttribute("requirementsList", requirements);
			} else if (request.getParameter("page").compareToIgnoreCase("area-iv-world-lang-culture-humanities-arts") == 0) {
				session.setAttribute("page", "area-iv-world-lang-culture-humanities-arts");
				session.setAttribute("jspfile", "/area-major.jsp");
				session.setAttribute("title", "AREA IV: World Lang & Culture, Humanities & Arts");
				
				if (session.getAttribute("coursesTree7") == null || session.getAttribute("coursesTree8") == null) {
					session.setAttribute("coursesTree7", new CourseDAO().getCourseOfferingsTree(7));
					session.setAttribute("coursesTree8", new CourseDAO().getCourseOfferingsTree(8));
				}
				
				ArrayList<LinkedHashMap<String, List<String>>> coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree7"));
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree8"));
				
				ArrayList<String> requirements = new ArrayList<String>();
				requirements.add("Core Curriculum IV: World Languages and Culture");
				requirements.add("Core Curriculum IV: Humanities and Arts");
				
				//Session Variables
				session.setAttribute("coursesTree", coursesTree);
				
				//Request Variables
				request.setAttribute("coursesTree", coursesTree);
				request.setAttribute("requirementsList", requirements);
			} else if (request.getParameter("page").compareToIgnoreCase("area-v-social-sciences") == 0) {
				session.setAttribute("page", "area-v-social-sciences");
				session.setAttribute("jspfile", "/area-major.jsp");
				session.setAttribute("title", "AREA V: Social Sciences");
				
				if (session.getAttribute("coursesTree9") == null)
					session.setAttribute("coursesTree9", new CourseDAO().getCourseOfferingsTree(9));
				
				ArrayList<LinkedHashMap<String, List<String>>> coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree9"));
				
				ArrayList<String> requirements = new ArrayList<String>();
				requirements.add("Core Curriculum V: Social Sciences");
				
				//Session Variables
				session.setAttribute("coursesTree", coursesTree);
				
				//Request Variables
				request.setAttribute("coursesTree", coursesTree);
				request.setAttribute("requirementsList", requirements);
			} else if (request.getParameter("page").compareToIgnoreCase("area-f-vi-major-related-requirements") == 0) {
				session.setAttribute("page", "area-f-vi-major-related-requirements");
				session.setAttribute("jspfile", "/area-major.jsp");
				session.setAttribute("title", "AREA F/VI: Major Related Requirements");
				
				if (session.getAttribute("coursesTree18") == null)
					session.setAttribute("coursesTree18", new CourseDAO().getCourseOfferingsTree(18));
				
				ArrayList<LinkedHashMap<String, List<String>>> coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree18"));
				
				ArrayList<String> requirements = new ArrayList<String>();
				requirements.add("Core Curriculum VI: Major related courses");
				
				//Session Variables
				session.setAttribute("coursesTree", coursesTree);
				
				//Request Variables
				request.setAttribute("coursesTree", coursesTree);
				request.setAttribute("requirementsList", requirements);
			} else if (request.getParameter("page").compareToIgnoreCase("major-requirements") == 0) {
				session.setAttribute("page", "major-requirements");
				session.setAttribute("jspfile", "/area-major.jsp");
				session.setAttribute("title", "Major Requirements");
				
				if (session.getAttribute("coursesTree19") == null)
					session.setAttribute("coursesTree19", new CourseDAO().getCourseOfferingsTree(19));
				
				ArrayList<LinkedHashMap<String, List<String>>> coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
				coursesTree.add((LinkedHashMap<String, List<String>>)session.getAttribute("coursesTree19"));
				
				ArrayList<String> requirements = new ArrayList<String>();
				requirements.add("Computer Science Major Courses");
				
				//Session Variables
				session.setAttribute("coursesTree", coursesTree);
				
				//Request Variables
				request.setAttribute("coursesTree", coursesTree);
				request.setAttribute("requirementsList", requirements);
			} else if (request.getParameter("page").compareToIgnoreCase("schedule") == 0) {
				//Session Variables
				session.setAttribute("page", "schedule");
				session.setAttribute("jspfile", "/schedule.jsp");
				session.setAttribute("title", "My Schedule");
			} else {
				//Session Variables
				session.setAttribute("page", "welcome");
				session.setAttribute("jspfile", "/welcome.jsp");
				session.setAttribute("title", "UGA Course Picker");
			}
		} else {
			//Session Variables
			session.setAttribute("page", "welcome");
			session.setAttribute("jspfile", "/welcome.jsp");
			session.setAttribute("title", "UGA Course Picker");
		}
		
		if (session.getAttribute("scheduleList") != null && session.getAttribute("scheduleTree") != null) {
			//Request Variables
			request.setAttribute("scheduleList", session.getAttribute("scheduleList"));
			request.setAttribute("scheduleTree", session.getAttribute("scheduleTree"));
		} else {
			//Session Variables
			session.setAttribute("scheduleList", new ArrayList<String>());
			session.setAttribute("scheduleTree", new LinkedHashMap<String, List<String>>());
		}
		
		ctx.getRequestDispatcher(session.getAttribute("jspfile").toString()).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @author Alex Tozzi
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = this.getServletContext();
		HttpSession session = request.getSession();
		
		if (request.getParameter("userName") != null) {
			//Session Variables
			session.setAttribute("userName", request.getParameter("userName"));
			
			//Redirection
			response.sendRedirect("/CoursePicker/CourseController?page=university-requirements");
		} else if (request.getParameter("addCourseCheckbox") != null) {
			String selected = request.getParameter("addCourseCheckbox");
			System.out.println("addCheckbox selection: " + selected);
						
			@SuppressWarnings("unchecked")
			Schedule schedule = new Schedule((ArrayList<String>)session.getAttribute("scheduleList"), (LinkedHashMap<String, List<String>>) session.getAttribute("scheduleTree"), (ArrayList<LinkedHashMap<String, List<String>>>) session.getAttribute("coursesTree"));
			schedule.addClass(selected);
			
			//Session Variables
			session.setAttribute("scheduleTree", schedule.getScheduleTree());
			session.setAttribute("scheduleList", schedule.getScheduleList());
			
			//Redirection
			response.sendRedirect("/CoursePicker/CourseController?page=" + session.getAttribute("page"));
		} else if (request.getParameter("deleteCourses") != null) {
			String[] selections = request.getParameterValues("deleteCourses");
			System.out.println("deleteCheckbox selection(s): " + Arrays.toString(selections));
			
			@SuppressWarnings("unchecked")
			Schedule schedule = new Schedule((ArrayList<String>) session.getAttribute("scheduleList"), (LinkedHashMap<String, List<String>>) session.getAttribute("scheduleTree"));
			schedule.deleteClasses(selections);
			
			//Session Variables
			session.setAttribute("scheduleTree", schedule.getScheduleTree());
			session.setAttribute("scheduleList", schedule.getScheduleList());
			
			//Redirection
			response.sendRedirect("/CoursePicker/CourseController?page=" + session.getAttribute("page"));
		} else {
			//Redirection
			response.sendRedirect("/CoursePicker/CourseController?page=" + session.getAttribute("page"));
		}
	}
}
