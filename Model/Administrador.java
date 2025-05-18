package Model;

public class Administrador extends Usuarios {

    public Administrador(String nombre, String usuario, String contraseña, int edad, String correo, String rol) {
        super(nombre, usuario, contraseña, edad, correo, rol);
    }

    @Override
    public String toString() {
        return "Administrador{" + 
               "nombre=" + getNombre() + 
               ", Usuario=" + getUsuario() + 
               ", correo=" + getCorreo() + 
               ", contrasena=" + getContraseña() + 
               ", edad= " + getEdad() + 
               ", rol= " + getRol() + 
               '}';
    }
} 
