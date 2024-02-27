package cr.ac.ucenfotec.bl.entities.sala;

import java.util.ArrayList;

public interface ISalaDAO {
    public String registrarSala(Sala nuevaSala) throws Exception;
    public String modificarSala(String codigo,Sala sala) throws Exception;
    public ArrayList<Sala> listarSalas() throws Exception;
    public Sala buscarSala(String codigo) throws Exception;
    public String eliminarSala(String codigo) throws Exception;
}
