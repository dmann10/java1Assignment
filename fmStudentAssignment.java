import java.util.*;
import java.io.*;

public class fmStudentAssignment {

	public static void main(String[] args) throws FileNotFoundException, IOException {
	
		Scanner inputFile = new Scanner(new File("C:/Users/dylan_000/Documents/fmStudentAssignment/studentCSV_file.csv"));
		ArrayList<Student> newStudent = new ArrayList<Student>();

		while(inputFile.hasNext())
		{
			String str = inputFile.nextLine();
			String[] studentInfo = str.split(",");
			newStudent.add(new Student(Integer.parseInt(studentInfo[0]), studentInfo[1], studentInfo[2]));
		}

		createSchoolFiles(newStudent);
	}	

	public static void createSchoolFiles(ArrayList<Student> newStudent) throws IOException {

			ArrayList<String> checkSchool = new ArrayList<String>();
			boolean newSchool;

			for(int x = 0 ; x < newStudent.size() ; x++)
			{
				newSchool = checkForSchoolName(checkSchool, newStudent.get(x).getSchool());
				if(newSchool)
				{
					String filename = newStudent.get(x).getSchool();
					File file = new File(filename + ".tsv");
					PrintWriter outputFile = new PrintWriter(file);
				
					for(int i = 0; i < newStudent.size(); i++)
					{
						if(newStudent.get(i).getSchool().equalsIgnoreCase(filename))
							outputFile.println(newStudent.get(i).writeTabOutput());
					}
					outputFile.close();
			}
		}		
	}

	public static boolean checkForSchoolName(ArrayList<String> checkSchool, String schoolName) {

		boolean bool = true;

		for(int i = 0; i < checkSchool.size(); i++)
		{
			if(checkSchool.get(i).equalsIgnoreCase(schoolName))
				bool = false;
			else
			{
				checkSchool.add(schoolName);
				bool = true;
			}
		}

		return bool;
	}

}	