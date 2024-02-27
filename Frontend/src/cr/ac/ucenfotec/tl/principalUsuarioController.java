package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.logic.TicketGestor;
import cr.ac.ucenfotec.bl.logic.UsuarioGestor;
import cr.ac.ucenfotec.bl.logic.VueloGestor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class principalUsuarioController implements Initializable {

    @FXML
    private TableColumn<?, ?> CarAerDestino;

    @FXML
    private TableColumn<?, ?> CarAerSalida;

    @FXML
    private TableColumn<?, ?> CarNumAsiento;

    @FXML
    private TableColumn<?, ?> CarNumTicket;

    @FXML
    private TableColumn<?, ?> CarNumVuelo;

    @FXML
    private TableColumn<?, ?> CarPaisDestino;

    @FXML
    private TableColumn<?, ?> CarPaisSalida;

    @FXML
    private TableColumn<?, ?> CarPrecio;

    @FXML
    private TableColumn<?, ?> CarTipoAsiento;

    @FXML
    private TableColumn<?, ?> TikAerDestino;

    @FXML
    private TableColumn<?, ?> TikAerSalida;

    @FXML
    private TableColumn<?, ?> TikNumAsiento;

    @FXML
    private TableColumn<?, ?> TikNumTicket;

    @FXML
    private TableColumn<?, ?> TikNumVuelo;

    @FXML
    private TableColumn<?, ?> TikPaisDestino;

    @FXML
    private TableColumn<?, ?> TikPaisSalida;

    @FXML
    private TableColumn<?, ?> TikPrecio;

    @FXML
    private TableColumn<?, ?> TikTipoAsiento;

    @FXML
    private TableColumn<?, ?> VueAerDestino;

    @FXML
    private TableColumn<?, ?> VueAerSalida;

    @FXML
    private TableColumn<?, ?> VueAvion;

    @FXML
    private TableColumn<?, ?> VueEstado;

    @FXML
    private TableColumn<?, ?> VueHoraLlegada;

    @FXML
    private TableColumn<?, ?> VueHoraSalida;

    @FXML
    private TableColumn<?, ?> VueLinea;

    @FXML
    private TableColumn<?, ?> VueNumVuelo;

    @FXML
    private TableColumn<?, ?> VuePaisDestino;

    @FXML
    private TableColumn<?, ?> VuePaisSalida;

    @FXML
    private TableColumn<?, ?> VueSalaDestino;

    @FXML
    private TableColumn<?, ?> VueSalaSalida;

    @FXML
    private TableColumn<?, ?> VueTripulacion;

    @FXML
    private Button btnMisTickets;

    @FXML
    private Button btnCambioContrasena;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnEliminarCarrito;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnMiembros;

    @FXML
    private Button btnPagarCarrito;

    @FXML
    private Button btnCarrito;

    @FXML
    private Button btnBuscarVuelos;

    @FXML
    private Button btnMiPerfil;

    @FXML
    private Label lblTitle;

    @FXML
    private Pane panelBotones;

    @FXML
    private Pane panelStatus;

    @FXML
    private GridPane pnCarrito;

    @FXML
    private GridPane pnMiPerfil;

    @FXML
    private GridPane pnMiTickets;

    @FXML
    private GridPane pnVuelos;

    @FXML
    private TableView<?> tblCarrito;

    @FXML
    private TableView<Object> tblTickets;

    @FXML
    private TableView<?> tblVuelos;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtBuscarCarrito;

    @FXML
    private TextField txtBuscarTickets;

    @FXML
    private TextField txtBuscarVuelos;

    @FXML
    private PasswordField txtContrasena1;

    @FXML
    private PasswordField txtContrasena2;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNacionalidad;

    @FXML
    private TextField txtNombre;

    @FXML
    void handleClicks(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            cargarMiPerfil();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Gestores

    UsuarioGestor usuarioGestor = new UsuarioGestor();
    VueloGestor vueloGestor = new VueloGestor();
    TicketGestor ticketGestor = new TicketGestor();
    iniciarSesionController iniciarSesionControllers = new iniciarSesionController();

    //Datos
    ObservableList<Object> datosTickets = FXCollections.observableArrayList();


    public void cambioMiPerfil() throws Exception {
        cargarMiPerfil();
        lblTitle.setText("Mi Perfil");
        pnMiPerfil.toFront();
    }

    public void cambioCarrito() throws Exception {
        cargarTickets();
        lblTitle.setText("Mi Carrito");
        pnCarrito.toFront();
    }

    public void cambioBuscarVuelos(){

        lblTitle.setText("Vuelos");
        pnVuelos.toFront();
    }

    public void cambioMisTickets(){

        lblTitle.setText("Mis Tickets");
        pnMiTickets.toFront();

    }

    private void cargarMiPerfil() throws Exception {

        int id = iniciarSesionControllers.usuarioSesion();

        txtIdentificacion.clear();
        txtIdentificacion.setText(String.valueOf(id));

        txtNombre.clear();
        txtNombre.setText(usuarioGestor.buscarUsuario(id).getNombre());

        txtApellidos.clear();
        txtApellidos.setText(usuarioGestor.buscarUsuario(id).getApellidos());

        txtNacionalidad.clear();
        txtNacionalidad.setText(usuarioGestor.buscarUsuario(id).getNacionalidad());

        txtCorreo.clear();
        txtCorreo.setText(usuarioGestor.buscarUsuario(id).getCorreo());

        txtDireccion.clear();
        txtDireccion.setText(usuarioGestor.buscarUsuario(id).getDireccion());

        txtEdad.setText(String.valueOf(usuarioGestor.buscarUsuario(id).getEdad()));
    }

    private void cargarTickets() throws Exception{
        tblTickets.getItems().clear();
        ticketGestor.listarTickets().forEach(ticket -> datosTickets.addAll(ticket));


        TikNumAsiento.setCellValueFactory(new PropertyValueFactory<>("numeroAsiento"));
        TikNumTicket.setCellValueFactory(new PropertyValueFactory<>("numeroTicket"));
        TikPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        TikTipoAsiento.setCellValueFactory(new PropertyValueFactory<>("tipoAsiento"));
        TikNumVuelo.setCellValueFactory(new PropertyValueFactory<>("numeroVuelo"));


        TikPaisDestino.setCellValueFactory(new PropertyValueFactory<>("paisDestino"));
        TikPaisSalida.setCellValueFactory(new PropertyValueFactory<>("paisSalida"));
        TikAerDestino.setCellValueFactory(new PropertyValueFactory<>("aereopuertoDestino"));
        TikAerSalida.setCellValueFactory(new PropertyValueFactory<>("aereopuertoSalida"));

        tblTickets.setItems(datosTickets);
    }



}
