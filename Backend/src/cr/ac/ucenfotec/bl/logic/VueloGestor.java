package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.aereopuerto.Aereopuerto;
import cr.ac.ucenfotec.bl.entities.aereopuerto.IAereopuertoDAO;
import cr.ac.ucenfotec.bl.entities.aereopuerto.MySqlAereopuerto;
import cr.ac.ucenfotec.bl.entities.avion.Avion;
import cr.ac.ucenfotec.bl.entities.avion.IAvionDAO;
import cr.ac.ucenfotec.bl.entities.avion.MySqlAvion;
import cr.ac.ucenfotec.bl.entities.lineaAerea.ILineaAereaDAO;
import cr.ac.ucenfotec.bl.entities.lineaAerea.LineaAerea;
import cr.ac.ucenfotec.bl.entities.lineaAerea.MySqlLineaAereaImpl;
import cr.ac.ucenfotec.bl.entities.pais.IPaisDAO;
import cr.ac.ucenfotec.bl.entities.pais.MySqlPais;
import cr.ac.ucenfotec.bl.entities.pais.Pais;
import cr.ac.ucenfotec.bl.entities.sala.ISalaDAO;
import cr.ac.ucenfotec.bl.entities.sala.MySqlSalaImpl;
import cr.ac.ucenfotec.bl.entities.sala.Sala;
import cr.ac.ucenfotec.bl.entities.tripulacion.ITripulacionDAO;
import cr.ac.ucenfotec.bl.entities.tripulacion.MySqlTripulacion;
import cr.ac.ucenfotec.bl.entities.tripulacion.Tripulacion;
import cr.ac.ucenfotec.bl.entities.vuelo.IVueloDAO;
import cr.ac.ucenfotec.bl.entities.vuelo.MySqlVuelo;
import cr.ac.ucenfotec.bl.entities.vuelo.Vuelo;

import java.util.ArrayList;

public class VueloGestor {
    private IVueloDAO datosVuelos;
    private ILineaAereaDAO datosLineaAerea;
    private IAereopuertoDAO datosAereopuertos;
    private IAvionDAO datosAvion;
    private ISalaDAO datosSalas;
    private IPaisDAO datosPaises;
    private ITripulacionDAO datosTripulacion;

    public VueloGestor(){
        datosLineaAerea = new MySqlLineaAereaImpl();
        datosVuelos = new MySqlVuelo();
        datosAereopuertos = new MySqlAereopuerto();
        datosAvion = new MySqlAvion();
        datosSalas = new MySqlSalaImpl();
        datosPaises = new MySqlPais();
        datosTripulacion = new MySqlTripulacion();
    }

    public String registrarVuelos(String numeroVuelo, int horaLlegada, int horaSalida, String estado) throws Exception{
        Vuelo vuelo =new Vuelo(numeroVuelo,horaLlegada,horaSalida,estado);
        return datosVuelos.registrarVuelo(vuelo);
    }

    public String modificarVuelos(String numeroVueloAnterior, String numeroVuelo, int horaLlegada, int horaSalida, String estado) throws Exception{
        Vuelo vuelo =new Vuelo(numeroVuelo,horaLlegada,horaSalida,estado);
        return datosVuelos.modificarVuelo(numeroVueloAnterior,vuelo);
    }

    public ArrayList<Vuelo> listarVuelos() throws Exception{
        return datosVuelos.listarVuelos();
    }

    public String eliminarVuelo(String numeroVuelo) throws Exception{
        return datosVuelos.eliminarVuelo(numeroVuelo);
    }

    public Vuelo buscarVuelo(String numeroVuelo) throws Exception{
        return datosVuelos.buscarVuelo(numeroVuelo);
    }

    public String validarVueloRelacion(String numeroVuelo) throws Exception{
        return datosVuelos.validarVuelosRelacion(numeroVuelo);
    }

    public String crearVueloAvanzado(String numeroVuelo) throws Exception{
        return datosVuelos.crearVueloAvanzado(datosVuelos.buscarVuelo(numeroVuelo));
    }

    public String registrarLineaAereaVuelo(String cedulaJuridica, String numeroVuelo) throws Exception {

        LineaAerea lineaAerea = datosLineaAerea.buscarLineaAerea(cedulaJuridica);
        if (lineaAerea != null){

            Vuelo vuelo = datosVuelos.buscarVuelo(numeroVuelo);

            if (vuelo != null){
                return datosVuelos.asociarLineaAerea(lineaAerea,vuelo);

            }else {
                return "Este numero de vuelo no se encuentra en el sistema..";
            }

        }else {
            return "Esta linea aerea no se encuentra en el sistema..";
        }
    }

