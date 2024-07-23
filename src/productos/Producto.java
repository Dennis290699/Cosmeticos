package productos;

public abstract class Producto {
	protected String nombre;
	protected double precio;
	protected String tipo;
	protected String fechaCaducidad;
	protected String numeroLote;

	public Producto(String nombre, double precio, String tipo, String fechaCaducidad, String numeroLote) {
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
		this.fechaCaducidad = fechaCaducidad;
		this.numeroLote = numeroLote;
	}

	public double getPrecio() {
		return precio;
	}

	public abstract void mostrarInformacion();
}
