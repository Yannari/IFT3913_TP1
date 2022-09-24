package egon;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import nvloc.nvloc;

import nvloc.nvloc;
import jls.*;
import lcsec.*;

public class egon {
    private ArrayList<ArrayList<String>> csvContent=new ArrayList<ArrayList<String>>();

	private String filePath;
    //csv info
	private String csvPath;

    public egon(String csvPath, String filePath)
    {
        this.csvPath = csvPath;
		this.filePath = filePath;
    }

    public void executeEgon(int seuil)
    {
        String writeCSV="";
        int count=0;
        if(seuil<1 || seuil > 99)
        {
            System.out.println("mauvais seuil");
            //return 0;
        }

        CSVtoString();
        completeCSVFile();
        List<Integer> list0 = suggestSuspectClass(seuil);

       
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.csvPath));
            for(Integer l0 : list0) {

                if(l0!=null)
                {
                    for(String s : csvContent.get(l0) )
                    {
                        if(count!=0)
                            writeCSV= writeCSV+", "+s;
                        else
                            writeCSV=s;
                        count++;
                    }
                    
                    System.out.println(writeCSV);
                    
                    writer.write(writeCSV);
                    writer.newLine();

                    writeCSV="";
                    count=0;
                }
               
            };
            //System.out.println("CSV is successfully written in the directory");
            writer.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }

       
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
                //Collections.addAll(csvList, contenu);
                
				csvList = new ArrayList<String>(Arrays.asList(contenu));
                
                
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
        lcsec test1 = new lcsec("C:/Users/yanna/OneDrive/Documents/GitHub/IFT3913_TP1/tp1-code/output.csv", filePath);
        for(int i = 0; i < csvContent.size(); i++) {
            
			ArrayList<String> contenu = csvContent.get(i);
			String path = contenu.get(0);
            File file = new File(path);
            nvloc test = new nvloc(file);
            int L=test.printLength(path);
            csvContent.get(i).add(String.valueOf(L));
            
		}
 
    }
    public List<Integer> suggestSuspectClass(Integer seuil)
    {
        Integer[][] csecmetric = new Integer [csvContent.size()][csvContent.size()];
        Integer[][] nvlocmetric = new Integer [csvContent.size()][csvContent.size()];
        Integer[] csecScores = new Integer [csvContent.size()];
        Integer[] nvlocScores = new Integer [csvContent.size()];

        Arrays.stream(csecmetric).forEach(a -> Arrays.fill(a, 0));
        Arrays.stream(nvlocmetric).forEach(a -> Arrays.fill(a, 0));
        

        for(int i = 0; i<csvContent.size();i++)
        {

            csecmetric[i][0] =  Integer.parseInt( csvContent.get(i).get(3) ) ;
            csecmetric[i][1] =  i ;
            
            nvlocmetric[i][0] =  Integer.parseInt( csvContent.get(i).get(4) ) ;
            nvlocmetric[i][1] =  i ;
        }
        
        csecScores=findBestScore(csecmetric, seuil);
        nvlocScores=findBestScore(nvlocmetric, seuil);

        

        List<Integer> list1= new ArrayList<Integer>(Arrays.asList(csecScores));
        
        List<Integer> list2= new ArrayList<Integer>(Arrays.asList(nvlocScores));


        List<Integer> intersectionList= intersection(list1, list2);
        
        System.out.println(intersectionList);

        return intersectionList;
    }

    public Integer[] findBestScore(Integer[][] score, Integer seuil){

        
        Integer[] is = new Integer [csvContent.size()];

        for(int i = 0; i<csvContent.size();i++)
        {
            Arrays.sort(score[i],Collections.reverseOrder());
        }

     

        float temp = (float)seuil / 100 * score.length;

        Integer avSeuil = Math.round(temp);

        
        for(int i = 0; i<=avSeuil;i++)
        {
            is[i]=score[i][1];
            
        }
        
        
        return is;

    }

    public <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                if(!list.contains(t))
                    list.add(t);
            }
        }
        
        return list;
    }
    
    



}
