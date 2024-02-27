package cr.ac.ucenfotec.bl.entities.miembro;


import java.util.ArrayList;

public interface IMiembroDAO {
    public String registrarMiembro(Miembro miembro) throws Exception;
    public ArrayList<Miembro> listarMiembros() throws Exception;
    public String modificarMiembro(int identificacionAnterior, Miembro miembro) throws Exception;
    public Miembro buscarMiembro(int identificacion) throws Exception;
    public boolean login(int identificacion,String contrasena)throws Exception;
}
