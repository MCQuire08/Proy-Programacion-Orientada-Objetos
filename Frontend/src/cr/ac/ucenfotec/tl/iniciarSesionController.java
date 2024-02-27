package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.entities.administrador.Administrador;
import cr.ac.ucenfotec.bl.entities.aereopuerto.Aereopuerto;
import cr.ac.ucenfotec.bl.entities.miembro.Miembro;
import cr.ac.ucenfotec.bl.entities.usuario.Usuario;
import cr.ac.ucenfotec.bl.logic.AdministradorGestor;
import cr.ac.ucenfotec.bl.logic.AereopuertoGestor;
import cr.ac.ucenfotec.bl.logic.MiembroGestor;
import cr.ac.ucenfotec.bl.logic.UsuarioGestor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class iniciarSesionController implements Initializable {

    @FXML
    private Button btnAcceder;
    @FXML
    private TextField txtIdentificacion;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnAccederAdmin;
    @FXML
    private Button btnAccederMiembro;
    @FXML
    private Label lblTitle;
    @FXML
    private Hyperlink linkAdmin;
    @FXML
    private Hyperlink linkUsuario;

    public static int IdSesion;

    //Gestor
    MiembroGestor miembroGestor = new MiembroGestor();
    UsuarioGestor usuarioGestor = new UsuarioGestor();
    AereopuertoGestor aereopuertoGestor = new AereopuertoGestor();
    AdministradorGestor administradorGestor = new AdministradorGestor();
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public int usuarioSesion(){
        return IdSesion;
    }

    public void accederUsuario(javafx.event.ActionEvent event) throws Exception {
        if (validacionLogin()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/principalUsuario.fxml"));
            Parent parentScene = loader.load();
            principalUsuarioController controller = loader.getController();

            Scene newScene = new Scene(parentScene);
            Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            window.setScene(newScene);
            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            window.setX((primScreenBounds.getWidth() - window.getWidth()) / 2);
            window.setY((primScreenBounds.getHeight() - window.getHeight()) / 2);
            window.show();

        }else {
        }
    }

    public void registrarUsuario()throws Exception{

    }

    public boolean validacionLogin() throws Exception {
        if (txtIdentificacion.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese la identificacion...");
        }else if(txtPassword.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese la contrasena...");
        }else {
            Usuario usuarioEncontrado = usuarioGestor.buscarUsuario(Integer.parseInt(txtIdentificacion.getText()));
            if (usuarioEncontrado == null){
                JOptionPane.showMessageDialog(null,"No se encontro el usuario con dicha identificacion...");
            }else {
                if (txtPassword.getText().equals(usuarioEncontrado.getContrasena())){
                    IdSesion = Integer.parseInt(txtIdentificacion.getText());
                    return true;
                }else {
                    JOptionPane.showMessageDialog(null,"Credenciales incorrectas...");
                    return false;
                }
            }
        }


        return false;
    }

    public void accederAdmin(javafx.event.ActionEvent event) throws Exception {
        if (validacionLoginAdmin()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/principalAdministrador.fxml"));
            Parent parentScene = loader.load();
            principalAdministradorController controller = loader.getController();

            Scene newScene = new Scene(parentScene);
            Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            window.setScene(newScene);
            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            window.setX((primScreenBounds.getWidth() - window.getWidth()) / 2);
            window.setY((primScreenBounds.getHeight() - window.getHeight()) / 2);
            window.show();

        }else {

        }


    }

    public boolean validacionLoginAdmin() throws Exception {
        if (txtIdentificacion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese la identificacion...");
        } else if (txtPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese la contrasena...");
        } else {
            Administrador administradorEncontrado = administradorGestor.buscarAdministrador(Integer.parseInt(txtIdentificacion.getText()));
            if (administradorEncontrado == null) {
                JOptionPane.showMessageDialog(null, "No se encontro el usuario con dicha identificacion...");
            } else {
                if (txtPassword.getText().equals(administradorEncontrado.getContrasena())) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas...");
                    return false;
                }
            }
        }
        return false;
    }

    public void accederMiembro(javafx.event.ActionEvent event) throws Exception {
        if (validacionLoginMiembro()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/principalUsuario.fxml"));
            Parent parentScene = loader.load();
            principalAdministradorController controller = loader.getController();

            Scene newScene = new Scene(parentScene);
            Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            window.setScene(newScene);
            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            window.setX((primScreenBounds.getWidth() - window.getWidth()) / 2);
            window.setY((primScreenBounds.getHeight() - window.getHeight()) / 2);
            window.show();

        }else {

        }


    }

    public void registrarMiembro(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Usuario.fxml"));
        Parent parentScene = loader.load();
        UsuarioController controller = loader.getController();

        Scene newScene = new Scene(parentScene);
        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((primScreenBounds.getWidth() - window.getWidth()) / 2);
        window.setY((primScreenBounds.getHeight() - window.getHeight()) / 2);
        window.show();
    }

    public boolean validacionLoginMiembro() throws Exception {
        if (txtIdentificacion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese la identificacion...");
        } else if (txtPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese la contrasena...");
        } else {
            Miembro miembroEncontrado = miembroGestor.buscarMiembro(Integer.parseInt(txtIdentificacion.getText()));
            if (miembroEncontrado == null) {
                JOptionPane.showMessageDialog(null, "No se encontro el usuario con dicha identificacion...");
            } else {
                if (txtPassword.getText().equals(miembroEncontrado.getContrasena())) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas...");
                    return false;
                }
            }
        }
        return false;
    }

    public void administrador() throws Exception {
        btnAcceder.setVisible(false);
        btnRegistrar.setVisible(false);
        btnAccederAdmin.setVisible(true);
        linkAdmin.setVisible(false);
        linkUsuario.setVisible(true);
        lblTitle.setText("Administrador");
    }

    public void miembro() throws Exception {
        btnAcceder.setVisible(false);
        btnRegistrar.setVisible(false);
        btnAccederAdmin.setVisible(false);
        btnRegistrar.setVisible(false);
        linkAdmin.setVisible(true);
        linkUsuario.setVisible(true);
        lblTitle.setText("Miembro");
    }

    public void usuario() throws Exception {
        btnAcceder.setVisible(true);
        btnRegistrar.setVisible(true);
        btnAccederAdmin.setVisible(false);
        linkAdmin.setVisible(true);
        linkUsuario.setVisible(false);
        lblTitle.setText("Usuario");
    }




}