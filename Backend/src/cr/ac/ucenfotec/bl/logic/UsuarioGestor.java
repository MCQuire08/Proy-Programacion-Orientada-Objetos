package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.sala.Sala;
import cr.ac.ucenfotec.bl.entities.usuario.IUsuarioDAO;
import cr.ac.ucenfotec.bl.entities.usuario.MySqlUsuarioImpl;
import cr.ac.ucenfotec.bl.entities.usuario.Usuario;
import cr.ac.ucenfotec.dl.Conector;

import java.util.ArrayList;

public class UsuarioGestor {


    private IUsuarioDAO datos;

    public UsuarioGestor(){
        datos = new MySqlUsuarioImpl();
    }

    //Registro de usuarios
    public String registrarUsuario(String nombre, String apellidos, String nacionalidad, String correo, String direccion, int identificacion, int edad,String contrasena) throws Exception {
        Usuario usuario = new Usuario(nombre,apellidos,nacionalidad,correo,direccion,identificacion,edad,contrasena);
        return datos.registrarUsuario(usuario);
    }

    public ArrayList<Usuario> listarUsuario()throws Exception{
        return datos.listarUsuarios();
    }

    public Usuario buscarUsuario(int identificacion)throws Exception{
        return datos.buscarUsuario(identificacion);
    }

    public String modificarUsuario(int identificacionAnterior,int identificacion, String nombre, String apellidos, String nacionalidad, String corrreo, String direccion, int edad,String contrasena) throws Exception{
        Usuario usuario = new Usuario(nombre,apellidos,nacionalidad,corrreo,direccion,identificacion,edad,contrasena);
        return datos.modificarUsuario(identificacionAnterior,usuario);
    }

    public boolean login(int identificacion, String contrasena) throws Exception {
        return datos.validarLogin(identificacion,contrasena);
    }

    public boolean validarContrasena(String contrasena){
        // Mas de 8 caracteres
        // Tiene al menos una letra masyucula
        // Tiene un numero

        boolean mayuscula=false;
        boolean numero=false;
        char c ;


        if (contrasena.length() > 8){
            for (int i = 0 ; i < contrasena.length(); i++){
                c = contrasena.charAt(i);
                if (Character.isDigit(c)){
                    numero=true;
                }else {
                    numero=false;
                }
                if (Character.isUpperCase(c)){
                    mayuscula=true;
                }else {
                    mayuscula=false;
                }
            }

            if (numero && mayuscula){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }


}
