 package Model;

import java.util.ArrayList;

public class Usuarios {

    private String nombre;
    private String usuario;
    private String contraseña;
    private int edad;
    private String correo;
    private String rol;
    private static final ArrayList<Usuarios> usuarios = new ArrayList<>();

    public Usuarios(String nombre, String usuario, String contraseña, int edad, String correo, String rol) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.edad = edad;
        this.correo = correo;
        this.usuario = usuario;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public static ArrayList<Usuarios> getUsuarios() {
        return usuarios;
    }

    public static void agregarUsuario(Usuarios usuario) {
        usuarios.add(usuario);
    }
}
