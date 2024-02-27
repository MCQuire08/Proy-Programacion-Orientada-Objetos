package cr.ac.ucenfotec.bl.entities.aereopuerto;

import java.util.ArrayList;

public interface IAereopuertoDAO {
    public String registrarAereopuerto(Aereopuerto aeropuerto) throws Exception;
    public String modificarAvion(String codigoAnterior, Aereopuerto aeropuerto) throws Exception;
    ArrayList<Aereopuerto> listarAereopuertos() throws Exception;
    public Aereopuerto buscarAereopuerto(String codigo) throws Exception;
    public String eliminarAereopuerto(String codigo) throws Exception;
}
