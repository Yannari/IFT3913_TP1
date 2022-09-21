package egon;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import nvloc.nvloc;

import nvloc.nvloc;
import jls.*;
import lcsec.*;

public class egon {
    private ArrayList<ArrayList<String>> csvContent;

	private String filePath;
    //csv info
	private String csvPath;

    public egon(String csvPath, String filePath)
    {
        this.csvPath = csvPath;
		this.filePath = filePath;
    }

    //lit le csv et ajoute le contenu de chaque ligne dans un ArrayList
    public ArrayList<String> ReadCSV()
    {
        ArrayList<String> csvList = new ArrayList<>();
		try {
			FileReader file = new FileReader(this.csvPath);
			BufferedReader br=new BufferedReader(file); 
			String line; 
			
			while((line = br.readLine()) != null) {
                String[] contenu = line.split(", ");
				csvList = new ArrayList<>(Arrays.asList(contenu));
				csvContent.add(csvList);
			}
			
			br.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
        return csvList;
    }

    public String CSVtoString()
    {
        String Line="";
        ArrayList<String> content = this.ReadCSV();
        for(int i = 0; i < content.size(); i++) {
			Line  = String.join(",", content); 
			Line+="\n";
		}
        return Line;
    }

    private void completeCSVFile(){
        Jls test0 = new Jls(filePath);
        Lcsec test1 = new Lcsec("./output/JLSoutput.csv", filePath);
        for(int i = 0; i < csvContent.size(); i++) {
			ArrayList<String> contenu = csvContent.get(i);
			String path = contenu.get(0);
            File file = new File(path);
            nvloc test = new nvloc(file);
            int L=test.printLength(path);
            csvContent.get(i).add(String.valueOf(L));
		}
 
    }
    public ArrayList<String> suggestSuspectClass(Integer seuil)
    {
        Integer[][] csecmetric = new Integer [csvContent.size()][];
        Integer[][] nvlocmetric = new Integer [csvContent.size()][];
        Integer[] csecScores = new Integer [csvContent.size()];
        Integer[] nvlocScores = new Integer [csvContent.size()];

        for(int i = 0; i<csvContent.size();i++)
        {
            
            csecmetric[i][0] =  Integer.parseInt( csvContent.get(i).get(3) ) ;
            csecmetric[i][1] =  i ;
            nvlocmetric[i][0] =  Integer.parseInt( csvContent.get(i).get(4) ) ;
            nvlocmetric[i][1] =  i ;
        }
        csecScores=findBestScore(csecmetric, seuil);
        nvlocScores=findBestScore(nvlocmetric, seuil);
    }

    public Integer[] findBestScore(Integer[][] score, Integer seuil){

        Integer[] is = new Integer [csvContent.size()];
        for(int i = 0; i<csvContent.size();i++)
        {
            Arrays.sort(score[i],Collections.reverseOrder());
        }
        Integer avSeuil = Math.round(((seuil / 100) * score.length));
       

        for(int i = 0; i<avSeuil;i++)
        {
            is[i]=score[i][1];
        }


        return is;

    }
    
    



}
