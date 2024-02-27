package cr.ac.ucenfotec.bl.entities.administrador;

import cr.ac.ucenfotec.bl.entities.usuario.Usuario;
import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlAdministradorImpl implements IAdministradorDAO{

    private String sql;

    public String registrarAdministrador(Administrador administrador)throws Exception{
        sql = "INSERT INTO administrador (nombre, apellidos, nacionalidad,correo,direccion,identificacion,edad,genero,contrasena) VALUES ('"+administrador.getNombre()+"','"+administrador.getApellidos()+"','"+administrador.getNacionalidad()+"','"+administrador.getCorreo()+"','"+administrador.getDireccion()+"',"+administrador.getIdentificacion()+","+administrador.getEdad()+",'"+administrador.getGenero()+"','"+administrador.getContrasena()+"');";

        Conector.getConnector().ejecutarSQL(sql);
        return "El administrador " + administrador.getNombre() + ", fue registrado exitosamente!";
    }

    @Override
    public String modificarAdministrador(int identificacionAnterior, Administrador nuevoAdministrador) throws Exception {
        Administrador anteriorAdministrador = buscarAdministrador(identificacionAnterior);

        if (anteriorAdministrador == null){
            return "Este administrador " + identificacionAnterior + ", no existe en el sistema";
        }

        //Modificar la identificacion
        sql = "UPDATE administrador SET identificacion = "+nuevoAdministrador.getIdentificacion()+" WHERE identificacion = "+identificacionAnterior+";";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar el nombre
        sql = "UPDATE administrador SET nombre = '"+nuevoAdministrador.getNombre()+"' WHERE identificacion = "+identificacionAnterior+" and nombre = '"+anteriorAdministrador.getNombre()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar los apellidos
        sql = "UPDATE administrador SET apellidos = '"+nuevoAdministrador.getApellidos()+"' WHERE identificacion = "+identificacionAnterior+" and apellidos = '"+anteriorAdministrador.getApellidos()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar la nacionalidad
        sql = "UPDATE administrador SET nacionalidad = '"+nuevoAdministrador.getNacionalidad()+"' WHERE identificacion = "+identificacionAnterior+" and nacionalidad = '"+anteriorAdministrador.getNacionalidad()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar el correo
        sql = "UPDATE administrador SET correo = '"+nuevoAdministrador.getCorreo()+"' WHERE identificacion = "+identificacionAnterior+" and correo = '"+anteriorAdministrador.getCorreo()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar la direccion
        sql = "UPDATE administrador SET direccion = '"+nuevoAdministrador.getDireccion()+"' WHERE identificacion = "+identificacionAnterior+" and direccion = '"+anteriorAdministrador.getDireccion()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar la edad
        sql = "UPDATE administrador SET edad = '"+nuevoAdministrador.getEdad()+"' WHERE identificacion = "+identificacionAnterior+" and edad = "+anteriorAdministrador.getEdad()+";";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar el genero
        sql = "UPDATE administrador SET genero = '"+nuevoAdministrador.getGenero()+"' WHERE identificacion = "+identificacionAnterior+" and genero = '"+anteriorAdministrador.getGenero()+"';";
        Conector.getConnector().ejecutarSQL(sql);



        return "Administrador " + identificacionAnterior + "modificado!";
    }

    @Override
    public Administrador buscarAdministrador(int identificacion) throws Exception {
        sql = "SELECT NOMBRE,APELLIDOS,NACIONALIDAD,CORREO,DIRECCION,IDENTIFICACION,EDAD,GENERO,CONTRASENA FROM administrador WHERE identificacion = "+ identificacion + ";" ;
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        while(rs.next()){
            Administrador administrador = new Administrador(
                    rs.getString("NOMBRE"),
                    rs.getString("APELLIDOS"),
                    rs.getString("NACIONALIDAD"),
                    rs.getString("CORREO"),
                    rs.getString("DIRECCION"),
                    rs.getInt("IDENTIFICACION"),
                    rs.getInt("EDAD"),
                    rs.getString("GENERO"),
                    rs.getString("CONTRASENA")
            );
            return administrador;
        }
        return null;
    }

    @Override
    public boolean login(int identificacion, String contrasena) throws Exception {
        Administrador administrador = new Administrador();
        try {
            administrador = buscarAdministrador(identificacion);
            if (administrador.getContrasena().equals(contrasena)){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public ArrayList<Administrador> listarAdministradores() throws Exception {
        ArrayList<Administrador> listaDeAdministradores = new ArrayList<>();

        sql = "SELECT NOMBRE,APELLIDOS,NACIONALIDAD,CORREO,DIRECCION,IDENTIFICACION,EDAD,GENERO,CONTRASENA FROM administrador ";

        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        while (rs.next()){
            Administrador nuevoAdministrador = new Administrador(
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("nacionalidad"),
                    rs.getString("correo"),
                    rs.getString("direccion"),
                    rs.getInt("identificacion"),
                    rs.getInt("edad"),
                    rs.getString("genero"),
                    rs.getString("contrasena")
            );
            listaDeAdministradores.add(nuevoAdministrador);
        }
        return listaDeAdministradores;
    }
}
