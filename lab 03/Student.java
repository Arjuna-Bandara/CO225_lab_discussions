public class Student {
	private String name;
	private int attendance;

	// class attributes
	static final int TOTAL_LECTURES = 45;
	
	public static int totalAttendance = 0;
	public static int totalStudentsCount = 0;
	

	public Student(String name, int attendance) {
		this.name = name;
		this.attendance = attendance;

		totalStudentsCount++;
		totalAttendance += attendance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	// calculate attendance precentage
	public double getAttendancePrecentage() {
		return (double)attendance/TOTAL_LECTURES*100.0 ;
	}	

	//average Attendance Percentage
	public static double getClassAverageAttendancePercentage() {
		return (double)totalAttendance / TOTAL_LECTURES / totalStudentsCount * 100.0 ;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", attendance=" + attendance + "]";
	}

	
	
}
