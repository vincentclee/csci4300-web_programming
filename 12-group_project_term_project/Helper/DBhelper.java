/**
 * @author Micah Meggs
 */
package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class DBhelper {

	
	//TODO add variables
	private static String JDBC_URL = "jdbc:mysql://localhost/cs4300";
	
	private PreparedStatement listCourseOfferingStatement;
	private int courseId;

	private PreparedStatement listCoursesByRequirementStatement;
	
	
	//TODO add PreparedStatements for accessing and updating database variables
	
	/**
	 * constructor
	 * initializes a connection to database and preparedStatements
	 */
	public DBhelper(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL, "root", "micah2011!");
			System.out.println("Connected to cs4300 database");
			
			listCourseOfferingStatement = conn.prepareStatement("select id, Term, CallNum, CoursePrefix, CourseNum, CourseTitle, Instructor, Avail, CrdHrs, Sess, Days, PeriodBgn, PeriodEnd, Bldg, Room from CourseOfferingFall2013");
			listCoursesByRequirementStatement = conn.prepareStatement("select id, CoursePrefix, CourseNum from CSCoursesRequirements");
		}
		catch(Exception e){
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}	
	
	/**
	 * creates a list of Courses Offered in fall 2013 from CourseOfferingsFall2013
	 * @return list of courses
	 */
	public ArrayList<Course> getCourseOfferingList(){
		ArrayList<Course> list = new ArrayList<Course>();
		try{
			ResultSet rs = listCourseOfferingStatement.executeQuery();
			
			while(rs.next()){
				
				int id = rs.getInt("id");
				courseId = id;
				int Term = rs.getInt("Term"); 
				int CallNum = rs.getInt("CallNum");
				String CoursePrefix = rs.getString("CoursePrefix");
				String CourseNum = rs.getString("CourseNum");
				String CourseTitle = rs.getString("CourseTitle");
				String Instructor = rs.getString("Instructor");
				String Avail = rs.getString("Avail");
				double CrdHrs = rs.getDouble("CrdHrs");
				String Sess = rs.getString("Sess");
				String Days = rs.getString("Days");
				String PeriodBgn = rs.getString("PeriodBgn");
				String PeriodEnd = rs.getString("PeriodEnd");
				String Bldg = rs.getString("Bldg");
				String Room = rs.getString("Room");
				Course course = new Course(courseId);
				
				list.add(course);
			}//End of while loop
		}catch(Exception e){
			System.out.println("Error populating Course Offering list\n" + e.getClass().getName() + ": " + e.getMessage());
		}
		return list;
	}

	public Course getCourseById(int id){
		ArrayList<Course> list = getCourseOfferingList();
		/**
		 * iterates through list of courses
		 * and returns course with matching id
		 */
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getCourseId() == id){
				return list.get(i);
			}
		}
		
		return null;
	}
	
	
	
	/* 
	|  1 | Cultural Diversity Requirement                     |
	|  2 | Environmental Literacy Requirement                 |
	|  3 | Core Curriculum I: Foundation Courses              |
	|  4 | Core Curriculum II: Physical Sciences              |
	|  5 | Core Curriculum II: Life Sciences                  |
	|  6 | Core Curriculum III: Quantitative Reasoning        |
	|  7 | Core Curriculum IV: World Languages and Culture    |
	|  8 | Core Curriculum IV: Humanities and Arts            |
	|  9 | Core Curriculum V: Social Sciences                 |
	| 10 | Franklin College Foreign Language                  |
	| 11 | Franklin College Literature                        |
	| 12 | Franklin College Fine Arts/Philosophy/Religion     |
	| 13 | Franlin College History                            |
	| 14 | Franklin CollegeSocial Sciences other than History |
	| 15 | Franklin College Biological Sciences               |
	| 16 | Franklin College:Physical Sciences                 |
	| 17 | Franklin College Multicultural Requirement         |
	| 18 | Core CurriculumVI: Major related courses           |
	| 19 | Computer Science Major Courses   
	 */
	public ArrayList<Course>getCoursesByRequirement(int requirementId){
		ArrayList<String> prefixList = new ArrayList<String>();
		ArrayList<String> numberList = new ArrayList<String>();
		ArrayList<Course> courseList = new ArrayList<Course>();
		ArrayList<Course> fullCourseList = getCourseOfferingList();
		try{
			ResultSet rs = listCoursesByRequirementStatement.executeQuery();
			
			while(rs.next()){
				
				int id = rs.getInt("id");
				if(id == requirementId){
				prefixList.add(rs.getString("CoursePrefix"));
				numberList.add(rs.getString("CourseNum"));
				}	
			}//End of while loop
			
			for(int i = 0; i < fullCourseList.size(); i++){
				for(int j = 0; j < numberList.size(); j++){
				if(fullCourseList.get(i).getCoursePrefix().equals(prefixList.get(j)) && fullCourseList.get(i).getCourseNum().equals(numberList.get(j))){
					courseList.add(fullCourseList.get(i));
				}
				}	
			}
		}catch(Exception e){
			System.out.println("Error populating CourseByRequirement list\n" + e.getClass().getName() + ": " + e.getMessage());
		}
		return courseList;
		
	}
	/**
	 * 
	 * @param courseId id of current course
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	
}