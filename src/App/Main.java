package App;

import component.CarritoCompra;
import component.ProductoIndividual;
import factory.ProductoAmericanoFactory;
import factory.ProductoAsiaticoFactory;
import factory.ProductoEuropeoFactory;
import factory.ProductoFactory;
import observer.Factura;
import productos.Producto;

public class Main {
	public static void main(String[] args) {
		ProductoFactory europeoFactory = new ProductoEuropeoFactory();
		ProductoFactory asiaticoFactory = new ProductoAsiaticoFactory();
		ProductoFactory americanoFactory = new ProductoAmericanoFactory();

		Producto europeo1 = europeoFactory.crearProducto("Crema Europea", 50.0, "Permanente", "2025-12-31", "L1234",
				"2023-01-01", "Francia", "1223/2009", "");
		Producto asiatico1 = asiaticoFactory.crearProducto("Serum Asiático", 30.0, "Rutina Facial", "2024-06-30",
				"L5678", "2022-12-01", "Grasa", "Corea del Sur", "");
		Producto americano1 = americanoFactory.crearProducto("Loción Americana", 40.0, "Hidratante", "2025-03-31",
				"L9101", "2023-05-15", "USA", "FDA1234", "No ingerir");

		CarritoCompra carrito = new CarritoCompra();
		Factura factura = new Factura(carrito);

		carrito.agregar(new ProductoIndividual(europeo1));
		carrito.agregar(new ProductoIndividual(asiatico1));
		carrito.agregar(new ProductoIndividual(americano1));

		factura.imprimirFactura();
	}
}
