package component;

//Interfaz Component
public interface ComponenteProducto {
	void agregar(ComponenteProducto componente);

	void eliminar(ComponenteProducto componente);

	void mostrarInformacion();

	double calcularPrecio();
}
