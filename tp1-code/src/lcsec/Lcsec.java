package lcsec;
import java.io.*;
import java.util.ArrayList;

public class Lcsec {
	
	private int[] coupleCounter;
	private String filePath;
	//csv info
	private String csvPath;
	private int lineNumber;
	
	
	public Lcsec(String csvPath, String filePath) {
		this.csvPath = csvPath;
		this.filePath = filePath;
		
	}
	
	// ouvrir le csv
	// déclarer un tableau de taille "ligneCsv"
	// on parcourt le dossier 
	// pour chaque fichier .java:
	//			on l'analyse et on vérifie si chaque fichiers 
	//			listés dans le csv apparait dans le contenu du fichier .java
	
	
	public void readCsv() {
		
		ArrayList<String> csvList = new ArrayList<>();
		int lineNumber = 0;
		try {
			FileReader file = new FileReader(this.csvPath);
			BufferedReader br=new BufferedReader(file); 
			String line; 
			
			while((line = br.readLine()) != null) {
				csvList.add(line);
				System.out.println(line);
			}
			
			
			
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	public void /*String[][]*/ csvToTable(){
	
	}
	
}
