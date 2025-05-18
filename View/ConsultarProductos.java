
package View;

public class ConsultarProductos extends javax.swing.JFrame {
    
    public ConsultarProductos() {
        
        initComponents();
    }
    AgregarAlCarrito ventanaP = new AgregarAlCarrito(); 
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ButtonAseoPersonal = new javax.swing.JButton();
        ButtonMedicamentos = new javax.swing.JButton();
        ButtonBebidas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ButtonCuidadoSexual = new javax.swing.JButton();
        ButtonVolver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consultar Productos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));
        jPanel2.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Fira Code Medium", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consultar Productos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
        );

        ButtonAseoPersonal.setBackground(new java.awt.Color(0, 102, 255));
        ButtonAseoPersonal.setFont(new java.awt.Font("Fira Code Medium", 0, 12)); // NOI18N
        ButtonAseoPersonal.setForeground(new java.awt.Color(255, 255, 255));
        ButtonAseoPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Jabon Boton.png"))); // NOI18N
        ButtonAseoPersonal.setText("AseoPersonal");
        ButtonAseoPersonal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ButtonAseoPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAseoPersonalActionPerformed(evt);
            }
        });

        ButtonMedicamentos.setBackground(new java.awt.Color(0, 102, 255));
        ButtonMedicamentos.setFont(new java.awt.Font("Fira Code Medium", 0, 12)); // NOI18N
        ButtonMedicamentos.setForeground(new java.awt.Color(255, 255, 255));
        ButtonMedicamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Pildora.png"))); // NOI18N
        ButtonMedicamentos.setText("  Medicamentos");
        ButtonMedicamentos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ButtonMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMedicamentosActionPerformed(evt);
            }
        });

        ButtonBebidas.setBackground(new java.awt.Color(0, 102, 255));
        ButtonBebidas.setFont(new java.awt.Font("Fira Code Medium", 0, 12)); // NOI18N
        ButtonBebidas.setForeground(new java.awt.Color(255, 255, 255));
        ButtonBebidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/soda.png"))); // NOI18N
        ButtonBebidas.setText("  Bebidas ");
        ButtonBebidas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ButtonBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBebidasActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Productos1.gif"))); // NOI18N

        ButtonCuidadoSexual.setBackground(new java.awt.Color(0, 102, 255));
        ButtonCuidadoSexual.setFont(new java.awt.Font("Fira Code Medium", 0, 12)); // NOI18N
        ButtonCuidadoSexual.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCuidadoSexual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/condoms.png"))); // NOI18N
        ButtonCuidadoSexual.setText("CuidadoSexual");
        ButtonCuidadoSexual.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ButtonCuidadoSexual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCuidadoSexualActionPerformed(evt);
            }
        });

        ButtonVolver.setBackground(new java.awt.Color(0, 102, 255));
        ButtonVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/SalidaIcono.png"))); // NOI18N
        ButtonVolver.setToolTipText("Salir");
        ButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVolverActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Fira Code Medium", 2, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Explora nuestra variedad de productos farmacéuticos |  © 2025 Superfarmax  ");

        jLabel5.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Seleccione una de las siguientes opciones para avanzar.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(ButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ButtonBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonCuidadoSexual, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonAseoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(225, 225, 225))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonAseoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonCuidadoSexual, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    

    private void ButtonAseoPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAseoPersonalActionPerformed
        ventanaP.setTipoProducto("Aseo Personal");
        ventanaP.llenarTablaAseoPersonal();
        ventanaP.setjLabelText("Aseo Personal");
        this.setVisible(false);
        ventanaP.setVisible(true);
    }//GEN-LAST:event_ButtonAseoPersonalActionPerformed

    private void ButtonMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMedicamentosActionPerformed
        ventanaP.setTipoProducto("Medicamentos");
        ventanaP.llenarTablaMedicamentos();
        ventanaP.setjLabelText("Medicamentos");
        this.setVisible(false);
        ventanaP.setVisible(true);
    }//GEN-LAST:event_ButtonMedicamentosActionPerformed

    private void ButtonCuidadoSexualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCuidadoSexualActionPerformed
        ventanaP.setTipoProducto("Cuidado Sexual");
        ventanaP.llenarTablaCuidadoSexual();
        ventanaP.setjLabelText("Cuidado Sexual");
        this.setVisible(false);
        ventanaP.setVisible(true);
    }//GEN-LAST:event_ButtonCuidadoSexualActionPerformed

    private void ButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVolverActionPerformed
        MenuClientes ventana1 = new MenuClientes();
        this.setVisible(false);
        ventana1.setVisible(true);
    }//GEN-LAST:event_ButtonVolverActionPerformed

    private void ButtonBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBebidasActionPerformed
        ventanaP.setTipoProducto("Bebidas");
        ventanaP.setjLabelText("Bebidas");
        ventanaP.llenarTablaBebidas();  
        this.setVisible(false);
        ventanaP.setVisible(true);
    }//GEN-LAST:event_ButtonBebidasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAseoPersonal;
    private javax.swing.JButton ButtonBebidas;
    private javax.swing.JButton ButtonCuidadoSexual;
    private javax.swing.JButton ButtonMedicamentos;
    private javax.swing.JButton ButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
