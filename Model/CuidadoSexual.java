package Model;

public class CuidadoSexual extends Productos {

    public static void cargarCuidadoSexual() {
    }
    
    public CuidadoSexual(String nombre, String descripcion ,int precio, String tipo, int cantidad) {
        super(nombre, descripcion, precio, tipo, cantidad);
    }

    @Override
    public String toString() {
        return "CuidadoSexual{" + "nombre=" + getNombre() + ", precio=" + getPrecio() + ", descripcion=" + getDescripcion() + ", tipo=" + getTipo() + ", cantidad=" + getCantidad() + '}';
    }


}
    