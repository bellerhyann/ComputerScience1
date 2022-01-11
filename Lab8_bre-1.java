import java.util.Scanner;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;


public class Lab8_bre {
	
	
	public static void main(String[] args) {

	boolean qNotPressed = true;
	Student student = null;
	int counter=0;
	Student[] xiList = new Student[100000];
	Scanner input = new Scanner(System.in);

	
	while (qNotPressed)
	{
	String pressed = null;
	System.out.print("Choose one (by letter):\nread new students from a (F)ile\n(R)emove all students from course\n(D)isplay students on scrren\nSort students by (N)ame\nSort students by (P)roject score\nSort students by (E)xam score\nSort students by (A)verage\n(Q)uit\n");

    System.out.print("Your Choice: ");
    pressed = input.next();
		switch(pressed.toUpperCase())
		{
		case "F":
			FileDialog fd = null;
		    {
		    fd = new FileDialog(fd, "Title for the GUI", FileDialog.LOAD);
		    fd.setVisible(true);
		    String filename = fd.getFile();  //what
		    String path = fd.getDirectory(); //where
		    String fullName = path + filename;
		    File myFile = new File(fullName);
		    Scanner reader;  // declare
		    try  // attempt the following code
		    {
		        reader = new Scanner(myFile); 
		    }
		    
		    catch(FileNotFoundException e)  
		    {
		        System.out.println("User error on read file!");
		        System.out.println(e);
		        return;
		    }
		
		    while(reader.hasNext())
		    {
		    student = new Student(reader);
		    xiList[counter]=student;
		    counter++;
		    }
		    }
			break;

		case "R":
			
			//reset // forget existing students
			//array =null? <<<<<<<<am I using an array?		
			break;
			
		case "D":
			for (int i=0; i<counter+1; i++)
			{	
			System.out.println(xiList[i]);
			}
			break;
			
		case "N":
			boolean swapped;			
			int indexA = 0;
			int indexB = indexA + 1;
			swapped=false;
			
			for(int i=0; i< counter; i++)
			{
			if(!swapped)
			{
				boolean aIsBigger =xiList[indexA].getLastName().compareTo(xiList[indexB].getLastName())<0;
				if(aIsBigger)//true if a comes before b
				{
				indexB++;	
				}
				if(!aIsBigger)// true if b comes before a
				{
					Student temp = xiList[indexB];
					xiList[indexB] = xiList[indexA];
					xiList[indexA] = temp;
					swapped= true;
				}
			}
			indexA++;
			}
			break;
			
		case "P":
			boolean swapMade;
			do
			{
				swapMade=false;
				for (int index=0; index<counter-1; index++)
				{

					boolean test =(xiList[index+1].getProject()>(xiList[index].getProject()));
					if(test)
							{
					Student temp = xiList[index+1];
					xiList[index+1] = xiList[index];
					xiList[index] = temp;
					swapped= true;
							}
							
				}
			}
			while(swapMade);
		
			
			//sort by project score
			break;
			
		case "E":
			do
			{
				swapMade=false;
				for (int index=0; index<counter-1; index++)
				{
			boolean test =xiList[index+1].getExam()>(xiList[index].getExam());
					if(test)
							{
					Student temp = xiList[index];
					xiList[index] = xiList[index+1];
					xiList[index+1] = temp;
					swapped= true;
							}
							
				}
			}
			while(swapMade);
			//sort by exam score
			break;
			
		case "A":
			do
			{
				swapMade=false;
				for (int index=0; index<counter-1; index++)
				{
			boolean test =xiList[index+1].getAverage()<(xiList[index].getAverage());
					if(test)
							{
					Student temp = xiList[index];
					xiList[index] = xiList[index+1];
					xiList[index+1] = temp;
					swapped= true;
							}
							
				}
			}
			while(swapMade);
			//sort by average score
			break;
			
		case "Q":
			qNotPressed = false;	
			input.close();
			System.out.print("\nGoodBye!");
			break;	
			
		default:
			System.out.println( "You have entered an invalid Key");		
			break;	
		
	}

}
	
}}