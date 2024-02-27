package cr.ac.ucenfotec.bl.entities.administrador;

import cr.ac.ucenfotec.bl.entities.administrador.Administrador;

import java.util.ArrayList;

public interface IAdministradorDAO {
    public String registrarAdministrador(Administrador nuevoAdministrador)throws Exception;
    public String modificarAdministrador(int identificacionAnterior, Administrador nuevoAdministrador)throws Exception;
    public boolean login(int identificacion,String contrasena)throws Exception;
    public Administrador buscarAdministrador(int identificacion) throws Exception;
    public ArrayList<Administrador> listarAdministradores()throws Exception;

}
