package nvloc;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class nvloc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine();
		File file = new File(path);
		try {
			nvlocClass test = new nvlocClass(file);
			List<String> contenueFichier = test.getFileContent();

			Iterator<String> iterateur = contenueFichier.iterator();
			while (iterateur.hasNext()) {
				String str = iterateur.next();
				if (str == null || str.trim().isEmpty())
					iterateur.remove();
			}

			System.out.println(contenueFichier.size());
		} catch (Exception e) {
			System.out.println("The file cannot be read, please try again");
			main(null);
		}

	}

}