package productos;

public class ProductoAmericano extends Producto {
	private String fechaFabricacion;
	private String paisOrigen;
	private String codigoOrganismoSupervision;
	private String advertencias;

	public ProductoAmericano(String nombre, double precio, String tipo, String fechaCaducidad, String numeroLote,
			String fechaFabricacion, String paisOrigen, String codigoOrganismoSupervision, String advertencias) {
		super(nombre, precio, tipo, fechaCaducidad, numeroLote);
		this.fechaFabricacion = fechaFabricacion;
		this.paisOrigen = paisOrigen;
		this.codigoOrganismoSupervision = codigoOrganismoSupervision;
		this.advertencias = advertencias;
	}

	@Override
	public void mostrarInformacion() {
		System.out.println("Producto Americano:");
		System.out.println("Nombre: " + nombre);
		System.out.println("Precio: " + precio);
		System.out.println("Tipo: " + tipo);
		System.out.println("Fecha de Caducidad: " + fechaCaducidad);
		System.out.println("Número de Lote: " + numeroLote);
		System.out.println("Fecha de Fabricación: " + fechaFabricacion);
		System.out.println("País de Origen: " + paisOrigen);
		System.out.println("Código de Supervisión: " + codigoOrganismoSupervision);
		System.out.println("Advertencias: " + advertencias);
	}
}
