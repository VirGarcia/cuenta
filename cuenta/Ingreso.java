//importamos las librerias para NOTACION EUROPEA
import java.text.NumberFormat;
import java.util.Locale;

public class Ingreso extends Dinero {
	private double ingreso;
	
	Locale spanish = new Locale ("es", "ES");
	NumberFormat nf = NumberFormat.getInstance(spanish);
	
	public Ingreso() {
		
	}

	
	public double getIngreso() {
		
		return ingreso;
	}
	
	
	public void setIngreso (double ingreso, String description) {
		dinero=ingreso;
		this.ingreso=ingreso;
		this.description=description;
	}
	@Override
	public String toString() {
		return "Ingreso [operacion=" + description + ", importe=" + nf.format(ingreso) + " €]";
	}
}