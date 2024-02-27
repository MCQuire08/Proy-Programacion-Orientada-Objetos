package cr.ac.ucenfotec.bl.entities.lineaAerea;

import cr.ac.ucenfotec.bl.entities.pais.Pais;
import cr.ac.ucenfotec.bl.entities.sala.Sala;

public class LineaAerea {
    private String nombre;
    private String cedulaJuridica;
    private String nomrbreEmpresa;
    private String logo;
    private Pais paisOrigen;

    public LineaAerea() {
    }

    public LineaAerea(String nombre, String cedulaJuridica, String nomrbreEmpresa, String logo) {
        this.nombre = nombre;
        this.cedulaJuridica = cedulaJuridica;
        this.nomrbreEmpresa = nomrbreEmpresa;
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public String getNombreEmpresa() {
        return nomrbreEmpresa;
    }

    public void setNomrbreEmpresa(String nomrbreEmpresa) {
        this.nomrbreEmpresa = nomrbreEmpresa;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + ", cedulaJuridica: " + cedulaJuridica + ", nomrbreEmpresa: " + nomrbreEmpresa + ", logo:" + logo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineaAerea that = (LineaAerea) o;
        return cedulaJuridica == that.cedulaJuridica;
    }

}
