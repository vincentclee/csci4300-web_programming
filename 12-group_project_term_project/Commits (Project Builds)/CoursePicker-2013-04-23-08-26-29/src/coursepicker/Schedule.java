package coursepicker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Manages a session user's current schedule, add, delete courses, etc.
 * @author Vincent Lee
 */
public class Schedule {
	ArrayList<String> scheduleList;
	LinkedHashMap<String, List<String>> scheduleTree;
	ArrayList<LinkedHashMap<String, List<String>>> coursesTree;
	
	/**
	 * Constructor - accepts the current schedule, scheduleList, the LinkedHashMap with course data, and all the courses ArrayList<LinkedHashMap>.
	 * @param scheduleList ArrayList<String> contains users current schedule for example: CSCI 4800
	 * @param scheduleTree LinkedHashMap<String, List<String>> contains users current schedule data.
	 * @param coursesTree ArrayList<LinkedHashMap<String, List<String>>> containing sets of course data.
	 * @author Vincent Lee
	 */
	public Schedule(ArrayList<String> scheduleList, LinkedHashMap<String, List<String>> scheduleTree, ArrayList<LinkedHashMap<String, List<String>>> coursesTree) {
		this.scheduleList = scheduleList;
		this.scheduleTree = scheduleTree;
		this.coursesTree = coursesTree;
	}
	
	/**
	 * Constructor - accepts the current schedule ArrayList--scheduleList and LinkedHashMap--scheduleTree with course data.
	 * @param scheduleList ArrayList<String> contains users current schedule for example: CSCI 4800
	 * @param scheduleTree LinkedHashMap<String, List<String>> contains users current schedule data.
	 * @author Vincent Lee
	 */
	public Schedule(ArrayList<String> scheduleList, LinkedHashMap<String, List<String>> scheduleTree) {
		this.scheduleList = scheduleList;
		this.scheduleTree = scheduleTree;
		this.coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
	}
	
	/**
	 * Default no-args constructor.
	 * @author Vincent Lee
	 */
	public Schedule() {
		this.scheduleList = new ArrayList<String>();
		this.scheduleTree = new LinkedHashMap<String, List<String>>();
		this.coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
	}
	
	/**
	 * Adds a class name to the scheduleList, and class data to scheduleTree
	 * @param callNumber String unique identifier for a particular class. 
	 * @author Vincent Lee
	 */
	public void addClass(String callNumber) {
		/*
		 * Loops through the ArrayList of LinkedHashMap (s) to find the course by call number.
		 * 
		 * ****EXAMPLE****
		 * AREA II: Sciences
		 * 4 Core Curriculum II: Physical Sciences
		 * 5 Core Curriculum II: Life Sciences
		 * 
		 * Using the example above area II has two lists of courses.
		 * The for loop will iterate through all of them, checking if they contain the course.
		 * Using the no iteration LinkedHashMap properties, a simple check to see if it is in the map.
		 * If not in the map, move on to the next map.
		 * If the item is found break; as some courses are cross-listed and that would add two items to the scheduleList
		 */
		for (int i = 0; i < coursesTree.size(); i++) {
			//If the call number is in the map, then add the name to the scheduleList, and data to scheduleTree
			if (coursesTree.get(i).containsKey(callNumber)) {
				//Adds a new course, but before the add, composes string as follows: "CSCI" + " " + "4800"
				scheduleList.add(coursesTree.get(i).get(callNumber).get(0) + " " + coursesTree.get(i).get(callNumber).get(1));
				//Adds a line of data to schedule map by getting a sublist, but getting all values.
				scheduleTree.put(callNumber, coursesTree.get(i).get(callNumber).subList(0, coursesTree.get(i).get(callNumber).size()));
				break;
			}
		}
		
		//Print out the LinkedHashMap in a visual appealing way.
		System.out.println("addClass(" + callNumber + "):");
		Iterator<String> iterator = scheduleTree.keySet().iterator();
		//Iterates through LinkedHashMap items.
		while (iterator.hasNext()) {
			String arrayName = iterator.next();
			List<String> list = scheduleTree.get(arrayName);
			System.out.print("\t" + arrayName + ":[");
			//Loops through a particular LinkedHashMap item values. 
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
				if (i < list.size()-1)
					System.out.print(", ");
			}
			System.out.println("]");
		}
	}
	
	/**
	 * @author Vincent Lee
	 * @param callNumber
	 */
	public void deleteClasses(String[] callNumber) {
		//Iterates over the classes needed to be removed
		for (int i = 0; i < callNumber.length; i++) {
			//Removes the course one by one from the LinkedHashMap
			scheduleTree.remove(callNumber[i]);
		}
		
		/*
		 * Rebuilds the scheduleList since the list does not a unique identifier to remove easily.
		 */
		scheduleList = new ArrayList<String>(); //Creates a empty ArrayList.
		Iterator<String> iterator1 = scheduleTree.keySet().iterator();
		//Iterates through LinkedHashMap items
		while (iterator1.hasNext()) {
			String arrayName = iterator1.next();
			List<String> list = scheduleTree.get(arrayName);
			scheduleList.add(list.get(0) + " " + list.get(1));
		}
		
		//Print out the LinkedHashMap in a visual appealing way.
		System.out.println("deleteClasses(" + Arrays.toString(callNumber) + "):");
		Iterator<String> iterator = scheduleTree.keySet().iterator();
		//Iterates through LinkedHashMap items.
		while (iterator.hasNext()) {
			String arrayName = iterator.next();
			List<String> list = scheduleTree.get(arrayName);
			System.out.print("\t" + arrayName + ":[");
			//Loops through a particular LinkedHashMap item values. 
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
				if (i < list.size()-1)
					System.out.print(", ");
			}
			System.out.println("]");
		}
	}

	/**
	 * @return An ArrayList consisting of the current users schedule: "CSCI 4800" + "CSCI 4900"
	 * @author Vincent Lee
	 */
	public ArrayList<String> getScheduleList() {
		return scheduleList;
	}

	/**
	 * @return An LinkedHashMap of the current users schedule data.
	 * @author Vincent Lee
	 */
	public LinkedHashMap<String, List<String>> getScheduleTree() {
		return scheduleTree;
	}
}