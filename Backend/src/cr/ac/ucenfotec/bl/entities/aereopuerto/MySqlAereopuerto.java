package cr.ac.ucenfotec.bl.entities.aereopuerto;

import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlAereopuerto implements IAereopuertoDAO{

    private String sql;
    @Override
    public String registrarAereopuerto(Aereopuerto aereopuerto) throws Exception {
        sql = sql="INSERT INTO aereopuerto (nombre,codigo) VALUES ('"+aereopuerto.getNombre()+"','"+aereopuerto.getCodigo()+"');";
        Conector.getConnector().ejecutarSQL(sql);
        return "El aereopuerto "+aereopuerto.getNombre()+", fue registrado correctamente!";
    }

    @Override
    public String modificarAvion(String codigoAnterior, Aereopuerto aereopuerto) throws Exception {
        Aereopuerto aereopuertoAnterior = buscarAereopuerto(codigoAnterior);

        if (aereopuertoAnterior==null){
            return "Este codigo "+codigoAnterior+", no existe en el sistema";
        }

        //Modificar el codigo
        sql = "UPDATE aereopuerto SET codigo = '"+aereopuerto.getCodigo()+"' WHERE codigo = '"+aereopuerto.getCodigo()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar el nombre
        sql = "UPDATE aereopuerto SET nombre = '"+aereopuerto.getNombre()+"' WHERE codigo = '"+aereopuertoAnterior.getCodigo()+"' and nombre = '"+aereopuertoAnterior.getNombre()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        return "El aereopuerto con el codigo = '"+codigoAnterior+"', fue modificado...";
    }

    @Override
    public ArrayList<Aereopuerto> listarAereopuertos() throws Exception {
        ArrayList<Aereopuerto> listaAereopuertos = new ArrayList<>();
        sql = "SELECT nombre,codigo FROM aereopuerto";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        while (rs.next()){
            Aereopuerto aereopuerto = new Aereopuerto(
                                            rs.getString("NOMBRE"),
                                            rs.getString("CODIGO")
            );
            listaAereopuertos.add(aereopuerto);
        }
        return listaAereopuertos;
    }

    @Override
    public Aereopuerto buscarAereopuerto(String codigo) throws Exception {
        sql = "SELECT nombre,codigo FROM aereopuerto WHERE codigo = '"+codigo+"';";

        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        if (rs.next()){
            Aereopuerto aereopuerto = new Aereopuerto(
                    rs.getString("NOMBRE"),
                    rs.getString("CODIGO")
            );
            return aereopuerto;
        }
        return null;
    }

    @Override
    public String eliminarAereopuerto(String codigo) throws Exception {
        sql = "DELETE FROM aereopuerto WHERE codigo = '"+ codigo + "';";
        Conector.getConnector().ejecutarSQL(sql);
        return "El aereopuerto con el codigo = '"+ codigo + "', se elimino correctamente...";
    }
}
