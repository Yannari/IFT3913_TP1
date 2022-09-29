package lcsec;

import java.io.*;

import java.util.Arrays;

public class lcsec {
    private String folderPath;
	private String csvPath;


    public lcsec(String csvPath, String folderPath)
    {
        this.csvPath = csvPath;
	    this.folderPath = folderPath;
    }
    //génère le fichier csv dans le dossier entre par l'utilisateur
    public void makeCsv()
    {
        
        String[] result = readCSV();
        
        
		try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(this.csvPath));
	        for(String fs : result) {
                                            
				writer.write(fs);
				writer.newLine();
			};
			writer.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
    }
    //lit le fichier csv entre en parametre lors de l'initialisation de la classe

    public String[] readCSV()
    {   
        
        int i=0,count=0;

        try{
            FileReader file0 = new FileReader(this.csvPath);
            BufferedReader br0=new BufferedReader(file0); 
            String lines0; 
                
                
            while((lines0 = br0.readLine()) != null) 
            {
                count++;

                
            }
            br0.close();
        }
        catch(Exception e){
			System.out.println(e);
		}

        String[] csvString = new String[count];
        String[] line = new String[count];
        String[] f = new String[count];
        String[] p = new String[count];
        try {
			FileReader file = new FileReader(this.csvPath);
			BufferedReader br=new BufferedReader(file); 
			String lines; 
            
            
			while((lines = br.readLine()) != null) {
                line = lines.split(" ");

                

				csvString[i] = lines;
                p[i] = line[0];
                f[i] = line[2].replace(" ", "") ;
                i++;
                
			}
			
			br.close();
		}
		catch(Exception e){
            
                
			System.out.println(e);
		}
        
		return csecScores(csvString, f, p);
    }
    /**
     * genere le score de couplage de chaque classe contenu dans les fichiers
     * java d'un dossier entre
     * @param csvString
     * @param files
     * @param paths
     * @return
     */
    public String[] csecScores(String[] csvString, String[] files , String[] paths)
    {
        
        Integer csecScores[] = new Integer [csvString.length];
        Arrays.fill(csecScores, 0);

        for(int i=0;i<paths.length;i++)
        {
            for(int j=0;j<paths.length;j++)
            {   
                
                paths[i]=paths[i].replace(",", "");
                paths[j]=paths[j].replace(",", "");

                if(Checkcouplage(paths[i],files[j])  | Checkcouplage(paths[j],files[i]) )
                {
                    csecScores[i]++;
                    csecScores[j]++;
                }
            }
            
            csvString[i]=csvString[i]+","+" "+Integer.toString(csecScores[i]);
            
            
        }
        
        return csvString;
    }
    /**
     * verifie si une classe d'un fichier est comprise dans une autre classe 
     * d'un autre fichier distinct
     * @param pathBase
     * @param strClass
     * @return true si la classe est trouve dans un fichier java false sinon
     */
    public boolean Checkcouplage(String pathBase,String strClass) 
    {
        String path= pathBase;

        strClass = "class"+" "+strClass;
        
        try {
       

			FileReader file = new FileReader(path);
			BufferedReader br = new BufferedReader(file) ;
            String line; 
            int i=0;
                
                while((line = br.readLine()) != null) {
                    
                    
                    String[] lines= line.split(" ");
                    
                    if(lines.length>1)
                    {
                        if(lines[0].equals("/")==false | lines[1].equals("/")==false )
                        {   
                            
                            if(line.contains(strClass))
                            {
                                
                                return true;
                            }
                        } 
                    }
                    i++;
                	 
                }
                
                br.close();
            
		}
		catch (IOException e) {
            
            e.printStackTrace();
        }

        return false;
    }

 
    
}
