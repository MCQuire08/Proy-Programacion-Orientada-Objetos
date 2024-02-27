package cr.ac.ucenfotec.bl.entities.tripulacion;

import cr.ac.ucenfotec.bl.entities.miembro.Miembro;

import java.util.ArrayList;
import java.util.Objects;

public class Tripulacion {
    private String  codigo;
    private String nombre;
    private ArrayList<Miembro> miembrosTripulacion;

    public Tripulacion() {
    }

    public Tripulacion(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.miembrosTripulacion = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarMiembro(Miembro nuevoMiembro){
        miembrosTripulacion.add(nuevoMiembro);
    }

    @Override
    public String toString() {
        return "codigo=" + codigo + ", nombre=" + nombre ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tripulacion that = (Tripulacion) o;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
