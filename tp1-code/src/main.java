
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import jls.Jls;
import lcsec.lcsec;
import egon.egon;
public class main {


    public static void main(String[] args) throws IOException {

        
        //Test jls

        Jls jl1=new Jls("./jfreechart/src/main/java");
        jl1.makeCsv("./tp1-code/outputfor1percent.csv");

        //Jls jl2=new Jls("./jfreechart/src/main/java");
        //jl2.makeCsv("./tp1-code/outputfor5percent.csv");

        //Jls jl3=new Jls("./jfreechart/src/main/java");
        //jl3.makeCsv("./tp1-code/outputfor10percent.csv");

        //Test 
        lcsec lc1=new lcsec ("./tp1-code/outputfor1percent.csv","./jfreechart/src/main/java");
        lc1.makeCsv();

        lcsec lc2=new lcsec ("./tp1-code/outputfor5percent.csv","./jfreechart/src/main/java");
        lc2.makeCsv();

        lcsec lc3=new lcsec ("./tp1-code/outputfor10percent.csv","./jfreechart/src/main/java");
        lc3.makeCsv();

        egon ex1 = new egon("./tp1-code/outputfor1percent.csv", "./jfreechart/src/main/java");
        ex1.executeEgon(1);
        egon ex2 = new egon("./tp1-code/outputfor5percent.csv", "./jfreechart/src/main/java");
        ex2.executeEgon(5);
        egon ex3 = new egon("./tp1-code/outputfor10percent.csv", "./jfreechart/src/main/java");
        ex3.executeEgon(10);
        
        
    }
    
}
