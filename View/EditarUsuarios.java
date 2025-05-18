package View;

import Controller.UsuarioController;
import Model.Usuarios;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EditarUsuarios extends javax.swing.JFrame {

    public EditarUsuarios() {
        initComponents();
    }

    public static ArrayList<Usuarios> usuarios = UsuarioController.usuarios;

    public void buscar() {
        String username = jTextFieldBuscarUsuario.getText().trim();
        Usuarios usuarioEncontrado = null;

        for (Usuarios u : usuarios) {
            if (u.getUsuario().equalsIgnoreCase(username)) {
                usuarioEncontrado = u;
                break;
            }
        }

        if (usuarioEncontrado != null) {
            jTextFieldNombre.setText(usuarioEncontrado.getNombre());
            jTextFieldUsuario.setText(usuarioEncontrado.getUsuario());
            jTextFieldContraseña.setText(usuarioEncontrado.getContraseña());
            jTextFieldEdad.setText(String.valueOf(usuarioEncontrado.getEdad()));
            jTextFieldCorreo.setText(usuarioEncontrado.getCorreo());
            jTextFieldRol.setText(usuarioEncontrado.getRol());
        } else {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregar() {
        String nombre = jTextFieldNombre.getText().trim();
        String usuario = jTextFieldUsuario.getText().trim();
        String contrasena = jTextFieldContraseña.getText().trim();
        String edadStr = jTextFieldEdad.getText().trim();
        String correo = jTextFieldCorreo.getText().trim();
        String rol = jTextFieldRol.getText().trim();
        int edad = 0;

        if (nombre.isEmpty() || usuario.isEmpty() || contrasena.isEmpty() || edadStr.isEmpty() || correo.isEmpty() || rol.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            edad = Integer.parseInt(edadStr);
            if (edad <= 0 || edad > 120) {
                JOptionPane.showMessageDialog(this, "Edad fuera de rango permitido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Edad debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!(correo.endsWith("@gmail.com") || correo.endsWith("@hotmail.com") || correo.endsWith("@outlook.com"))) {
            JOptionPane.showMessageDialog(this, "Correo no válido. Solo se aceptan Gmail, Hotmail y Outlook.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (Usuarios u : usuarios) {
            if (u.getUsuario().equalsIgnoreCase(usuario)) {
                JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        Usuarios nuevo = new Usuarios(nombre, usuario, contrasena, edad, correo, rol);
        usuarios.add(nuevo);
        UsuarioController.guardarUsuario(nuevo);
        JOptionPane.showMessageDialog(this, "Usuario agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

    }

    public void modificar() {
        String nombre = jTextFieldNombre.getText().trim();
        String usuario = jTextFieldUsuario.getText().trim();
        String contrasena = jTextFieldContraseña.getText().trim();
        String edadStr = jTextFieldEdad.getText().trim();
        String correo = jTextFieldCorreo.getText().trim();
        String rol = jTextFieldRol.getText().trim();
        int edad = 0;

        if (nombre.isEmpty() || usuario.isEmpty() || contrasena.isEmpty() || edadStr.isEmpty() || correo.isEmpty() || rol.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            edad = Integer.parseInt(edadStr);
            if (edad <= 0 || edad > 120) {
                JOptionPane.showMessageDialog(this, "Edad fuera de rango permitido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Edad debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Usuarios usuarioEncontrado = null;
        for (Usuarios u : usuarios) {
            if (u.getUsuario().equalsIgnoreCase(usuario)) {
                usuarioEncontrado = u;
                break;
            }
        }
        if (usuarioEncontrado != null) {
            usuarioEncontrado.setNombre(nombre);
            usuarioEncontrado.setContraseña(contrasena);
            usuarioEncontrado.setEdad(edad);
            usuarioEncontrado.setCorreo(correo);
            usuarioEncontrado.setRol(rol);
            UsuarioController.modificarUsuario(nombre, usuario, contrasena, edadStr, correo, rol);
            JOptionPane.showMessageDialog(this, "Usuario modificado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void eliminar() {
        String usuario = jTextFieldUsuario.getText().trim();
        boolean eliminado = false;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getUsuario().equalsIgnoreCase(usuario)) {
                usuarios.remove(i);
                eliminado = true;
                break;
            }
        }
        if (eliminado) {
            UsuarioController.eliminarUsuario(usuario);
            JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void RealizarAccion(String accion) {
        switch (accion.toLowerCase()) {
            case "agregar" -> {
                BotonCambiante.setText("Agregar");
                for (ActionListener al : BotonCambiante.getActionListeners()) {
                    BotonCambiante.removeActionListener(al);
                }
                BotonCambiante.addActionListener(e -> {
                    agregar();
                });
            }

            case "modificar" -> {
                BotonCambiante.setText("Modificar");
                for (ActionListener al : BotonCambiante.getActionListeners()) {
                    BotonCambiante.removeActionListener(al);
                }
                BotonCambiante.addActionListener(e -> {
                    modificar();
                });
            }

            case "eliminar" -> {
                BotonCambiante.setText("Eliminar");
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
        jTextFieldBuscarUsuario = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldUsuario = new javax.swing.JTextField();
        jTextFieldEdad = new javax.swing.JTextField();
        jTextFieldContraseña = new javax.swing.JTextField();
        BotonCambiante = new javax.swing.JButton();
        BuscarProducto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelProducto = new javax.swing.JLabel();
        jTextFieldRol = new javax.swing.JTextField();
        jTextFieldCorreo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldBuscarUsuario.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldBuscarUsuario.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldBuscarUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldBuscarUsuario.setToolTipText("");
        jTextFieldBuscarUsuario.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        jTextFieldNombre.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldNombre.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldNombre.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldNombre.setToolTipText("");
        jTextFieldNombre.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        jTextFieldUsuario.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldUsuario.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldUsuario.setToolTipText("");
        jTextFieldUsuario.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        jTextFieldEdad.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldEdad.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldEdad.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldEdad.setToolTipText("");
        jTextFieldEdad.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        jTextFieldEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEdadActionPerformed(evt);
            }
        });

        jTextFieldContraseña.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldContraseña.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldContraseña.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldContraseña.setToolTipText("");
        jTextFieldContraseña.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        BotonCambiante.setBackground(new java.awt.Color(0, 102, 255));
        BotonCambiante.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        BotonCambiante.setForeground(new java.awt.Color(0, 0, 0));
        BotonCambiante.setText("Depende");
        BotonCambiante.setToolTipText("");
        BotonCambiante.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        BotonCambiante.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonCambiante.setFocusPainted(false);
        BotonCambiante.setSelected(true);

        BuscarProducto.setBackground(new java.awt.Color(0, 102, 255));
        BuscarProducto.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        BuscarProducto.setForeground(new java.awt.Color(0, 0, 0));
        BuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Buscar.png"))); // NOI18N
        BuscarProducto.setText("Buscar ");
        BuscarProducto.setToolTipText("");
        BuscarProducto.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        BuscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BuscarProducto.setFocusPainted(false);
        BuscarProducto.setSelected(true);
        BuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarProductoActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabelProducto.setFont(new java.awt.Font("Fira Code Medium", 0, 36)); // NOI18N
        jLabelProducto.setForeground(new java.awt.Color(0, 0, 0));
        jLabelProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProducto.setText("Usuarios");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTextFieldRol.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldRol.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldRol.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldRol.setToolTipText("");
        jTextFieldRol.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        jTextFieldCorreo.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldCorreo.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldCorreo.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldCorreo.setToolTipText("");
        jTextFieldCorreo.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        jLabel2.setFont(new java.awt.Font("Fira Code Medium", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Contraseña");

        jLabel3.setFont(new java.awt.Font("Fira Code Medium", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombres");

        jLabel4.setFont(new java.awt.Font("Fira Code Medium", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Usuario");

        jLabel5.setFont(new java.awt.Font("Fira Code Medium", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Edad");

        jLabel6.setFont(new java.awt.Font("Fira Code Medium", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Correo");

        jLabel7.setFont(new java.awt.Font("Fira Code Medium", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Fira Code Medium", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Rol");

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
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jTextFieldBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(BuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldRol, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonCambiante, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(297, 297, 297))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BuscarProducto)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRol, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(BotonCambiante)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarProductoActionPerformed
        buscar();
    }//GEN-LAST:event_BuscarProductoActionPerformed

    private void jTextFieldEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEdadActionPerformed
        MenuUsuarios ventana1 = new MenuUsuarios();
        this.setVisible(false);
        ventana1.setVisible(true);

    }//GEN-LAST:event_jTextFieldEdadActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        MenuUsuarios ventana1 = new MenuUsuarios();
        this.setVisible(false);
        ventana1.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCambiante;
    private javax.swing.JButton BuscarProducto;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldBuscarUsuario;
    private javax.swing.JTextField jTextFieldContraseña;
    private javax.swing.JTextField jTextFieldCorreo;
    private javax.swing.JTextField jTextFieldEdad;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldRol;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables

}
