package cr.ac.ucenfotec.bl.entities.usuario;

import java.util.ArrayList;

public interface IUsuarioDAO {
    public String registrarUsuario(Usuario usuario)throws Exception;
    public ArrayList<Usuario> listarUsuarios()throws Exception;
    public String modificarUsuario(int identificacion, Usuario usuarioNuevo)throws Exception;
    public Usuario buscarUsuario(int identificacion)throws Exception;
    public Boolean validarLogin(int identificacion, String contrasena)throws Exception;
}
