package Controller;

import static Controller.AseoPersonalController.guardarAseoPersonal;
import static Controller.BebidasController.guardarBebidas;
import static Controller.CuidadoSexualController.guardarCuidadoSexual;
import static Controller.MedicamentoController.guardarMedicamentos;
import Model.*;
import java.io.File;
import java.util.ArrayList;

public class ProductosController {

    public static ArrayList<Medicamentos> medicamentos = new ArrayList<>();
    public static ArrayList<Bebidas> bebidas = new ArrayList<>();
    public static ArrayList<CuidadoSexual> cuidadoSexual = new ArrayList<>();
    public static ArrayList<AseoPersonal> aseoPersonal = new ArrayList<>();

    public void cargarProductosDesdeArchivos() {
        MedicamentoController.cargarMedicamentos();
        BebidasController.cargarBebidas();
        CuidadoSexualController.cargarCuidadoSexual();
        AseoPersonalController.cargarAseoPersonal();

    }

    public static boolean guardarCambiosYRetornar(boolean exito, String tipo) {
        if (!exito) {
            return false;
        }
        switch (tipo) {
            case "medicamentos" ->
                guardarMedicamentos();
            case "bebidas" ->
                guardarBebidas();
            case "cuidadoSexual" ->
                guardarCuidadoSexual();
            case "aseoPersonal" ->
                guardarAseoPersonal();
        }
        return true;
    }

    private boolean validarIndiceColumna(javax.swing.JTable table, int columnIndex) {
        return columnIndex >= 0 && columnIndex < table.getColumnCount();
    }


    public boolean validarIndiceFila(javax.swing.JTable table, int rowIndex) {
        return rowIndex >= 0 && rowIndex < table.getRowCount();
    }


    public Object obtenerValorSeguro(javax.swing.JTable table, int rowIndex, int columnIndex) {
        if (validarIndiceFila(table, rowIndex) && validarIndiceColumna(table, columnIndex)) {
            return table.getValueAt(rowIndex, columnIndex);
        }
        return null; 
    }

