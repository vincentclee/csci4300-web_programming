package coursepicker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
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
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = this.getServletContext();
		HttpSession session = request.getSession();
		

		

//
//		
//		
//		ctx.getRequestDispatcher("/graph.jsp").forward(request, response);

		
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
		
		//Schedule Items
		if (session.getAttribute("scheduleList") != null && session.getAttribute("scheduleTree") != null && session.getAttribute("classMeetings") != null) {
			//Request Variables
			request.setAttribute("scheduleList", session.getAttribute("scheduleList"));
			request.setAttribute("scheduleTree", session.getAttribute("scheduleTree"));
			request.setAttribute("classMeetings", session.getAttribute("classMeetings"));
			request.setAttribute("JSONprefix", session.getAttribute("JSONprefix"));
			request.setAttribute("JSONnumber", session.getAttribute("JSONnumber"));
			request.setAttribute("JSONtitle", session.getAttribute("JSONtitle"));
			request.setAttribute("JSONinstructor", session.getAttribute("JSONinstructor"));
			request.setAttribute("JSONday", session.getAttribute("JSONday"));
			request.setAttribute("JSONstartTime", session.getAttribute("JSONstartTime"));
			request.setAttribute("JSONendTime", session.getAttribute("JSONendTime"));
			request.setAttribute("JSONbuilding", session.getAttribute("JSONbuilding"));
			request.setAttribute("JSONroom", session.getAttribute("JSONroom"));
			request.setAttribute("JSONposX", session.getAttribute("JSONposX"));
			request.setAttribute("JSONposY", session.getAttribute("JSONposY"));
			request.setAttribute("JSONheight", session.getAttribute("JSONheight"));
		} else {
			//Session Variables
			session.setAttribute("scheduleList", new ArrayList<String>());
			session.setAttribute("scheduleTree", new LinkedHashMap<String, List<String>>());
			session.setAttribute("classMeetings", new ArrayList<Meeting>());
		}
		
		ctx.getRequestDispatcher(session.getAttribute("jspfile").toString()).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @author Alex Tozzi
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (request.getParameter("addCourseCheckbox") != null) {
			String selected = request.getParameter("addCourseCheckbox");
			System.out.println("addCheckbox selection: " + selected);
						
			Schedule checker = new Schedule((ArrayList<LinkedHashMap<String, List<String>>>) session.getAttribute("coursesTree"));
			ArrayList<Meeting> temp = checker.getClass(selected);
					
			if (new Meeting().checkFullSchedule(temp, (ArrayList<Meeting>) session.getAttribute("classMeetings"))) {			
				Schedule schedule = new Schedule((ArrayList<String>) session.getAttribute("scheduleList"), 
						(LinkedHashMap<String, List<String>>) session.getAttribute("scheduleTree"), 
						(ArrayList<LinkedHashMap<String, List<String>>>) session.getAttribute("coursesTree"), 
						(ArrayList<Meeting>) session.getAttribute("classMeetings"));
				schedule.addClass(selected);

				
				//JSON Parsing
				ArrayList<Meeting> classMeetings = schedule.getClassMeetings();
				
				String JSONprefix = "";
				String JSONnumber = "";
				String JSONtitle = "";
				String JSONinstructor = "";
				String JSONday = "";
				String JSONstartTime = "";
				String JSONendTime = "";
				String JSONbuilding = "";
				String JSONroom = "";
				String JSONposX = "";
				String JSONposY = "";
				String JSONheight = "";
				
				for (int i = 0; i < classMeetings.size(); i++) {
					JSONprefix += classMeetings.get(i).getPrefix();
					JSONnumber += classMeetings.get(i).getNumber();
					JSONtitle += classMeetings.get(i).getTitle();
					JSONinstructor += classMeetings.get(i).getInstructor();
					JSONday += classMeetings.get(i).getDay();
					JSONstartTime += classMeetings.get(i).getStartTime();
					JSONendTime += classMeetings.get(i).getEndTime();
					JSONbuilding += classMeetings.get(i).getBuilding();
					JSONroom += classMeetings.get(i).getRoom();
					JSONposX += classMeetings.get(i).getPixelX();
					JSONposY += classMeetings.get(i).getPixelY();
					JSONheight += classMeetings.get(i).getHeight();
					if (i < classMeetings.size()-1) {
						JSONprefix += "\", \"";
						JSONnumber += "\", \"";
						JSONtitle += "\", \"";
						JSONinstructor += "\", \"";
						JSONday += "\", \"";
						JSONstartTime += "\", \"";
						JSONendTime += "\", \"";
						JSONbuilding += "\", \"";
						JSONroom += "\", \"";
						JSONposX += "\", \"";
						JSONposY += "\", \"";
						JSONheight += "\", \"";
					}
				}
				
				
				//Session Variables
				session.setAttribute("scheduleTree", schedule.getScheduleTree());
				session.setAttribute("scheduleList", schedule.getScheduleList());
				session.setAttribute("classMeetings", schedule.getClassMeetings());
				session.setAttribute("JSONprefix", JSONprefix);
				session.setAttribute("JSONnumber", JSONnumber);
				session.setAttribute("JSONtitle", JSONtitle);
				session.setAttribute("JSONinstructor", JSONinstructor);
				session.setAttribute("JSONday", JSONday);
				session.setAttribute("JSONstartTime", JSONstartTime);
				session.setAttribute("JSONendTime", JSONendTime);
				session.setAttribute("JSONbuilding", JSONbuilding);
				session.setAttribute("JSONroom", JSONroom);
				session.setAttribute("JSONposX", JSONposX);
				session.setAttribute("JSONposY", JSONposY);
				session.setAttribute("JSONheight", JSONheight);
			} else {
				//TODO: return error.
				System.out.println("Class not added becuase of time/conflicts");
			}
			
			
			
			
			
			// String prefix, String number, String title, String instructor, String day, String startTime, String endTime, String building, String room
			
//			ArrayList<Meeting> classMeetings = new ArrayList<Meeting>();
//			classMeetings.add(new Meeting("CSCI", "4800", "HUMAN-COMP INTERACT", "PLAUE", "M", "1115A", "1205P", "1023", "0306"));
//			classMeetings.add(new Meeting("CSCI", "4800", "HUMAN-COMP INTERACT", "PLAUE", "T", "1100A", "1215P", "1031", "0102"));
//			classMeetings.add(new Meeting("CSCI", "4800", "HUMAN-COMP INTERACT", "PLAUE", "R", "1100A", "1215P", "1031", "0102"));
//			
			
			
			
//			Meeting meetings = new Meeting();
			
			
			//   43957:[CSCI, 4800, 4.0, HUMAN-COMP INTERACT, PLAUE, Avail, M, 1115A, 1205P, 1023, 0306, T R, 1100A, 1215P, 1031, 0102]
			
//			String posX = 
//			stringArray+=classMeetings.get(0);
			
			
//		
//			System.out.println(classMeetings.get(0).getPixelX());
//			System.out.println(classMeetings.get(0).getPixelY());
//			System.out.println(classMeetings.get(0).getHeight());
//			JSONposX+="\"";
//			JSONposY+="\"";
//			JSONheight+="\"";
			
			
//			request.setAttribute("", stringArray);
//			request.setAttribute("", stringArray);
//			request.setAttribute("", stringArray);
//			request.setAttribute("", stringArray);
//			request.setAttribute("JSONposX", JSONposX);
//			request.setAttribute("JSONposY", JSONposY);
//			request.setAttribute("JSONheight", JSONheight);
			
			

			
			
			
			
			
			
			
			
			

			
			//Redirection
			response.sendRedirect("/CoursePicker/CourseController?page=" + session.getAttribute("page"));
		} else if (request.getParameter("deleteCourses") != null) {
			String[] selections = request.getParameterValues("deleteCourses");
			System.out.println("deleteCheckbox selection(s): " + Arrays.toString(selections));
			
			@SuppressWarnings("unchecked")
			Schedule schedule = new Schedule((ArrayList<String>) session.getAttribute("scheduleList"), (LinkedHashMap<String, List<String>>) session.getAttribute("scheduleTree"));
			schedule.deleteClasses(selections);
			
			//JSON Parsing
			ArrayList<Meeting> classMeetings = schedule.getClassMeetings();
			
			String JSONprefix = "";
			String JSONnumber = "";
			String JSONtitle = "";
			String JSONinstructor = "";
			String JSONday = "";
			String JSONstartTime = "";
			String JSONendTime = "";
			String JSONbuilding = "";
			String JSONroom = "";
			String JSONposX = "";
			String JSONposY = "";
			String JSONheight = "";
			
			for (int i = 0; i < classMeetings.size(); i++) {
				JSONprefix += classMeetings.get(i).getPrefix();
				JSONnumber += classMeetings.get(i).getNumber();
				JSONtitle += classMeetings.get(i).getTitle();
				JSONinstructor += classMeetings.get(i).getInstructor();
				JSONday += classMeetings.get(i).getDay();
				JSONstartTime += classMeetings.get(i).getStartTime();
				JSONendTime += classMeetings.get(i).getEndTime();
				JSONbuilding += classMeetings.get(i).getBuilding();
				JSONroom += classMeetings.get(i).getRoom();
				JSONposX += classMeetings.get(i).getPixelX();
				JSONposY += classMeetings.get(i).getPixelY();
				JSONheight += classMeetings.get(i).getHeight();
				if (i < classMeetings.size()-1) {
					JSONprefix += "\", \"";
					JSONnumber += "\", \"";
					JSONtitle += "\", \"";
					JSONinstructor += "\", \"";
					JSONday += "\", \"";
					JSONstartTime += "\", \"";
					JSONendTime += "\", \"";
					JSONbuilding += "\", \"";
					JSONroom += "\", \"";
					JSONposX += "\", \"";
					JSONposY += "\", \"";
					JSONheight += "\", \"";
				}
			}
			
			
			//Session Variables
			session.setAttribute("scheduleTree", schedule.getScheduleTree());
			session.setAttribute("scheduleList", schedule.getScheduleList());
			session.setAttribute("classMeetings", schedule.getClassMeetings());
			session.setAttribute("JSONprefix", JSONprefix);
			session.setAttribute("JSONnumber", JSONnumber);
			session.setAttribute("JSONtitle", JSONtitle);
			session.setAttribute("JSONinstructor", JSONinstructor);
			session.setAttribute("JSONday", JSONday);
			session.setAttribute("JSONstartTime", JSONstartTime);
			session.setAttribute("JSONendTime", JSONendTime);
			session.setAttribute("JSONbuilding", JSONbuilding);
			session.setAttribute("JSONroom", JSONroom);
			session.setAttribute("JSONposX", JSONposX);
			session.setAttribute("JSONposY", JSONposY);
			session.setAttribute("JSONheight", JSONheight);
			
			//Redirection
			response.sendRedirect("/CoursePicker/CourseController?page=" + session.getAttribute("page"));
		} else {
			//Redirection
			response.sendRedirect("/CoursePicker/CourseController?page=" + session.getAttribute("page"));
		}
	}
}
