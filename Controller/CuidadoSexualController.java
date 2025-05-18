package Controller;

import static Controller.ProductosController.cuidadoSexual;
import static Controller.ProductosController.guardarCambiosYRetornar;
import Model.CuidadoSexual;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CuidadoSexualController {

    public static void cargarCuidadoSexual() {
        cuidadoSexual.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("cuidadoSexual.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(",");
                if (p.length == 5) {
                    cuidadoSexual.add(new CuidadoSexual(p[0], p[1], Integer.parseInt(p[2]), p[3], Integer.parseInt(p[4])));
                }
            }
        } catch (IOException e) {
        }
    }

    public static void guardarCuidadoSexual() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("cuidadoSexual.txt"))) {
            for (CuidadoSexual c : cuidadoSexual) {
                bw.write(c.getNombre() + "," + c.getDescripcion() + "," + c.getPrecio() + ","
                        + c.getTipo() + "," + c.getCantidad());
                bw.newLine();
            }
        } catch (IOException e) {
        }
    }

    public static boolean eliminarCuidadoSexual(String nombre) {
        return cuidadoSexual.removeIf(c -> c.getNombre().equals(nombre)) && guardarCambiosYRetornar(true, "cuidadoSexual");
    }

    public static boolean modificarCuidadoSexual(CuidadoSexual existente, CuidadoSexual nuevo) {
        int i = cuidadoSexual.indexOf(existente);
        if (i != -1) {
            cuidadoSexual.set(i, nuevo);
        }
        return guardarCambiosYRetornar(i != -1, "cuidadoSexual");
    }

}
