package net.javaguides.usermanagement.model;

public class User {
	private int companyid ;
	private String companyname;
	private int year;
	private String position;
	private int stipend;
	private int students_selected;
	private int ppo;
	private String branch;
	private String duration;
	private String location;
	private String branches_eligible;
	private int ctc;
	private int cgpa;
	private String link;
	
	
	
	public User(int companyid, String companyname, int year, String position, int stipend, int students_selected,
			int ppo, String branch, String duration, String location, String branches_eligible, int ctc, int cgpa,
			String link) {
		super();
		this.companyid = companyid;
		this.companyname = companyname;
		this.year = year;
		this.position = position;
		this.stipend = stipend;
		this.students_selected = students_selected;
		this.ppo = ppo;
		this.branch = branch;
		this.duration = duration;
		this.location = location;
		this.branches_eligible = branches_eligible;
		this.ctc = ctc;
		this.cgpa = cgpa;
		this.link = link;
	}
	
	
	
	public User(String companyname, int year, String position, int stipend, int students_selected, int ppo,
			String branch, String duration, String location, String branches_eligible, int ctc, int cgpa, String link) {
		super();
		this.companyname = companyname;
		this.year = year;
		this.position = position;
		this.stipend = stipend;
		this.students_selected = students_selected;
		this.ppo = ppo;
		this.branch = branch;
		this.duration = duration;
		this.location = location;
		this.branches_eligible = branches_eligible;
		this.ctc = ctc;
		this.cgpa = cgpa;
		this.link = link;
	}



	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getStipend() {
		return stipend;
	}
	public void setStipend(int stipend) {
		this.stipend = stipend;
	}
	public int getStudents_selected() {
		return students_selected;
	}
	public void setStudents_selected(int students_selected) {
		this.students_selected = students_selected;
	}
	public int getPpo() {
		return ppo;
	}
	public void setPpo(int ppo) {
		this.ppo = ppo;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBranches_eligible() {
		return branches_eligible;
	}
	public void setBranches_eligible(String branches_eligible) {
		this.branches_eligible = branches_eligible;
	}
	public int getCtc() {
		return ctc;
	}
	public void setCtc(int ctc) {
		this.ctc = ctc;
	}
	public int getCgpa() {
		return cgpa;
	}
	public void setCgpa(int cgpa) {
		this.cgpa = cgpa;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
	
	

}
