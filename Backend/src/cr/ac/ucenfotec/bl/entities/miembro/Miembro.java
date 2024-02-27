package cr.ac.ucenfotec.bl.entities.miembro;

import cr.ac.ucenfotec.bl.entities.Persona;

public class Miembro extends Persona {
    private String genero;
    private int anosExp; //Anos Experiencia
    private int fechaGrad; //Fecha de Graduacion
    private int numeroLic; // Numero de Licencia
    private String puesto;
    private int telefono;
    private String contrasena;

    public Miembro() {
    }

    public Miembro(String nombre, String apellidos, String nacionalidad, String correo, String direccion, int identificacion, String genero, int anosExp, int fechaGrad, int numeroLic, String puesto, int telefono, String contrasena) {
        super(nombre, apellidos, nacionalidad, correo, direccion, identificacion);
        this.genero = genero;
        this.anosExp = anosExp;
        this.fechaGrad = fechaGrad;
        this.numeroLic = numeroLic;
        this.puesto = puesto;
        this.telefono = telefono;
        this.contrasena = contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnosExp() {
        return anosExp;
    }

    public void setAnosExp(int anosExp) {
        this.anosExp = anosExp;
    }

    public int getFechaGrad() {
        return fechaGrad;
    }

    public void setFechaGrad(int fechaGrad) {
        this.fechaGrad = fechaGrad;
    }

    public int getNumeroLic() {
        return numeroLic;
    }

    public void setNumeroLic(int numeroLic) {
        this.numeroLic = numeroLic;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public void iniciarSesion() {

    }

    @Override
    public String toString() {
        return "genero: " + genero + ", anosExp: " + anosExp + ", fechaGrad: " + fechaGrad + ", numeroLic: " + numeroLic + ", puesto: " + puesto + ", telefono: " + telefono;
    }


}
