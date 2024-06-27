import java.text.NumberFormat;
import java.util.Locale;
import java.util.ArrayList;


public class Cuenta {
	
	//atributos
	private double saldo;
	private Usuario usuario;
	Locale spanish = new Locale ("es", "ES");
	NumberFormat nf = NumberFormat.getInstance(spanish);
	
	//guardamos las operaciones en ARRAYLIST
	private ArrayList<Gasto> gastos;
	private ArrayList<Ingreso> ingresos;

	
	//constructor
	public Cuenta (Usuario usuario){		
		this.usuario=usuario;
		this.saldo=0;
		this.gastos=new ArrayList<>();
		this.ingresos=new ArrayList<>();		
	}
	
	//getters y setters
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo (double saldo) {
		this.saldo=saldo;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario=usuario;
	}
	
	//creamos los metodos
	
	public double addIngresos(String description, double cantidad) {
		Ingreso ingresoAdcionar=new Ingreso ();
		ingresoAdcionar.setIngreso(cantidad, description);
		this.ingresos.add(ingresoAdcionar);
		setSaldo(this.saldo+cantidad);
		return this.getSaldo();
	}
	
	public double addGastos(String description, double cantidad) throws GastoException{
		//el if es para que no deje hacer la operacion si no hay saldo suficiente
		if (saldo>=cantidad){
			saldo = saldo - cantidad;
			Gasto gastoAdicionar = new Gasto ();								
			gastoAdicionar.setGasto(cantidad, description);
			this.gastos.add(gastoAdicionar);
		} else { throw new GastoException();
		
		}
		return saldo;
			
	}
	
	public ArrayList<Ingreso> getIngresos(){
		return ingresos;
		
	}
	public ArrayList<Gasto> getGastos(){
		return gastos;
	}
		
		
	
		
		@Override
		public String toString() {
			return "Cuenta [La cuenta de =" + getUsuario().getNombre() + ", tiene un saldo de=" + nf.format(saldo) + "euros"+ "]";
	}
}
