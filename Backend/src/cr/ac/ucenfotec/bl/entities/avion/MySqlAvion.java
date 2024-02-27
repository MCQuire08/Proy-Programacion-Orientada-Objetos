package cr.ac.ucenfotec.bl.entities.avion;

import cr.ac.ucenfotec.bl.entities.pais.Pais;
import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlAvion implements IAvionDAO {
    private String sql;
    @Override
    public String registrarAvion(Avion nuevoAvion) throws Exception {
        sql = "INSERT INTO avion (placa,marca,modelo,capacidad) VALUES ('"+nuevoAvion.getPlaca()+"','"+nuevoAvion.getMarca()+"','"+nuevoAvion.getModelo()+"',"+nuevoAvion.getCapacidad()+");";
        Conector.getConnector().ejecutarSQL(sql);
        return "El avion "+nuevoAvion.getPlaca()+", fue registrado correctamente!";
    }

    @Override
    public String modificarAvion(String placaAnterior, Avion avionNuevo) throws Exception {
        Avion avionAnterior = buscarAvion(placaAnterior);

        if (placaAnterior == null){
            return "Esta placa = '"+placaAnterior+"', no existe en el sistema..";
        }

        //Modificar la placa
        sql = "UPDATE avion SET placa = '"+avionNuevo.getPlaca()+"' WHERE placa = '"+placaAnterior+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar la marca
        sql = "UPDATE avion SET marca = '"+avionNuevo.getMarca()+"' WHERE placa = '"+placaAnterior+"' and marca = '"+avionAnterior.getMarca()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar el modelo
        sql = "UPDATE avion SET modelo = '"+avionNuevo.getModelo()+"' WHERE placa = '"+placaAnterior+"' and modelo = '"+avionAnterior.getModelo()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar la capacidad
        sql = "UPDATE avion SET capacidad = '"+avionNuevo.getCapacidad()+"' WHERE placa = '"+placaAnterior+"' and capacidad = '"+avionAnterior.getCapacidad()+"';";
        Conector.getConnector().ejecutarSQL(sql);



        return "El avion con la placa= '"+placaAnterior+"', fue modificado!";
    }

    @Override
    public ArrayList<Avion> listarAviones() throws Exception {
        ArrayList<Avion> listaDeAviones = new ArrayList<>();
        sql="SELECT PLACA,MARCA,MODELO,CAPACIDAD FROM avion;";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        while (rs.next()){
            Avion avion = new Avion(
                                    rs.getString("PLACA"),
                                    rs.getString("MARCA"),
                                    rs.getString("MODELO"),
                                    rs.getInt("CAPACIDAD")
            );
            listaDeAviones.add(avion);
        }
        return listaDeAviones;
    }

    @Override
    public Avion buscarAvion(String placaAvion) throws Exception {
        sql = "SELECT placa,marca,modelo,capacidad FROM avion WHERE placa = '"+ placaAvion +"';";

        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        if (rs.next()){
            Avion avionEncontrado = new Avion(
                    rs.getString("PLACA"),
                    rs.getString("MARCA"),
                    rs.getString("MODELO"),
                    rs.getInt("CAPACIDAD")
            );
            return avionEncontrado;
        }
        return null;
    }

    @Override
    public String eliminarAvion(String placaAvion) throws Exception {
        sql = "DELETE FROM avion WHERE placa='"+placaAvion+"';";
        Conector.getConnector().ejecutarSQL(sql);
        return "El avion con la placa = '"+ placaAvion +"', se elimino correctamente!";
    }
}
