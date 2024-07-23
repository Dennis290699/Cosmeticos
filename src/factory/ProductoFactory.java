package factory;

import productos.Producto;

public interface ProductoFactory {
	Producto crearProducto(String nombre, double precio, String tipo, String fechaCaducidad, String numeroLote,
			String fechaFabricacion, String paisOrigen, String extra1, String extra2);
}
