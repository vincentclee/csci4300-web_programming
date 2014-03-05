package coursepicker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Handles database access for the Course Picker project
 * @author Vincent Lee
 * @author Johnathan Meggs
 *
 */
public class CourseDAO {
	/**
	 * Connect to the database and creates PreparedStatements
	 * @author Vincent Lee
	 * @author Johnathan Meggs
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

	/**
	 * Returns a list of all classes and data that fall under a particular section.
	 * @param section Integer value representing the requirement area.
	 * @return A LinkedHashMap list of all classes and following data which are in the section requested.
	 * @author Vincent Lee
	 * @author Johnathan Meggs
	 */
	public LinkedHashMap<String, List<String>> getCourseOfferingsTree(int section) {
		/*
		 * Stores information for classes uniquely identified by course Call#.
		 * 
		 * LinkedHashMap preserves insertion order where HashMap auto sorts.
		 * HashMap has a key and a value.
		 * Key: String
		 * Value: ArrayList<String>
		 * 
		 * For example:
		 * 43957 CSCI, 4800, 4.0, HUMAN-COMP INTERACT, PLAUE, Avail, M, 1115A, 1205P, 1023, 0306, T R, 1100A, 1215P, 1031, 0102
		 * 
		 * key: 43957
		 * value: CSCI, 4800, 4.0, HUMAN-COMP INTERACT, PLAUE, Avail, M, 1115A, 1205P, 1023, 0306, T R, 1100A, 1215P, 1031, 0102
		 * or
		 * {"43957"=["CSCI", "4800", "4.0", "HUMAN-COMP INTERACT", "PLAUE", "Avail", "M", "1115A", "1205P", "1023", "0306", "T R", "1100A", "1215P", "1031", "0102"]}
		 * 
		 * Only unique key is allowed in a hash map.
		 * 
		 * ****ADDING ITEMS****
		 * Items can be added by: map.put(String, new ArrayList<String>());
		 * Once the ArrayList is initialized you can add items by: map.get(String).add(String);
		 * 
		 * ****SEARCHING ITEMS****
		 * Keys can be searched: map.containsKey(String)
		 * Items can be located without iteration: map.get(String)
		 * 
		 * Let's say we want to check whether "CSCI 4800" is available for registration.
		 * We can, knowing the call number, check if the item is in the map by: map.containsKey(43957)
		 * Once it is confirmed in the map we can get that item by: map.get(43957).contains("Avail")
		 * 
		 * The benefits with this data structure is the no-iteration item location and searching.
		 */
		try {
			LinkedHashMap<String, List<String>> requirementsMap = new LinkedHashMap<String, List<String>>();
			int counter = 0; //Counter for the number of requirement courses.
			
			//Load table CSCoursesRequirements
			ResultSet rs = listCoursesRequirementsStatement.executeQuery();
			
			//Iterates through the course requirements result set
			while (rs.next()) {
				//If the course is in the section requested add to the LinkedHashMap
				if (rs.getInt("id") == section) {
					String coursePrefix = rs.getString("CoursePrefix").trim();
					String courseNum = rs.getString("CourseNum").trim();
					
					//If the there is already a Course Prefix key in map, add to values.
					if (requirementsMap.containsKey(coursePrefix)) {
						requirementsMap.get(coursePrefix).add(courseNum);
						counter++;
					} 
					//If not in the map create a new entry based on course prefix, and add value.
					else {
						requirementsMap.put(coursePrefix, new ArrayList<String>());
						requirementsMap.get(coursePrefix).add(courseNum);
						counter++;
					}
				}
			}
			
			//Change table to CourseOfferingFall2013
			rs = listCourseOfferingsStatement.executeQuery();
			LinkedHashMap<String, List<String>> classesMap = new LinkedHashMap<String, List<String>>();
			int courses = 0; //Counter for the number of classes.
			
			//TODO: Still need to handle * classes in classesMap  2300*
			
			//Iterates through the course offerings result set
			while (rs.next()) {
				//Check if the class is cancelled, only add classes that are Full or Available
				if (rs.getString("Avail").trim().compareToIgnoreCase("Cancelled") != 0) {
					//Check if the course prefix is in the requirements list: CSCI
					if (requirementsMap.containsKey(rs.getString("CoursePrefix").trim())) {
						//Check if course number is in that course prefix from requirements list: CSCI 4800
						if (requirementsMap.get(rs.getString("CoursePrefix").trim()).contains(rs.getString("CourseNum").trim())) {
							String callNum = rs.getString("CallNum").trim();
							//Check to see if the course prefix is in the classesMap
							if (classesMap.containsKey(callNum)) {
								//If the course already has the same day, time and location, don't add.
								if (classesMap.get(callNum).contains(rs.getString("Days").trim()) && 
										classesMap.get(callNum).contains(rs.getString("PeriodBgn").trim()) && 
										classesMap.get(callNum).contains(rs.getString("PeriodEnd").trim()) && 
										classesMap.get(callNum).contains(rs.getString("Bldg").trim()) && 
										classesMap.get(callNum).contains(rs.getString("Room").trim())) {
								} 
								//Add the course if it has a different day, time and location.
								else {
									classesMap.get(callNum).add(rs.getString("Days").trim());
									classesMap.get(callNum).add(rs.getString("PeriodBgn").trim());
									classesMap.get(callNum).add(rs.getString("PeriodEnd").trim());
									classesMap.get(callNum).add(rs.getString("Bldg").trim());
									classesMap.get(callNum).add(rs.getString("Room").trim());
								}
							}
							//Add the course Prefix to the classesMap, and course data to map.
							else {
								classesMap.put(callNum, new ArrayList<String>());
								classesMap.get(callNum).add(rs.getString("CoursePrefix").trim());
								classesMap.get(callNum).add(rs.getString("CourseNum").trim());
								classesMap.get(callNum).add(rs.getString("CrdHrs").trim());
								classesMap.get(callNum).add(rs.getString("CourseTitle").trim());
								
								//If Instructor is null, set as STAFF
								if (rs.getString("Instructor").trim().compareToIgnoreCase("null") == 0)
									classesMap.get(callNum).add("STAFF");
								else
									classesMap.get(callNum).add(rs.getString("Instructor").trim());
								
								//Make Available classes read as Avail
								if (rs.getString("Avail").trim().compareToIgnoreCase("Available") == 0)
									classesMap.get(callNum).add("Avail");
								else if (rs.getString("Avail").trim().compareToIgnoreCase("Full") == 0)
									classesMap.get(callNum).add("Full");
								
								//Add the rest of data to map.
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
			
			
			//Print out the LinkedHashMap in a visual appealing way.
			System.out.println("getCourseOfferingsTree(" + section + "):");
			System.out.println("\tMatches: " + counter);
			Iterator<String> iterator = requirementsMap.keySet().iterator();
			//Iterates through LinkedHashMap items.
			while (iterator.hasNext()) {
				String arrayName = iterator.next();
				List<String> list = requirementsMap.get(arrayName);
				System.out.print("\t" + arrayName + ":[");
				//Loops through a particular LinkedHashMap item values. 
				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i));
					if (i < list.size()-1)
						System.out.print(", ");
				}
				System.out.println("]");
			}
			
			//Print out the LinkedHashMap in a visual appealing way.
			System.out.println("\n\tCourses: " + courses);
			Iterator<String> iterator1 = classesMap.keySet().iterator();
			//Iterates through LinkedHashMap items.
			while (iterator1.hasNext()) {
				String arrayName = iterator1.next();
				List<String> list = classesMap.get(arrayName);
				System.out.print("\t" + arrayName + ":[");
				//Loops through a particular LinkedHashMap item values. 
				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i));
					if (i < list.size()-1)
						System.out.print(", ");
				}
				System.out.println("]");
			}
			
			//Returns the LinkedHashMap
			return classesMap;
		} catch (Exception e) {
			 System.out.println("Error in getCourseOfferingsTree():\n" + e.getClass().getName() + ": " + e.getMessage());
		}
		
		//Returns a empty LinkedHashMap if a error is found.
		return new LinkedHashMap<String, List<String>>();
	}
}