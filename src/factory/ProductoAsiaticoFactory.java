package factory;

import productos.Producto;
import productos.ProductoAsiatico;

public class ProductoAsiaticoFactory implements ProductoFactory {
	@Override
	public Producto crearProducto(String nombre, double precio, String tipo, String fechaCaducidad, String numeroLote,
			String fechaFabricacion, String tipoPiel, String paisOrigen, String unused) {
		return new ProductoAsiatico(nombre, precio, tipo, fechaCaducidad, numeroLote, fechaFabricacion, tipoPiel,
				paisOrigen);
	}
}
