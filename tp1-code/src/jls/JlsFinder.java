package jls;
import java.util.ArrayList;
import java.io.*;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class JlsFinder {
	
	private ArrayList<String> fileList;
	private String path;
	
	public JlsFinder(String path) {
		this.fileList = new ArrayList<>();
		this.path = path;
	}
	
	public void makeCsv() {
		File pathFile = new File(this.path);
		getall(pathFile);
		for(String fs : this.fileList) {
			System.out.println(fs);
		};
		
		try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter("./output/output.csv"));
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
	
	public void getall(File f){
		File[] files = f.listFiles();
        for (File fs: files) {
        	if(fs.isDirectory()==true)
                getall(fs);
            if(fs.getName().toLowerCase().endsWith(".java")) {
            	this.fileList.add(fs +", "+ this.pathToPackage(fs.getPath())+ ", "+ fs.getName());
                //System.out.println(fs +", "+ this.pathToPackage(fs.getPath())+ ", "+ fs.getName());
            }
        }
    }
	
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
	

