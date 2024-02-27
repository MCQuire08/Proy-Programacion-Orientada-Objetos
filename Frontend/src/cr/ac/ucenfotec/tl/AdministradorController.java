package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.logic.AdministradorGestor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.*;

public class AdministradorController implements Initializable {

    private static AdministradorGestor administradorGestor = new AdministradorGestor();


    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Label lblTitulo;

    @FXML
    private MenuButton menuGenero;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtContrasena;

    @FXML
    private TextField txtContrasena2;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNacionalidad;

    @FXML
    private TextField txtNombre;


    @FXML
    protected void registrarAdministrador()throws Exception{
        if (txtId.getText().length() == 0 && txtNombre.getText().length() == 0 && txtApellidos.getText().length() == 0 && txtNacionalidad.getText().length() == 0
        && txtCorreo.getText().length() == 0 && txtEdad.getText().length() == 0 && txtDireccion.getText().length() == 0 && txtContrasena.getText().length() ==0 && txtContrasena2.getText().length() == 0){
            JOptionPane.showMessageDialog(null,"Hay campos vacíos...","Error",JOptionPane.WARNING_MESSAGE);
        }else{
            if (txtContrasena.getText().equals(txtContrasena2.getText())){
                int id = Integer.parseInt(txtId.getText());
                int edad = Integer.parseInt(txtEdad.getText());
                administradorGestor.registrarAdministrador(txtNombre.getText(),txtApellidos.getText(),txtNacionalidad.getText(),txtCorreo.getText(),txtDireccion.getText(),
                        id,edad,"",txtContrasena.getText());
                JOptionPane.showMessageDialog(null,"Se registro correctamente","Sala",JOptionPane.PLAIN_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden...","Error",JOptionPane.WARNING_MESSAGE);
            }
        }

    }

    public void btnVolver(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/principalAdministrador.fxml"));
        Parent parentScene = loader.load();
        principalAdministradorController controller = loader.getController();

        Scene newScene = new Scene(parentScene);
        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



}

