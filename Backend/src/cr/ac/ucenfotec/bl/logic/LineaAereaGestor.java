package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.lineaAerea.ILineaAereaDAO;
import cr.ac.ucenfotec.bl.entities.lineaAerea.LineaAerea;
import cr.ac.ucenfotec.bl.entities.lineaAerea.MySqlLineaAereaImpl;
import cr.ac.ucenfotec.bl.entities.pais.Pais;


import java.util.ArrayList;


public class LineaAereaGestor {

    private ILineaAereaDAO datosLineasAereas;

    public LineaAereaGestor(){
        datosLineasAereas = new MySqlLineaAereaImpl();
    }

    public String registrarLineaAerea(String nombre, String cedulaJuridica, String nombreEmpresa,String logo) throws Exception {
        LineaAerea lineaAerea = new LineaAerea(nombre,cedulaJuridica,nombreEmpresa,logo);
        return datosLineasAereas.registrarLineaAerea(lineaAerea);
    }

    public String modificarLineaAerea(String cedulaAnterior,String nombre, String cedulaJuridica, String nombreEmpresa,String logo) throws Exception {
        LineaAerea lineaAerea = new LineaAerea(nombre,cedulaJuridica,nombreEmpresa,logo);
        return datosLineasAereas.modificarLineaAerea(cedulaAnterior,lineaAerea);
    }

    public ArrayList<LineaAerea> listarLineasAereas() throws Exception {
        return datosLineasAereas.listarLineaAerea();
    }

    public LineaAerea buscarLineaAerea(String cedulaJuridica) throws Exception{
        return datosLineasAereas.buscarLineaAerea(cedulaJuridica);
    }

    public String eliminarLineaAerea(String cedulaJuridica) throws Exception{
        return datosLineasAereas.eliminarLineaAerea(cedulaJuridica);
    }
}