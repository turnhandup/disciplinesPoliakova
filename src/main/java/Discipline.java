package main.java;
public class Discipline {
	private int id;
	private String name;
	private double credits;
	private int isRecommended;
	private String teacher;
	private String annotation;
	
	public Discipline(int id, String name, double credits, int isRecommended, String teacher, String annotation) {
		this.id = id;
		this.name = name;
		this.credits = credits;
		this.isRecommended = isRecommended;
		this.teacher = teacher;
		this.annotation=annotation;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCredits() {
		return credits;
	}
	public void setCredits(double credits) {
		this.credits = credits;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getAnnotation() {
		return annotation;
	}
	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}
	public int getIsRecommended(){
		return  isRecommended;
	}
	public void setIsRecommended(int isRecommended){
		this.isRecommended=isRecommended;
	}
	public String toString(){
		return "Id:" + getId() + "\nName: " + getName() + "\nCredits:" +getCredits() +"\n Recommended:" +getIsRecommended();
	}
}
