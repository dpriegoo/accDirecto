package model;

public interface IEmpleado {
	
	public final int MAXNOMBRE = 10;
	public final int MAXAPELLIDOS = 20;
	public final int MAXCORREO = 25;
	
	
	public String getsNombreEmp();
	public void setsNombreEmp(String sNombreEmp);
	public String getsApellEmp();
	public void setsApellEmp(String sApellEmp);
	public long getlNumeroTel();
	public void setlNumeroTel(long lNumeroTel);
	public String getsCorreo();
	public void setsCorreo(String sCorreo);
	public int getiEdad();
	public void setiEdad(int iEdad);
	public double getdSueldo();
	public void setdSueldo(double dSueldo);
}
