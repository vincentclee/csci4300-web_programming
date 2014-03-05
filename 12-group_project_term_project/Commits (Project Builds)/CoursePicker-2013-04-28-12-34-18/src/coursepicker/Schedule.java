package coursepicker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Manages a session user's current schedule, add, delete courses, etc.
 * @author Vincent Lee
 */
public class Schedule {
	protected ArrayList<String> scheduleList;
	protected ArrayList<Meeting> classMeetings;
	protected LinkedHashMap<String, List<String>> scheduleTree;
	protected ArrayList<LinkedHashMap<String, List<String>>> coursesTree;
	
	/**
	 * Constructor - accepts the current schedule, scheduleList, the scheduleTree, coursesTree, and classMeetings.
	 * @param scheduleList ArrayList<String> contains users current schedule for example: CSCI 4800
	 * @param scheduleTree LinkedHashMap<String, List<String>> contains users current schedule data.
	 * @param coursesTree ArrayList<LinkedHashMap<String, List<String>>> containing sets of course data.
	 * @param classMeetings ArrayList<Meeting> contains meeting times for classes.
	 */
	public Schedule(ArrayList<String> scheduleList, LinkedHashMap<String, List<String>> scheduleTree, ArrayList<LinkedHashMap<String, List<String>>> coursesTree, ArrayList<Meeting> classMeetings) {
		this.scheduleList = scheduleList;
		this.scheduleTree = scheduleTree;
		this.coursesTree = coursesTree;
		this.classMeetings = classMeetings;
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
		this.classMeetings = new ArrayList<Meeting>();
	}
	
	/**
	 * Default no-args constructor.
	 * @author Vincent Lee
	 */
	public Schedule() {
		this.scheduleList = new ArrayList<String>();
		this.classMeetings = new ArrayList<Meeting>();
		this.scheduleTree = new LinkedHashMap<String, List<String>>();
		this.coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
	}
	
	/**
	 * 
	 * @param callNumber
	 * @return
	 * @author Vincent Lee
	 */
	public ArrayList<Meeting> getClass(String callNumber) {
		ArrayList<Meeting> meetings = new ArrayList<Meeting>();
		for (int i = 0; i < coursesTree.size(); i++) {
			//If the call number is in the map, then add the name to the scheduleList, and data to scheduleTree
			if (coursesTree.get(i).containsKey(callNumber)) {
				for (int j = 6; j < coursesTree.get(i).get(callNumber).size(); j+=5) {
					//Days parsing by quintet
					Scanner tokenize = new Scanner(coursesTree.get(i).get(callNumber).get(j));
					while (tokenize.hasNext()) {
						meetings.add(new Meeting(coursesTree.get(i).get(callNumber).get(0), 
								coursesTree.get(i).get(callNumber).get(1), 
								coursesTree.get(i).get(callNumber).get(3), 
								coursesTree.get(i).get(callNumber).get(4), 
								tokenize.next(), 
								coursesTree.get(i).get(callNumber).get(j+1), 
								coursesTree.get(i).get(callNumber).get(j+2), 
								coursesTree.get(i).get(callNumber).get(j+3), 
								coursesTree.get(i).get(callNumber).get(j+4)));
					}
					tokenize.close();
				}
				break;
			}
		}
		
		//Print out Class Meetings ArrayList
		System.out.println("getClass(" + callNumber + "):");
		for (int i = 0; i < meetings.size(); i++) {
			System.out.println("\t" + meetings.get(i).toString());
		}
		
		return meetings;
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
		 * 
		 * SAMPLE:
		 * from:
		 * {"43957"=["CSCI", "4800", "4.0", "HUMAN-COMP INTERACT", "PLAUE", "Avail", "M", "1115A", "1205P", "1023", "0306", "T R", "1100A", "1215P", "1031", "0102"]}
		 * to:
		 * new Meeting("CSCI", "4800", "HUMAN-COMP INTERACT", "PLAUE", "M", "1115A", "1205P", "1023", "0306")
		 */
		for (int i = 0; i < coursesTree.size(); i++) {
			//If the call number is in the map, then add the name to the scheduleList, and data to scheduleTree
			if (coursesTree.get(i).containsKey(callNumber)) {
				//Adds a new course, but before the add, composes string as follows: "CSCI" + " " + "4800"
				scheduleList.add(coursesTree.get(i).get(callNumber).get(0) + " " + coursesTree.get(i).get(callNumber).get(1));
				//Adds a line of data to schedule map by getting a sublist, but getting all values.
				scheduleTree.put(callNumber, coursesTree.get(i).get(callNumber).subList(0, coursesTree.get(i).get(callNumber).size()));
				
				for (int j = 6; j < coursesTree.get(i).get(callNumber).size(); j+=5) {
					//Days parsing by quintet
					Scanner tokenize = new Scanner(coursesTree.get(i).get(callNumber).get(j));
					while (tokenize.hasNext()) {
						classMeetings.add(new Meeting(coursesTree.get(i).get(callNumber).get(0), 
								coursesTree.get(i).get(callNumber).get(1), 
								coursesTree.get(i).get(callNumber).get(3), 
								coursesTree.get(i).get(callNumber).get(4), 
								tokenize.next(), 
								coursesTree.get(i).get(callNumber).get(j+1), 
								coursesTree.get(i).get(callNumber).get(j+2), 
								coursesTree.get(i).get(callNumber).get(j+3), 
								coursesTree.get(i).get(callNumber).get(j+4)));
					}
					tokenize.close();
				}
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
		
		//Print out Class Meetings ArrayList
		System.out.println("\n\tMeetings:");
		for (int i = 0; i < classMeetings.size(); i++) {
			System.out.println("\t" + classMeetings.get(i).toString());
		}
	}
	
	/**
	 * @author Vincent Lee
	 * @param callNumber
	 */
	public void deleteClasses(String[] callNumber) {
		classMeetings = new ArrayList<Meeting>();
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
			
			for (int j = 6; j < list.size(); j+=5) {
				//Days parsing by quintet
				Scanner tokenize = new Scanner(list.get(j));
				while (tokenize.hasNext()) {
					classMeetings.add(new Meeting(list.get(0), 
							list.get(1), 
							list.get(3), 
							list.get(4), 
							tokenize.next(), 
							list.get(j+1), 
							list.get(j+2), 
							list.get(j+3), 
							list.get(j+4)));
				}
				tokenize.close();
			}
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
		
		//Print out Class Meetings ArrayList
		System.out.println("\n\tMeetings:");
		for (int i = 0; i < classMeetings.size(); i++) {
			System.out.println("\t" + classMeetings.get(i).toString());
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

	/**
	 * @return the classMeetings
	 */
	public ArrayList<Meeting> getClassMeetings() {
		return classMeetings;
	}
}