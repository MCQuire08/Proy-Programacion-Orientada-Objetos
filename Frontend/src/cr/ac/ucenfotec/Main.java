package cr.ac.ucenfotec;

import cr.ac.ucenfotec.bl.entities.administrador.Administrador;
import cr.ac.ucenfotec.bl.entities.aereopuerto.Aereopuerto;
import cr.ac.ucenfotec.bl.logic.AdministradorGestor;
import cr.ac.ucenfotec.bl.logic.AereopuertoGestor;
import cr.ac.ucenfotec.tl.Pruebas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;

public class Main extends   Application{

    AdministradorGestor administradorGestor = new AdministradorGestor();
    AereopuertoGestor aereopuertoGestor = new AereopuertoGestor();
    public void start(Stage stage) throws Exception {
        if (!validarAereopuertoAdministrador()){
            JOptionPane.showMessageDialog(null,"No existen datos de administrador ni aereopuerto...");
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ui/InicioAdministrador.fxml"));
            stage.setTitle("Registrar Administrador");
            //stage.setScene(new Scene(fxmlLoader.load(), 650, 350));
            stage.setScene(new Scene(fxmlLoader.load(), 650, 350));
            //stage.initStyle(StageStyle.UNDECORATED);
            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
            stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
            stage.show();

        }else {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ui/iniciarSesion.fxml"));
            stage.setTitle("Iniciar Sesion");
            //stage.setScene(new Scene(fxmlLoader.load(), 650, 350));
            stage.setScene(new Scene(fxmlLoader.load(), 650, 350));
            //stage.initStyle(StageStyle.UNDECORATED);
            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
            stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
            stage.show();
        }

    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public boolean validarAereopuertoAdministrador() throws Exception {
        boolean pase1;
        boolean pase2;

        ArrayList<Aereopuerto> listaAereopuertos = aereopuertoGestor.listarAereopuertos();
        ArrayList<Administrador> listaAdministrador = administradorGestor.listarAdministrador();

        if (listaAereopuertos.isEmpty()){
            pase1 = false;
        }else {
            pase1 = true;
        }

        if (listaAdministrador.isEmpty()){
            pase2 = false;
        }else {
            pase2 = true;
        }

        if (pase1 && pase2){
            return true;
        }else {
            return false;
        }
    }
}
