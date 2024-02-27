package cr.ac.ucenfotec.bl.entities.lineaAerea;

import cr.ac.ucenfotec.bl.entities.aereopuerto.Aereopuerto;
import cr.ac.ucenfotec.dl.Conector;

import javax.sound.sampled.Line;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlLineaAereaImpl implements ILineaAereaDAO{
    private String sql;

    @Override
    public String registrarLineaAerea(LineaAerea lineaAerea) throws Exception {
        sql="INSERT INTO linea_aerea (nombre,cedulaJuridica,nombreEmpresa,logo) VALUES ('"+lineaAerea.getNombre()+"','"+lineaAerea.getCedulaJuridica()+"','"+lineaAerea.getNombreEmpresa()+"','"+lineaAerea.getLogo()+"');";
        Conector.getConnector().ejecutarSQL(sql);
        return "La linea aerea "+lineaAerea.getNombre()+", fue registrado correctamente!";
    }

    @Override
    public String modificarLineaAerea(String cedulaJuridica, LineaAerea lineaAereaNueva) throws Exception {
        LineaAerea lineaAereaAnterior = buscarLineaAerea(cedulaJuridica);

        if (lineaAereaAnterior==null){
            return "Esta cedula juridica "+cedulaJuridica+", no existe en el sistema";
        }

        //Modificar la cedulaJuridica
        sql = "UPDATE linea_aerea SET cedulaJuridica = '"+lineaAereaNueva.getCedulaJuridica()+"' WHERE cedulaJuridica = '"+lineaAereaAnterior.getCedulaJuridica()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar el nombre
        sql = "UPDATE linea_aerea SET nombre = '"+lineaAereaNueva.getNombre()+"' WHERE cedulaJuridica = '"+lineaAereaAnterior.getCedulaJuridica()+"' and nombre = '"+lineaAereaAnterior.getNombre()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar el nombre de empresa
        sql = "UPDATE linea_aerea SET nombreEmpresa = '"+lineaAereaNueva.getNombreEmpresa()+"' WHERE cedulaJuridica = '"+lineaAereaAnterior.getCedulaJuridica()+"' and nombreEmpresa = '"+lineaAereaAnterior.getNombreEmpresa()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar el logo
        sql = "UPDATE linea_aerea SET logo = '"+lineaAereaNueva.getLogo()+"' WHERE cedulaJuridica = '"+lineaAereaAnterior.getCedulaJuridica()+"' and logo = '"+lineaAereaAnterior.getLogo()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        return "La linea aerea con la cedula = '"+cedulaJuridica+"', fue modificado...";
    }

    @Override
    public ArrayList<LineaAerea> listarLineaAerea() throws Exception {
        ArrayList<LineaAerea> listaLineasAereas = new ArrayList<>();
        sql = "SELECT * FROM aereopuertobd.linea_aerea";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        while (rs.next()){
            LineaAerea lineaAerea = new LineaAerea(
                    rs.getString("NOMBRE"),
                    rs.getString("CEDULAJURIDICA"),
                    rs.getString("NOMBREEMPRESA"),
                    rs.getString("LOGO")
            );
            listaLineasAereas.add(lineaAerea);
        }
        return listaLineasAereas;
    }

    @Override
    public LineaAerea buscarLineaAerea(String cedulaJuridica) throws Exception {
        sql = "SELECT * FROM aereopuertobd.linea_aerea WHERE cedulaJuridica ='"+cedulaJuridica+"';";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        while (rs.next()){
            LineaAerea lineaAerea = new LineaAerea(
                    rs.getString("NOMBRE"),
                    rs.getString("CEDULAJURIDICA"),
                    rs.getString("NOMBREEMPRESA"),
                    rs.getString("LOGO")
            );
            return lineaAerea;
        }
        return null;
    }

    @Override
    public String eliminarLineaAerea(String cedulaJuridica) throws Exception {
        sql = "DELETE FROM linea_aerea WHERE cedulaJuridica = '"+ cedulaJuridica + "';";
        Conector.getConnector().ejecutarSQL(sql);
        return "La linea aerea con la cedula = '"+ cedulaJuridica + "', se elimino correctamente...";
    }
}
