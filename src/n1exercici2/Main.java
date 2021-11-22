package n1exercici2;

import java.io.File;
import java.sql.Date;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		String ruta = "C:\\Users\\Marcos\\Desktop\\Prueba";
		File dir = new File(ruta);
		File[] directorio = dir.listFiles();
			
		Arrays.sort(directorio);
		mostraDirectori(directorio);
		
	}
	
	public static void mostraDirectori(File[] d) {
		
		for(int i = 0; i < d.length; i++) {
			
			if(d[i].isDirectory()){
				System.out.println("D - "+d[i]);
				File[] newDirectorio = d[i].listFiles();
				mostraDirectori(newDirectorio);
				
			}else if(d[i].isFile()) {
				long ultModif = d[i].lastModified();
				Date lastmodif = new Date(ultModif);
				System.out.println("F - "+d[i]+" \tÚltima modificació "+lastmodif);
			}
		}
	}
		
}
