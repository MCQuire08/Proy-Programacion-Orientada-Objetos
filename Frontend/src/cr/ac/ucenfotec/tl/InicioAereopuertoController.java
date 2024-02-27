package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.logic.AereopuertoGestor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InicioAereopuertoController implements Initializable {
    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Label lblTitulo;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;


    //Gestor
    AereopuertoGestor aereopuertoGestor = new AereopuertoGestor();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    protected void registrarAereopuerto(javafx.event.ActionEvent event)throws Exception{
        if (txtCodigo.getText().length() == 0 && txtNombre.getText().length() == 0 ){
            JOptionPane.showMessageDialog(null,"Hay campos vacíos...","Error",JOptionPane.WARNING_MESSAGE);
        }else{
                aereopuertoGestor.registrarAereopuerto(txtNombre.getText(),txtCodigo.getText());
                JOptionPane.showMessageDialog(null,"Se registro correctamente","Aerepuerto",JOptionPane.PLAIN_MESSAGE);
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

        }

    }


}
