package cr.ac.ucenfotec.bl.entities.tripulacion;

import cr.ac.ucenfotec.bl.entities.miembro.Miembro;
import cr.ac.ucenfotec.bl.entities.usuario.Usuario;

import java.util.ArrayList;

public interface ITripulacionDAO {
    public String registrarTripulacion(Tripulacion tripulacion)throws Exception;
    public ArrayList<Tripulacion> listarTripulaciones()throws Exception;
    public String modificarTripulacion(String codigo, Tripulacion tripulacionNueva)throws Exception;
    public Tripulacion buscarTripulacion(String codigo)throws Exception;
    public String asociarMiembroATripulacion(Miembro miembro, Tripulacion tripulacion) throws Exception;
}
