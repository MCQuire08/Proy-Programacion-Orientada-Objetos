package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.miembro.IMiembroDAO;
import cr.ac.ucenfotec.bl.entities.miembro.Miembro;
import cr.ac.ucenfotec.bl.entities.miembro.MySqlMiembro;

import java.util.ArrayList;

public class MiembroGestor {
    private IMiembroDAO datosMiembros;

    public MiembroGestor(){
        datosMiembros = new MySqlMiembro();
    }

    public String registrarMiembro(String nombre, String apellidos, String nacionalidad, String correo, String direccion, int identificacion, String genero, int anosExp, int fechaGrad, int numeroLic, String puesto, int telefono, String contrasena) throws Exception{
        Miembro miembro = new Miembro(nombre,apellidos,nacionalidad,correo,direccion,identificacion,genero,anosExp,fechaGrad,numeroLic,puesto,telefono,contrasena);
        return datosMiembros.registrarMiembro(miembro);
    }

    //Listar
    public ArrayList<Miembro> listarMiembros() throws Exception {
        ArrayList<Miembro> listaDeMiembros = datosMiembros.listarMiembros();
        return listaDeMiembros;
    }

    public String modificarMiembro(int identificacionAnterior,String nombre, String apellidos, String nacionalidad, String correo, String direccion, int identificacion, String genero, int anosExp, int fechaGrad, int numeroLic, String puesto, int telefono, String contrasena) throws Exception{
        Miembro miembroVerificacion = new Miembro(nombre,apellidos,nacionalidad,correo,direccion,identificacion,genero,anosExp,fechaGrad,numeroLic,puesto,telefono,contrasena);
        return datosMiembros.modificarMiembro(identificacionAnterior,miembroVerificacion);
    }

    public Miembro buscarMiembro(int identificacion) throws Exception{
        return datosMiembros.buscarMiembro(identificacion);
    }

    public boolean login(int identificacion, String contrasena)throws Exception{
        return datosMiembros.login(identificacion,contrasena);
    }
}
