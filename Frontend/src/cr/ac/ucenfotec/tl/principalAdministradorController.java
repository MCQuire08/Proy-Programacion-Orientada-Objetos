package cr.ac.ucenfotec.tl;
import cr.ac.ucenfotec.bl.entities.vuelo.Vuelo;
import cr.ac.ucenfotec.bl.logic.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class principalAdministradorController implements Initializable {
    ObservableList<Object> datosAdministrador = FXCollections.observableArrayList();
    ObservableList<Object> datosMiembros = FXCollections.observableArrayList();
    ObservableList<Object> datosVuelos = FXCollections.observableArrayList();
    ObservableList<Object> datosPaises = FXCollections.observableArrayList();
    ObservableList<Object> datosTripulaciones = FXCollections.observableArrayList();
    ObservableList<Object> datosLineasAereas = FXCollections.observableArrayList();
    ObservableList<Object> datosAviones = FXCollections.observableArrayList();
    ObservableList<Object> datosSalas = FXCollections.observableArrayList();
    ObservableList<Object> datosAereopuertos = FXCollections.observableArrayList();


    @FXML
    private TableColumn AdminApellidos;

    @FXML
    private TableColumn AdminCorreo;

    @FXML
    private TableColumn AdminDireccion;

    @FXML
    private TableColumn AdminEdad;

    @FXML
    private TableColumn AdminGenero;

    @FXML
    private TableColumn AdminId;

    @FXML
    private TableColumn AdminNacionalidad;

    @FXML
    private TableColumn AdminNombre;

    @FXML
    private TableColumn AviCapacidad;

    @FXML
    private TableColumn AviMarca;

    @FXML
    private TableColumn AviModelo;

    @FXML
    private TableColumn AviPlaca;

    @FXML
    private TableColumn LinCedulaJuridica;

    @FXML
    private TableColumn LinLogo;

    @FXML
    private TableColumn LinNombre;

    @FXML
    private TableColumn LinNombreEmpresa;

    @FXML
    private TableColumn MiemAnosExp;

    @FXML
    private TableColumn MiemApellidos;

    @FXML
    private TableColumn MiemCorreo;

    @FXML
    private TableColumn MiemDireccion;

    @FXML
    private TableColumn MiemGenero;

    @FXML
    private TableColumn MiemGrad;

    @FXML
    private TableColumn MiemId;

    @FXML
    private TableColumn MiemNacionalidad;

    @FXML
    private TableColumn MiemNombre;

    @FXML
    private TableColumn MiemNumLic;

    @FXML
    private TableColumn MiemPuesto;

    @FXML
    private TableColumn MiemTelefono;

    @FXML
    private TableColumn PaisAbreviatura;

    @FXML
    private TableColumn PaisCodigo;

    @FXML
    private TableColumn PaisNombre;

    @FXML
    private TableColumn SalCodigo;

    @FXML
    private TableColumn SalNombre;

    @FXML
    private TableColumn SalUbicacion;

    @FXML
    private TableColumn TriCodigo;

    @FXML
    private TableColumn TriNombre;

    @FXML
    private TableColumn VueAereoDestino;

    @FXML
    private TableColumn VueAereoSalida;

    @FXML
    private TableColumn VueAvion;

    @FXML
    private TableColumn VueEstado;

    @FXML
    private TableColumn VueHoraLlegada;

    @FXML
    private TableColumn VueHoraSalida;

    @FXML
    private TableColumn VueLineaAerea;

    @FXML
    private TableColumn VueNumVuelo;

    @FXML
    private TableColumn<?, ?> VuePaisDestino;

    @FXML
    private TableColumn VuePaisSalida;

    @FXML
    private TableColumn VueSalaDestino;

    @FXML
    private TableColumn VueSalaSalida;

    @FXML
    private TableColumn VueTripulacion;
    @FXML
    private TableColumn AerNombre;
    @FXML
    private TableColumn AerCodigo;

    @FXML
    private Button btnAdministradores;

    @FXML
    private Button btnMiembros;

    @FXML
    private Button btnVuelos;

    @FXML
    private Button btnPaises;

    @FXML
    private Button btnTripulacion;

    @FXML
    private Button btnLineaAerea;

    @FXML
    private Button btnAvion;

    @FXML
    private Button btnSala;

    @FXML
    private Button btnAereopuerto;

    @FXML
    private Label lblStatus;

    @FXML
    private Pane panelBotones;

    @FXML
    private Pane panelStatus;

    @FXML
    private GridPane pnAdministrador;

    @FXML
    private GridPane pnAviones;

    @FXML
    private GridPane pnLineasAereas;

    @FXML
    private GridPane pnMiembros;

    @FXML
    private GridPane pnPaises;

    @FXML
    private GridPane pnSalas;

    @FXML
    private GridPane pnTripulacion;

    @FXML
    private GridPane pnVuelos;
    @FXML
    private GridPane pnAereopuerto;
    @FXML
    private TableView tblAdministradores;

    @FXML
    private TableView tblAviones;

    @FXML
    private TableView tblLineasAereas;

    @FXML
    private TableView tblMiembros;

    @FXML
    private TableView tblPais;

    @FXML
    private TableView tblSalas;

    @FXML
    private TableView tblTripulacion;

    @FXML
    private TableView tblVuelos;
    @FXML
    private TableView tblAereopuerto;



    //Gestores
    AdministradorGestor administradorGestor = new AdministradorGestor();
    MiembroGestor miembroGestor = new MiembroGestor();
    VueloGestor vueloGestor = new VueloGestor();
    PaisGestor paisGestor = new PaisGestor();
    TripulacionGestor tripulacionGestor = new TripulacionGestor();
    LineaAereaGestor lineaAereaGestor = new LineaAereaGestor();
    AvionGestor avionGestor = new AvionGestor();
    SalaGestor salaGestor = new SalaGestor();
    AereopuertoGestor aereopuertoGestor = new AereopuertoGestor();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            cargarListaAdministradores();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    public void handleClicks(javafx.event.ActionEvent event) throws Exception {
        if (event.getSource()==btnAdministradores){
            cargarListaAdministradores();
            lblStatus.setText("Administradores");
            pnAdministrador.toFront();

        } else if (event.getSource() == btnMiembros) {
            cargarListaMiembros();
            lblStatus.setText("Miembros");
            pnMiembros.toFront();

        } else if (event.getSource() == btnVuelos) {
            cargarListaVuelos();
            lblStatus.setText("Vuelos");
            pnVuelos.toFront();

        } else if (event.getSource() == btnPaises) {
            cargarListaPais();
            lblStatus.setText("Países");
            pnPaises.toFront();

        } else if (event.getSource() == btnTripulacion) {
            cargarListaTripulaciones();
            lblStatus.setText("Tripulación");
            pnTripulacion.toFront();

        } else if (event.getSource() == btnLineaAerea) {
            cargarListaLineasAereas();
            lblStatus.setText("Línea Aérea");
            pnLineasAereas.toFront();

        } else if (event.getSource() == btnAvion) {
            cargarListaAviones();
            lblStatus.setText("Aviónes");
            pnAviones.toFront();

        } else if (event.getSource() == btnSala) {
            cargarListaSalas();
            lblStatus.setText("Salas");
            pnSalas.toFront();

        } else if (event.getSource() == btnAereopuerto) {
            cargarListaAereopuertos();
            lblStatus.setText("Aereopuertos");
            pnAereopuerto.toFront();

        }
    }

    private void cargarListaAdministradores() throws Exception{

        tblAdministradores.getItems().clear();
        administradorGestor.listarAdministrador().forEach(administrador -> datosAdministrador.addAll(administrador));

        AdminNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        AdminApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        AdminNacionalidad.setCellValueFactory(new PropertyValueFactory<>("nacionalidad"));
        AdminCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        AdminDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        AdminId.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        AdminEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        AdminGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        tblAdministradores.setItems(datosAdministrador);

    }

    private void cargarListaMiembros() throws Exception{

        tblMiembros.getItems().clear();
        miembroGestor.listarMiembros().forEach(miembro -> datosMiembros.addAll(miembro));

        MiemNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        MiemApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        MiemNacionalidad.setCellValueFactory(new PropertyValueFactory<>("nacionalidad"));
        MiemCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        MiemDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        MiemId.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        MiemGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        MiemAnosExp.setCellValueFactory(new PropertyValueFactory<>("anosExp"));
        MiemGrad.setCellValueFactory(new PropertyValueFactory<>("fechaGrad"));
        MiemNumLic.setCellValueFactory(new PropertyValueFactory<>("numeroLic"));
        MiemPuesto.setCellValueFactory(new PropertyValueFactory<>("puesto"));
        MiemTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        tblMiembros.setItems(datosMiembros);

    }

    private void cargarListaVuelos() throws Exception{

        tblVuelos.getItems().clear();
        vueloGestor.listarVuelos().forEach(vuelo -> datosVuelos.addAll(vuelo));

        ArrayList<Vuelo> lista = vueloGestor.listarVuelos();

        VueNumVuelo.setCellValueFactory(new PropertyValueFactory<>("numeroVuelo"));
        VueHoraLlegada.setCellValueFactory(new PropertyValueFactory<>("horaLlegada"));
        VueHoraSalida.setCellValueFactory(new PropertyValueFactory<>("horaSalida"));
        VueEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        VueLineaAerea.setCellValueFactory(new PropertyValueFactory<>("lineaAerea"));
        VueAereoDestino.setCellValueFactory(new PropertyValueFactory<>("aeropuertoSalida"));
        VueAereoSalida.setCellValueFactory(new PropertyValueFactory<>("aeropuertoDestino"));
        VueAvion.setCellValueFactory(new PropertyValueFactory<>("avion"));
        VueSalaDestino.setCellValueFactory(new PropertyValueFactory<>("salaSalida"));
        VueSalaSalida.setCellValueFactory(new PropertyValueFactory<>("salaDestino"));
        VuePaisDestino.setCellValueFactory(new PropertyValueFactory<>("paisDestino"));
        VuePaisSalida.setCellValueFactory(new PropertyValueFactory<>("paisSalida"));
        VueTripulacion.setCellValueFactory(new PropertyValueFactory<>("tripulacion"));
        tblVuelos.setItems(datosVuelos);

    }

    private void cargarListaPais() throws Exception{
        tblPais.getItems().clear();
        paisGestor.listarPaises().forEach(pais -> datosPaises.addAll(pais));

        PaisCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        PaisNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        PaisAbreviatura.setCellValueFactory(new PropertyValueFactory<>("abreviatura"));

        tblPais.setItems(datosPaises);
    }


    private void cargarListaTripulaciones() throws Exception{
        tblTripulacion.getItems().clear();
        tripulacionGestor.listarTripulacion().forEach(tripulacion -> datosTripulaciones.addAll(tripulacion));

        TriCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        TriNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        tblTripulacion.setItems(datosTripulaciones);
    }

    private void cargarListaLineasAereas() throws Exception{
        tblLineasAereas.getItems().clear();
        lineaAereaGestor.listarLineasAereas().forEach(lineaAerea -> datosLineasAereas.addAll(lineaAerea));

        LinCedulaJuridica.setCellValueFactory(new PropertyValueFactory<>("cedulaJuridica"));
        LinNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        LinNombreEmpresa.setCellValueFactory(new PropertyValueFactory<>("nombreEmpresa"));
        LinLogo.setCellValueFactory(new PropertyValueFactory<>("logo"));

        tblLineasAereas.setItems(datosLineasAereas);
    }

    private void cargarListaAviones() throws Exception{
        tblAviones.getItems().clear();
        avionGestor.listarAviones().forEach(avion -> datosAviones.addAll(avion));

        AviPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        AviMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        AviModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        AviCapacidad.setCellValueFactory(new PropertyValueFactory<>("capacidad"));

        tblAviones.setItems(datosAviones);
    }

    private void cargarListaSalas() throws Exception{
        tblSalas.getItems().clear();
        salaGestor.listarSala().forEach(sala -> datosSalas.addAll(sala));

        SalCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        SalNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        SalUbicacion.setCellValueFactory(new PropertyValueFactory<>("ubicacion"));

        tblSalas.setItems(datosSalas);

    }

    private void cargarListaAereopuertos() throws Exception{
        tblAereopuerto.getItems().clear();
        aereopuertoGestor.listarAereopuertos().forEach(aereopuerto -> datosAereopuertos.addAll(aereopuerto));

        AerCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        AerNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        tblAereopuerto.setItems(datosAereopuertos);

    }

    public void registrarAdministrador(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Administrador.fxml"));
        Parent parentScene = loader.load();
        AdministradorController controller = loader.getController();

        Scene newScene = new Scene(parentScene);
        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    public void registrarMiembro(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Miembro.fxml"));
        Parent parentScene = loader.load();
        MiembroController controller = loader.getController();

        Scene newScene = new Scene(parentScene);
        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    public void registrarSala(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Salas.fxml"));
        Parent parentScene = loader.load();
        SalasController controller = loader.getController();

        Scene newScene = new Scene(parentScene);
        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    public void registrarPais(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Pais.fxml"));
        Parent parentScene = loader.load();
        PaisController controller = loader.getController();

        Scene newScene = new Scene(parentScene);
        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    public void registrarTripulacion(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Tripulacion.fxml"));
        Parent parentScene = loader.load();
        TripulacionController controller = loader.getController();

        Scene newScene = new Scene(parentScene);
        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    public void registrarVuelos(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Vuelos.fxml"));
        Parent parentScene = loader.load();
        VuelosController controller = loader.getController();

        Scene newScene = new Scene(parentScene);
        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    public void registrarLineaAerea(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/LineasAereas.fxml"));
        Parent parentScene = loader.load();
        LineasAereasController controller = loader.getController();

        Scene newScene = new Scene(parentScene);
        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    public void registrarAereopuerto(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Aereopuerto.fxml"));
        Parent parentScene = loader.load();
        AereopuertoController controller = loader.getController();

        Scene newScene = new Scene(parentScene);
        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    public void registrarVueloAvanzado(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/VuelosAvanzado.fxml"));
        Parent parentScene = loader.load();
        VuelosAvanzadosController controller = loader.getController();

        Scene newScene = new Scene(parentScene);
        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    public void registrarAviones(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Aviones.fxml"));
        Parent parentScene = loader.load();
        AvionesController controller = loader.getController();

        Scene newScene = new Scene(parentScene);
        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }



}
