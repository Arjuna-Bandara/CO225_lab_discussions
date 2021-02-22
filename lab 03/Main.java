import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String []args) throws FileNotFoundException, IOException {
		//read student names from file
		
		String fileName = new File("co225-classlist.txt").getAbsolutePath(); //get absolute file path
		
		Student []studentarray = new Student[61];
		Student st = null;
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    String line;
		    int i = 0;
		    
		    while ((line = br.readLine()) != null) {
		    int attendance = (int) ((Math.random()*100)%46); //use 46 instead of 45
			st = new Student(line,attendance); //   constructor to initiate object
		      studentarray[i]=st;
		      i++;
		      
		    }
		    
		}

		//print all students in array
		for (int i = 0; i < studentarray.length; i++) {			
			System.out.println(studentarray[i]);
		}

		System.out.println("\nThose who have less than 80 attendance precentage");
		for (Student student : studentarray) {
			if (student.getAttendancePrecentage() < 80.0){
				System.out.println(student.getName() + "\t\t" + student.getAttendancePrecentage() + " %");
			}
		}

		System.out.println("\nThose who have greater than 80 attendance precentage");
		for (Student student : studentarray) {
			if (student.getAttendancePrecentage() >= 80){
				System.out.println(student.getName() + "\t\t" + student.getAttendancePrecentage() +" %");
			}
		}

		System.out.println("average attendance precentage " + Student.getClassAverageAttendancePercentage());


	}

	
}
