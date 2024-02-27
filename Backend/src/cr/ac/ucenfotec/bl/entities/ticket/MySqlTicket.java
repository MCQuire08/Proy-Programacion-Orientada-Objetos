package cr.ac.ucenfotec.bl.entities.ticket;

import cr.ac.ucenfotec.bl.entities.aereopuerto.Aereopuerto;
import cr.ac.ucenfotec.bl.entities.pais.Pais;
import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlTicket implements ITicketDAO{
    private String sql;

    @Override
    public String registrarTicket(Ticket ticket) throws Exception {
        sql = "INSERT INTO ticket (numeroTicket,numeroAsiento,precio,numeroVuelo,tipoAsiento,aereopuertoSalida,aereopuertoDestino,paisSalida,paisDestino) VALUES ('"+ticket.getNumeroTicket()+"','"+ticket.getNumeroAsiento()+"',"+ticket.getPrecio()+",'"+ticket.getNumeroVuelo()+"','"+ticket.getTipoAsiento()+"','"+ticket.getAeropuertoSalida()+"','"+ticket.getAeropuertoDestino()+"','"+ticket.getPaisSalida()+"','"+ticket.getPaisDestino()+"');";
        Conector.getConnector().ejecutarSQL(sql);
        return "El ticket "+ticket.getNumeroTicket()+", fue registrado correctamente!";
    }

    @Override
    public ArrayList<Ticket> listarTickets() throws Exception {
        ArrayList<Ticket> listaTickets = new ArrayList<>();
        sql = "SELECT numeroTicket,numeroAsiento,precio,numeroVuelo,tipoAsiento,aereopuertoSalida,aereopuertoDestino,paisSalida,paisDestino FROM ticket";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        while (rs.next()){
            Ticket ticket = new Ticket(
                    rs.getString("numeroTicket"),
                    rs.getString("numeroAsiento"),
                    rs.getDouble("precio"),
                    rs.getString("numeroVuelo"),
                    rs.getString("tipoAsiento"),
                    rs.getString("aereopuertoSalida"),
                    rs.getString("aereopuertoDestino"),
                    rs.getString("paisSalida"),
                    rs.getString("paisDestino")
            );
            listaTickets.add(ticket);
        }

        return listaTickets;
    }

    @Override
    public Ticket buscarTicket(String numeroTicket) throws Exception {
        sql = "SELECT numeroTicket,numeroAsiento,precio,numeroVuelo,tipoAsiento,aereopuertoSalida,aereopuertoDestino,paisSalida,paisDestino FROM ticket WHERE numeroTicket ='"+numeroTicket+"';";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        while (rs.next()){
            Ticket ticket = new Ticket(
                    rs.getString("numeroTicket"),
                    rs.getString("numeroAsiento"),
                    rs.getDouble("precio"),
                    rs.getString("numeroVuelo"),
                    rs.getString("tipoAsiento"),
                    rs.getString("aereopuertoSalida"),
                    rs.getString("aereopuertoDestino"),
                    rs.getString("paisSalida"),
                    rs.getString("paisDestino")
            );
            return ticket;
        }
        return null;
    }

    @Override
    public String asociarTicketAereopuertoSalida(Ticket ticket, Aereopuerto aereopuerto) throws Exception {
        sql = "UPDATE ticket SET aereopuertosalida = "+aereopuerto.getCodigo()+" WHERE numeroTicket = '"+ticket.getNumeroTicket()+"';";
        Conector.getConnector().ejecutarSQL(sql);
        return "Se ha agregado el aereopuerto Salida "+ aereopuerto.getNombre() + " al ticket " + ticket.getNumeroTicket();
    }

    @Override
    public String asociarTicketAereopuertoDestino(Ticket ticket, Aereopuerto aereopuerto) throws Exception {
        sql = "UPDATE ticket SET aereopuertodestino = "+aereopuerto.getCodigo()+" WHERE numeroTicket = '"+ticket.getNumeroTicket()+"';";
        Conector.getConnector().ejecutarSQL(sql);
        return "Se ha agregado el aereopuerto Destino "+ aereopuerto.getNombre() + " al ticket " + ticket.getNumeroTicket();
    }

    @Override
    public String asociarTicketPaisSalida(Ticket ticket, Pais pais) throws Exception {
        sql = "UPDATE ticket SET paissalida = "+pais.getCodigo()+" WHERE numeroTicket = '"+ticket.getNumeroTicket()+"';";
        Conector.getConnector().ejecutarSQL(sql);
        return "Se ha agregado el pais de Salida "+ pais.getNombre() + " al ticket " + ticket.getNumeroTicket();
    }

    @Override
    public String asociarTicketPaisDestino(Ticket ticket, Pais pais) throws Exception {
        sql = "UPDATE ticket SET paisdestino = "+pais.getCodigo()+" WHERE numeroTicket = '"+ticket.getNumeroTicket()+"';";
        Conector.getConnector().ejecutarSQL(sql);
        return "Se ha agregado el pais de destino "+ pais.getNombre() + " al ticket " + ticket.getNumeroTicket();

    }
}
