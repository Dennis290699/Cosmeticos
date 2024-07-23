package component;

import productos.Producto;

public class ProductoIndividual implements ComponenteProducto {
	private Producto producto;

	public ProductoIndividual(Producto producto) {
		this.producto = producto;
	}

	@Override
	public void agregar(ComponenteProducto componente) {
		// No se aplica
	}

	@Override
	public void eliminar(ComponenteProducto componente) {
		// No se aplica
	}

	@Override
	public void mostrarInformacion() {
		producto.mostrarInformacion();
	}

	@Override
	public double calcularPrecio() {
		return producto.getPrecio();
	}
}
