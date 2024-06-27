//importamos las librerias para NOTACION EUROPEA
import java.text.NumberFormat;
import java.util.Locale;

public class Gasto extends Dinero {
	private double gasto;
	
	Locale spanish = new Locale ("es", "ES");
	NumberFormat nf = NumberFormat.getInstance(spanish);
	
	public Gasto() {
		
	}

	
	public double getGasto() {
		
		return gasto;
	}
	
	
	public void setGasto (double gasto, String description) {
		dinero=gasto;
		this.gasto=gasto;
		this.description=description;
	}
	@Override
	public String toString() {
		return "Gasto [operacion=" + this.description + ", importe=" + nf.format(this.gasto) + " €]";
	}
}