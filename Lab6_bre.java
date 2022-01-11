import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

	/**
	*
	*My first attempt at an at home lab
	*Belle E
	*/
public class Lab6 {
public static void main(String[] args) {
		
	FileDialog fd = null;
	fd = new FileDialog(fd, "Title for the GUI", FileDialog.LOAD);
	fd.setVisible(true);
	String filename = fd.getFile();  //what
	String path = fd.getDirectory(); //where
	String fullName = path + filename;
	File myFile = new File(fullName);
	Scanner reader;

try 
{
	reader = new Scanner(myFile);
}
catch(FileNotFoundException e) 
{
	System.out.println("User error on read file!");
	System.out.println(e);
	return;
}

Student topStudent = new Student(reader);
double sum= topStudent.getScore(); //initialize sum
int count = 1;  //initialize count
Student lowStudent = new Student(reader);
double ignitalScore = lowStudent.getScore();
	while (reader.hasNext())
		{
		Student currstudent = new Student(reader);
		sum= sum+ currstudent.getScore();
			
		if (topStudent.getScore()<= currstudent.getScore())
			{
				topStudent = currstudent;
			}
		if (currstudent.getScore()<= lowStudent.getScore() && ignitalScore > currstudent.getScore())
			{
			lowStudent = currstudent;
			}		
				count++;
			}
		
	
	double average = 1.0*sum/count; 
	System.out.printf("Average Was: %.3f\n", average);
	System.out.println("The best student was"+ topStudent.toString());
	System.out.println("The worst student was"+ lowStudent.toString());
		
	reader.close();

		
	}
}
