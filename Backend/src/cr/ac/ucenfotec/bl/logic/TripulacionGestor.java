package cr.ac.ucenfotec.bl.logic;


import cr.ac.ucenfotec.bl.entities.miembro.IMiembroDAO;
import cr.ac.ucenfotec.bl.entities.miembro.Miembro;
import cr.ac.ucenfotec.bl.entities.miembro.MySqlMiembro;
import cr.ac.ucenfotec.bl.entities.tripulacion.ITripulacionDAO;
import cr.ac.ucenfotec.bl.entities.tripulacion.MySqlTripulacion;
import cr.ac.ucenfotec.bl.entities.tripulacion.Tripulacion;

import java.util.ArrayList;

public class TripulacionGestor {

    private ITripulacionDAO datosTripulacion;
    private IMiembroDAO datosMiembros;

    public TripulacionGestor(){
        datosMiembros = new MySqlMiembro();
        datosTripulacion = new MySqlTripulacion();
    }

    public String registrarTripulacion(String codigo, String nombre) throws Exception {
        Tripulacion tripulacion = new Tripulacion(codigo,nombre);
        return datosTripulacion.registrarTripulacion(tripulacion);
    }

    public ArrayList<Tripulacion> listarTripulacion() throws Exception {
        ArrayList<Tripulacion> listaDeTripulaciones = datosTripulacion.listarTripulaciones();
        return listaDeTripulaciones;
    }

    public String modificarTripulacion(String codigoAnterior,String codigo, String nombre) throws Exception{
        Tripulacion tripulacion = new Tripulacion(codigo,nombre);
        return datosTripulacion.modificarTripulacion(codigoAnterior,tripulacion);
    }

    public Tripulacion buscarTripulacion(String codigo) throws Exception {
        return datosTripulacion.buscarTripulacion(codigo);
    }

    public String agregarMiembroATripulacion(int identificacion, String codigo) throws Exception {
        //1.Buscar el miembro
        Miembro miembroEncontrado = datosMiembros.buscarMiembro(identificacion);

        if (miembroEncontrado != null){

            //2.Buscar la tripulacion
            Tripulacion tripulacionEncontrada = datosTripulacion.buscarTripulacion(codigo);
            if (tripulacionEncontrada != null){
                //3.Asociar al miembro con la tripulacion
                return datosTripulacion.asociarMiembroATripulacion(miembroEncontrado,tripulacionEncontrada);
            }else {
                return "El codigo de la tripulacion "+ codigo + ", no existe en el sistema...";
            }

        }else {
            return "La identificacion del miembro "+ identificacion + ", no existe en el sistema...";
        }
    }
}
