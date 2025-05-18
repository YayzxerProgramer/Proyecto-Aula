package View;

import Controller.MedicamentoController;
import Controller.ProductosController;
import Model.Medicamentos;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EditarMedicamentos extends javax.swing.JFrame {

    ProductosController controlador = new ProductosController();

    public EditarMedicamentos() {
        controlador.inicializarProductos();
        controlador.cargarProductosDesdeArchivos();
        initComponents();
    }

    ArrayList<Medicamentos> medicamento = ProductosController.medicamentos;

    public void buscar() {
        if (medicamento == null || medicamento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay medicamentos cargados. Por favor, verifica los datos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombreBuscado = jTextFieldUsuario10.getText().toLowerCase();

        if (nombreBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre de medicamento para buscar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Medicamentos medicamentoEncontrado = null;
        for (Medicamentos med : medicamento) {
            if (med.getNombre().equalsIgnoreCase(nombreBuscado)) {
                medicamentoEncontrado = med;
                break;
            }
        }

        if (medicamentoEncontrado != null) {
            jTextFieldNombre.setText(medicamentoEncontrado.getNombre());
            jTextFieldPrecio.setText(String.valueOf(medicamentoEncontrado.getPrecio()));
            jTextFieldTipo.setText((medicamentoEncontrado.getTipo()));
            jTextFieldCantidad.setText(String.valueOf(medicamentoEncontrado.getCantidad()));
            jTextFieldLaboratorio.setText(medicamentoEncontrado.getLaboratorio());
            jTextFieldFechaVencimiento.setText(String.valueOf(medicamentoEncontrado.getFechaVencimiento()));
            jTextFieldVia.setText((medicamentoEncontrado.getVia()));
            jTextFieldLote.setText(medicamentoEncontrado.getLote());
            jTextFieldDescripcion.setText(medicamentoEncontrado.getDescripcion());
            
        } else {
            JOptionPane.showMessageDialog(this, "Medicamento no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modificar() {
        String nombre = jTextFieldNombre.getText();
        String descripcion = jTextFieldDescripcion.getText();
        String precioStr = jTextFieldPrecio.getText();
        String tipo = jTextFieldTipo.getText();
        String cantidadStr = jTextFieldCantidad.getText();
        String laboratorio = jTextFieldLaboratorio.getText();
        String fechaVencimiento = jTextFieldFechaVencimiento.getText();
        String lote = jTextFieldLote.getText();
        String via = jTextFieldVia.getText();

        if (nombre.isEmpty() || descripcion.isEmpty() || precioStr.isEmpty() || tipo.isEmpty()
                || cantidadStr.isEmpty() || laboratorio.isEmpty() || fechaVencimiento.isEmpty()
                || lote.isEmpty() || via.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int precio, cantidad;
        try {
            precio = Integer.parseInt(precioStr);
            cantidad = Integer.parseInt(cantidadStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Precio y cantidad deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Medicamentos medicamentoExistente = null;
        for (Medicamentos med : medicamento) {
            if (med.getNombre().equalsIgnoreCase(nombre)) {
                medicamentoExistente = med;
                break;
            }
        }

        if (medicamentoExistente == null) {
            JOptionPane.showMessageDialog(this, "El medicamento no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Medicamentos nuevoMedicamento = new Medicamentos(nombre, descripcion, precio, tipo,
                cantidad, laboratorio, fechaVencimiento, lote, via);

        boolean modificado = MedicamentoController.modificarMedicamento(medicamentoExistente, nuevoMedicamento);

        if (modificado) {
            JOptionPane.showMessageDialog(this, "Medicamento modificado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo modificar el medicamento.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregar() {
        String nombre = jTextFieldNombre.getText();
        String descripcion = jTextFieldDescripcion.getText();
        String precioStr = jTextFieldPrecio.getText();
        String tipo = jTextFieldTipo.getText();
        String cantidadStr = jTextFieldCantidad.getText();
        String laboratorio = jTextFieldLaboratorio.getText();
        String fechaVencimiento = jTextFieldFechaVencimiento.getText();
        String lote = jTextFieldLote.getText();
        String via = jTextFieldVia.getText();

        if (nombre.isEmpty() || descripcion.isEmpty() || precioStr.isEmpty() || tipo.isEmpty()
                || cantidadStr.isEmpty() || laboratorio.isEmpty() || fechaVencimiento.isEmpty()
                || lote.isEmpty() || via.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int precio, cantidad;
        try {
            precio = Integer.parseInt(precioStr);
            cantidad = Integer.parseInt(cantidadStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Precio y cantidad deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Medicamentos med : medicamento) {
            if (med.getNombre().equalsIgnoreCase(nombre)) {
                JOptionPane.showMessageDialog(this, "El medicamento ya existe. Use la opción de modificar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        Medicamentos nuevoMedicamento = new Medicamentos(nombre, descripcion, precio, tipo, cantidad, laboratorio, fechaVencimiento, lote, via);

        medicamento.add(nuevoMedicamento);

        JOptionPane.showMessageDialog(this, "Medicamento agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    private void eliminar() {
    String nombre = jTextFieldNombre.getText();

    if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese el nombre del medicamento a eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Medicamentos medicamentoExistente = null;
    for (Medicamentos med : medicamento) {
        if (med.getNombre().equalsIgnoreCase(nombre)) {
            medicamentoExistente = med;
            break;
        }
    }

    if (medicamentoExistente == null) {
        JOptionPane.showMessageDialog(this, "El medicamento no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int confirmacion = JOptionPane.showConfirmDialog(this, 
        "¿Estás seguro de que deseas eliminar el medicamento " + nombre + "?",
        "Confirmación", JOptionPane.YES_NO_OPTION);

    if (confirmacion == JOptionPane.YES_OPTION) {
        boolean eliminado = MedicamentoController.eliminarMedicamento(nombre);

        if (eliminado) {
            guardarCambios();
            JOptionPane.showMessageDialog(this, "Medicamento eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar el medicamento.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    private void limpiarCampos() {
    jTextFieldNombre.setText("");
    jTextFieldDescripcion.setText("");
    jTextFieldPrecio.setText("");
    jTextFieldTipo.setText("");
    jTextFieldCantidad.setText("");
    jTextFieldLaboratorio.setText("");
    jTextFieldFechaVencimiento.setText("");
    jTextFieldLote.setText("");
    jTextFieldVia.setText("");
}

    private void guardarCambios() {
        MedicamentoController.guardarMedicamentos();
        JOptionPane.showMessageDialog(this, "Cambios guardados en el archivo exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void RealizarAccion(String accion) {
        switch (accion.toLowerCase()) {
            case "agregar" -> {
                BotonCambiante.setText("Agregar");
                jLabelProducto.setText("Agregar Medicamento");
                for (ActionListener al : BotonCambiante.getActionListeners()) {
                    BotonCambiante.removeActionListener(al);
                }
                BotonCambiante.addActionListener(e -> {
                    agregar();
                });
            }

            case "modificar" -> {
                BotonCambiante.setText("Modificar");
                jLabelProducto.setText("Modificar Medicamento");
                for (ActionListener al : BotonCambiante.getActionListeners()) {
                    BotonCambiante.removeActionListener(al);
                }
                BotonCambiante.addActionListener(e -> {
                    modificar();
                });
            }

            case "eliminar" -> {
                BotonCambiante.setText("Eliminar");
                jLabelProducto.setText("Eliminar Medicamento");
                for (ActionListener al : BotonCambiante.getActionListeners()) {
                    BotonCambiante.removeActionListener(al);
                }
                BotonCambiante.addActionListener(e -> {
                    eliminar();
                });
            }
            default ->
                JOptionPane.showMessageDialog(this, "Acción no reconocida: " + accion, "Error", JOptionPane.ERROR);
        }
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelProducto = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldTipo = new javax.swing.JTextField();
        jTextFieldCantidad = new javax.swing.JTextField();
        jTextFieldLaboratorio = new javax.swing.JTextField();
        jTextFieldFechaVencimiento = new javax.swing.JTextField();
        jTextFieldVia = new javax.swing.JTextField();
        jTextFieldLote = new javax.swing.JTextField();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jTextFieldUsuario10 = new javax.swing.JTextField();
        jTextFieldPrecio = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        BotonCambiante = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabelProducto.setFont(new java.awt.Font("Fira Code Medium", 0, 36)); // NOI18N
        jLabelProducto.setForeground(new java.awt.Color(0, 0, 0));
        jLabelProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProducto.setText("MEDICAMENTOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTextFieldNombre.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldNombre.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldNombre.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldNombre.setToolTipText("");
        jTextFieldNombre.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        jTextFieldTipo.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldTipo.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldTipo.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldTipo.setToolTipText("");
        jTextFieldTipo.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        jTextFieldCantidad.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldCantidad.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldCantidad.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldCantidad.setToolTipText("");
        jTextFieldCantidad.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        jTextFieldLaboratorio.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldLaboratorio.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldLaboratorio.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldLaboratorio.setToolTipText("");
        jTextFieldLaboratorio.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        jTextFieldFechaVencimiento.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldFechaVencimiento.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldFechaVencimiento.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldFechaVencimiento.setToolTipText("");
        jTextFieldFechaVencimiento.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        jTextFieldVia.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldVia.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldVia.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldVia.setToolTipText("");
        jTextFieldVia.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        jTextFieldLote.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldLote.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldLote.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldLote.setToolTipText("");
        jTextFieldLote.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        jTextFieldDescripcion.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldDescripcion.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldDescripcion.setToolTipText("");
        jTextFieldDescripcion.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        jTextFieldUsuario10.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldUsuario10.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldUsuario10.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldUsuario10.setToolTipText("");
        jTextFieldUsuario10.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        jTextFieldPrecio.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldPrecio.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldPrecio.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPrecio.setToolTipText("");
        jTextFieldPrecio.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        Buscar.setBackground(new java.awt.Color(0, 102, 255));
        Buscar.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        Buscar.setForeground(new java.awt.Color(0, 0, 0));
        Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Buscar.png"))); // NOI18N
        Buscar.setText("Buscar");
        Buscar.setToolTipText("");
        Buscar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        Buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Buscar.setFocusPainted(false);
        Buscar.setSelected(true);
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        BotonCambiante.setBackground(new java.awt.Color(0, 102, 255));
        BotonCambiante.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        BotonCambiante.setForeground(new java.awt.Color(0, 0, 0));
        BotonCambiante.setText("Depende");
        BotonCambiante.setToolTipText("");
        BotonCambiante.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        BotonCambiante.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonCambiante.setFocusPainted(false);
        BotonCambiante.setSelected(true);
        BotonCambiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCambianteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Precio:");

        jLabel5.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tipo:");

        jLabel6.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Cantidad:");

        jLabel7.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Laboratorio:");

        jLabel9.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Fecha De Vencimiento:");

        jLabel10.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Via:");

        jLabel11.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Lote:");

        jLabel12.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Descripcion:");

        jButton7.setBackground(new java.awt.Color(0, 102, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/SalidaIcono.png"))); // NOI18N
        jButton7.setToolTipText("Salir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton7)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldUsuario10, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(BotonCambiante, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(210, 210, 210))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldDescripcion)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel3))
                                        .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                    .addGap(2, 2, 2))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(35, 35, 35)
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel9)
                                                .addComponent(jTextFieldFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(41, 41, 41)
                                            .addComponent(jLabel11))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jTextFieldVia, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldLote, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldUsuario10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldVia, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLote, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(7, 7, 7)
                .addComponent(jTextFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonCambiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        buscar();
    }//GEN-LAST:event_BuscarActionPerformed

    private void BotonCambianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCambianteActionPerformed
        modificar();
        guardarCambios();
        limpiarCampos();
    }//GEN-LAST:event_BotonCambianteActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        MenuMedicamentos ventana1 = new MenuMedicamentos();
        this.setVisible(false);
        ventana1.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCambiante;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldFechaVencimiento;
    private javax.swing.JTextField jTextFieldLaboratorio;
    private javax.swing.JTextField jTextFieldLote;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldTipo;
    private javax.swing.JTextField jTextFieldUsuario10;
    private javax.swing.JTextField jTextFieldVia;
    // End of variables declaration//GEN-END:variables
}
