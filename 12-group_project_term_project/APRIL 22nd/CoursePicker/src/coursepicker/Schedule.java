/**
 * @author Vincent Lee
 */

package coursepicker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class Schedule {
	ArrayList<String> scheduleList;
	LinkedHashMap<String, List<String>> scheduleTree;
	ArrayList<LinkedHashMap<String, List<String>>> coursesTree;
	
	/**
	 * 
	 * @author Vincent Lee
	 * @param scheduleList
	 * @param scheduleTree
	 * @param coursesTree
	 */
	public Schedule(ArrayList<String> scheduleList, LinkedHashMap<String, List<String>> scheduleTree, ArrayList<LinkedHashMap<String, List<String>>> coursesTree) {
		this.scheduleList = scheduleList;
		this.scheduleTree = scheduleTree;
		this.coursesTree = coursesTree;
	}
	
	/**
	 * 
	 * @author Vincent Lee
	 * @param scheduleList
	 * @param scheduleTree
	 */
	public Schedule(ArrayList<String> scheduleList, LinkedHashMap<String, List<String>> scheduleTree) {
		this.scheduleList = scheduleList;
		this.scheduleTree = scheduleTree;
		this.coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
	}
	
	/**
	 * @author Vincent Lee
	 */
	public Schedule() {
		this.scheduleList = new ArrayList<String>();
		this.scheduleTree = new LinkedHashMap<String, List<String>>();
		this.coursesTree = new ArrayList<LinkedHashMap<String, List<String>>>();
	}
	
	/**
	 * @author Vincent Lee
	 * @param callNumber
	 */
	public void addClass(String callNumber) {
		for (int i = 0; i < coursesTree.size(); i++) {
			if (coursesTree.get(i).containsKey(callNumber)) {
				scheduleList.add(coursesTree.get(i).get(callNumber).get(0) + " " + coursesTree.get(i).get(callNumber).get(1));
				scheduleTree.put(callNumber, coursesTree.get(i).get(callNumber).subList(0, coursesTree.get(i).get(callNumber).size()));
				break;
			}
		}

		System.out.println("addClass(" + callNumber + "):");
		Iterator<String> iterator = scheduleTree.keySet().iterator();
		while (iterator.hasNext()) {
			String arrayName = iterator.next();
			List<String> list = scheduleTree.get(arrayName);
			System.out.print("\t" + arrayName + ":[");
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
		for (int i = 0; i < callNumber.length; i++) {
			scheduleTree.remove(callNumber[i]);
		}
		
		
		scheduleList = new ArrayList<String>();
		Iterator<String> iterator1 = scheduleTree.keySet().iterator();
		while (iterator1.hasNext()) {
			String arrayName = iterator1.next();
			List<String> list = scheduleTree.get(arrayName);
			scheduleList.add(list.get(0) + " " + list.get(1));
		}
		
		
		System.out.println("deleteClasses(" + Arrays.toString(callNumber) + "):");
		Iterator<String> iterator = scheduleTree.keySet().iterator();
		while (iterator.hasNext()) {
			String arrayName = iterator.next();
			List<String> list = scheduleTree.get(arrayName);
			System.out.print("\t" + arrayName + ":[");
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
	 * @return the scheduleList
	 */
	public ArrayList<String> getScheduleList() {
		return scheduleList;
	}

	/**
	 * @author Vincent Lee
	 * @return the scheduleTree
	 */
	public LinkedHashMap<String, List<String>> getScheduleTree() {
		return scheduleTree;
	}

	/**
	 * @author Vincent Lee
	 * @return the coursesTree
	 */
	public ArrayList<LinkedHashMap<String, List<String>>> getCoursesTree() {
		return coursesTree;
	}
}
