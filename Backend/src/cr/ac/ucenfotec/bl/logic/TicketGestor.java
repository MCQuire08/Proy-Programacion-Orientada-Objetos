package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.aereopuerto.Aereopuerto;
import cr.ac.ucenfotec.bl.entities.aereopuerto.IAereopuertoDAO;
import cr.ac.ucenfotec.bl.entities.aereopuerto.MySqlAereopuerto;
import cr.ac.ucenfotec.bl.entities.pais.IPaisDAO;
import cr.ac.ucenfotec.bl.entities.pais.MySqlPais;
import cr.ac.ucenfotec.bl.entities.pais.Pais;
import cr.ac.ucenfotec.bl.entities.ticket.ITicketDAO;
import cr.ac.ucenfotec.bl.entities.ticket.MySqlTicket;
import cr.ac.ucenfotec.bl.entities.ticket.Ticket;

import java.util.ArrayList;

public class TicketGestor {

    private ITicketDAO datosTicket;
    private IAereopuertoDAO datosAereopuerto;
    private IPaisDAO datosPais;

    public TicketGestor(){
        datosAereopuerto = new MySqlAereopuerto();
        datosPais = new MySqlPais();
        datosTicket = new MySqlTicket();
    }


    public String registrarTickets(String numeroTicket,String numeroAsiento, double precio, String numeroVuelo, String tipoAsiento) throws Exception {
        Ticket ticket = new Ticket(numeroTicket,numeroAsiento,precio,numeroVuelo,tipoAsiento);
        return datosTicket.registrarTicket(ticket);
    }

    public ArrayList<Ticket> listarTickets() throws Exception{
        return datosTicket.listarTickets();
    }

    public Ticket buscarTicket(String numeroTicket)throws Exception{
        return datosTicket.buscarTicket(numeroTicket);
    }

    public String asociarAereopuertoSalida(String codigo,String numeroTicket) throws Exception {
        Aereopuerto aereopuerto = datosAereopuerto.buscarAereopuerto(codigo);
        Ticket ticket = datosTicket.buscarTicket(numeroTicket);
        return datosTicket.asociarTicketAereopuertoSalida(ticket,aereopuerto);
    }

    public String asociarAereopuertoDestino(String codigo,String numeroTicket) throws Exception {
        Aereopuerto aereopuerto = datosAereopuerto.buscarAereopuerto(codigo);
        Ticket ticket = datosTicket.buscarTicket(numeroTicket);
        return datosTicket.asociarTicketAereopuertoDestino(ticket,aereopuerto);
    }

    public String asociarPaisSalida(String codigo,String numeroTicket) throws Exception {
        Pais pais = datosPais.buscarPais(codigo);
        Ticket ticket = datosTicket.buscarTicket(numeroTicket);
        return datosTicket.asociarTicketPaisSalida(ticket,pais);
    }

    public String asociarPaisDestino(String codigo,String numeroTicket) throws Exception {
        Pais pais = datosPais.buscarPais(codigo);
        Ticket ticket = datosTicket.buscarTicket(numeroTicket);
        return datosTicket.asociarTicketPaisDestino(ticket,pais);
    }

}
