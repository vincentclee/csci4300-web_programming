package coursepicker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class CourseDAO {
	/**
	 * Connect to DB and create PreparedStatements
	 */
	public CourseDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("<Instantiated MySQL driver!>");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/CoursePicker", "root", "mysql");
			System.out.println("<Connected to MySQL!>");
			
			//Prepared statements used to query database - CourseOfferingFall2013
			listCourseOfferingsStatement = conn.prepareStatement("select * from CourseOfferingFall2013");
			clearCourseOfferingsStatement = conn.prepareStatement("delete from CourseOfferingFall2013");
			
			//Prepared statements used to query database - CSCoursesRequirements
			listCoursesRequirementsStatement = conn.prepareStatement("select * from CSCoursesRequirements");
			clearCoursesRequirementsStatement = conn.prepareStatement("delete from CSCoursesRequirements");
		} catch(Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	//CourseOfferingFall2013
	PreparedStatement listCourseOfferingsStatement; //Statement to list all the courses and data from the CourseOfferingFall2013 table
	PreparedStatement clearCourseOfferingsStatement; //Statement to delete all the courses and data from the CourseOfferingFall2013 table
	
	//CSCoursesRequirements
	PreparedStatement listCoursesRequirementsStatement; //Statement to list all the courses required from the CSCoursesRequirements table
	PreparedStatement clearCoursesRequirementsStatement; //Statement to delete all the courses required from the CSCoursesRequirements table
	

	public LinkedHashMap<String, List<String>> getCourseOfferingsTree(int section) {
		try {
			LinkedHashMap<String, List<String>> requirementsMap = new LinkedHashMap<String, List<String>>();
			int counter = 0;
			ResultSet rs = listCoursesRequirementsStatement.executeQuery();
			
			while (rs.next()) {
				if (rs.getInt("id") == section) {
					String coursePrefix = rs.getString("CoursePrefix").trim();
					String courseNum = rs.getString("CourseNum").trim();
					
					if (requirementsMap.containsKey(coursePrefix)) {
						requirementsMap.get(coursePrefix).add(courseNum);
						counter++;
					} else {
						requirementsMap.put(coursePrefix, new ArrayList<String>());
						requirementsMap.get(coursePrefix).add(courseNum);
						counter++;
					}
				}
			}
			
			//Change table
			rs = listCourseOfferingsStatement.executeQuery();
			LinkedHashMap<String, List<String>> classesMap = new LinkedHashMap<String, List<String>>();
			int courses = 0; 
			
			//TODO: Still need to handle * classes in classesMap  2300*
			while (rs.next()) {
				if (rs.getString("Avail").trim().compareToIgnoreCase("Cancelled") != 0) {
					if (requirementsMap.containsKey(rs.getString("CoursePrefix").trim())) {
						if (requirementsMap.get(rs.getString("CoursePrefix").trim()).contains(rs.getString("CourseNum").trim())) {
							String callNum = rs.getString("CallNum").trim();
							
							if (classesMap.containsKey(callNum)) {
								if (classesMap.get(callNum).contains(rs.getString("Days").trim()) && 
										classesMap.get(callNum).contains(rs.getString("PeriodBgn").trim()) && 
										classesMap.get(callNum).contains(rs.getString("PeriodEnd").trim()) && 
										classesMap.get(callNum).contains(rs.getString("Bldg").trim()) && 
										classesMap.get(callNum).contains(rs.getString("Room").trim())) {
								} else {
									classesMap.get(callNum).add(rs.getString("Days").trim());
									classesMap.get(callNum).add(rs.getString("PeriodBgn").trim());
									classesMap.get(callNum).add(rs.getString("PeriodEnd").trim());
									classesMap.get(callNum).add(rs.getString("Bldg").trim());
									classesMap.get(callNum).add(rs.getString("Room").trim());
								}
							} else {
								classesMap.put(callNum, new ArrayList<String>());
								classesMap.get(callNum).add(rs.getString("CoursePrefix").trim());
								classesMap.get(callNum).add(rs.getString("CourseNum").trim());
								classesMap.get(callNum).add(rs.getString("CrdHrs").trim());
								classesMap.get(callNum).add(rs.getString("CourseTitle").trim());
								
								if (rs.getString("Instructor").trim().compareToIgnoreCase("null") == 0)
									classesMap.get(callNum).add("STAFF");
								else
									classesMap.get(callNum).add(rs.getString("Instructor").trim());
								
								if (rs.getString("Avail").trim().compareToIgnoreCase("Available") == 0)
									classesMap.get(callNum).add("Avail");
								else if (rs.getString("Avail").trim().compareToIgnoreCase("Full") == 0)
									classesMap.get(callNum).add("Full");
								
								
								classesMap.get(callNum).add(rs.getString("Days").trim());
								classesMap.get(callNum).add(rs.getString("PeriodBgn").trim());
								classesMap.get(callNum).add(rs.getString("PeriodEnd").trim());
								classesMap.get(callNum).add(rs.getString("Bldg").trim());
								classesMap.get(callNum).add(rs.getString("Room").trim());
								
								courses++;
							}
						}
					}
				}
			}
			
			
			//Print out Array
			System.out.println("getCourseOfferingsTree(" + section + "):");
			System.out.println("\tMatches: " + counter);
			Iterator<String> iterator = requirementsMap.keySet().iterator();
			while (iterator.hasNext()) {
				String arrayName = iterator.next();
				List<String> list = requirementsMap.get(arrayName);
				System.out.print("\t" + arrayName + ":[");
				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i));
					if (i < list.size()-1)
						System.out.print(", ");
				}
				System.out.println("]");
			}
			
			System.out.println("\n\tCourses: " + courses);
			Iterator<String> iterator1 = classesMap.keySet().iterator();
			while (iterator1.hasNext()) {
				String arrayName = iterator1.next();
				List<String> list = classesMap.get(arrayName);
				System.out.print("\t" + arrayName + ":[");
				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i));
					if (i < list.size()-1)
						System.out.print(", ");
				}
				System.out.println("]");
			}
			
			return classesMap;
		} catch (Exception e) {
			 System.out.println("Error in getCourseOfferingsTree():\n" + e.getClass().getName() + ": " + e.getMessage());
		}
		
		return new LinkedHashMap<String, List<String>>();
	}
}