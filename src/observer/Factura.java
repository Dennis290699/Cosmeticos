package observer;

import component.CarritoCompra;

public class Factura implements Observador {
	private CarritoCompra carrito;

	public Factura(CarritoCompra carrito) {
		this.carrito = carrito;
		carrito.agregarObservador(this);
	}

	@Override
	public void actualizar() {
		// Actualizar la interfaz de usuario cuando se agregan productos al carrito
	}

	public void imprimirFactura() {
		// Imprimir el detalle de la factura
		carrito.mostrarInformacion();
		System.out.println("Total: " + carrito.calcularPrecio());
	}
}
