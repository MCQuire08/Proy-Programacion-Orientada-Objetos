package cr.ac.ucenfotec.bl.entities.sala;

import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlSalaImpl implements ISalaDAO{

    private String sql;

    public String registrarSala(Sala sala) throws Exception {
        sql = "INSERT INTO sala (codigo,nombre,ubicacion) VALUES ("+sala.getCodigo()+",'"+sala.getNombre()+"','"+sala.getUbicacion()+"');";
        Conector.getConnector().ejecutarSQL(sql);
        return "La sala "+ sala.getNombre() + " ha sido registrada!";
    }

    @Override
    public String modificarSala(String codigoAnterior, Sala nuevaSala) throws Exception {
        Sala salaAnterior = buscarSala(codigoAnterior);

        if (codigoAnterior == null){
            return "Esta sala "+codigoAnterior+", no existe en el sistema..";
        }

        //Modificar la codigo
        sql = "UPDATE sala SET codigo = '"+nuevaSala.getCodigo()+"' WHERE codigo = '"+salaAnterior.getCodigo()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar la nombre
        sql = "UPDATE sala SET nombre = '"+nuevaSala.getNombre()+"' WHERE codigo = '"+codigoAnterior+"' and nombre = '"+salaAnterior.getNombre()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar la ubicacion
        sql = "UPDATE sala SET ubicacion = '"+nuevaSala.getUbicacion()+"' WHERE codigo = '"+codigoAnterior+"' and ubicacion = '"+salaAnterior.getUbicacion()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        return "La sala "+codigoAnterior+", fue modificada...";
    }

    @Override
    public ArrayList<Sala> listarSalas() throws Exception {
        ArrayList<Sala> listaDeSalas = new ArrayList<>();

        sql = "SELECT nombre,codigo,ubicacion FROM aereopuertobd.sala;";

        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        while (rs.next()){
            Sala nuevaSala = new Sala(
                    rs.getString("nombre"),
                    rs.getString("codigo"),
                    rs.getString("ubicacion")
            );
            listaDeSalas.add(nuevaSala);
        }

        return listaDeSalas;
    }

    @Override
    public Sala buscarSala(String codigo) throws Exception {
        sql = "SELECT nombre,codigo,ubicacion FROM sala WHERE codigo='"+codigo+"';";

        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        while (rs.next()){
            Sala nuevaSala = new Sala(
                    rs.getString("nombre"),
                    rs.getString("codigo"),
                    rs.getString("ubicacion")
            );
            return nuevaSala;
        }

        return null;
    }

    @Override
    public String eliminarSala(String codigo) throws Exception {
        sql = "DELETE FROM sala WHERE codigo ='"+codigo+"';";
        Conector.getConnector().ejecutarSQL(sql);
        return "La sala "+ codigo + ", fue eliminada...";
    }
}
