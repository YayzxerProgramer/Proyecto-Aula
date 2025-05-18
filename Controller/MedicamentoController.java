package Controller;

import static Controller.ProductosController.guardarCambiosYRetornar;
import static Controller.ProductosController.medicamentos;
import Model.Medicamentos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MedicamentoController {

    public static void cargarMedicamentos() {
        medicamentos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("medicamentos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split("_");
                if (p.length == 9) {
                    medicamentos.add(new Medicamentos(
                            p[0],
                            p[1],
                            Integer.parseInt(p[2]),
                            p[3],
                            Integer.parseInt(p[4]),
                            p[5],
                            p[6],
                            p[7],
                            p[8]
                    ));
                } else {
                    System.err.println("Línea con formato incorrecto: " + linea);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo medicamentos.txt no encontrado.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo medicamentos.txt: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir un número: " + e.getMessage());
        }
    }

    public static void guardarMedicamentos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("medicamentos.txt"))) {
            for (Medicamentos m : medicamentos) {
                bw.write(m.getNombre() + "_" + m.getDescripcion() + "_" + m.getPrecio() + "_" + m.getTipo() + "_"
                        + m.getCantidad() + "_" + m.getLaboratorio() + "_" + m.getFechaVencimiento() + "_"
                        + m.getLote() + "_" + m.getVia());
                bw.newLine();
            }
        } catch (IOException e) {
        }
    }

    public static boolean eliminarMedicamento(String nombre) {
        return medicamentos.removeIf(m -> m.getNombre().equals(nombre)) && guardarCambiosYRetornar(true, "medicamentos");
    }

    public static boolean modificarMedicamento(Medicamentos existente, Medicamentos nuevo) {
        int i = medicamentos.indexOf(existente);
        if (i != -1) {
            medicamentos.set(i, nuevo);
        }
        return guardarCambiosYRetornar(i != -1, "medicamentos");
    }
}
