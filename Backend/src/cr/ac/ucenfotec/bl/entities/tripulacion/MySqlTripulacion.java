package cr.ac.ucenfotec.bl.entities.tripulacion;

import cr.ac.ucenfotec.bl.entities.miembro.Miembro;
import cr.ac.ucenfotec.bl.entities.usuario.MySqlUsuarioImpl;
import cr.ac.ucenfotec.bl.entities.usuario.Usuario;
import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlTripulacion implements ITripulacionDAO{
    private String sql;
    @Override
    public String registrarTripulacion(Tripulacion tripulacion) throws Exception {
        sql = "INSERT INTO tripulacion (nombre,codigo) VALUES ('"+tripulacion.getNombre()+"','"+tripulacion.getCodigo()+"');";
        Conector.getConnector().ejecutarSQL(sql);
        return "El usuario se ha registrado correctamente";
    }

    @Override
    public ArrayList<Tripulacion> listarTripulaciones() throws Exception {
        ArrayList<Tripulacion> listaDeTripulaciones = new ArrayList<>();

        sql = "SELECT nombre,codigo FROM tripulacion;";

        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        while (rs.next()){
            Tripulacion tripulacion = new Tripulacion(
                    rs.getString("NOMBRE"),
                    rs.getString("CODIGO")
            );

            sql = "SELECT M.IDENTIFICACION,M.NOMBRE,M.APELLIDOS,M.NACIONALIDAD,M.CORREO,M.DIRECCION,M.GENERO,M.ANOSEXP,M.FECHAGRAD,M.NUMEROLIC,M.PUESTO,M.TELEFONO,M.CONTRASENA " +
                    "FROM miembro M JOIN tripulacion_miembro TM ON M.identificacion = TM.identificacion AND TM.codigo = '"+tripulacion.getCodigo()+"'; ";

            ResultSet rsMiembros = Conector.getConnector().ejecutarQuery(sql);

            while (rsMiembros.next()){
                Miembro miembro = new Miembro(
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("nacionalidad"),
                        rs.getString("correo"),
                        rs.getString("direccion"),
                        rs.getInt("identificacion"),
                        rs.getString("genero"),
                        rs.getInt("anosExp"),
                        rs.getInt("fechaGrad"),
                        rs.getInt("numeroLic"),
                        rs.getString("puesto"),
                        rs.getInt("telefono"),
                        rs.getString("contrasena")
                );
                tripulacion.agregarMiembro(miembro);
            }

            listaDeTripulaciones.add(tripulacion);
        }
        return listaDeTripulaciones;
    }

    @Override
    public String modificarTripulacion(String codigo, Tripulacion tripulacionNueva) throws Exception {
        Tripulacion tripulacionAnterior = buscarTripulacion(codigo);

        if(tripulacionAnterior == null){
            return "Esta tripulacion "+ codigo + "no existe en el sistema..";
        }

        //Modificar la codigo
        sql = "UPDATE tripulacion SET codigo = "+ tripulacionNueva.getCodigo() +" WHERE codigo = '"+codigo+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar el nombre
        sql = "UPDATE tripulacion SET nombre = "+ tripulacionNueva.getNombre() +" WHERE codigo = '"+codigo+"','"+tripulacionAnterior.getNombre()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        return "La tripulacion "+codigo+", ha sido modificada!";
    }

    @Override
    public Tripulacion buscarTripulacion(String codigo) throws Exception {

        sql = "SELECT nombre,codigo FROM tripulacion WHERE codigo ='"+codigo+"';";

        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        while (rs.next()){
            Tripulacion tripulacion = new Tripulacion(
                    rs.getString("CODIGO"),
                    rs.getString("NOMBRE")
            );
            return tripulacion;
        }
        return null;
    }

    public String asociarMiembroATripulacion(Miembro miembro, Tripulacion tripulacion) throws Exception{
        sql = "INSERT INTO tripulacion_miembro (codigo,identificacion) VALUES ('"+tripulacion.getCodigo()+"',"+miembro.getIdentificacion()+");";
        Conector.getConnector().ejecutarSQL(sql);
        return "Se ha agregado el miembro " + miembro.getNombre() + " a la tripulacion " + tripulacion.getNombre() ;
    }
}
