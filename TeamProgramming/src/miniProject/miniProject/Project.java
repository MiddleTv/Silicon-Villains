//package miniProject;

import java.util.ArrayList;

public class Project {

	private String ID;
	private String name;
	private String desc;
	private int duration;//in weeks
	private int budget;
	private int RoI;
	private ArrayList<PersonTime> times; // should be array with each member and their time
	//private ArrayList<Task> tasks; //TODO

	
	ArrayList<Task> tasks;

	public Project(String ID, String name, String desc, int duration, int budget, int RoI, int time) {
		this.ID = ID;
		this.name = name;
		this.desc = desc;
		this.duration = duration;
		this.budget = budget;
		this.RoI = RoI;
		this.times = new ArrayList<>();
	}

	public double costVariance(int current_week) {

		double earned_Value = earnedValue(current_week);
		double cost_Variance = 0;
		cost_Variance = earned_Value - this.budget;
		return cost_Variance;
	}
	
	public double scheduleVariance(int current_week) {
		
		return (this.earnedValue(current_week)-this.plannedValue(current_week));
		
		/*
		 * this method should return the schedule variance the schedule variance =
		 * budgeted cost of the work performed - budgeted cost of work scheduled
		 */

		//return 0;(Arvin: this return causes an error)
	}
	public double plannedValue(int current_week) {
		
		int projectDuration=this.duration;
		
		double percentageOfProjectDone=(double)(current_week/projectDuration);
		double plannedValue=percentageOfProjectDone*this.budget;
		
		return plannedValue;
		
	}
	public boolean updateTime(String personID, int time) {
		//The method goes through each couple of PersonID and time spent in the project
		//and if the ID is found then the time is updated and the method returns true
		boolean found = false;
		for(PersonTime couple : this.times) {
			if(personID.equals(couple.getID())) {
				couple.setTime(time);
				found = true;
			}
		}
		return found;
	}
	
	public void createTask(String name, int start_week,int end_week,int sn) {

		Task task = new Task(name, start_week, end_week,sn);
		this.tasks.add(task);
	}
	public int getNumberOfTasks() {
		return tasks.size();
	}
	public Task getTask(int position) {
		return this.tasks.get(position);
	}
	public double retrieveCompletedPercentage(int week) {
		
		double completedPercentage=0.0;
		int completedTasks=0;
		int allTasks=0;

		for (Task task : this.tasks) {
			if(tasks != null) {
				allTasks+=task.LengthOfTask();
				if(task.completedTask(week))
					completedTasks+=task.LengthOfTask();
			}
		}
		completedPercentage=allTasks/completedTasks;
		return completedPercentage;
	}
	public double earnedValue(int current_week) {
		
		double earned_value=0;
		double completed_work=retrieveCompletedPercentage(current_week);
		
		earned_value=this.budget*completed_work;
		return earned_value;
		
		/*
		 * this method should return the earned value = % of completed
		 * work / budget at completion (BAC)
		 */
	}
	
	public String scheduleActivity() {
		/*
		 * this method will return the project's schedule and planned activity.
		 * it should return the start week and end week of the project
		 */
		return null;
	}
	
	
	//Risk Matrix method; think about this!!!
	
	

	public String getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public String getDesc() {
		return this.desc;
	}

	public int getDuration() {
		return this.duration;
	}
	//getbudget should have capital B.
	public int getbudget() {
		return this.budget;
	}

	public int getRoI() {
		return this.RoI;
	}

	public int getTime() {
		//return this.time;
		return 1;//(Arvin: there is no time attribute(fix?))
	}
	public ArrayList<PersonTime> getTimes(){
		return this.times;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public void setRoI(int roI) {
		RoI = roI;
	}
	public String toString() {

		final String END_OF_LINE = System.lineSeparator();
		String projectInfo = "ID of a person: " + this.ID + END_OF_LINE;
		projectInfo += "Name Of Project: " + this.name + END_OF_LINE;
		projectInfo += "Decription: " + this.desc + END_OF_LINE;
		projectInfo += "Duration: " + this.duration + END_OF_LINE;
		projectInfo += "Budget: " + this.budget + " SEK per month" + END_OF_LINE;
		
		return projectInfo;
	}

}
