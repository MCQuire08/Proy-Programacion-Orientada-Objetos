package cr.ac.ucenfotec.bl.entities.usuario;

import cr.ac.ucenfotec.bl.entities.Persona;

public class Usuario extends Persona {
    private int edad;
    private String contrasena;

    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String nacionalidad, String correo, String direccion, int identificacion, int edad, String contrasena) {
        super(nombre, apellidos, nacionalidad, correo, direccion, identificacion);
        this.edad = edad;
        this.contrasena=contrasena;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public void iniciarSesion() {

    }

    @Override
    public String toString() {

        String mensaje = this.getNombre()+ " , " + this.getApellidos() + " , " + this.getIdentificacion() + " , " + this.getCorreo() + " , " + this.getNacionalidad() + " , " + this.getDireccion() + " , " + edad;
        return mensaje;
    }
}
