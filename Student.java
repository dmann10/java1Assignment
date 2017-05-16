public class Student {
	
	private int student_ID;
	private String student_Name, school;

	public Student() {
		student_ID = 0;
		student_Name = "no name";
		school = "no school";
	}

	public Student(int sID, String sN, String sch) {
		student_ID = sID;
		student_Name = sN;
		school = sch;
	}

	public void setStudentID(int sID) {
		student_ID = sID;
	}

	public int getStudentID() {
		return student_ID;
	}

	public void setStudentName(String name) {
		student_Name = name;
	}

	public String getStudentName() {
		return student_Name;
	}

	public void setSchool(String sch) {
		school = sch;
	}

	public String getSchool() {
		return school; 
	}

	public String writeTabOutput() {
		String studentInfo = student_ID + "\t" + student_Name + "\t" + school;
		return studentInfo;
	}
}
