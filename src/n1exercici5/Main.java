package n1exercici5;

import java.lang.Exception;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	
	public static void main(String[] args) {
		
		Empleado emp_1 = new Empleado("Juan", 34000);
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\Marcos\\Desktop\\Docu.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(emp_1);
			oos.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		/////////////////////////////Deserialització////////////////////
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Marcos\\Desktop\\Docu.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Empleado nou_emp_1 = (Empleado)ois.readObject();
			System.out.println(nou_emp_1.toString());
			
		}catch(Exception e) {
			
		}
		
	}

}
