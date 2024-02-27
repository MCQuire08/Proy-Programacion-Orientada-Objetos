package cr.ac.ucenfotec.bl.entities.administrador;

import cr.ac.ucenfotec.bl.entities.Persona;

public class Administrador extends Persona {
    private int edad;
    private String genero;
    private String contrasena;

    public Administrador(){

    }

    public Administrador(String nombre, String apellidos, String nacionalidad, String correo, String direccion, int identificacion, int edad, String genero, String contrasena) {
        super(nombre, apellidos, nacionalidad, correo, direccion, identificacion);
        this.edad = edad;
        this.genero = genero;
        this.contrasena=contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String  getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public void iniciarSesion() {

    }

    @Override
    public String toString() {
        String mensaje = "-Nombre: " + getNombre() + " Apellidos: " + getApellidos() + " Nacionalidad: " + getNacionalidad() + " Correo: " + getCorreo() + " Direccion: "
                + getDireccion() + "\n Identificacion: " + getIdentificacion()+ " Edad: " + edad + " Genero: " + genero ;
        return mensaje;
    }



}