    public void inicializarProductos() {
        File archivoMedicamentos = new File("medicamentos.txt");
        File archivoBebidas = new File("bebidas.txt");
        File archivoCuidado = new File("cuidadoSexual.txt");
        File archivoAseo = new File("aseoPersonal.txt");

        if (!archivoMedicamentos.exists()) {
            medicamentos.add(new Medicamentos("Acetaminofen", "Baja la fiebre y alivia el dolor de cabeza, muscular, mestrual, de garganta muelas y espalda", 1000, "Tabletas", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Naproxeno", "Dolor e inflamacion", 2000, "Tabletas", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Xraydol", "Alivia el dolor e inflamacion especialmente dolores musculares y articulares", 3000, "Tabletas", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Ibuprofeno", "Reducce la fiebre y alivia dolores menores, cefaleas, dolor muscular, artritis, periodos mestruales, resfriado, dolor de muelas y dolor de espaldas", 4000, "Tabletas", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Diclofenaco", "Se usa para aliviar el dolor la inflamacion y fiebre", 5000, "Tabletas", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Sevedol", "Se usa para el dolor de cabeza y dolores asociados con la migraña", 6000, "Tabletas", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Dolex", "Es efectivo contra el dolor y la fiebre", 7000, "Tabletas", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Cefalexina", "Es para tratar infecciones ", 8000, "Capsulas/Antibioticos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Ampicilina", "Es para tratar infecciones que son ocasionadas por bacterias como meninguitis", 9000, "Capsulas/Antibioticos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Omeprazol", "Reduce la produccion de acido en el estomago", 10000, "Capsulas/Antibioticos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Noxpirin", "Tratamiento sintomatico del resfriado comun", 11000, "Capsulas/Antibioticos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Tramadol", "Se usa para aliviar dolor intenso durante mucho tiempo y que no pueden ser tratadas con otros analgesicos", 12000, "Capsulas/Antibioticos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Oripol", "Alivia temporalmente los sintomas de la fiebre del heno", 13000, "Capsulas/Antibioticos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Mieltertos", "Ayuda a aliviar la tos y a mejorar los sintomas de la gripa", 14000, "Jarabes", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("A1", "Se usa para aliviar dolor leve o moderado de las cefaleas, dolores musculares, dolores mestruales, refriados dolor de garganta muelas y espaldas", 15000, "Jarabes", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Dolex", "Dolor de cabeza dolor musculoesqueletico cuando salen los dientes dolor despues de procedimientos dentales dolor de oido. Alivio del dolor y fiebre despues de la vacunacion", 16000, "Jarabes", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Tucol—D", "Se usa para aliviar la tos ya sea seca o con flemas ademas de ayudar a descongestionar la nariz y el pecho", 17000, "Jarabes", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Apetifort", "Estimulante natural del apetito en niños y adultos y sobre tod en aquellos casos donde la perdida del apetito este asociada a poliparasitismo intestinal", 18000, "Jarabes", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Bisolvon", "Fluidificar y facilitar la expulsion de moco y flema especialmente en casos de refriados y gripes", 19000, "Suspencion", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Ampicilina", "Trata determinadas infecciones que son ocasionadas por una bacteria como la meningitis e infeccion de garganta senos nasales pulmones organos reproductivos tracto urinario y tracto gastrointestinal", 20000, "Suspencion", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Cefalexina", "Trata algunas infecciones provocadas por bacterias como neumonia y otras infecciones de los huesos piel oidos genitales y del tacto urinario", 21000, "Suspencion", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Noproxeno", "Reduce la fiebre y alivia los dolores musculares artritis periodos menstruales resfriado comun dolor de muelas y dolor de espalda", 22000, "Suspencion", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Fluimicil", "Se utiliza para facilitar la eliminacion de exceso de mocos y flemas en refriados gripes y otras afecciones respiratorias", 23000, "Suspencion", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Vick Vaporup", "Alivia sintomas de refriados y gripe como la tos y congestion nasal", 24000, "Unguentos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Mentolin", "Se usa principalmente para aliviar la picazon y los problemas de las vias respiratorias superiores  como la tos y la congestion", 25000, "Ungüentos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Nixoderm", "Es utilizado para tratar diversas afecciones de la piel incluyendo accemas manchas espinillas erupciones y hongos", 26000, "Ungüentos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            medicamentos.add(new Medicamentos("Calendula", "Se utiliza para aliviar irritaciones quemaduras piel seca heridas y problemas como dermatitis atopicas tambien puede usar para tratar ulceras llagas y pequeñas cicatrices", 27000, "Ungüentos", 100, "Bayer", "12/12/2022", "1234", "Dolor de cabeza"));
            guardarMedicamentos();
        }

        if (!archivoBebidas.exists()) {
            bebidas.add(new Bebidas("CocaCola", "Gaseosa", 6000, "Gaseosa", 1000));
            bebidas.add(new Bebidas("Pepsi", "Gaseosa", 5800, "Gaseosa", 1000));
            bebidas.add(new Bebidas("Sprite", "Gaseosa", 5700, "Gaseosa", 1000));
            bebidas.add(new Bebidas("Fanta", "Gaseosa", 5900, "Gaseosa", 1000));
            bebidas.add(new Bebidas("Manzana Postobón", "Gaseosa", 5600, "Gaseosa", 1000));
            bebidas.add(new Bebidas("Agua Cristal", "Agua", 3000, "Agua", 500));
            bebidas.add(new Bebidas("Agua Manantial", "Agua", 3100, "Agua", 500));
            bebidas.add(new Bebidas("Electrolit", "Hidratante", 8500, "Hidratante", 625));
            bebidas.add(new Bebidas("Gatorade", "Hidratante", 7000, "Hidratante", 600));
            bebidas.add(new Bebidas("Powerade", "Hidratante", 7200, "Hidratante", 600));
            bebidas.add(new Bebidas("Red Bull", "Energética", 9000, "Energética", 250));
            bebidas.add(new Bebidas("Monster", "Energética", 9500, "Energética", 500));
            bebidas.add(new Bebidas("Vive 100", "Energética", 5000, "Energética", 400));
            bebidas.add(new Bebidas("Lipton Té Frío", "Té", 4500, "Té", 500));
            bebidas.add(new Bebidas("Nestea", "Té", 4600, "Té", 500));
            bebidas.add(new Bebidas("Jugo Del Valle Mango", "Jugo", 5500, "Jugo", 500));
            guardarBebidas();
        }

        if (!archivoCuidado.exists()) {
            cuidadoSexual.add(new CuidadoSexual("Condones Durex", "Condones", 5000, "Latex", 12));
            cuidadoSexual.add(new CuidadoSexual("Condones Today", "Condones", 4500, "Latex", 12));
            cuidadoSexual.add(new CuidadoSexual("Condones Vive", "Condones", 4000, "Latex", 12));
            cuidadoSexual.add(new CuidadoSexual("Lubricante Durex", "Lubricante", 7000, "Gel", 50));
            cuidadoSexual.add(new CuidadoSexual("Lubricante Today", "Lubricante", 6500, "Gel", 50));
            cuidadoSexual.add(new CuidadoSexual("Lubricante Vive", "Lubricante", 6000, "Gel", 50));
            cuidadoSexual.add(new CuidadoSexual("Anticonceptivos Fem", "Anticonceptivo", 15000, "Oral", 21));
            cuidadoSexual.add(new CuidadoSexual("Anticonceptivos Yasmin", "Anticonceptivo", 16000, "Oral", 21));
            cuidadoSexual.add(new CuidadoSexual("Anticonceptivos Dixi", "Anticonceptivo", 15500, "Oral", 21));
            guardarCuidadoSexual();
        }

        if (!archivoAseo.exists()) {
            aseoPersonal.add(new AseoPersonal("Jabón de tocador", "Jabón de tocador", 1000, "Jabón", 1));
            aseoPersonal.add(new AseoPersonal("Gel de baño", "Gel de baño", 2000, "Gel", 1));
            aseoPersonal.add(new AseoPersonal("Desodorante", "Desodorante", 3000, "Desodorante", 1));
            aseoPersonal.add(new AseoPersonal("Talco corporal", "Talco corporal", 4000, "Talco", 1));
            aseoPersonal.add(new AseoPersonal("Crema dental", "Crema dental", 5000, "Crema dental", 1));
            aseoPersonal.add(new AseoPersonal("Cepillo de dientes", "Cepillo de dientes", 6000, "Cepillo de dientes", 1));
            aseoPersonal.add(new AseoPersonal("Enjuague bucal", "Enjuague bucal", 7000, "Enjuague bucal", 1));
            aseoPersonal.add(new AseoPersonal("Hilo dental", "Hilo dental", 8000, "Hilo dental", 1));
            aseoPersonal.add(new AseoPersonal("Champú", "Champú", 9000, "Champú", 1));
            aseoPersonal.add(new AseoPersonal("Acondicionador", "Acondicionador", 10000, "Acondicionador", 1));
            aseoPersonal.add(new AseoPersonal("Tratamientos capilares", "Tratamientos capilares", 11000, "Tratamientos capilares", 1));
            aseoPersonal.add(new AseoPersonal("Gel o cera para el cabello", "Gel o cera para el cabello", 12000, "Gel o cera para el cabello", 1));
            aseoPersonal.add(new AseoPersonal("Toallas higiénicas", "Toallas higiénicas", 13000, "Toallas higiénicas", 1));
            aseoPersonal.add(new AseoPersonal("Protectores diarios", "Protectores diarios", 14000, "Protectores diarios", 1));
            aseoPersonal.add(new AseoPersonal("Jabón íntimo", "Jabón íntimo", 15000, "Jabón íntimo", 1));
            aseoPersonal.add(new AseoPersonal("Papel higiénico", "Papel higiénico", 16000, "Papel higiénico", 1));

            guardarAseoPersonal();
        }
    }

}
