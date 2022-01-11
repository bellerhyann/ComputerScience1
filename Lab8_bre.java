import java.util.Scanner;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;


public class Lab8_bre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
				boolean aIsBigger =xiList[indexA].getFullName().compareTo(xiList[indexB].getFullName())<0;
				if(aIsBigger)//true if a comes before b
				{
				indexB++;	
				}
				if(!aIsBigger)// true if b comes before a
				{
					Student temp = xiList[indexA];
					xiList[indexA] = xiList[indexB];
					xiList[indexB] = temp;
					swapped= true;
				}
			}
			indexA++;
			}
			break;
			
		case "P":
			int indexc = 0;
			int indexd = indexc + 1;
			swapped=false;
			
			for(int i=0; i< counter+1; i++)
			{
			if(!swapped)
			{
				boolean aIsBigger =xiList[indexc].getProject()>(xiList[indexd].getProject());
				if(aIsBigger)//true if c comes before d
				{
				indexd++;	
				}
				if(!aIsBigger)// true if b comes before a
				{
					Student temp = xiList[indexc];
					xiList[indexc] = xiList[indexd];
					xiList[indexd] = temp;
					swapped= true;
				}
			}
			indexc++;
			}
			
			//sort by project score
			break;
			
		case "E":
			int indexe = 0;
			int indexf = indexe + 1;
			swapped=false;
			
			for(int i=0; i< counter+1; i++)
			{
			if(!swapped)
			{
				boolean aIsBigger =xiList[indexe].getExam()>(xiList[indexf].getExam());
				if(aIsBigger)//true if c comes before d
				{
				indexf++;	
				}
				if(!aIsBigger)// true if b comes before a
				{
					Student temp = xiList[indexe];
					xiList[indexe] = xiList[indexf];
					xiList[indexf] = temp;
					swapped= true;
				}
			}
			indexe++;
			}
			//sort by exam score
			break;
			
		case "A":
			int indexg = 0;
			int indexh= indexg + 1;
			
			int h = 0;
			while(h<10) {
			swapped=false;	
			for(int i=0; i< counter; i++)
			{
			if(!swapped)
			{
				boolean aIsBigger =xiList[indexg].getAverage()>(xiList[indexh].getAverage());
				if(!aIsBigger)//true if g comes before h
				{
				indexh++;	
				}
				if(aIsBigger)// true if g comes before h
				{
					Student temp = xiList[indexg];
					xiList[indexg] = xiList[indexh];
					xiList[indexh] = temp;
					swapped= true;
				}
			}
			h++;}
			indexg++;
			}
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