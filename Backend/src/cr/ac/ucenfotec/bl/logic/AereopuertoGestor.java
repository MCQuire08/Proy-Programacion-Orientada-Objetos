package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.aereopuerto.Aereopuerto;
import cr.ac.ucenfotec.bl.entities.aereopuerto.IAereopuertoDAO;
import cr.ac.ucenfotec.bl.entities.aereopuerto.MySqlAereopuerto;

import java.util.ArrayList;

public class AereopuertoGestor {

    private IAereopuertoDAO datosAereopuertos;

    public AereopuertoGestor(){
        datosAereopuertos = new MySqlAereopuerto();
    }

    public String registrarAereopuerto(String nombre, String codigo) throws Exception{
        Aereopuerto aeropuerto = new Aereopuerto(nombre,codigo);
        return datosAereopuertos.registrarAereopuerto(aeropuerto);
    }

    public String modificarAereopuerto(String codigoAnterior,String nombre, String codigo) throws Exception{
        Aereopuerto aeropuerto = new Aereopuerto(nombre,codigo);
        return datosAereopuertos.modificarAvion(codigoAnterior,aeropuerto);
    }

    public ArrayList<Aereopuerto> listarAereopuertos() throws Exception{
        return datosAereopuertos.listarAereopuertos();
    }

    public String eliminarAereopuertos(String codigo) throws Exception{
        return datosAereopuertos.eliminarAereopuerto(codigo);
    }

    public Aereopuerto buscarAereopuerto(String codigo) throws Exception{
        return datosAereopuertos.buscarAereopuerto(codigo);
    }

}
