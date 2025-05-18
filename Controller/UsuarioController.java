package Controller;

import Model.Usuarios;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JButton;

public abstract class UsuarioController {

    public static ArrayList<Usuarios> usuarios = new ArrayList<>();

    public static void guardarUsuario(Usuarios usuario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt", true))) {
            String linea = usuario.getNombre() + ","
                    + usuario.getUsuario() + ","
                    + usuario.getContraseña() + ","
                    + usuario.getEdad() + ","
                    + usuario.getCorreo() + ","
                    + usuario.getRol();
            writer.write(linea);
            writer.newLine();
        } catch (IOException e) {
        }
    }

    protected abstract void reporte();

    public static void cargarUsuarios() {
        File archivo = new File("usuarios.txt");

        if (!archivo.exists()) {
            usuarios.clear();
            usuarios.add(new Usuarios("Yannior Jose Tapias Segovia", "YanniorT", "Ytapias0118", 18, "yanniortapias36@gmail.com", "Administrador"));
            usuarios.add(new Usuarios("Anderson Javier Pajaro Fanco", "AndersonP", "AndersonP18", 18, "andersonjota.pajarofranco@gmail.com", "Empleado"));
            usuarios.add(new Usuarios("Andres David Rico Palencia", "AndresR", "AndresR0118", 18, "ricoandres096@gmail.com", "Cliente"));
            usuarios.add(new Usuarios("Luis Sarmiento", "LuisS", "LuisS123", 17, "luiskdr22@gmail.com", "Administrador"));

            actualizarArchivo();
            return;
        }

        usuarios.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 6) {
                    String nombre = partes[0];
                    String username = partes[1];
                    String contraseña = partes[2];
                    int edad = Integer.parseInt(partes[3]);
                    String correo = partes[4];
                    String rol = partes[5];
                    usuarios.add(new Usuarios(nombre, username, contraseña, edad, correo, rol));
                }
            }
        } catch (IOException e) {
        }
    }

    public static boolean validarUsuario(String usuario, String contraseña) {
        for (Usuarios u : usuarios) {
            if (u.getUsuario().equals(usuario)) {
                if (u.getContraseña().equals(contraseña)) {
                    JOptionPane.showMessageDialog(null, "Inicio de Sesión Exitoso!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña es incorrecta. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "El usuario ingresado no existe. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public static boolean RegistroUsuario(String nombre, String usuario, String contraseña, String edad, String correo) {
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre no válido");
            return false;
        }
        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usuario no válido");
            return false;
        }
        if (contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Contraseña no válida");
            return false;
        }
        int edadInt = 0;
        if (edad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Edad no válida");
            return false;
        } else {
            try {
                edadInt = Integer.parseInt(edad);
                if (edadInt <= 0 || edadInt > 120) {
                    JOptionPane.showMessageDialog(null, "Edad fuera de rango permitido");
                    return false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Edad debe ser un número entero");
                return false;
            }
        }

        correo = correo.trim();
        if (correo.isEmpty() || !(correo.endsWith("@gmail.com") || correo.endsWith("@hotmail.com") || correo.endsWith("@outlook.com"))) {
            JOptionPane.showMessageDialog(null, "Correo no válido. Solo aceptamos Gmail, Hotmail y Outlook.");
            return false;
        }

        for (Usuarios u : usuarios) {
            if (u.getUsuario().equals(usuario)) {
                JOptionPane.showMessageDialog(null, "El nombre de usuario ya está en uso");
                return false;
            }
        }

        Usuarios nuevoUsuario = new Usuarios(nombre, usuario, contraseña, edadInt, correo, "Cliente");
        usuarios.add(nuevoUsuario);
        guardarUsuario(nuevoUsuario);

        JOptionPane.showMessageDialog(null, "Usuario registrado con éxito", "Software SuperFarmax", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public static void eliminarUsuario(String username) {
        boolean encontrado = false;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getUsuario().equals(username)) {
                usuarios.remove(i);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        } else {
            actualizarArchivo();
            JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito");
        }
    }

    public static void modificarUsuario(String nombre, String username, String contraseña, String edad, String correo, String rol) {
        int edadInt = 0;
        if (!edad.isEmpty()) {
            try {
                edadInt = Integer.parseInt(edad);
                if (edadInt <= 0 || edadInt > 120) {
                    JOptionPane.showMessageDialog(null, "Edad fuera de rango permitido");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Edad debe ser un número entero");
                return;
            }
        }

        for (Usuarios usuario1 : usuarios) {
            if (usuario1 != null && usuario1.getUsuario().equals(username)) {
                usuario1.setNombre(nombre);
                usuario1.setContraseña(contraseña);
                usuario1.setEdad(edadInt);
                usuario1.setCorreo(correo);
                usuario1.setRol(rol);
                actualizarArchivo();
                JOptionPane.showMessageDialog(null, "Usuario modificado con éxito");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Usuario no encontrado");
    }

    private static void actualizarArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt", false))) {
            for (Usuarios usuario : usuarios) {
                String linea = usuario.getNombre() + ","
                        + usuario.getUsuario() + ","
                        + usuario.getContraseña() + ","
                        + usuario.getEdad() + ","
                        + usuario.getCorreo() + ","
                        + usuario.getRol();
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
        }
    }

    public static void sombraBoton(JButton boton) {
        Color colorOriginal = boton.getBackground();

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent var) {
                boton.setBackground(new Color(0, 51, 153));
            }

            @Override
            public void mouseExited(MouseEvent var) {
                boton.setBackground(colorOriginal);
            }
        });
    }

}
