package Controller;

import static Controller.ProductosController.bebidas;
import static Controller.ProductosController.guardarCambiosYRetornar;
import Model.Bebidas;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BebidasController {

    public static void cargarBebidas() {
        bebidas.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("bebidas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(",");
                if (p.length == 5) {
                    bebidas.add(new Bebidas(p[0], p[1], Integer.parseInt(p[2]), p[3], Integer.parseInt(p[4])));
                }
            }
        } catch (IOException e) {
        }
    }

    public static void guardarBebidas() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("bebidas.txt"))) {
            for (Bebidas b : bebidas) {
                bw.write(b.getNombre() + "," + b.getDescripcion() + "," + b.getPrecio() + ","
                        + b.getTipo() + "," + b.getCantidad());
                bw.newLine();
            }
        } catch (IOException e) {
        }
    }

    public static boolean eliminarBebida(String nombre) {
        return bebidas.removeIf(b -> b.getNombre().equals(nombre)) && guardarCambiosYRetornar(true, "bebidas");
    }

    public static boolean modificarBebida(Bebidas existente, Bebidas nuevo) {
        int i = bebidas.indexOf(existente);
        if (i != -1) {
            bebidas.set(i, nuevo);
        }
        return guardarCambiosYRetornar(i != -1, "bebidas");
    }

}
