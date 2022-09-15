package nvloc;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class nvlocClass {
    private File file;
    private List<String> filecontains;
    

//Constructeur
public nvlocClass(File file)
{
    this.file=file;
    this.filecontains=new ArrayList<String>();
    readFile();
}
//GETTER
public File getFullFile() {
    return file;
}

public List<String> getFileContent() {
    return filecontains;
}

//SETTER	
public void setFile(File newFile) {
    this.file = newFile;
}

/**
 * @return le contenu du fichier dans la Arraylist Filecontains
 */
public void readFile() 
	  { 
		String nomFichier = file.getAbsolutePath();
	    List<String> lines = Collections.emptyList(); 
	    try
	    { 
	      lines = Files.readAllLines(Paths.get(nomFichier), StandardCharsets.ISO_8859_1); 
	    } 
	    catch (IOException e) 
	    { 
	    	 
	      e.printStackTrace(); 
	    } 
             this.filecontains = lines; 
	  } 




}