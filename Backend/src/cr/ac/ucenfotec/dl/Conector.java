package cr.ac.ucenfotec.dl;

public class Conector {

    private static AccesoBD connecionBD = null;

    public static AccesoBD getConnector() throws Exception{
        String URL = "jdbc:mysql://localhost/aereopuertobd?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root";
        String password = "HolaMundo123.";

        if (connecionBD == null){
            connecionBD = new AccesoBD(URL,user,password);
        }
        return connecionBD;
    }

}
