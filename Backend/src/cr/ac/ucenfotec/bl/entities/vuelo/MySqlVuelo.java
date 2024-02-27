package cr.ac.ucenfotec.bl.entities.vuelo;

import cr.ac.ucenfotec.bl.entities.aereopuerto.Aereopuerto;
import cr.ac.ucenfotec.bl.entities.avion.Avion;
import cr.ac.ucenfotec.bl.entities.lineaAerea.LineaAerea;
import cr.ac.ucenfotec.bl.entities.pais.Pais;
import cr.ac.ucenfotec.bl.entities.sala.Sala;
import cr.ac.ucenfotec.bl.entities.tripulacion.Tripulacion;
import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlVuelo implements IVueloDAO{
    private String sql;

    @Override
    public String registrarVuelo(Vuelo vuelo) throws Exception {
        sql = "INSERT INTO vuelo (numeroVuelo,horaLlegada,horaSalida,estado) VALUES ('"+vuelo.getNumeroVuelo()+"',"+vuelo.getHoraLlegada()+","+vuelo.getHoraSalida()+",'"+vuelo.getEstado()+"');";
        Conector.getConnector().ejecutarSQL(sql);
        return "El vuelo "+vuelo.getNumeroVuelo()+", fue registrado correctamente!";
    }

    @Override
    public String modificarVuelo(String numeroVuelo, Vuelo vuelo) throws Exception {
        Vuelo vueloAnterior = buscarVuelo(numeroVuelo);

        if (vueloAnterior == null){
            return "Este vuelo "+ numeroVuelo + ", no existe en el sistema";
        }

        //Modificar el numero de vuelo
        sql = "UPDATE vuelo SET numeroVuelo = '"+vuelo.getNumeroVuelo()+"' WHERE numeroVuelo = '"+numeroVuelo+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar la hora llegada
        sql = "UPDATE vuelo SET horaLlegada = "+vuelo.getHoraLlegada()+" WHERE numeroVuelo = '"+numeroVuelo+"' and horaLlegada = "+vueloAnterior.getHoraLlegada()+";";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar la hora salida
        sql = "UPDATE vuelo SET horaSalida = "+vuelo.getHoraSalida()+" WHERE numeroVuelo = '"+numeroVuelo+"' and horaSalida = "+vueloAnterior.getHoraSalida()+";";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar el estado
        sql = "UPDATE vuelo SET estado = "+vuelo.getEstado()+" WHERE numeroVuelo = '"+numeroVuelo+"' and estado = "+vueloAnterior.getEstado()+";";
        Conector.getConnector().ejecutarSQL(sql);

        return "El vuelo " + numeroVuelo + ", fue modificado!";
    }


    @Override
    public ArrayList<Vuelo> listarVuelos() throws Exception {
        ArrayList<Vuelo> listaDeVuelos = new ArrayList<>();

        sql = "SELECT v.numeroVuelo,v.horallegada,v.horasalida,v.estado,vr.numeroVuelo,vr.lineaaerea,vr.aereopuertoSalida,vr.aereopuertoDestino,vr.avion,vr.salasalida,vr.saladestino,vr.paissalida,vr.paisllegada,vr.tripulacion \n" +
                "from vuelo v JOIN vuelo_relacion vr ON v.numeroVuelo = vr.numeroVuelo;";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        while (rs.next()){
            Vuelo vuelo = new Vuelo(
                    rs.getString("NUMEROVUELO"),
                    rs.getInt("HORALLEGADA"),
                    rs.getInt("HORASALIDA"),
                    rs.getString("ESTADO"),
                    rs.getString("LINEAAEREA"),
                    rs.getString("AEREOPUERTOSALIDA"),
                    rs.getString("AEREOPUERTODESTINO"),
                    rs.getString("AVION"),
                    rs.getString("SALASALIDA"),
                    rs.getString("SALADESTINO"),
                    rs.getString("TRIPULACION"),
                    rs.getString("PAISSALIDA"),
                    rs.getString("PAISLLEGADA")
            );
            listaDeVuelos.add(vuelo);
        }
        return listaDeVuelos;
    }

    public String validarVuelosRelacion(String numeroVuelo) throws Exception{
        sql = "SELECT numeroVuelo FROM vuelo_relacion WHERE numeroVuelo = '"+numeroVuelo+"';";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        if (rs.next()){
            return rs.getString("numeroVuelo");
        }
        return null;
    }



    @Override
    public Vuelo buscarVuelo(String numeroVuelo) throws Exception {
        sql = "SELECT numeroVuelo,horaLlegada,horaSalida,estado FROM vuelo WHERE numeroVuelo = '"+numeroVuelo+"';";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        if (rs.next()){
            Vuelo vuelo = new Vuelo(
                    rs.getString("NUMEROVUELO"),
                    rs.getInt("HORALLEGADA"),
                    rs.getInt("HORASALIDA"),
                    rs.getString("ESTADO")
            );
            return vuelo;
        }
        return null;
    }

    @Override
    public String eliminarVuelo(String numeroVuelo) throws Exception {
        sql = "DELETE FROM vuelo WHERE numeroVuelo='"+numeroVuelo+"';";
        Conector.getConnector().ejecutarSQL(sql);
        return "El vuelo "+ numeroVuelo +"', se elimino correctamente!";
    }

    @Override
    public String crearVueloAvanzado(Vuelo vuelo) throws Exception {
        sql = "INSERT INTO vuelo_relacion (numeroVuelo) VALUES ('"+vuelo.getNumeroVuelo()+"')";
        Conector.getConnector().ejecutarSQL(sql);
        return "Se ha creado el vuelo" + vuelo.getNumeroVuelo();
    }

    @Override
    public String asociarLineaAerea(LineaAerea lineaAerea, Vuelo vuelo) throws Exception {
        sql = "UPDATE vuelo_relacion SET lineaaerea = '"+lineaAerea.getCedulaJuridica()+"' WHERE numeroVuelo = '"+vuelo.getNumeroVuelo()+"';";
        Conector.getConnector().ejecutarSQL(sql);
        return "Se ha agregado al vuelo "+ vuelo.getNumeroVuelo() + " la linea aerea " + lineaAerea.getNombre();
    }

    @Override
    public String asociarAereopuertoSalida(Aereopuerto aereopuerto, Vuelo vuelo) throws Exception {
        sql = "UPDATE vuelo_relacion SET aereopuertosalida = '"+aereopuerto.getCodigo()+"' WHERE numeroVuelo = '"+vuelo.getNumeroVuelo()+"' ;";
        Conector.getConnector().ejecutarSQL(sql);
        return "Se ha agregado al vuelo "+ vuelo.getNumeroVuelo() + " el aereopuerto de salida " + aereopuerto.getNombre();
    }

    @Override
    public String asociarAereopuertoDestino(Aereopuerto aereopuerto, Vuelo vuelo) throws Exception {
        sql = "UPDATE vuelo_relacion SET aereopuertodestino = '"+aereopuerto.getCodigo()+"' WHERE numeroVuelo = '"+vuelo.getNumeroVuelo()+"' ;";
        Conector.getConnector().ejecutarSQL(sql);
        return "Se ha agregado al vuelo "+ vuelo.getNumeroVuelo() + " el aereopuerto destino " + aereopuerto.getNombre();
    }

    @Override
    public String asociarAvion(Avion avion, Vuelo vuelo) throws Exception {
        sql = "UPDATE vuelo_relacion SET avion = '"+avion.getPlaca()+"' WHERE numeroVuelo = '"+vuelo.getNumeroVuelo()+"' ;";
        Conector.getConnector().ejecutarSQL(sql);
        return "Se ha agregado al vuelo "+ vuelo.getNumeroVuelo() + " el avion " + avion.getPlaca();
    }

    @Override
    public String asociarSalaSalida(Sala sala, Vuelo vuelo) throws Exception {
        sql = "UPDATE vuelo_relacion SET salasalida = '"+sala.getCodigo()+"' WHERE numeroVuelo = '"+vuelo.getNumeroVuelo()+"' ;";
        Conector.getConnector().ejecutarSQL(sql);
        return "Se ha agregado al vuelo "+ vuelo.getNumeroVuelo() + " la sala de salida " + sala.getNombre();
    }

    @Override
    public String asociarSalaDestino(Sala sala, Vuelo vuelo) throws Exception {
        sql = "UPDATE vuelo_relacion SET saladestino = '"+sala.getCodigo()+"' WHERE numeroVuelo = '"+vuelo.getNumeroVuelo()+"' ;";
        Conector.getConnector().ejecutarSQL(sql);
        return "Se ha agregado al vuelo "+ vuelo.getNumeroVuelo() + " la sala destino " + sala.getNombre();
    }

    @Override
    public String asociarPaisSalida(Pais pais, Vuelo vuelo) throws Exception {
        sql = "UPDATE vuelo_relacion SET paissalida = '"+pais.getCodigo()+"' WHERE numeroVuelo = '"+vuelo.getNumeroVuelo()+"' ;";
        Conector.getConnector().ejecutarSQL(sql);
        return "Se ha agregado al vuelo "+ vuelo.getNumeroVuelo() + " el pais de salida " + pais.getNombre();
    }

    @Override
    public String asociarPaisDestino(Pais pais, Vuelo vuelo) throws Exception {
        sql = "UPDATE vuelo_relacion SET paisllegada = '"+pais.getCodigo()+"' WHERE numeroVuelo = '"+vuelo.getNumeroVuelo()+"' ;";
        Conector.getConnector().ejecutarSQL(sql);
        return "Se ha agregado al vuelo "+ vuelo.getNumeroVuelo() + " el pais destino " + pais.getNombre();
    }

    @Override
    public String asociarTripulacion(Tripulacion tripulacion, Vuelo vuelo) throws Exception {
        sql = "UPDATE vuelo_relacion SET tripulacion = '"+tripulacion.getCodigo()+"' WHERE numeroVuelo = '"+vuelo.getNumeroVuelo()+"' ;";
        Conector.getConnector().ejecutarSQL(sql);
        return "Se ha agregado al vuelo "+ vuelo.getNumeroVuelo() + " la tripulacion " + tripulacion.getNombre();
    }
}
