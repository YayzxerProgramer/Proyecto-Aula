    package Model;

import java.util.ArrayList;

public class Medicamentos extends Productos {

    private String laboratorio;
    private String fechaVencimiento;
    private String lote;
    private String via;
    private static final ArrayList<Medicamentos> medicamentos = new ArrayList<>();

    public Medicamentos(String nombre, String descripcion ,int precio, String tipo, int cantidad, String laboratorio, String fechaVencimiento, String lote, String via) {
        super(nombre, descripcion, precio, tipo, cantidad);
        this.laboratorio = laboratorio;
        this.fechaVencimiento = fechaVencimiento;
        this.lote = lote;
        this.via = via;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    
    public static ArrayList<Medicamentos> getMedicamentos() {
        return medicamentos;
    }

    @Override
    public String toString() {
        return "Medicamentos{" + "nombre=" + getNombre() + ", precio=" + getPrecio() + ", descripcion=" + getDescripcion() + ", tipo=" + getTipo() + ", cantidad=" + getCantidad() + ", laboratorio=" + laboratorio + ", fechaVencimiento=" + fechaVencimiento + ", lote=" + lote + ", via=" + via + '}';
    }

}
