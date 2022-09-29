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

public class nvloc {
	private File file;
	private List<String> filecontains;

//Constructeur
	public nvloc(File file) {
		this.file = file;
		this.filecontains = new ArrayList<String>();
		
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
	public void readFile() {
		String nomFichier = file.getAbsolutePath();
		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(nomFichier), StandardCharsets.ISO_8859_1);
		} catch (IOException e) {

			e.printStackTrace();
		}
		this.filecontains = lines;
	}
	/**
	 * 
	 * @param path
	 * @return la taille de la liste correspondant au nombre de lignes du fichier entre
	 */
	public  int printLength(String path) {
		
		File file = new File(path);
		this.file=file;
		try {
			readFile();
			List<String> contenueFichier = filecontains;

			Iterator<String> iterateur = contenueFichier.iterator();
			while (iterateur.hasNext()) {
				String str = iterateur.next();
				if (str == null || str.trim().isEmpty())
					iterateur.remove();
			}

			return contenueFichier.size();

		} catch (Exception e) {
			System.out.println("The file cannot be read, please try again");
			//main(null);
		}
		return 0;
	}

}