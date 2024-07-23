package productos;

public class ProductoAsiatico extends Producto {
	private String fechaFabricacion;
	private String tipoPiel;
	private String paisOrigen;

	public ProductoAsiatico(String nombre, double precio, String tipo, String fechaCaducidad, String numeroLote,
			String fechaFabricacion, String tipoPiel, String paisOrigen) {
		super(nombre, precio, tipo, fechaCaducidad, numeroLote);
		this.fechaFabricacion = fechaFabricacion;
		this.tipoPiel = tipoPiel;
		this.paisOrigen = paisOrigen;
	}

	@Override
	public void mostrarInformacion() {
		System.out.println("Producto Asiático:");
		System.out.println("Nombre: " + nombre);
		System.out.println("Precio: " + precio);
		System.out.println("Tipo: " + tipo);
		System.out.println("Fecha de Caducidad: " + fechaCaducidad);
		System.out.println("Número de Lote: " + numeroLote);
		System.out.println("Fecha de Fabricación: " + fechaFabricacion);
		System.out.println("Tipo de Piel: " + tipoPiel);
		System.out.println("País de Origen: " + paisOrigen);
	}
}
