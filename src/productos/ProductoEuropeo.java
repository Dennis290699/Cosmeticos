package productos;

public class ProductoEuropeo extends Producto {
	private String fechaFabricacion;
	private String paisOrigen;
	private String normaFabricacion;

	public ProductoEuropeo(String nombre, double precio, String tipo, String fechaCaducidad, String numeroLote,
			String fechaFabricacion, String paisOrigen, String normaFabricacion) {
		super(nombre, precio, tipo, fechaCaducidad, numeroLote);
		this.fechaFabricacion = fechaFabricacion;
		this.paisOrigen = paisOrigen;
		this.normaFabricacion = normaFabricacion;
	}

	@Override
	public void mostrarInformacion() {
		System.out.println("Producto Europeo:");
		System.out.println("Nombre: " + nombre);
		System.out.println("Precio: " + precio);
		System.out.println("Tipo: " + tipo);
		System.out.println("Fecha de Caducidad: " + fechaCaducidad);
		System.out.println("Número de Lote: " + numeroLote);
		System.out.println("Fecha de Fabricación: " + fechaFabricacion);
		System.out.println("País de Origen: " + paisOrigen);
		System.out.println("Norma de Fabricación: " + normaFabricacion);
	}
}
