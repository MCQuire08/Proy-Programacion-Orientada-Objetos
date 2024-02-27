package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.pais.IPaisDAO;
import cr.ac.ucenfotec.bl.entities.pais.MySqlPais;
import cr.ac.ucenfotec.bl.entities.pais.Pais;

import java.util.ArrayList;

public class PaisGestor {

    private IPaisDAO datosPaises;

    public PaisGestor(){
        datosPaises = new MySqlPais();
    }

    public String registrarPais(String nombre, String abreviatura, String codigo) throws Exception {
        Pais nuevoPais = new Pais(nombre,abreviatura,codigo);
        return datosPaises.registrarPais(nuevoPais);
    }

    public String modificarPais(String codigoPaisAModificar, String nombre, String abreviatura,String codigo) throws Exception{
        Pais paisModificar = new Pais(nombre,abreviatura,codigo);
        return datosPaises.modificarPais(codigoPaisAModificar,paisModificar);
    }

    public ArrayList<Pais> listarPaises() throws Exception{
        return datosPaises.listarPaises();
    }

    public String eliminarPais(String codigoPais) throws Exception{
        return datosPaises.eliminarPais(codigoPais);
    }

    public Pais buscarPais(String codigoPais) throws Exception{
        return datosPaises.buscarPais(codigoPais);
    }


}
