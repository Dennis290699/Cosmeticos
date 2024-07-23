package observer;

import java.util.ArrayList;
import java.util.List;

import component.ComponenteProducto;

public class CarritoCompra implements ComponenteProducto, Sujeto {
	private List<ComponenteProducto> productos = new ArrayList<>();
	private List<Observador> observadores = new ArrayList<>();

	@Override
	public void agregar(ComponenteProducto componente) {
		productos.add(componente);
		notificarObservadores();
	}

	@Override
	public void eliminar(ComponenteProducto componente) {
		productos.remove(componente);
		notificarObservadores();
	}

	@Override
	public void mostrarInformacion() {
		for (ComponenteProducto producto : productos) {
			producto.mostrarInformacion();
		}
	}

	@Override
	public double calcularPrecio() {
		double total = 0;
		for (ComponenteProducto producto : productos) {
			total += producto.calcularPrecio();
		}
		return total;
	}

	@Override
	public void agregarObservador(Observador observador) {
		observadores.add(observador);
	}

	@Override
	public void eliminarObservador(Observador observador) {
		observadores.remove(observador);
	}

	@Override
	public void notificarObservadores() {
		for (Observador observador : observadores) {
			observador.actualizar();
		}
	}
}
