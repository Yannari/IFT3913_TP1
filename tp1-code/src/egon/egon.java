package egon;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
        for(int i = 0; i < csvContent.size(); i++) {
			ArrayList<String> contenu = csvContent.get(i);
			String path = contenu.get(0);
            File file = new File(path);
            nvloc test = new nvloc(file);
            int L=test.printLength(path);
            csvContent.get(i).add(String.valueOf(L));
		}
 
    }
    public ArrayList<String> suggestSuspectClass(Arra)

}
