package unico;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

import model.empleado;

public class principal {

	public static void main(String[] args) throws IOException {

		byte bOpcion;
		String fileName = "empleados.db";

		RandomAccessFile fch = new RandomAccessFile(fileName, "rw");
		System.out.println(fch.length());
		do {
			bOpcion = menu();

			switch (bOpcion) {
			case 1:

				ctrl.ctrlPrincipal.listarTodo(fch);

				break;
			case 2: // BUSCAR POR POSICION
				byte bPos = (byte) Libreria.leer("Introduce una posicion", 1, (fch.length()) / 130, -1, -1, (byte) 1);
				ctrl.ctrlPrincipal.buscarPos(fch, bPos);
				break;
			case 3: // MODIFICAR
				byte bPos2 = (byte) Libreria.leer("Introduce una posicion", 1, (fch.length()) / 130, -1, -1, (byte) 1);
				ctrl.ctrlPrincipal.modificar(fch, bPos2, crear());
				break;
			case 4: // AÑADIR

				ctrl.ctrlPrincipal.escribirRegistro(fch, crear());
				break;

			default:
				System.out.println("Hasta luego.");
				System.exit(0);
			}

		} while (bOpcion != 5);

	}

	public static byte menu() {
		System.out.println("\n##################################");

		System.out.println("############# MENU ###############");

		System.out.println("##################################");
		System.out.println("1. LISTAR TODO");
		System.out.println("2. BUSCAR POR POSICION");
		System.out.println("3. MODIFICAR");
		System.out.println("4. AÑADIR");
		System.out.println("5. SALIR" + "\n");
		return (byte) Libreria.leer("Introduce una opcion", 1, 5, -1, -1, (byte) 1);
	}

	public static empleado crear() {

		String sNombre = (String) Libreria.leer("Introduce un nombre", 1, 10, -1, -1, (byte) 6);
		String sApellidos = (String) Libreria.leer("Introduce los apellidos", 1, 20, -1, -1, (byte) 6);
		long lTlf = (long) Libreria.leer("Introduce el numero de tlf", 1, 1000000000, -1, -1, (byte) 4);
		String sCorreo = (String) Libreria.leer("Introduce un correo", 1, 25, -1, -1, (byte) 6);
		int iEdad = (int) Libreria.leer("Introduce la edad", 1, 100, -1, -1, (byte) 3);
		double dSueldo = (double) Libreria.leer("Introduce el sueldo", -1, -1, 1, 10000, (byte) 7);

		return new empleado(sNombre, sApellidos, lTlf, sCorreo, iEdad, dSueldo);

	}

}
