package cr.ac.ucenfotec.bl.entities.avion;

import cr.ac.ucenfotec.bl.entities.pais.Pais;

import java.util.ArrayList;

public interface IAvionDAO {
    public String registrarAvion(Avion nuevoAvion) throws Exception;
    public String modificarAvion(String Avion,Avion avion) throws Exception;

    ArrayList<Avion> listarAviones() throws Exception;

    public Avion buscarAvion(String placaAvion) throws Exception;
    public String eliminarAvion(String placaAvion) throws Exception;
}
