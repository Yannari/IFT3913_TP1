package egon;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import jls.Jls;
import lcsec.lcsec;
import egon.egon;
public class test {


    public static void main(String[] args) throws IOException {

        /*FileReader file = new FileReader("C:/Users/yanna/OneDrive/Documents/GitHub/IFT3913_TP1/tp1-code/gr/spinellis/ckjm/MethodVisitor.java");
        try (BufferedReader br = new BufferedReader(file)) {
            String line;
            while ((line = br.readLine()) != null) {
               System.out.println(line);
            }
        }*/
        System.out.println("test");
        Jls test=new Jls("C:/Users/yanna/OneDrive/Documents/GitHub/IFT3913_TP1/tp1-code/gr/spinellis/ckjm");
        test.makeCsv("C:/Users/yanna/OneDrive/Documents/GitHub/IFT3913_TP1/tp1-code/output.csv");
        lcsec test2=new lcsec ("C:/Users/yanna/OneDrive/Documents/GitHub/IFT3913_TP1/tp1-code/output.csv","C:/Users/yanna/OneDrive/Documents/GitHub/IFT3913_TP1/tp1-code/gr/spinellis/ckjm");
        test2.makeCsv();

        egon test3 = new egon("C:/Users/yanna/OneDrive/Documents/GitHub/IFT3913_TP1/tp1-code/output.csv", "C:/Users/yanna/OneDrive/Documents/GitHub/IFT3913_TP1/tp1-code/gr/spinellis/ckjm");
        test3.executeEgon(50);
        
        
    }
    
}
