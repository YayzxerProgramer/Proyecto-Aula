package Model;

import java.util.ArrayList;

public class Carrito {
    private static final ArrayList<Object> carrito = new ArrayList<>();

    public static void agregarProducto(Object producto) {
        carrito.add(producto);
    }

    public static ArrayList<Object> getCarrito() {
        return carrito;
    }

    public static void limpiarCarrito() {
        carrito.clear();
    }
}
