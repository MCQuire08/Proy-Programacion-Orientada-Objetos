package cr.ac.ucenfotec.bl.entities.pais;

import java.util.ArrayList;

public interface IPaisDAO {
    public String registrarPais(Pais nuevoPais) throws Exception;
    public String modificarPais(String codigoAnterior,Pais pais) throws Exception;
    public ArrayList<Pais> listarPaises() throws Exception;
    public Pais buscarPais(String codigoPais) throws Exception;
    public String eliminarPais(String codigoPais) throws Exception;
}
