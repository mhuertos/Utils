package n2exercici1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.Properties;

public class Main {

		public static void main(String[] args) {
			
			Properties prop = new Properties();
			try {
				prop.load(new FileInputStream("C:\\Users\\Marcos\\Desktop\\conf.properties"));
			
				String ruta = prop.getProperty("directorio");
				File dir = new File(ruta);
				File[] directorio = dir.listFiles();
				Arrays.sort(directorio);
				
				String fl = prop.getProperty("archivo");
				File nuevoArchivo = new File(fl);
			
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

