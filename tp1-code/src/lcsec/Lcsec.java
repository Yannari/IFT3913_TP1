package lcsec;

import java.io.*;
import java.util.ArrayList;

public class Lcsec {

	private File filePath;
	private String csvPath;
	private int index;
	private ArrayList<String> csvContent;
	private ArrayList<Class> classlist;
	private ArrayList<String> classNameList;

	public Lcsec(String csvPath, String filePath) {
		this.csvPath = csvPath;
		this.filePath = new File(filePath);
		this.classlist = this.csvToList();
		this.index = 0;
		this.getall(this.filePath);
		this.makeCsv();
		System.out.println(classlist.size());
	}
	
	

	//lit le csv et ajoute le contenu de chaque ligne dans un ArrayList (1 element = 1 ligne)
	public ArrayList<String> readCsv() {

		ArrayList<String> csvList = new ArrayList<>();
		try {
			FileReader file = new FileReader(this.csvPath);
			BufferedReader br=new BufferedReader(file); 
			String line; 

			while((line = br.readLine()) != null) {
				csvList.add(line);
			}
			br.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		this.csvContent = csvList;
		return csvList;
	}

	// lit le csv et récupère seulement la partie du nom - son extension 
	//retourne un ArrayList<String> avec les noms des classes 
	public ArrayList<Class> csvToList(){

		ArrayList<String> content = this.readCsv();
		ArrayList<Class> csvList = new ArrayList<Class>();

		for(int i = 0; i < content.size(); i++) {
			String line [] = content.get(i).split(","); 
			//on retire l'extension du fichier et on ajoute les noms dans le tableau
			
			csvList.add(new Class(line[2].substring(0, line[2].lastIndexOf("."))));

			//System.out.println(csvList.get(i).getName());
		}

		return csvList;

	}

	private void getall(File f){
		File[] files = f.listFiles();
		for (File fs: files) {
			//Si c'est un dossier on parcourt
			if(fs.isDirectory()==true) {
				getall(fs);
			}
			//Si c'est un fichier .java on le lit et on check tous les autres 
			//noms de classes pour voir si l'un d'entre eux apparait dans le fichier
			//si oui on incrémente la valeur de couplage pour les deux classes
			if(fs.getName().toLowerCase().endsWith(".java")) {    
					System.out.println("file : "+this.index + " "+fs.getName());
					this.wordFind(fs, this.index);
					this.index +=1;
			}
		}
	}
	//inspirée de https://www.candidjava.com/tutorial/program-to-search-word-in-a-file/
	public void wordFind(File f1, int currentIndex) {
		try {
			//Creation of File Descriptor for input file
			FileReader fr = new FileReader(f1);  //Creation of File Reader object
			BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
			String line[];
			String s;  
			 
			//Intialize the word to zero
			//Reading Content from the file
			while((s=br.readLine())!=null){
				line=s.split(" ");  
				//Pour chaque mot de la ligne on le compare à tous 
				//les autres noms de classes != nom du fichier actuel
				
				for (String word : line){	
					for( int i = 0; i<this.classlist.size(); i++) {
						if(i!= currentIndex){	
							if (this.classlist.get(i).getName().equals(word)) {   //Search for the given word
								System.out.println("something should happen");
								this.classlist.get(currentIndex).increCoupling();
								this.classlist.get(i).increCoupling();
							}
						}
						
					}
				
				}
			}
			br.close();
			fr.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
	}
	
	public void makeCsv() {
		
		try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter("./output/LCSECoutput.csv"));
	        for(int i = 0; i<classlist.size();i++) {
	        	writer.write(this.csvContent.get(i) +", "+ classlist.get(i).getCoupling());
				writer.newLine();
	        }
	        
			writer.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}


}

