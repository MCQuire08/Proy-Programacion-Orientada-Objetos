package cr.ac.ucenfotec.bl.entities.lineaAerea;

import cr.ac.ucenfotec.bl.entities.aereopuerto.Aereopuerto;

import javax.sound.sampled.Line;
import java.util.ArrayList;

public interface ILineaAereaDAO {
    public String registrarLineaAerea(LineaAerea lineaAerea) throws Exception;
    public String modificarLineaAerea(String cedulaJuridica, LineaAerea lineaAerea) throws Exception;
    ArrayList<LineaAerea> listarLineaAerea() throws Exception;
    public LineaAerea buscarLineaAerea(String cedulaJuridica) throws Exception;
    public String eliminarLineaAerea(String cedulaJuridica) throws Exception;
}
