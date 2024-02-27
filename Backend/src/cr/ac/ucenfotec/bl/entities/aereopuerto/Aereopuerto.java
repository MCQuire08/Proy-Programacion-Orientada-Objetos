package cr.ac.ucenfotec.bl.entities.aereopuerto;

public class Aereopuerto {
    private String nombre;
    private String  codigo;

    public Aereopuerto() {
    }

    public Aereopuerto(String nombre, String  codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", codigo: " + codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aereopuerto that = (Aereopuerto) o;
        return codigo == that.codigo;
    }

}
