package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.sala.ISalaDAO;
import cr.ac.ucenfotec.bl.entities.sala.MySqlSalaImpl;
import cr.ac.ucenfotec.bl.entities.sala.Sala;

import java.util.ArrayList;

public class SalaGestor {

    private ISalaDAO datos;

    public SalaGestor(){
        datos = new MySqlSalaImpl();
    }

    public String registrarSala (String nombre, String codigo, String ubicacion) throws Exception {
        Sala salaVerificacion = new Sala(nombre,codigo,ubicacion);
        return datos.registrarSala(salaVerificacion);
    }

    public ArrayList<Sala> listarSala()throws Exception{
        return datos.listarSalas();
    }

    public Sala buscarSala(String codigo)throws Exception{
        return datos.buscarSala(codigo);
    }

}
