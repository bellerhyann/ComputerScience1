	import java.awt.FileDialog;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.Scanner;

public class Lab7_bre {


		public static void main(String[] args) {
			// TODO Auto-generated method stub
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
		double sigma2=0;
		double sigma=0;
		double perabov=0;
		int sum= 0;
		int N=0;
		int[] xiList =null;
		int counter =0;
		    while(reader.hasNext())
		    {
		     if(counter==0)
		    	 {N = reader.nextInt();
		          xiList = new int[N];}
		           counter ++;
		    
			for(int i=0; i<N; i++)
		    	{ 
		    	int xi = reader.nextInt();
		    	xiList[i]=xi;//add to end of the List 
		    	sum = sum +xi;
		    	}
		double bsigma2 = 0;	
		double mu= sum/ N;
			for(int i=0; i<N; i++)
				{
				int xi= xiList[i];
				double asigma2= ((xi-mu)*(xi-mu));

				bsigma2 = bsigma2 +asigma2;
				sigma2= bsigma2/N;
				sigma = Math.sqrt(sigma2);
				}
		int larger = 0;
		double std = 0;
				for(int i=0; i<N; i++)
				{	
					if(xiList[i]<mu+sigma && xiList[i]>mu-sigma)
					{std++;}
					if(xiList[i]>mu)
					{larger++;}
				}
				perabov = 100.0*larger/ N;	
				std = 100*std/N;
				
			System.out.printf("Average: %5.3f", mu);
			System.out.printf("\nVariance: %5.3f", sigma2);
		    System.out.printf("\nStandard Deviation: %5.3f", sigma);
		    System.out.printf("\nPercent Above: %5.3f", perabov);
		    System.out.printf("\nPercent Within 1 Standard Deviation: %5.3f", std);  
		    
		  	


		  //reader.close();//close reader    	   
		    }
		   
		    }
		}
	}
