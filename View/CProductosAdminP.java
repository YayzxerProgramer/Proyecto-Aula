package View;

import Controller.ProductosController;
import Model.AseoPersonal;
import Model.Bebidas;
import Model.CuidadoSexual;
import Model.Medicamentos;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CProductosAdminP extends javax.swing.JFrame {

    private String tipoProductoSeleccionado;
    ProductosController controlador = new ProductosController();

    public CProductosAdminP() {
        controlador.inicializarProductos();
        controlador.cargarProductosDesdeArchivos();
//        UsuarioController.sombraBoton(ButtonBuscar);
//        UsuarioController.sombraBoton(ButtonVolver);
        initComponents();
        
    }
    

    public void setTipoProducto(String tipoProductoSeleccionado) {
        this.tipoProductoSeleccionado = tipoProductoSeleccionado;
    }
    
    public void setjLabelText(String texto){
        jLabel1.setText(texto);
    }

    ArrayList<AseoPersonal> aseoPersonal = ProductosController.aseoPersonal;
    ArrayList<Bebidas> bebidas = ProductosController.bebidas;
    ArrayList<CuidadoSexual> cuidadoSexual = ProductosController.cuidadoSexual;

    public void configurarColumnas(String[] columnas) {
        DefaultTableModel model = (DefaultTableModel) TableProductos.getModel();
        model.setColumnIdentifiers(columnas);
    }

    public String[] obtenerColumnas(String tipoProducto) {
        return switch (tipoProducto) {
            case "Medicamentos" ->
                new String[]{
                    "Nombre", "Descripción", "Precio", "Tipo", "Laboratorio",
                    "Cantidad", "Fecha Vencimiento", "Lote", "Vía"
                };
            default ->
                new String[]{
                    "Nombre", "Descripción", "Precio", "Tipo", "Cantidad"
                };
        };
    }

    public void llenarTablaCuidadoSexual() {
        String[] columnas = obtenerColumnas("Cuidado Sexual");
        configurarColumnas(columnas);
        DefaultTableModel model = (DefaultTableModel) TableProductos.getModel();
        model.setRowCount(0);

        for (CuidadoSexual cuidadosexual : cuidadoSexual) {
            model.addRow(new Object[]{
                cuidadosexual.getNombre(),
                cuidadosexual.getPrecio(),
                cuidadosexual.getDescripcion(),
                cuidadosexual.getTipo(),
                cuidadosexual.getCantidad()
            });
        }
    }


    public void llenarTablaAseoPersonal() {
        String[] columnas = obtenerColumnas("Aseo Personal");
        configurarColumnas(columnas);

        DefaultTableModel model = (DefaultTableModel) TableProductos.getModel();
        model.setRowCount(0);

        for (AseoPersonal aseopersonal : aseoPersonal) {
            model.addRow(new Object[]{
                aseopersonal.getNombre(),
                aseopersonal.getPrecio(),
                aseopersonal.getDescripcion(),
                aseopersonal.getTipo(),
                aseopersonal.getCantidad()

            });
        }
    }

    public void llenarTablaBebidas() {
        String[] columnas = obtenerColumnas("Bebidas");
        configurarColumnas(columnas);

        DefaultTableModel model = (DefaultTableModel) TableProductos.getModel();
        model.setRowCount(0);

        for (Bebidas bebida : bebidas) {
            model.addRow(new Object[]{
                bebida.getNombre(),
                bebida.getDescripcion(),
                bebida.getPrecio(),
                bebida.getTipo(),
                bebida.getCantidad(),});
        }
    }

    private void buscarProducto(String nombreProducto) {

    if (nombreProducto == null || nombreProducto.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre de producto válido para buscar.");
        return;
    }

    ArrayList<Object> productosNoMedicamentos = new ArrayList<>();
    productosNoMedicamentos.addAll(bebidas);
    productosNoMedicamentos.addAll(aseoPersonal);
    productosNoMedicamentos.addAll(cuidadoSexual);

    boolean encontrado = false;
    StringBuilder informacion = new StringBuilder();

    for (Object producto : productosNoMedicamentos) {
        if (producto instanceof Bebidas bebida && bebida.getNombre() != null && bebida.getNombre().equalsIgnoreCase(nombreProducto)) {
            informacion.append("Nombre: ").append(bebida.getNombre()).append("\n")
                    .append("Descripción: ").append(bebida.getDescripcion()).append("\n")
                    .append("Precio: ").append(bebida.getPrecio()).append("\n")
                    .append("Tipo: ").append(bebida.getTipo()).append("\n")
                    .append("Cantidad: ").append(bebida.getCantidad()).append("\n");
            encontrado = true;
            break;
        } else if (producto instanceof CuidadoSexual cuidadosexual && cuidadosexual.getNombre() != null && cuidadosexual.getNombre().equalsIgnoreCase(nombreProducto)) {
            informacion.append("Nombre: ").append(cuidadosexual.getNombre()).append("\n")
                    .append("Descripción: ").append(cuidadosexual.getDescripcion()).append("\n")
                    .append("Precio: ").append(cuidadosexual.getPrecio()).append("\n")
                    .append("Tipo: ").append(cuidadosexual.getTipo()).append("\n")
                    .append("Cantidad: ").append(cuidadosexual.getCantidad()).append("\n");
            encontrado = true;
            break;
        } else if (producto instanceof AseoPersonal aseopersonal && aseopersonal.getNombre() != null && aseopersonal.getNombre().equalsIgnoreCase(nombreProducto)) {
            informacion.append("Nombre: ").append(aseopersonal.getNombre()).append("\n")
                    .append("Descripción: ").append(aseopersonal.getDescripcion()).append("\n")
                    .append("Precio: ").append(aseopersonal.getPrecio()).append("\n")
                    .append("Tipo: ").append(aseopersonal.getTipo()).append("\n")
                    .append("Cantidad: ").append(aseopersonal.getCantidad()).append("\n");
            encontrado = true;
            break;
        }
    }


    if (encontrado) {
        InfoTextArea.setText(informacion.toString());
    } else {
        InfoTextArea.setText("Producto no encontrado en las categorías seleccionadas.");
    }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProductos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        InfoTextArea = new javax.swing.JTextArea();
        TextFieldBuscar = new javax.swing.JTextField();
        ButtonBuscar = new javax.swing.JButton();
        ButtonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Fira Code Medium", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DEPENDE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        TableProductos.setBackground(new java.awt.Color(255, 255, 255));
        TableProductos.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        TableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DEPENDE", "DEPENDE", "DEPENDE", "DEPENDE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableProductos.setFocusable(false);
        TableProductos.setGridColor(new java.awt.Color(51, 51, 51));
        TableProductos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TableProductos.setShowGrid(true);
        TableProductos.getTableHeader().setResizingAllowed(false);
        TableProductos.getTableHeader().setReorderingAllowed(false);
        TableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableProductos);

        InfoTextArea.setEditable(false);
        InfoTextArea.setBackground(new java.awt.Color(255, 255, 255));
        InfoTextArea.setColumns(20);
        InfoTextArea.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        InfoTextArea.setRows(5);
        InfoTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        InfoTextArea.setFocusable(false);
        jScrollPane2.setViewportView(InfoTextArea);

        TextFieldBuscar.setBackground(new java.awt.Color(255, 255, 255));
        TextFieldBuscar.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        TextFieldBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextFieldBuscarKeyPressed(evt);
            }
        });

        ButtonBuscar.setBackground(new java.awt.Color(0, 102, 204));
        ButtonBuscar.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        ButtonBuscar.setForeground(new java.awt.Color(0, 0, 0));
        ButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Buscar.png"))); // NOI18N
        ButtonBuscar.setText("Buscar");
        ButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscarActionPerformed(evt);
            }
        });

        ButtonVolver.setBackground(new java.awt.Color(0, 102, 204));
        ButtonVolver.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        ButtonVolver.setForeground(new java.awt.Color(0, 0, 0));
        ButtonVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/SalidaIcono.png"))); // NOI18N
        ButtonVolver.setText("Volver");
        ButtonVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 186, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ButtonVolver)
                                .addGap(18, 18, 18)
                                .addComponent(TextFieldBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonBuscar))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(187, 187, 187))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonBuscar)
                    .addComponent(ButtonVolver))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProductosMouseClicked
        int selectedRow = TableProductos.getSelectedRow();
        if (selectedRow != -1) {
            String nombre = (String) TableProductos.getValueAt(selectedRow, 0);
            TextFieldBuscar.setText(nombre.trim());
        }
    }//GEN-LAST:event_TableProductosMouseClicked

    private void ButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarActionPerformed
        buscarProducto(TextFieldBuscar.getText());
    }//GEN-LAST:event_ButtonBuscarActionPerformed

    private void TextFieldBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldBuscarKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            buscarProducto(TextFieldBuscar.getText());
        }
    }//GEN-LAST:event_TextFieldBuscarKeyPressed

    private void ButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVolverActionPerformed
        ProductosGen ventana = new ProductosGen();
        this.dispose();
        ventana.setVisible(true);
    }//GEN-LAST:event_ButtonVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBuscar;
    private javax.swing.JButton ButtonVolver;
    private javax.swing.JTextArea InfoTextArea;
    private javax.swing.JTable TableProductos;
    private javax.swing.JTextField TextFieldBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
