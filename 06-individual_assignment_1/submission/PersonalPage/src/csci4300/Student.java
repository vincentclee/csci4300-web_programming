package csci4300;

import java.util.ArrayList;

public class Student {
	private String studentName;
	private String description;
	private String imageURL;
	private ArrayList<String> activityList;
	
	public Student(String studentName, String description, String imageURL) {
		this.studentName = studentName;
		this.description = description;
		this.imageURL = imageURL;
		activityList = new ArrayList<String>();

	}
	
	public Student(String studentName, String description) {
		this.studentName = studentName;
		this.description = description;
		this.imageURL = null;
		activityList = new ArrayList<String>();
	}

	public Student() {
		studentName = "";
		description = "";
		imageURL = "";
		activityList = new ArrayList<String>();
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public ArrayList<String> getActivityList() {
		return activityList;
	}

	public void setActivityList(ArrayList<String> activityList) {
		this.activityList = activityList;
	}
	
	public void setNewActivity(String newActivity) {
		activityList.add(newActivity);
		
		//Find Duplicates
		for (int i = 0; i < activityList.size(); i++) {
			for (int j = 0; j < activityList.size(); j++) {
				if (j == i) {
					
				} else if (activityList.get(i).toString().equalsIgnoreCase(activityList.get(j).toString()))
					activityList.remove(i);
			}
		}
	}
	
	public String getActivitiesStatement() {
		if (activityList.isEmpty()) {
			return "I am a complete nerd without any activities.";
		} else if (activityList.size() == 1) {
			return "My favorite activity is " + activityList.get(0) + ".";
		} else if (activityList.size() > 1) {
			String temp = "My favorite activities are ";
			
			for (int i = 0; i < (activityList.size()-1); i++) {
				temp += activityList.get(i);
					
				if (activityList.size() > 2)
					temp += ", ";
				else
					temp += " ";
			}
			
			temp += "and " + activityList.get(activityList.size()-1) + ".";
			
			System.out.println(temp);
			
			return temp;
		}			
		return "";
	}
}
