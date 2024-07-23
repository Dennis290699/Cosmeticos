package factory;

import productos.Producto;
import productos.ProductoEuropeo;

public class ProductoEuropeoFactory implements ProductoFactory {
	@Override
	public Producto crearProducto(String nombre, double precio, String tipo, String fechaCaducidad, String numeroLote,
			String fechaFabricacion, String paisOrigen, String normaFabricacion, String unused) {
		return new ProductoEuropeo(nombre, precio, tipo, fechaCaducidad, numeroLote, fechaFabricacion, paisOrigen,
				normaFabricacion);
	}
}
