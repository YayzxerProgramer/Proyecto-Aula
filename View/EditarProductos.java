package View;

import Controller.ProductosController;
import Model.AseoPersonal;
import Model.Bebidas;
import Model.CuidadoSexual;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class EditarProductos extends javax.swing.JFrame {

    ProductosController controlador = new ProductosController();

    public EditarProductos() {
        controlador.inicializarProductos();
        controlador.cargarProductosDesdeArchivos();
        initComponents();
    }
    ArrayList<AseoPersonal> aseoPersonal = ProductosController.aseoPersonal;
    ArrayList<Bebidas> bebidas = ProductosController.bebidas;
    ArrayList<CuidadoSexual> cuidadoSexual = ProductosController.cuidadoSexual;
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelProducto = new javax.swing.JLabel();
        jTextFieldUsuario10 = new javax.swing.JTextField();
        BuscarProducto = new javax.swing.JButton();
        jTextFieldPrecio = new javax.swing.JTextField();
        jTextFieldTipo = new javax.swing.JTextField();
        jTextFieldDescripcion = new javax.swing.JTextField();
        BotonCambiante = new javax.swing.JButton();
        jTextFieldCantidad = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabelProducto.setFont(new java.awt.Font("Fira Code Medium", 0, 36)); // NOI18N
        jLabelProducto.setForeground(new java.awt.Color(0, 0, 0));
        jLabelProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProducto.setText("Depende Accion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTextFieldUsuario10.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldUsuario10.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldUsuario10.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldUsuario10.setToolTipText("");
        jTextFieldUsuario10.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

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

        jTextFieldPrecio.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldPrecio.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldPrecio.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPrecio.setToolTipText("");
        jTextFieldPrecio.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        jTextFieldTipo.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldTipo.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldTipo.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldTipo.setToolTipText("");
        jTextFieldTipo.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        jTextFieldDescripcion.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldDescripcion.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldDescripcion.setToolTipText("");
        jTextFieldDescripcion.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        BotonCambiante.setBackground(new java.awt.Color(0, 102, 255));
        BotonCambiante.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        BotonCambiante.setForeground(new java.awt.Color(0, 0, 0));
        BotonCambiante.setText("Depende Accion");
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

        jTextFieldCantidad.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldCantidad.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldCantidad.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldCantidad.setToolTipText("");
        jTextFieldCantidad.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        jTextFieldNombre.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldNombre.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jTextFieldNombre.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldNombre.setToolTipText("");
        jTextFieldNombre.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Fira Code Medium", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Fira Code Medium", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Descripcion");

        jLabel4.setFont(new java.awt.Font("Fira Code Medium", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Precio");

        jLabel5.setFont(new java.awt.Font("Fira Code Medium", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tipo");

        jLabel6.setFont(new java.awt.Font("Fira Code Medium", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Cantidad");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jTextFieldUsuario10, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(BuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextFieldTipo))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(BotonCambiante)))
                .addGap(71, 97, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUsuario10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarProducto))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(BotonCambiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void buscar() {
        if ((aseoPersonal == null || aseoPersonal.isEmpty())
                && (bebidas == null || bebidas.isEmpty())
                && (cuidadoSexual == null || cuidadoSexual.isEmpty())) {
            JOptionPane.showMessageDialog(this, "No hay productos cargados. Por favor, verifica los datos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombreBuscado = jTextFieldUsuario10.getText().toLowerCase();

        if (nombreBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre de producto para buscar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Object productoEncontrado = null;
        String tipoProducto = "";

        if (aseoPersonal != null) {
            for (AseoPersonal aseo : aseoPersonal) {
                if (aseo.getNombre().equalsIgnoreCase(nombreBuscado)) {
                    productoEncontrado = aseo;
                    tipoProducto = "AseoPersonal";
                    break;
                }
            }
        }

        if (productoEncontrado == null && bebidas != null) {
            for (Bebidas bebida : bebidas) {
                if (bebida.getNombre().equalsIgnoreCase(nombreBuscado)) {
                    productoEncontrado = bebida;
                    tipoProducto = "Bebidas";
                    break;
                }
            }
        }

        if (productoEncontrado == null && cuidadoSexual != null) {
            for (CuidadoSexual cuidado : cuidadoSexual) {
                if (cuidado.getNombre().equalsIgnoreCase(nombreBuscado)) {
                    productoEncontrado = cuidado;
                    tipoProducto = "CuidadoSexual";
                    break;
                }
            }
        }

        if (productoEncontrado != null) {
            switch (tipoProducto) {
                case "AseoPersonal" -> {
                    AseoPersonal aseo = (AseoPersonal) productoEncontrado;
                    jTextFieldNombre.setText(aseo.getNombre());
                    jTextFieldPrecio.setText(String.valueOf(aseo.getPrecio()));
                    jTextFieldTipo.setText(aseo.getTipo());
                    jTextFieldCantidad.setText(String.valueOf(aseo.getCantidad()));
                    jTextFieldDescripcion.setText(aseo.getDescripcion());
                }
                case "Bebidas" -> {
                    Bebidas bebida = (Bebidas) productoEncontrado;
                    jTextFieldNombre.setText(bebida.getNombre());
                    jTextFieldPrecio.setText(String.valueOf(bebida.getPrecio()));
                    jTextFieldTipo.setText(bebida.getTipo());
                    jTextFieldCantidad.setText(String.valueOf(bebida.getCantidad()));
                    jTextFieldDescripcion.setText(bebida.getDescripcion());
                }
                case "CuidadoSexual" -> {
                    CuidadoSexual cuidado = (CuidadoSexual) productoEncontrado;
                    jTextFieldNombre.setText(cuidado.getNombre());
                    jTextFieldPrecio.setText(String.valueOf(cuidado.getPrecio()));
                    jTextFieldTipo.setText(cuidado.getTipo());
                    jTextFieldCantidad.setText(String.valueOf(cuidado.getCantidad()));
                    jTextFieldDescripcion.setText(cuidado.getDescripcion());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregar() {
        String nombre = jTextFieldNombre.getText().trim();
        String tipo = jTextFieldTipo.getText().trim();
        String descripcion = jTextFieldDescripcion.getText().trim();
        String cantidadStr = jTextFieldCantidad.getText().trim();
        String precioStr = jTextFieldPrecio.getText().trim();

        if (nombre.isEmpty() || tipo.isEmpty() || descripcion.isEmpty() || cantidadStr.isEmpty() || precioStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int cantidad;
        int precio;
        try {
            cantidad = Integer.parseInt(cantidadStr);
            precio = Integer.parseInt(precioStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cantidad o precio inválidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tipo.equalsIgnoreCase("AseoPersonal")) {
            AseoPersonal producto = new AseoPersonal(nombre, descripcion, precio, tipo, cantidad);
            aseoPersonal.add(producto);
            JOptionPane.showMessageDialog(this, "Producto de Aseo Personal agregado c   orrectamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equalsIgnoreCase("Bebidas")) {
            Bebidas producto = new Bebidas(nombre, descripcion, precio, tipo, cantidad);
            bebidas.add(producto);
            JOptionPane.showMessageDialog(this, "Producto de Bebidas agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equalsIgnoreCase("CuidadoSexual")) {
            CuidadoSexual producto = new CuidadoSexual(nombre, descripcion, precio, tipo, cantidad);
            cuidadoSexual.add(producto);
            JOptionPane.showMessageDialog(this, "Producto de Cuidado Sexual agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Tipo de producto no reconocido. Debe ser AseoPersonal, Bebidas o CuidadoSexual.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void modificar() {
        String nombreBuscado = jTextFieldUsuario10.getText().trim().toLowerCase();
        String nuevoNombre = jTextFieldNombre.getText().trim();
        String tipo = jTextFieldTipo.getText().trim();
        String descripcion = jTextFieldDescripcion.getText().trim();
        String cantidadStr = jTextFieldCantidad.getText().trim();
        String precioStr = jTextFieldPrecio.getText().trim();

        if (nombreBuscado.isEmpty() || nuevoNombre.isEmpty() || tipo.isEmpty() || descripcion.isEmpty() || cantidadStr.isEmpty() || precioStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int cantidad;
        double precio;
        try {
            cantidad = Integer.parseInt(cantidadStr);
            precio = Double.parseDouble(precioStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cantidad o precio inválidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean modificado = false;

        if (aseoPersonal != null) {
            for (AseoPersonal producto : aseoPersonal) {
                if (producto.getNombre().equalsIgnoreCase(nombreBuscado)) {
                    producto.setNombre(nuevoNombre);
                    producto.setTipo(tipo);
                    producto.setDescripcion(descripcion);
                    producto.setCantidad(cantidad);
                    producto.setPrecio((int) precio);
                    modificado = true;
                    break;
                }
            }
        }

        if (!modificado && bebidas != null) {
            for (Bebidas producto : bebidas) {
                if (producto.getNombre().equalsIgnoreCase(nombreBuscado)) {
                    producto.setNombre(nuevoNombre);
                    producto.setTipo(tipo);
                    producto.setDescripcion(descripcion);
                    producto.setCantidad(cantidad);
                    producto.setPrecio((int) precio);
                    modificado = true;
                    break;
                }
            }
        }

        if (!modificado && cuidadoSexual != null) {
            for (CuidadoSexual producto : cuidadoSexual) {
                if (producto.getNombre().equalsIgnoreCase(nombreBuscado)) {
                    producto.setNombre(nuevoNombre);
                    producto.setTipo(tipo);
                    producto.setDescripcion(descripcion);
                    producto.setCantidad(cantidad);
                    producto.setPrecio((int) precio);
                    modificado = true;
                    break;
                }
            }
        }

        if (modificado) {
            JOptionPane.showMessageDialog(this, "Producto modificado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void eliminar() {
        String nombreBuscado = jTextFieldUsuario10.getText().trim().toLowerCase();

        if (nombreBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre de producto para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean eliminado = false;

        if (aseoPersonal != null) {
            Iterator<AseoPersonal> it = aseoPersonal.iterator();
            while (it.hasNext()) {
                AseoPersonal producto = it.next();
                if (producto.getNombre().equalsIgnoreCase(nombreBuscado)) {
                    it.remove();
                    eliminado = true;
                    break;
                }
            }
        }

        if (!eliminado && bebidas != null) {
            Iterator<Bebidas> it = bebidas.iterator();
            while (it.hasNext()) {
                Bebidas producto = it.next();
                if (producto.getNombre().equalsIgnoreCase(nombreBuscado)) {
                    it.remove();
                    eliminado = true;
                    break;
                }
            }
        }

        if (!eliminado && cuidadoSexual != null) {
            Iterator<CuidadoSexual> it = cuidadoSexual.iterator();
            while (it.hasNext()) {
                CuidadoSexual producto = it.next();
                if (producto.getNombre().equalsIgnoreCase(nombreBuscado)) {
                    it.remove();
                    eliminado = true;
                    break;
                }
            }
        }

        if (eliminado) {
            JOptionPane.showMessageDialog(this, "Producto eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void RealizarAccion(String accion) {
        switch (accion.toLowerCase()) {
            case "agregar" -> {
                BotonCambiante.setText("Agregar");
                jLabelProducto.setText("Agregar Producto");
                for (ActionListener al : BotonCambiante.getActionListeners()) {
                    BotonCambiante.removeActionListener(al);
                }
                BotonCambiante.addActionListener(e -> {
                    agregar();
                });
            }

            case "modificar" -> {
                BotonCambiante.setText("Modificar");
                jLabelProducto.setText("Agregar Modificar");
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


    private void BotonCambianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCambianteActionPerformed

    }//GEN-LAST:event_BotonCambianteActionPerformed

    private void BuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarProductoActionPerformed
        buscar();
    }//GEN-LAST:event_BuscarProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCambiante;
    private javax.swing.JButton BuscarProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldTipo;
    private javax.swing.JTextField jTextFieldUsuario10;
    // End of variables declaration//GEN-END:variables
}
