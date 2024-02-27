package cr.ac.ucenfotec.bl.entities.sala;

import java.util.Objects;

public class Sala {
    private String nombre;
    private String codigo;
    private String ubicacion;

    public Sala() {
    }

    public Sala(String nombre, String codigo, String ubicacion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.ubicacion = ubicacion;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", codigo=" + codigo + ", ubicacion=" + ubicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        return codigo == sala.codigo && Objects.equals(nombre, sala.nombre);
    }

}
