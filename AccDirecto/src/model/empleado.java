package model;

public class empleado implements IEmpleado {
	private String sNombreEmp;
	private String sApellEmp;
	private long lNumeroTel;
	private String sCorreo;
	private int iEdad;
	private double dSueldo;
	
	
	
	public empleado(String sNombreEmp, String sApellEmp, long lNumeroTel, String sCorreo, int iEdad, double dSueldo) {
		super();
		this.sNombreEmp = sNombreEmp;
		this.sApellEmp = sApellEmp;
		this.lNumeroTel = lNumeroTel;
		this.sCorreo = sCorreo;
		this.iEdad = iEdad;
		this.dSueldo = dSueldo;
	}
	
	public String getsNombreEmp() {
		return sNombreEmp;
	}
	public void setsNombreEmp(String sNombreEmp) {
		if (this.sNombreEmp.length()>0 && this.sNombreEmp.length()<=MAXNOMBRE && !this.sNombreEmp.isEmpty()) {
		this.sNombreEmp = sNombreEmp;
		} else {
			System.out.println("Nombre fuera de rango (10)");
		}
	}
	public String getsApellEmp() {
		return sApellEmp;
	}
	public void setsApellEmp(String sApellEmp) {
		if (this.sApellEmp.length()>0 && !this.sApellEmp.isEmpty() && this.sApellEmp.length()<=MAXAPELLIDOS) {
		this.sApellEmp = sApellEmp;
		} else {
			System.out.println("Appellidos fuera de rango (20)");
		}
	}
	public long getlNumeroTel() {
		return lNumeroTel;
	}
	public void setlNumeroTel(long lNumeroTel) {
		this.lNumeroTel = lNumeroTel;
	}
	public String getsCorreo() {
		return sCorreo;
	}
	public void setsCorreo(String sCorreo) {
		if(this.sCorreo.length()>0 && !this.sCorreo.isEmpty() && this.sCorreo.length()<=MAXCORREO) {
		this.sCorreo = sCorreo;
		} else {
			System.out.println("Correo fuera de rango (25)");
		}
	}
	public int getiEdad() {
		return iEdad;
	}
	public void setiEdad(int iEdad) {
		this.iEdad = iEdad;
	}
	public double getdSueldo() {
		return dSueldo;
	}
	public void setdSueldo(double dSueldo) {
		this.dSueldo = dSueldo;
	}
	

	@Override
	public String toString() {
		return "empleado [NOMBRE= " + sNombreEmp.replace(" ","") + ", APELLIDOS= " + sApellEmp.replace(" ","") + ", TELEFONO= " + lNumeroTel
				+ ", CORREO= " + sCorreo.replace(" ","") + ", EDAD= " + iEdad + ", SUELDO= " + dSueldo + "]";
	}
	
	
	
	
}
