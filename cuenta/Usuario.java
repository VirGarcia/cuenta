//librerias importadas
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Usuario {
	//atributos
	private String nombre;
	private int edad;
	private String DNI;
	
	//constructor 
	public Usuario () {
	
	}
	
	//getters y setters
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad=edad;
	}
	
	public String getDNI() {
		return DNI;
	}
	
	public boolean setDNI(String DNI) {
		//comprobar DNI mediante patron 
		String patronDNI= "^\\d{8}-?[A-Z]$";
		String formato = "DNI incorrecto, introduzca de nuevo.";
		Pattern patron = Pattern.compile(patronDNI);
		try {
		Matcher correcto = patron.matcher(DNI);
		if (correcto.matches()) {
			this.DNI=DNI;
			return true;
		}else {
			System.out.println(formato);
			return false;
			
		}
		}catch (Exception ex) {
			return false;
		}
	}
	

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", edad=" + edad + ", DNI=" + DNI + "]";
	}
	
}