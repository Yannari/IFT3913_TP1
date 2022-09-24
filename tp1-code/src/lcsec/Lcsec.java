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
            
            //System.out.println(i+"<"+paths.length+" :"+ "fs: "+csvString[i]); 
        }
        
        return csvString;
    }
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }

 
    
}
