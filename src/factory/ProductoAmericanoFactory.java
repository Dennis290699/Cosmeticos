package factory;

import productos.Producto;
import productos.ProductoAmericano;

public class ProductoAmericanoFactory implements ProductoFactory {
	@Override
	public Producto crearProducto(String nombre, double precio, String tipo, String fechaCaducidad, String numeroLote,
			String fechaFabricacion, String paisOrigen, String codigoOrganismoSupervision, String advertencias) {
		return new ProductoAmericano(nombre, precio, tipo, fechaCaducidad, numeroLote, fechaFabricacion, paisOrigen,
				codigoOrganismoSupervision, advertencias);
	}
}
