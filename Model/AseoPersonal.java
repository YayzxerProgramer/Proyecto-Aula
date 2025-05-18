package Model;

public class AseoPersonal extends Productos {

    public AseoPersonal(String nombre, String descripcion ,int precio, String tipo, int cantidad) {
        super(nombre, descripcion, precio, tipo, cantidad);
    }

    @Override
    public String toString() {
        return "AseoPersonal{" + "nombre=" + getNombre() + ", precio=" + getPrecio() + ", descripcion=" + getDescripcion() + ", tipo=" + getTipo() + ", cantidad=" + getCantidad() + '}';
    }

}



