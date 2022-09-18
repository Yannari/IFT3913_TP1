package lcsec;
import java.io.*;
import java.util.ArrayList;

public class Lcsec {
	
	//tableau qui contient à chaque index le nombre de couplage d'une classe avec une autre 
	private int[] coupleCounter;
	//tableau qui contient les noms de tous les fichiers du dossier
	private String[] fileList;
	private String filePath;
	
	//csv info
	private String csvPath;
	private ArrayList<String> csvContent;
	
	public Lcsec(String csvPath, String filePath) {
		this.csvPath = csvPath;
		this.filePath = filePath;
		this.fileList = this.csvToTable();
		this.coupleCounter = new int[fileList.length];
		
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
				System.out.println(line);
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
	public String[] csvToTable(){
		
		ArrayList<String> content = this.readCsv();
		int tableLength = content.size();
		
		String csvTable[] = new String[tableLength];
		for(int i = 0; i < tableLength; i++) {
			String line [] = content.get(i).split(","); 
			//on retire l'extension du fichier et on ajoute les noms dans le tableau
			csvTable[i] = line[2].substring(0, line[2].lastIndexOf("."));;
			System.out.println(csvTable[i]);
		}
		
		return csvTable;
	
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
