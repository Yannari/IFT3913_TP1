package jls;
import java.util.ArrayList;
import java.io.*;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Jls {
	
	private ArrayList<String> fileList;
	private String path;
	
	public Jls(String path) {
		this.fileList = new ArrayList<>();
		this.path = path;
	}
	//génère le fichier csv dans le dossier "output"
	public void makeCsv() {
		File pathFile = new File(this.path);
		getall(pathFile);
		for(String fs : this.fileList) {
			System.out.println(fs);
		};
		
		try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter("./output/JLSoutput.csv"));
	        for(String fs : this.fileList) {
				writer.write(fs);
				writer.newLine();
			};
			writer.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//parcourt récursivement un dossier et tous ses fichiers / sous dossiers
	//ajoute chaque fichier .java dans un arrayList
	
	private void getall(File f){
		File[] files = f.listFiles();
        for (File fs: files) {
        	if(fs.isDirectory()==true)
                getall(fs);
            if(fs.getName().toLowerCase().endsWith(".java")) {
            	//génère une ligne complète pour un fichier
            	this.fileList.add(fs +", "+ this.pathToPackage(fs.getPath())+ ", "+ fs.getName());
                
            }
        }
    } 
	
	//convertir un chemin en notation package 
	private String pathToPackage(String path) {
		String[] fpath = path.split("/");
		String str = "";
		for(int i = 1;i<fpath.length - 1; i++) {
			if(i == fpath.length - 2) {
			str+= fpath[i];
			}
			else {
				str+= fpath[i]+".";
			}
		}
		
		return str ;
	}
	

}
	

