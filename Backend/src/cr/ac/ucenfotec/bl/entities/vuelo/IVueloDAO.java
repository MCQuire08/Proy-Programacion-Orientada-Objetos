package cr.ac.ucenfotec.bl.entities.vuelo;

import cr.ac.ucenfotec.bl.entities.aereopuerto.Aereopuerto;
import cr.ac.ucenfotec.bl.entities.avion.Avion;
import cr.ac.ucenfotec.bl.entities.lineaAerea.LineaAerea;
import cr.ac.ucenfotec.bl.entities.pais.Pais;
import cr.ac.ucenfotec.bl.entities.sala.Sala;
import cr.ac.ucenfotec.bl.entities.tripulacion.Tripulacion;

import java.util.ArrayList;

public interface IVueloDAO {
    public String registrarVuelo(Vuelo vuelo) throws Exception;
    public String modificarVuelo(String numeroVuelo,Vuelo vuelo) throws Exception;
    ArrayList<Vuelo> listarVuelos() throws Exception;
    public Vuelo buscarVuelo(String numeroVuelo) throws Exception;
    public String validarVuelosRelacion(String numeroVuelo) throws Exception;
    public String eliminarVuelo(String numeroVuelo) throws Exception;
    public String crearVueloAvanzado(Vuelo vuelo) throws Exception;
    public String asociarLineaAerea(LineaAerea lineaAerea, Vuelo vuelo) throws Exception;
    public String asociarAereopuertoSalida(Aereopuerto aereopuerto, Vuelo vuelo) throws Exception;
    public String asociarAereopuertoDestino(Aereopuerto aereopuerto, Vuelo vuelo) throws Exception;
    public String asociarAvion(Avion avion, Vuelo vuelo) throws Exception;
    public String asociarSalaSalida(Sala sala, Vuelo vuelo) throws Exception;
    public String asociarSalaDestino(Sala sala,Vuelo vuelo) throws Exception;
    public String asociarPaisSalida(Pais pais, Vuelo vuelo) throws Exception;
    public String asociarPaisDestino(Pais pais,Vuelo vuelo) throws Exception;
    public String asociarTripulacion(Tripulacion tripulacion, Vuelo vuelo) throws Exception;
}
