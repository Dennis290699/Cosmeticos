# Tienda de Cosméticos

Este proyecto simula una tienda de cosméticos que permite realizar pedidos, agregar productos al carrito de compras y generar una factura detallada. La tienda trabaja con tres tipos de productos: europeos, asiáticos y americanos. 

## Patrones de Diseño Utilizados

### 1. Factory Method

**Descripción:** El patrón Factory Method define una interfaz para crear un objeto, pero permite a las clases delegar la instanciación a subclases. Este patrón ayuda a desacoplar el código que crea los objetos del código que los utiliza.

**Implementación en el Proyecto:**
- Se utiliza para crear instancias de diferentes tipos de productos (europeos, asiáticos, americanos) sin especificar la clase exacta del producto que se va a crear.
- Clases involucradas: `ProductoFactory`, `ProductoEuropeoFactory`, `ProductoAsiaticoFactory`, `ProductoAmericanoFactory`.

```java
// ProductoFactory.java
public abstract class ProductoFactory {
    public abstract Producto crearProducto(String nombre, double precio, String tipo, String fechaCaducidad, String numeroLote, String fechaFabricacion, String paisOrigen, String extra1, String extra2);
}

// ProductoEuropeoFactory.java
public class ProductoEuropeoFactory extends ProductoFactory {
    @Override
    public Producto crearProducto(String nombre, double precio, String tipo, String fechaCaducidad, String numeroLote, String fechaFabricacion, String paisOrigen, String normaFabricacion, String extra2) {
        return new ProductoEuropeo(nombre, precio, tipo, fechaCaducidad, numeroLote, fechaFabricacion, paisOrigen, normaFabricacion);
    }
}

// ProductoAsiaticoFactory.java y ProductoAmericanoFactory.java implementan ProductoFactory de manera similar
```

### 2. Composite

**Descripción:** El patrón Composite permite a los clientes tratar de manera uniforme objetos individuales y composiciones de objetos. Este patrón compone objetos en estructuras de árbol para representar jerarquías parte-todo.

**Implementación en el Proyecto:**
- Se utiliza para gestionar productos individuales y carritos de compras de manera uniforme.
- Clases involucradas: `ComponenteProducto`, `ProductoIndividual`, `CarritoCompra`.

```java
// ComponenteProducto.java
public interface ComponenteProducto {
    void agregar(ComponenteProducto componente);
    void eliminar(ComponenteProducto componente);
    void mostrarInformacion();
    double calcularPrecio();
}

// ProductoIndividual.java
public class ProductoIndividual implements ComponenteProducto {
    private Producto producto;

    // Implementaciones de los métodos de la interfaz
}

// CarritoCompra.java
public class CarritoCompra implements ComponenteProducto {
    private List<ComponenteProducto> productos = new ArrayList<>();

    // Implementaciones de los métodos de la interfaz
}
```

### 3. Observer

**Descripción:** El patrón Observer define una dependencia uno-a-muchos entre objetos para que cuando un objeto cambie de estado, todos sus dependientes sean notificados y actualizados automáticamente.

**Implementación en el Proyecto:**
- Se utiliza para notificar a la factura cuando se agregan productos al carrito de compras.
- Clases involucradas: `Sujeto`, `Observador`, `CarritoCompra`, `Factura`.

```java
// Sujeto.java
public interface Sujeto {
    void agregarObservador(Observador observador);
    void eliminarObservador(Observador observador);
    void notificarObservadores();
}

// Observador.java
public interface Observador {
    void actualizar();
}

// CarritoCompra.java
public class CarritoCompra implements Sujeto {
    private List<Observador> observadores = new ArrayList<>();

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

// Factura.java
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
        carrito.mostrarInformacion();
        System.out.println("Total: " + carrito.calcularPrecio());
    }
}
```

## Ejecución del Proyecto

Para ejecutar el proyecto, simplemente compila y ejecuta la clase `Main`:

```java
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

        Producto europeo1 = europeoFactory.crearProducto("Crema Europea", 50.0, "Permanente", "2025-12-31", "L1234", "2023-01-01", "Francia", "1223/2009", "");
        Producto asiatico1 = asiaticoFactory.crearProducto("Serum Asiático", 30.0, "Rutina Facial", "2024-06-30", "L5678", "2022-12-01", "Grasa", "Corea del Sur", "");
        Producto americano1 = americanoFactory.crearProducto("Loción Americana", 40.0, "Hidratante", "2025-03-31", "L9101", "2023-05-15", "USA", "FDA1234", "No ingerir");

        CarritoCompra carrito = new CarritoCompra();
        Factura factura = new Factura(carrito);

        carrito.agregar(new ProductoIndividual(europeo1));
        carrito.agregar(new ProductoIndividual(asiatico1));
        carrito.agregar(new ProductoIndividual(americano1));

        factura.imprimirFactura();
    }
}
```