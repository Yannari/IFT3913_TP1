
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
    /**
     * recupere le choix du User
     * @return choice
     */
    public static String makeChoice() 
    {
            
                System.out.println("Select an option:\n 1- Jls\n 2- Nvloc\n 3- Lcsec\n 4- Egon\n 5- Exit");
                
                String  choice = sc.nextLine();  // Read user input
                
                return choice;
            
            
            
    }
    /**
     * Menu principal du programme
     */
    public static void menu()
    {
        String choice = makeChoice();
     
        switch( choice)
        {
            case "1":
            
           
            System.out.println("Choose the path to the folder which contains java  (ex : ./gr)");
            String  path = sc.nextLine();
            System.out.println("Choose the path of the folder where you want to create the file (ex : .)");
            String  path2 = sc.nextLine();
            path2=path2+"/output.csv ";
            Jls jl1=new Jls(path);
            jl1.makeCsv(path2);
            System.out.println("The csv has been written in the folder "+path2);
            
            menu();
            
            case "2":

            System.out.println("Choose the path to the java file (ex : ./file.java)");
            String  path5 = sc.nextLine();
            
            File file = new File(path5);
            nvloc nv1=new nvloc(file);
            
            System.out.println("The nvloc value of the file in the folder "+path5+" is "+nv1.printLength(path5));
            
            menu();

            case "3":

            System.out.println("Choose the path to the csv file like this example: ./output.csv");
            String  path3 = sc.nextLine();
            System.out.println("Choose the path to the folder which contains java files like this example: ./gr");
            String  path4 = sc.nextLine();
            lcsec lc1=new lcsec(path3,path4);
            lc1.makeCsv();
            System.out.println("The csv has been written in the folder ");
            
            menu();

            case "4":

            System.out.println("Choose the path to the csv file  (ex : ./output.csv)");
            String  path6 = sc.nextLine();
            System.out.println("Choose the path to the folder which contains java files (ex : ./gr)");
            String  path7 = sc.nextLine();
            egon eg1=new egon(path6,path7);
            System.out.println("Enter the threshold a value between 1 and 99");
            String threshold=sc.nextLine();
            int seuil=Integer.parseInt(threshold);

            System.out.println("The suspected class are: \n");
          

            eg1.executeEgon(seuil);
            
            
            menu();

            case "5":
            System.out.println("Thanks for using our program!");
            sc.close();
            System.exit(0);

            default:

            System.out.println("Invalit input try again ");
            menu();



        }
    }
    /**
     * Execution
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        
        
        menu();
        
       
        

        
        
    }
    
}
