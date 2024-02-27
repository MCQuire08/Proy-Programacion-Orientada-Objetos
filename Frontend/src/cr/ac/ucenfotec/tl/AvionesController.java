package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.logic.AereopuertoGestor;
import cr.ac.ucenfotec.bl.logic.AvionGestor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AvionesController implements Initializable {
    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Label lblTitulo;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtCapacidad;


    //Gestor
    AvionGestor avionGestor = new AvionGestor();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    protected void registrarAvion(ActionEvent event)throws Exception{
        if (txtCapacidad.getText().length() == 0 && txtMarca.getText().length() == 0 && txtModelo.getText().length() == 0 && txtPlaca.getText().length() == 0 ){
            JOptionPane.showMessageDialog(null,"Hay campos vacíos...","Error",JOptionPane.WARNING_MESSAGE);
        }else{
                avionGestor.registrarAvion(txtPlaca.getText(),txtMarca.getText(),txtModelo.getText(),Integer.parseInt(txtCapacidad.getText()));
                JOptionPane.showMessageDialog(null,"Se registro correctamente","Avion",JOptionPane.PLAIN_MESSAGE);
                btnVolver(event);
        }

    }

    public void btnVolver(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/principalAdministrador.fxml"));
        Parent parentScene = loader.load();
        principalAdministradorController controller = loader.getController();

        Scene newScene = new Scene(parentScene);
        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

}
