package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.administrador.Administrador;
import cr.ac.ucenfotec.bl.entities.administrador.IAdministradorDAO;
import cr.ac.ucenfotec.bl.entities.administrador.MySqlAdministradorImpl;
import cr.ac.ucenfotec.bl.entities.usuario.Usuario;

import java.util.ArrayList;


public class AdministradorGestor {

    private IAdministradorDAO datos;

    public AdministradorGestor(){
        datos = new MySqlAdministradorImpl();
    }

    public String registrarAdministrador(String nombre, String apellidos, String nacionalidad, String correo, String direccion, int identificacion, int edad, String genero,String contrasena) throws Exception {
        Administrador nuevoAdministrador = new Administrador(nombre,apellidos,nacionalidad,correo,direccion,identificacion,edad,genero,contrasena);
        return datos.registrarAdministrador(nuevoAdministrador);
    }

    public String modificarAdministrador(int identificacionAnterior,String nombre, String apellidos, String nacionalidad, String correo, String direccion, int identificacion, int edad, String genero,String contrasena) throws Exception {
        Administrador nuevoAdministrador = new Administrador(nombre,apellidos,nacionalidad,correo,direccion,identificacion,edad,genero,contrasena);
        return datos.modificarAdministrador(identificacionAnterior, nuevoAdministrador);
    }

    public boolean login(int identificacion, String contrasena)throws Exception{
        return datos.login(identificacion,contrasena);
    }

    public ArrayList<Administrador> listarAdministrador()throws Exception{
        return datos.listarAdministradores();
    }

    public Administrador buscarAdministrador(int Id) throws Exception{
        return datos.buscarAdministrador(Id);
    }

}
