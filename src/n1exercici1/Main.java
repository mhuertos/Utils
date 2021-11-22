package n1exercici1;

import java.io.File;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		
		File dir = new File("C:\\Users\\Marcos");
		String[] directorio = dir.list();
		Arrays.sort(directorio);
		
		for(String e: directorio) {
			System.out.println(e);
		}
		
		
	}
}