    public String registrarAereopuertoSalidaVuelo(String codigo, String numeroVuelo) throws Exception {
        Aereopuerto aereopuerto = datosAereopuertos.buscarAereopuerto(codigo) ;

        if (aereopuerto != null){

            Vuelo vuelo = datosVuelos.buscarVuelo(numeroVuelo);

            if (vuelo != null){
                return datosVuelos.asociarAereopuertoSalida(aereopuerto,vuelo);

            }else {
                return "Este numero de vuelo no se encuentra en el sistema..";
            }

        }else {
            return "Este aereopuerto no se encuentra en el sistema..";
        }
    }

    public String registrarAereopuertoDestinoVuelo(String codigo, String numeroVuelo) throws Exception {
        Aereopuerto aereopuerto = datosAereopuertos.buscarAereopuerto(codigo) ;

        if (aereopuerto != null){

            Vuelo vuelo = datosVuelos.buscarVuelo(numeroVuelo);

            if (vuelo != null){
                return datosVuelos.asociarAereopuertoDestino(aereopuerto,vuelo);

            }else {
                return "Este numero de vuelo no se encuentra en el sistema..";
            }

        }else {
            return "Este aereopuerto no se encuentra en el sistema..";
        }
    }

    public String registrarAvionVuelo(String placa, String numeroVuelo) throws Exception {
        Avion avion = datosAvion.buscarAvion(placa) ;

        if (avion != null){

            Vuelo vuelo = datosVuelos.buscarVuelo(numeroVuelo);

            if (vuelo != null){
                return datosVuelos.asociarAvion(avion,vuelo);

            }else {
                return "Este numero de vuelo no se encuentra en el sistema..";
            }

        }else {
            return "Este avion no se encuentra en el sistema..";
        }
    }

    public String registrarSalaSalidaVuelo(String codigo, String numeroVuelo) throws Exception {
        Sala sala = datosSalas.buscarSala(codigo);

        if (sala != null){

            Vuelo vuelo = datosVuelos.buscarVuelo(numeroVuelo);

            if (vuelo != null){
                return datosVuelos.asociarSalaSalida(sala,vuelo);

            }else {
                return "Este numero de vuelo no se encuentra en el sistema..";
            }

        }else {
            return "Esta sala no se encuentra en el sistema..";
        }
    }

    public String registrarSalaDestinoVuelo(String codigo, String numeroVuelo) throws Exception {
        Sala sala = datosSalas.buscarSala(codigo);

        if (sala != null){

            Vuelo vuelo = datosVuelos.buscarVuelo(numeroVuelo);

            if (vuelo != null){
                return datosVuelos.asociarSalaDestino(sala,vuelo);

            }else {
                return "Este numero de vuelo no se encuentra en el sistema..";
            }

        }else {
            return "Esta sala no se encuentra en el sistema..";
        }
    }

    public String registrarPaisSalidaVuelo(String codigo, String numeroVuelo) throws Exception {
        Pais pais = datosPaises.buscarPais(codigo);

        if (pais != null){

            Vuelo vuelo = datosVuelos.buscarVuelo(numeroVuelo);

            if (vuelo != null){
                return datosVuelos.asociarPaisSalida(pais,vuelo);

            }else {
                return "Este numero de vuelo no se encuentra en el sistema..";
            }

        }else {
            return "Este pais no se encuentra en el sistema..";
        }
    }

    public String registrarPaisDestinoVuelo(String codigo, String numeroVuelo) throws Exception {
        Pais pais = datosPaises.buscarPais(codigo);

        if (pais != null){

            Vuelo vuelo = datosVuelos.buscarVuelo(numeroVuelo);

            if (vuelo != null){
                return datosVuelos.asociarPaisDestino(pais,vuelo);

            }else {
                return "Este numero de vuelo no se encuentra en el sistema..";
            }

        }else {
            return "Este pais no se encuentra en el sistema..";
        }
    }

    public String registrarTripulacionVuelo(String codigo, String numeroVuelo) throws Exception {
        Tripulacion tripulacion = datosTripulacion.buscarTripulacion(codigo);

        if (tripulacion != null){

            Vuelo vuelo = datosVuelos.buscarVuelo(numeroVuelo);

            if (vuelo != null){
                return datosVuelos.asociarTripulacion(tripulacion,vuelo);

            }else {
                return "Este numero de vuelo no se encuentra en el sistema..";
            }

        }else {
            return "Esta tripulacion no se encuentra en el sistema..";
        }
    }

}
