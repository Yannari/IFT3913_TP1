
import java.util.Scanner;
import csec.csec;
import Jls.Jls;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the path to the folder which contains java  (ex : ./gr)");
        String  path = sc.nextLine();
        System.out.println("Choose the path of the folder where you want to create the file (ex : .)");
        String  path2 = sc.nextLine();
        path2=path2+"/output.csv ";
        Jls jl1=new Jls(path);
        jl1.makeCsv(path2);
        csec lc1=new csec(path2);
        lc1.makeCsv();
        System.out.println("The csv has been written in the folder ");
    }
}