package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.logic.AdministradorGestor;
import cr.ac.ucenfotec.bl.logic.VueloGestor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VuelosController implements Initializable {

    private static AdministradorGestor administradorGestor = new AdministradorGestor();


    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Label lblTitulo;

    @FXML
    private TextField txtEstado;

    @FXML
    private TextField txtHoraLlegada;

    @FXML
    private TextField txtHoraSalida;

    @FXML
    private TextField txtNumeroVuelo;

    @FXML
    private ChoiceBox combobox;

    //Gestor
    VueloGestor vueloGestor = new VueloGestor();

    @FXML
    protected void registrarVuelo(javafx.event.ActionEvent event)throws Exception{
        if (txtNumeroVuelo.getText().length() == 0 && txtEstado.getText().length() == 0 && txtHoraLlegada.getText().length() == 0 && txtHoraSalida.getText().length() == 0 ){
            JOptionPane.showMessageDialog(null,"Hay campos vacíos...","Error",JOptionPane.WARNING_MESSAGE);
        }else{
            int horaLlegada = Integer.parseInt(txtHoraLlegada.getText());
            int horaSalida = Integer.parseInt(txtHoraSalida.getText());
            vueloGestor.registrarVuelos(txtNumeroVuelo.getText(),horaLlegada,horaSalida, combobox.getSelectionModel().getSelectedItem().toString());
            JOptionPane.showMessageDialog(null,"Se registro correctamente","Vuelo",JOptionPane.PLAIN_MESSAGE);
            btnVolver(event);
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
        combobox.getItems().addAll(
                "En sala",
                "Registrado",
                "Pendiente",
                "En curso",
                "Finalizado"
        );

    }





}

