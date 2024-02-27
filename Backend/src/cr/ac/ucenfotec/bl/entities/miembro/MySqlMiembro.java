package cr.ac.ucenfotec.bl.entities.miembro;

import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlMiembro implements IMiembroDAO{
    private String sql;

    @Override
    public String registrarMiembro(Miembro miembro) throws Exception {
        sql = "INSERT INTO miembro (identificacion,nombre, apellidos, nacionalidad,correo,direccion,genero,anosExp,fechaGrad,numeroLic,puesto,telefono,contrasena) VALUES " +
                "("+miembro.getIdentificacion()+",'"+miembro.getNombre()+"','"+miembro.getApellidos()+"','"+miembro.getNacionalidad()+"','"+miembro.getCorreo()+"','"+miembro.getDireccion()+"','"+miembro.getGenero()+
                "',"+miembro.getAnosExp()+","+miembro.getFechaGrad()+","+miembro.getNumeroLic()+",'"+miembro.getPuesto()+"',"+miembro.getTelefono()+",'"+miembro.getContrasena()+"');";
        Conector.getConnector().ejecutarSQL(sql);
        return "El miembro se ha registrado correctamente";
    }

    @Override
    public ArrayList<Miembro> listarMiembros() throws Exception {
        ArrayList<Miembro> listaDeMiembros = new ArrayList<>();
        sql = "SELECT identificacion,nombre, apellidos, nacionalidad,correo,direccion,genero,anosExp,fechaGrad,numeroLic,puesto,telefono,contrasena FROM miembro;";

        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        while(rs.next()){
            Miembro miembro = new Miembro(
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("nacionalidad"),
                    rs.getString("correo"),
                    rs.getString("direccion"),
                    rs.getInt("identificacion"),
                    rs.getString("genero"),
                    rs.getInt("anosExp"),
                    rs.getInt("fechaGrad"),
                    rs.getInt("numeroLic"),
                    rs.getString("puesto"),
                    rs.getInt("telefono"),
                    rs.getString("contrasena")
            );
            listaDeMiembros.add(miembro);
        }
        return listaDeMiembros;
    }

    @Override
    public String modificarMiembro(int identificacionAnterior, Miembro miembroNuevo) throws Exception {
        Miembro miembroAnterior = buscarMiembro(identificacionAnterior);

        if (miembroAnterior == null){
            return "Este miembro " + identificacionAnterior + ", no existe en el sistema...";
        }

        //Modificar la identificacion
        sql = "UPDATE miembro SET identificacion = "+miembroNuevo.getIdentificacion()+" WHERE identificacion = "+identificacionAnterior+";";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar el nombre
        sql = "UPDATE miembro SET nombre = '"+miembroNuevo.getNombre()+"' WHERE identificacion = "+identificacionAnterior+" and nombre = '"+miembroAnterior.getNombre()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar los apellidos
        sql = "UPDATE miembro SET apellidos = '"+miembroNuevo.getApellidos()+"' WHERE identificacion = "+identificacionAnterior+" and apellidos = '"+miembroAnterior.getApellidos()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar la nacionalidad
        sql = "UPDATE miembro SET nacionalidad = '"+miembroNuevo.getNacionalidad()+"' WHERE identificacion = "+identificacionAnterior+" and nacionalidad = '"+miembroAnterior.getNacionalidad()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar la correo
        sql = "UPDATE miembro SET correo = '"+miembroNuevo.getCorreo()+"' WHERE identificacion = "+identificacionAnterior+" and correo = '"+miembroAnterior.getCorreo()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar la direccion
        sql = "UPDATE miembro SET direccion = '"+miembroNuevo.getDireccion()+"' WHERE identificacion = "+identificacionAnterior+" and direccion = '"+miembroAnterior.getDireccion()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar el genero
        sql = "UPDATE miembro SET genero = '"+miembroNuevo.getGenero()+"' WHERE identificacion = "+identificacionAnterior+" and genero = '"+miembroAnterior.getGenero()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar los anos Experiencia
        sql = "UPDATE miembro SET anosExp = "+miembroNuevo.getAnosExp()+" WHERE identificacion = "+identificacionAnterior+" and anosExp = "+miembroAnterior.getAnosExp()+";";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar la fecha de graduacion
        sql = "UPDATE miembro SET fechaGrad = "+miembroNuevo.getFechaGrad()+" WHERE identificacion = "+identificacionAnterior+" and fechaGrad = "+miembroAnterior.getFechaGrad()+";";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar el numero de liciencia
        sql = "UPDATE miembro SET numeroLic = "+miembroNuevo.getNumeroLic()+" WHERE identificacion = "+identificacionAnterior+" and numeroLic = "+miembroAnterior.getNumeroLic()+";";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar el puesto
        sql = "UPDATE miembro SET puesto = "+miembroNuevo.getPuesto()+" WHERE identificacion = "+identificacionAnterior+" and puesto = '"+miembroAnterior.getPuesto()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar el telefono
        sql = "UPDATE miembro SET telefono = "+miembroNuevo.getTelefono()+" WHERE identificacion = "+identificacionAnterior+" and telefono = "+miembroAnterior.getTelefono()+";";
        Conector.getConnector().ejecutarSQL(sql);

        //Modificar la contrasena
        sql = "UPDATE miembro SET contrasena = '"+miembroNuevo.getContrasena()+"' WHERE identificacion = "+identificacionAnterior+" and contrasena = '"+miembroAnterior.getContrasena()+"';";
        Conector.getConnector().ejecutarSQL(sql);

        return "Miembro " + identificacionAnterior + ", fue modificado!";
    }

    @Override
    public Miembro buscarMiembro(int identificacion) throws Exception {
        sql = "SELECT identificacion,nombre, apellidos, nacionalidad,correo,direccion,genero,anosExp,fechaGrad,numeroLic,puesto,telefono,contrasena FROM miembro WHERE identificacion ="+identificacion+";";

        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        while(rs.next()){
            Miembro miembro = new Miembro(
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("nacionalidad"),
                    rs.getString("correo"),
                    rs.getString("direccion"),
                    rs.getInt("identificacion"),
                    rs.getString("genero"),
                    rs.getInt("anosExp"),
                    rs.getInt("fechaGrad"),
                    rs.getInt("numeroLic"),
                    rs.getString("puesto"),
                    rs.getInt("telefono"),
                    rs.getString("contrasena")
            );
            return miembro;
        }
        return null;
    }

    @Override
    public boolean login(int identificacion, String contrasena) throws Exception {
        Miembro miembro = new Miembro();
        try {
            miembro = buscarMiembro(identificacion);
            if (miembro.getContrasena().equals(contrasena)){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
}
