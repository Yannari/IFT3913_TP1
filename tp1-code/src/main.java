
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import jls.Jls;
import lcsec.lcsec;
import nvloc.nvloc;
import egon.egon;
public class main {
    	
    public static Scanner sc = new Scanner(System.in);
    public static String makeChoice() 
    {
            
                System.out.println("Select an option:\n 1- Jls\n 2- Nvloc\n 3- Lcsec\n 4- Egon\n 5- Exit");
                
                String  choice = sc.nextLine();  // Read user input
                
                return choice;
            
            
            
    }
    public static void menu()
    {
        String choice = makeChoice();
     
        switch( choice)
        {
            case "1":
            
           
            System.out.println("Choose the path to the folder which contains java files like this example: ./jfreechart/src/main/java ");
            String  path = sc.nextLine();
            System.out.println("Choose the path to the folder we will be the container of the csv and the csv file name: ./jfreechart/src/main/java/output.csv ");
            String  path2 = sc.nextLine();
            Jls jl1=new Jls(path);
            jl1.makeCsv(path2);
            System.out.println("The csv has been written in the folder "+path2);
            
            menu();
            
            case "2":

            System.out.println("Choose the path to the java file  like this example: ./tp1-code/gr/spinellis/ckjm/MethodVisitor.java");
            String  path5 = sc.nextLine();
            
            File file = new File(path5);
            nvloc nv1=new nvloc(file);
            
            System.out.println("The nvloc value of the file in the folder "+path5+" is "+nv1.printLength(path5));
            
            menu();

            case "3":

            System.out.println("Choose the path to the csv file  like this example: ./tp1-code/outputfor10percent.csv");
            String  path3 = sc.nextLine();
            System.out.println("Choose the path to the folder which contains java files like this example: ./jfreechart/src/main/java ");
            String  path4 = sc.nextLine();
            lcsec lc1=new lcsec(path3,path4);
            lc1.makeCsv();
            System.out.println("The csv has been written in the folder ");
            
            menu();

            case "4":

            System.out.println("Choose the path to the csv file  like this example: ./tp1-code/outputfor10percent.csv");
            String  path6 = sc.nextLine();
            System.out.println("Choose the path to the folder which contains java files like this example: ./jfreechart/src/main/java ");
            String  path7 = sc.nextLine();
            egon eg1=new egon(path6,path7);
            System.out.println("Enter the threshold a value between 1 and 99");
            String threshold=sc.nextLine();
            int seuil=Integer.parseInt(threshold);
            System.out.println("Those suspected class are: \n");
            eg1.executeEgon(seuil);
            
            
            menu();

            case "5":
            System.out.println("Thanks for using our program!");
            System.exit(0);

            default:

            System.out.println("Invalit input try again ");
            menu();



        }
    }

    public static void main(String[] args) throws IOException {

        
        
        menu();
        
       
        

        //Jls jl1=new Jls("./jfreechart/src/main/java");
        //jl1.makeCsv("./tp1-code/outputfor1percent.csv");

        // nJls jl2=new Jls("./jfreechart/src/main/java");
        //jl2.makeCsv("./tp1-code/outputfor5percent.csv");

        //Jls jl3=new Jls("./jfreechart/src/main/java");
        //jl3.makeCsv("./tp1-code/outputfor10percent.csv");

        //Test 
        //lcsec lc1=new lcsec ("./tp1-code/outputfor1percent.csv","./jfreechart/src/main/java");
        //lc1.makeCsv();

        //lcsec lc2=new lcsec ("./tp1-code/outputfor5percent.csv","./jfreechart/src/main/java");
        //lc2.makeCsv();

        //lcsec lc3=new lcsec ("./tp1-code/outputfor10percent.csv","./jfreechart/src/main/java");
        //lc3.makeCsv();

        //egon ex1 = new egon("./tp1-code/outputfor1percent.csv", "./jfreechart/src/main/java");
       // ex1.executeEgon(1);
        //egon ex2 = new egon("./tp1-code/outputfor5percent.csv", "./jfreechart/src/main/java");
        //ex2.executeEgon(5);
        //egon ex3 = new egon("./tp1-code/outputfor10percent.csv", "./jfreechart/src/main/java");
        //ex3.executeEgon(10);
        
        
    }
    
}
