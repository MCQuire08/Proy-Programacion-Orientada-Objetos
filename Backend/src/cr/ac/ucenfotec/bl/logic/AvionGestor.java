package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.avion.Avion;
import cr.ac.ucenfotec.bl.entities.avion.IAvionDAO;
import cr.ac.ucenfotec.bl.entities.avion.MySqlAvion;

import java.util.ArrayList;

public class AvionGestor {

    private IAvionDAO datosAviones;
    public AvionGestor(){
        datosAviones = new MySqlAvion();
    }

    public String registrarAvion(String placa, String marca, String modelo,int capacidad) throws Exception{
        Avion avion = new Avion(placa,marca,modelo,capacidad);
        return datosAviones.registrarAvion(avion);
    }

    public String modificarAvion(String placaAnterior,String placa, String marca, String modelo,int capacidad) throws Exception{
        Avion avion = new Avion(placa,marca,modelo,capacidad);
        return datosAviones.modificarAvion(placaAnterior,avion);
    }

    public ArrayList<Avion> listarAviones()throws Exception{
        return datosAviones.listarAviones();
    }

    public String eliminarAvion(String placa)throws Exception{
        return datosAviones.eliminarAvion(placa);
    }

    public Avion buscarAvion(String placa) throws Exception{
        return datosAviones.buscarAvion(placa);
    }
}
