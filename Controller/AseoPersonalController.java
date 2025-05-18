package Controller;

import static Controller.ProductosController.aseoPersonal;
import static Controller.ProductosController.guardarCambiosYRetornar;
import Model.AseoPersonal;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AseoPersonalController {

    public static void cargarAseoPersonal() {
        aseoPersonal.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("aseoPersonal.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(",");
                if (p.length == 5) {
                    aseoPersonal.add(new AseoPersonal(p[0], p[1], Integer.parseInt(p[2]), p[3], Integer.parseInt(p[4])));
                }
            }
        } catch (IOException e) {
        }
    }

    public static void guardarAseoPersonal() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("aseoPersonal.txt"))) {
            for (AseoPersonal a : aseoPersonal) {
                bw.write(a.getNombre() + "," + a.getDescripcion() + "," + a.getPrecio() + ","
                        + a.getTipo() + "," + a.getCantidad());
                bw.newLine();
            }
        } catch (IOException e) {
        }
    }

    public static boolean eliminarAseoPersonal(String nombre) {
        return aseoPersonal.removeIf(a -> a.getNombre().equals(nombre)) && guardarCambiosYRetornar(true, "aseoPersonal");
    }

    public static boolean modificarAseoPersonal(AseoPersonal existente, AseoPersonal nuevo) {
        int i = aseoPersonal.indexOf(existente);
        if (i != -1) {
            aseoPersonal.set(i, nuevo);
        }
        return guardarCambiosYRetornar(i != -1, "aseoPersonal");
    }
}
