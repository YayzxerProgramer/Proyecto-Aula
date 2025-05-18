package Model;

public class Bebidas extends Productos {
    
    public Bebidas(String nombre, String descripcion ,int precio, String tipo, int cantidad) {
        super(nombre, descripcion, precio, tipo, cantidad);
    }

    @Override
    public String toString() {
        return "Bebidas{" + "nombre=" + getNombre() + ", precio=" + getPrecio() + ", descripcion=" + getDescripcion() + ", tipo=" + getTipo() + ", cantidad=" + getCantidad() + '}';
    }


}
