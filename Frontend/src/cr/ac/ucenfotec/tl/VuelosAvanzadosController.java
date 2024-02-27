package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.entities.aereopuerto.Aereopuerto;
import cr.ac.ucenfotec.bl.entities.vuelo.Vuelo;
import cr.ac.ucenfotec.bl.logic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VuelosAvanzadosController implements Initializable {

    @FXML
    private Label lblTitulo;

    @FXML
    private TextField txtAerDestino;

    @FXML
    private TextField txtAerSalida;

    @FXML
    private TextField txtAvion;

    @FXML
    private TextField txtLinea;

    @FXML
    private TextField txtNumeroVuelo;

    @FXML
    private TextField txtPaisDestino;

    @FXML
    private TextField txtPaisSalida;

    @FXML
    private TextField txtSalaDestino;

    @FXML
    private TextField txtSalaSalida;

    @FXML
    private TextField txtTripulacion;

    //Gestores
    AereopuertoGestor aereopuertoGestor = new AereopuertoGestor();
    AvionGestor avionGestor = new AvionGestor();
    LineaAereaGestor lineaAereaGestor = new LineaAereaGestor();
    PaisGestor paisGestor = new PaisGestor();
    SalaGestor salaGestor = new SalaGestor();
    TripulacionGestor tripulacionGestor = new TripulacionGestor();
    VueloGestor vueloGestor = new VueloGestor();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void validarAsociacion() throws Exception {

        if (!txtNumeroVuelo.getText().equals("")){
            Vuelo vuelo = vueloGestor.buscarVuelo(txtNumeroVuelo.getText());
            String mensaje =  "Se registro : ";


            if (vueloGestor.validarVueloRelacion(vuelo.getNumeroVuelo()) == null){
                vueloGestor.crearVueloAvanzado(vuelo.getNumeroVuelo());
                mensaje += vuelo.getNumeroVuelo()+", ";
                txtNumeroVuelo.clear();
            }

            if (!txtLinea.getText().equals("")){
                vueloGestor.registrarLineaAereaVuelo(txtLinea.getText(),vuelo.getNumeroVuelo());
                mensaje += txtLinea.getText()+", ";
                txtLinea.clear();
            }

            if (!txtAerDestino.getText().equals("")){
                vueloGestor.registrarAereopuertoDestinoVuelo(txtAerDestino.getText(),vuelo.getNumeroVuelo());
                mensaje += txtAerDestino.getText() +", ";
                txtAerDestino.clear();
            }

            if (!txtAerSalida.getText().equals("")){
                vueloGestor.registrarAereopuertoSalidaVuelo(txtAerSalida.getText(),vuelo.getNumeroVuelo());
                mensaje += txtAerSalida.getText() +", ";
                txtAerSalida.clear();
            }

            if (!txtAvion.getText().equals("")){
                vueloGestor.registrarAvionVuelo(txtAvion.getText(),vuelo.getNumeroVuelo());
                mensaje += txtAvion.getText() +", ";
                txtAvion.clear();
            }

            if (!txtSalaSalida.getText().equals("")){
                vueloGestor.registrarSalaSalidaVuelo(txtSalaSalida.getText(),vuelo.getNumeroVuelo());
                mensaje += txtSalaSalida.getText() +", ";
                txtSalaSalida.clear();
            }

            if (!txtSalaDestino.getText().equals("")){
                vueloGestor.registrarSalaDestinoVuelo(txtSalaDestino.getText(),vuelo.getNumeroVuelo());
                mensaje += txtSalaDestino.getText() +", ";
                txtSalaDestino.clear();
            }

            if(!txtPaisSalida.getText().equals("")){
                vueloGestor.registrarPaisSalidaVuelo(txtPaisSalida.getText(),vuelo.getNumeroVuelo());
                mensaje += txtPaisSalida.getText() +", ";
                txtPaisSalida.clear();
            }

            if (!txtPaisDestino.getText().equals("")){
                vueloGestor.registrarPaisDestinoVuelo(txtPaisDestino.getText(),vuelo.getNumeroVuelo());
                mensaje += txtPaisDestino.getText()+", ";
                txtPaisDestino.clear();
            }

            if (!txtTripulacion.getText().equals("")){
                vueloGestor.registrarTripulacionVuelo(txtTripulacion.getText(),vuelo.getNumeroVuelo());
                mensaje += txtTripulacion.getText();
                txtTripulacion.clear();
            }

            JOptionPane.showMessageDialog(null,mensaje);

        }else{
            JOptionPane.showMessageDialog(null,"Se necesita el numero de vuelo para continuar");
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

