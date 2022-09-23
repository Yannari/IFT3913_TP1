package lcsec;

import java.io.*;
import java.util.ArrayList;

public class Lcsec {
	
	public class Class{
		
		private String name;
		private int couplage;
		public Class(String name){
			this.name = name;
			this.couplage = 0;
		}
		
		public String getName() {
			return this.name;
		}
	}
	
	private String filePath;
	private String csvPath;
	private ArrayList<String> csvContent;
	private ArrayList<Class> classlist;
	
	public Lcsec(String csvPath, String filePath) {
		this.csvPath = csvPath;
		this.filePath = filePath;
		this.classlist = this.csvToList();
		
		
	}
	
	//lit le csv et ajoute le contenu de chaque ligne dans un ArrayList
	public ArrayList<String> readCsv() {
		
		ArrayList<String> csvList = new ArrayList<>();
		try {
			FileReader file = new FileReader(this.csvPath);
			BufferedReader br=new BufferedReader(file); 
			String line; 
			
			while((line = br.readLine()) != null) {
				csvList.add(line);
			}
			this.csvContent = csvList;
			br.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return csvList;
	}
	
	// lit le csv et récupère seulement la partie du nom - son extension 
	public ArrayList<Class> csvToList(){
		
		ArrayList<String> content = this.readCsv();
		ArrayList<Class> csvList = new ArrayList<Class>();
		
		for(int i = 0; i < content.size(); i++) {
			String line [] = content.get(i).split(","); 
			//on retire l'extension du fichier et on ajoute les noms dans le tableau
			csvList.add(new Class(line[2].substring(0, line[2].lastIndexOf("."))));
			System.out.println(csvList.get(i).getName());
		}
		
		return csvList;
	
	}
	
	private void getall(File f){
		File[] files = f.listFiles();
        for (File fs: files) {
        	if(fs.isDirectory()==true)
                getall(fs);
            if(fs.getName().toLowerCase().endsWith(".java")) {    
            	
            }
        }
    }
}

