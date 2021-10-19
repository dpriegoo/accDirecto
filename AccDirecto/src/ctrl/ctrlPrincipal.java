package ctrl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import model.empleado;

public class ctrlPrincipal {
	//private static RandomAccessFile fch;
	// edad 4, sueldo 8, telefono 8, nombre 10, apellidos 20, email 25
	// total 4+8+4+20+40+50 = 130 bytes por empleado
	
	private static int longReg = 130;//5 caracteres x 2, 5 int y 8 double
	


	public static void escribirRegistro(RandomAccessFile fch, empleado empleado) {
		try {
			long posicion = fch.length();
			fch.seek(posicion);
			
			//nombre
			String nombre = empleado.getsNombreEmp();
			String apellido = empleado.getsApellEmp();
			long lNumero = empleado.getlNumeroTel();
			char letra;
			String sCorreo = empleado.getsCorreo();
			int iEdad = empleado.getiEdad();
			double dSueldo = empleado.getdSueldo();
			
			
			
			for (int i = 0; i < 10; i++) {
				letra = (i < nombre.length()) ? nombre.charAt(i) : ' ';
				fch.writeChar(letra);
			}
			
			letra = ' ';
			
			for (int i = 0; i < 20; i++) {
				letra = (i < apellido.length()) ? apellido.charAt(i) : ' ';
				fch.writeChar(letra);
			}
			
			fch.writeLong(lNumero);
			
			for (int i = 0; i < 25; i++) {
				letra = (i < sCorreo.length()) ? sCorreo.charAt(i) : ' ';
				fch.writeChar(letra);
			}
			
			fch.writeInt(iEdad);
	
			fch.writeDouble(dSueldo);
			
		} catch (IOException e) {
			System.err.println("El archivo no es accesible");
		}
	}

	private static long getPosicion(int numReg) {
		return (numReg-1) * longReg;
	}

public static void listarTodo(RandomAccessFile fch) throws IOException {
		
		
		String sNombre = "";
		String sApellidos = "";
		long lNumeroTelf = 0;
		String sCorreo = "";
		int iEdad = 0;
		double dSueldo = 0.0;
		
		for (int i=0; i<fch.length(); i+=130) {
		fch.seek(i);
		
			
			//nombre
			for(int i2 = 0; i2 < 10; i2++) {
				sNombre += fch.readChar();
			}
		
			
			//apellidos
			for(int i3 = 0; i3 < 20; i3++) {
				sApellidos += fch.readChar();
			
			}
			
			//telefono
			
			lNumeroTelf = fch.readLong();
		
			//correo
			for(int i4 = 0; i4 < 25; i4++) {
				sCorreo += fch.readChar();
			
			}
			
			//edad
			iEdad = fch.readInt();
			
			//altura
			dSueldo = fch.readDouble();
			

			
			
			//System.out.println(sNombre.replace(" ","")+" "+sApellidos.replace(" ","")+" "+lNumeroTelf+" "+sCorreo.replace(" ","")+" "+iEdad+" "+dSueldo);
			empleado e = new empleado (sNombre, sApellidos, lNumeroTelf, sCorreo, iEdad, dSueldo);
			System.out.println(e);
			sNombre = "";
			sApellidos = "";
			sCorreo = "";
		}
		
	
	}

public static void buscarPos(RandomAccessFile fch, int numReg) throws IOException {
	
	String sNombre = "";
	String sApellidos = "";
	long lNumeroTelf = 0;
	String sCorreo = "";
	int iEdad = 0;
	double dSueldo = 0.0;
	
	long posicion = getPosicion(numReg);
	fch.seek(posicion);
		
		
		//nombre
		for(int i2 = 0; i2 < 10; i2++) {
			sNombre += fch.readChar();
		}
	
		
		//apellidos
		for(int i3 = 0; i3 < 20; i3++) {
			sApellidos += fch.readChar();
		
		}
		
		//telefono
		
		lNumeroTelf = fch.readLong();
	
		//correo
		for(int i4 = 0; i4 < 25; i4++) {
			sCorreo += fch.readChar();
		
		}
		
		//edad
		iEdad = fch.readInt();
		
		//altura
		dSueldo = fch.readDouble();
		

		
		empleado e = new empleado (sNombre, sApellidos, lNumeroTelf, sCorreo, iEdad, dSueldo);
		System.out.println("\nª"+e);
		
	}
	


public static void modificar(RandomAccessFile fch, int numReg, empleado empleado) throws IOException {
	
	try {
		long posicion =  getPosicion(numReg);
		fch.seek(posicion);
		
		//nombre
		String nombre = empleado.getsNombreEmp();
		String apellido = empleado.getsApellEmp();
		long lNumero = empleado.getlNumeroTel();
		char letra;
		String sCorreo = empleado.getsCorreo();
		int iEdad = empleado.getiEdad();
		double dSueldo = empleado.getdSueldo();
		
		
		
		for (int i = 0; i < 10; i++) {
			letra = (i < nombre.length()) ? nombre.charAt(i) : ' ';
			fch.writeChar(letra);
		}
		
		letra = ' ';
		
		for (int i = 0; i < 20; i++) {
			letra = (i < apellido.length()) ? apellido.charAt(i) : ' ';
			fch.writeChar(letra);
		}
		
		fch.writeLong(lNumero);
		
		for (int i = 0; i < 25; i++) {
			letra = (i < sCorreo.length()) ? sCorreo.charAt(i) : ' ';
			fch.writeChar(letra);
		}
		
		fch.writeInt(iEdad);

		fch.writeDouble(dSueldo);
		
	} catch (IOException e) {
		System.err.println("El archivo no es accesible");
	}

}

	
	
}
