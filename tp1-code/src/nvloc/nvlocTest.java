package nvloc;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class nvlocTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine();
		File file = new File(path);
        nvloc test = new nvloc(file);
		System.out.println(test.printLength(path));
	

	}

}