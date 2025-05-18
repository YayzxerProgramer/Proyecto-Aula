
package View;

import Model.Carrito;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VerCarrito extends javax.swing.JFrame {

    public VerCarrito() {
        initComponents();
        llenarTablaCarrito();
    }
    
    public void botonn(String tipo){
        if ("Eliminar".equals(tipo)){
            ButtonEliminar.setVisible(false);
        }
   
        else if ("Finalizar".equals(tipo)){
            ButtonFinalizarCompra.setVisible(false);
        }
            
    }
    
    public void eliminarProducto() {
    int selectedRow = VerCarrito.getSelectedRow(); 

    if (selectedRow != -1) {
        Carrito.getCarrito().remove(selectedRow);

        DefaultTableModel model = (DefaultTableModel) VerCarrito.getModel();
        model.removeRow(selectedRow);

        JOptionPane.showMessageDialog(this, "Producto eliminado correctamente del carrito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Por favor seleccione un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        VerCarrito = new javax.swing.JTable();
        ButtonVolver = new javax.swing.JButton();
        ButtonEliminar = new javax.swing.JButton();
        ButtonFinalizarCompra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Fira Code Medium", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CARRITO DE COMPRAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        VerCarrito.setBackground(new java.awt.Color(255, 255, 255));
        VerCarrito.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        VerCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        VerCarrito.setGridColor(new java.awt.Color(0, 0, 0));
        VerCarrito.setShowGrid(true);
        VerCarrito.getTableHeader().setResizingAllowed(false);
        VerCarrito.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(VerCarrito);

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

        ButtonEliminar.setBackground(new java.awt.Color(0, 102, 204));
        ButtonEliminar.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        ButtonEliminar.setForeground(new java.awt.Color(0, 0, 0));
        ButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Eiminar.png"))); // NOI18N
        ButtonEliminar.setText("Eliminar");
        ButtonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEliminarActionPerformed(evt);
            }
        });

        ButtonFinalizarCompra.setBackground(new java.awt.Color(0, 102, 204));
        ButtonFinalizarCompra.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        ButtonFinalizarCompra.setForeground(new java.awt.Color(0, 0, 0));
        ButtonFinalizarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Finalizar.png"))); // NOI18N
        ButtonFinalizarCompra.setText("Finalizar Compra");
        ButtonFinalizarCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonFinalizarCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(ButtonFinalizarCompra))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonEliminar))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonFinalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonVolver)
                .addContainerGap(47, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVolverActionPerformed
        ConsultarProductos ventana = new ConsultarProductos();
        this.dispose();
        ventana.setVisible(true);
    }//GEN-LAST:event_ButtonVolverActionPerformed

    private void ButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEliminarActionPerformed
       eliminarProducto();
    }//GEN-LAST:event_ButtonEliminarActionPerformed

    private void ButtonFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonFinalizarCompraActionPerformed
       
    }//GEN-LAST:event_ButtonFinalizarCompraActionPerformed
    
    private void llenarTablaCarrito() {
        String[] columnas = {"Nombre", "Precio"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        VerCarrito.setModel(model); 

        for (Object producto : Carrito.getCarrito()) {
            if (producto instanceof Model.Medicamentos medicamento) {
                model.addRow(new Object[]{medicamento.getNombre(), medicamento.getPrecio()});
            } else if (producto instanceof Model.Bebidas bebida) {
                model.addRow(new Object[]{bebida.getNombre(), bebida.getPrecio()});
            } else if (producto instanceof Model.AseoPersonal aseoPersonal) {
                model.addRow(new Object[]{aseoPersonal.getNombre(), aseoPersonal.getPrecio()});
            } else if (producto instanceof Model.CuidadoSexual cuidadoSexual) {
                model.addRow(new Object[]{cuidadoSexual.getNombre(), cuidadoSexual.getPrecio()});
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonEliminar;
    private javax.swing.JButton ButtonFinalizarCompra;
    private javax.swing.JButton ButtonVolver;
    private javax.swing.JTable VerCarrito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
