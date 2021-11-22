package n1exercici3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		String ruta = "C:\\Users\\Marcos\\Desktop\\Prueba";
		File dir = new File(ruta);
		File[] directorio = dir.listFiles();
		Arrays.sort(directorio);
		
		File nuevoArchivo = new File("C:\\Users\\Marcos\\Desktop\\dioptrias.txt");
		try {
			FileWriter fw = new FileWriter(nuevoArchivo);
			BufferedWriter bw = new BufferedWriter(fw);
			registraDirectorios(directorio, nuevoArchivo, bw);
			bw.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void registraDirectorios(File[] d, File f, BufferedWriter bw) {
		try {
			for(int i = 0; i < d.length; i++) {
				if(d[i].isDirectory()){
					bw.write("D - "+d[i]); 
					bw.newLine();
					File[] newDirectorio = d[i].listFiles();
					if(newDirectorio.length > 0) {
						registraDirectorios(newDirectorio, f, bw);
					}
				}else if(d[i].isFile()) {
					Date lastmodif = new Date(d[i].lastModified());
					bw.write("F - "+d[i]+" \tÚltima modificació "+lastmodif); 
					bw.newLine();
				}				
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}	
}
