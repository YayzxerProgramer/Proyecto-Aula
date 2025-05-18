package Model;

public class Cliente extends Usuarios {

    public Cliente(String nombre, String usuario, String contraseña, int edad, String correo, String rol) {
        super(nombre, usuario, contraseña, edad, correo, "Cliente");
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + getNombre() + ", Usuario=" + getUsuario() + ", correo=" + getCorreo()
                + ", contrasena=" + getContraseña() + ", edad= " + getEdad() + ", rol= " + getRol() + '}';
    }
}
