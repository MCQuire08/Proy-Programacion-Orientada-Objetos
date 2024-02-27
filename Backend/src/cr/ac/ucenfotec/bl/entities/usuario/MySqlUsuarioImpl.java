package cr.ac.ucenfotec.bl.entities.usuario;

import cr.ac.ucenfotec.dl.Conector;

import javax.swing.*;
import java.sql.BatchUpdateException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlUsuarioImpl implements IUsuarioDAO {

    private String sql;

    public String registrarUsuario(Usuario usuario) throws Exception {
        sql = "INSERT INTO usuario (nombre, apellidos, nacionalidad,correo,direccion,identificacion,edad,contrasena) VALUES ('"+usuario.getNombre()+"','"+usuario.getApellidos()+"','"+usuario.getNacionalidad()+"','"+usuario.getCorreo()+"','"+usuario.getDireccion()+"',"+usuario.getIdentificacion()+","+usuario.getEdad()+",'"+usuario.getContrasena()+"');";
        Conector.getConnector().ejecutarSQL(sql);
        return "El usuario se ha registrado correctamente";
    }

    @Override
    public ArrayList<Usuario> listarUsuarios() throws Exception {
        ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();

        sql = "SELECT nombre,apellidos,nacionalidad,correo,direccion,identificacion,edad,contrasena FROM usuario; ";

        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        while (rs.next()){
            Usuario nuevoUsuario = new Usuario(
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("nacionalidad"),
                    rs.getString("correo"),
                    rs.getString("direccion"),
                    rs.getInt("identificacion"),
                    rs.getInt("edad"),
                    rs.getString("contrasena")
            );
            listaDeUsuarios.add(nuevoUsuario);
        }
        return listaDeUsuarios;
    }

    @Override
    public String modificarUsuario(int identificacion, Usuario usuarioNuevo) throws Exception {
        Usuario usuarioAnterior = buscarUsuario(identificacion);

        if (usuarioAnterior == null){
            return "Este usuario " + identificacion + ", no existe en el sistema";
        }

        //Modificar la identificacion
        sql = "UPDATE usuario SET identificacion = "+usuarioNuevo.getIdentificacion()+" WHERE identificacion = "+identificacion+";";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar el nombre
        sql = "UPDATE usuario SET nombre = '"+usuarioNuevo.getNombre()+"' WHERE identificacion = "+identificacion+" and nombre = '"+usuarioAnterior.getNombre()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar los apellidos
        sql = "UPDATE usuario SET apellidos = '"+usuarioNuevo.getApellidos()+"' WHERE identificacion = "+identificacion+" and apellidos = '"+usuarioAnterior.getApellidos()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar la nacionalidad
        sql = "UPDATE usuario SET nacionalidad = '"+usuarioNuevo.getNacionalidad()+"' WHERE identificacion = "+identificacion+" and nacionalidad = '"+usuarioAnterior.getNacionalidad()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar el correo
        sql = "UPDATE usuario SET correo = '"+usuarioNuevo.getCorreo()+"' WHERE identificacion = "+identificacion+" and correo = '"+usuarioAnterior.getCorreo()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar la direccion
        sql = "UPDATE usuario SET direccion = '"+usuarioNuevo.getDireccion()+"' WHERE identificacion = "+identificacion+" and direccion = '"+usuarioAnterior.getDireccion()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar la edad
        sql = "UPDATE usuario SET edad = "+usuarioNuevo.getEdad()+" WHERE identificacion = "+identificacion+" and edad = "+usuarioAnterior.getEdad()+";";
        Conector.getConnector().ejecutarSQL(sql);

        return "Usuario "+ identificacion + ", modificado!";
    }

    @Override
    public Usuario buscarUsuario(int identificacion) throws Exception {

        sql = "SELECT nombre,apellidos,nacionalidad,correo,direccion,identificacion,edad,contrasena FROM usuario WHERE identificacion = "+identificacion+"; ";

        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        while (rs.next()){
            Usuario nuevoUsuario = new Usuario(
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("nacionalidad"),
                    rs.getString("correo"),
                    rs.getString("direccion"),
                    rs.getInt("identificacion"),
                    rs.getInt("edad"),
                    rs.getString("contrasena")
            );
            return nuevoUsuario;
        }

        return null;
    }

    @Override
    public Boolean validarLogin(int identificacion, String contrasena) throws Exception {
        Usuario usuario = new Usuario();
        try {
           usuario = buscarUsuario(identificacion);
            if (usuario.getContrasena().equals(contrasena)){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }

    }
}
