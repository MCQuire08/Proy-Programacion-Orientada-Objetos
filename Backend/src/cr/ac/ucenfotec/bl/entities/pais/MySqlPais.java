package cr.ac.ucenfotec.bl.entities.pais;

import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlPais implements IPaisDAO{
    private String sql;

    @Override
    public String registrarPais(Pais nuevoPais) throws Exception {
        sql = "INSERT INTO pais (nombre, codigo, abreviatura) VALUES('"+nuevoPais.getNombre()+"','"+nuevoPais.getCodigo()+"','"+nuevoPais.getAbreviatura()+"');";
        Conector.getConnector().ejecutarSQL(sql);
        return "El pais " + nuevoPais.getNombre() + ", fue registrado correctamente";
    }

    @Override
    public String modificarPais(String codigoAnterior, Pais nuevoPais) throws Exception {
        Pais paisAnterior = buscarPais(codigoAnterior);

        if (paisAnterior == null){
            return "Este codigo = '" + codigoAnterior + "', no existe en el sistema...";
        }

        //Modificar el nombre
        sql = "UPDATE pais SET nombre = '"+nuevoPais.getNombre()+"' WHERE codigo = '"+paisAnterior.getCodigo()+"' and nombre = '"+paisAnterior.getNombre()+"' ;";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar el codigo
        sql = "UPDATE pais SET codigo = '"+nuevoPais.getCodigo()+"' WHERE codigo = '"+paisAnterior.getCodigo()+"' ;";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar la abreviatura
        sql = "UPDATE pais SET abreviatura = '"+nuevoPais.getAbreviatura()+"' WHERE codigo = '"+paisAnterior.getCodigo()+"' and abreviatura = '"+paisAnterior.getAbreviatura()+"' ;";
        Conector.getConnector().ejecutarSQL(sql);

        return "El pais "+paisAnterior.getNombre() + " se modifico correctamente!";
    }

    @Override
    public ArrayList<Pais> listarPaises() throws Exception {
        ArrayList<Pais> listaDePaises = new ArrayList<>();
        sql="SELECT CODIGO,NOMBRE,ABREVIATURA FROM pais";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        while (rs.next()){
            Pais nuevoPais = new Pais(
                                        rs.getString("NOMBRE"),
                                        rs.getString("ABREVIATURA"),
                                        rs.getString("CODIGO"));
        listaDePaises.add(nuevoPais);
        }

        return listaDePaises;
    }

    @Override
    public Pais buscarPais(String codigoPais) throws Exception {
        sql = "SELECT nombre,codigo,abreviatura from pais where codigo = '"+codigoPais+"';";

        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        if (rs.next()){
            Pais paisEncontrado = new Pais(rs.getString("NOMBRE"),
                                            rs.getString("ABREVIATURA"),
                                            rs.getString("CODIGO"));
            return paisEncontrado;
        }
        return null;
    }

    @Override
    public String eliminarPais(String codigoPais) throws Exception {
        sql = "DELETE FROM pais WHERE codigo = '"+codigoPais+"';";
        Conector.getConnector().ejecutarSQL(sql);
        return "El pais con el codigo = '"+ codigoPais + "', se elimino correctamente...";
    }
}
