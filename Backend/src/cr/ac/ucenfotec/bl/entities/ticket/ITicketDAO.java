package cr.ac.ucenfotec.bl.entities.ticket;

import cr.ac.ucenfotec.bl.entities.aereopuerto.Aereopuerto;
import cr.ac.ucenfotec.bl.entities.pais.Pais;

import java.util.ArrayList;

public interface ITicketDAO {
    public String registrarTicket(Ticket ticket) throws Exception;
    public ArrayList<Ticket> listarTickets()throws Exception;
    public Ticket buscarTicket(String numeroTicket)throws Exception;
    public String asociarTicketAereopuertoSalida(Ticket ticket, Aereopuerto aereopuerto)throws Exception;
    public String asociarTicketAereopuertoDestino(Ticket ticket, Aereopuerto aereopuerto)throws Exception;
    public String asociarTicketPaisSalida(Ticket ticket, Pais pais)throws Exception;
    public String asociarTicketPaisDestino(Ticket ticket, Pais pais)throws Exception;
}
