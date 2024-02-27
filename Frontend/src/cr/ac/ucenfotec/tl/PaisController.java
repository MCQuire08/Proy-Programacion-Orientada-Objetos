package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.logic.PaisGestor;
import cr.ac.ucenfotec.bl.logic.SalaGestor;
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

public class PaisController implements Initializable {
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

    @FXML
    private TextField txtAbreviatura;

    //Gestor
    PaisGestor paisGestor = new PaisGestor();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    protected void registrarPais()throws Exception{
        if (txtCodigo.getText().length() == 0 && txtAbreviatura.getText().length() == 0 && txtAbreviatura.getText().length() == 0 ){
            JOptionPane.showMessageDialog(null,"Hay campos vacíos...","Error",JOptionPane.WARNING_MESSAGE);
        }else{
                paisGestor.registrarPais(txtNombre.getText(),txtAbreviatura.getText(),txtCodigo.getText());
                JOptionPane.showMessageDialog(null,"Se registro correctamente","Pais",JOptionPane.PLAIN_MESSAGE);
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
