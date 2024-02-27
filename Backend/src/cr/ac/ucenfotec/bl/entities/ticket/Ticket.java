package cr.ac.ucenfotec.bl.entities.ticket;

import cr.ac.ucenfotec.bl.entities.aereopuerto.Aereopuerto;
import cr.ac.ucenfotec.bl.entities.pais.Pais;

import java.util.Objects;

public class Ticket {
    private String numeroTicket;
    private String numeroAsiento;
    private double precio;
    private String numeroVuelo;
    private String tipoAsiento;
    private Aereopuerto aeropuertoSalida;
    private Aereopuerto aeropuertoDestino;
    private Pais paisSalida;
    private Pais paisDestino;
    public Ticket() {
    }

    public Ticket(String numeroTicket, String numeroAsiento, double precio, String numeroVuelo, String tipoAsiento) {
        this.numeroTicket = numeroTicket;
        this.numeroAsiento = numeroAsiento;
        this.precio = precio;
        this.numeroVuelo = numeroVuelo;
        this.tipoAsiento = tipoAsiento;
    }

    public Ticket(String numeroTicket, String numeroAsiento, double precio, String numeroVuelo, String tipoAsiento,String aereopuertoSalida,String aereopuertoDestino,String paisSalida,String paisDestino) {
        this.numeroTicket = numeroTicket;
        this.numeroAsiento = numeroAsiento;
        this.precio = precio;
        this.numeroVuelo = numeroVuelo;
        this.tipoAsiento = tipoAsiento;
    }

    public String getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(String numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public Aereopuerto getAeropuertoSalida() {
        return aeropuertoSalida;
    }

    public void setAeropuertoSalida(Aereopuerto aeropuertoSalida) {
        this.aeropuertoSalida = aeropuertoSalida;
    }

    public Aereopuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aereopuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public Pais getPaisSalida() {
        return paisSalida;
    }

    public void setPaisSalida(Pais paisSalida) {
        this.paisSalida = paisSalida;
    }

    public Pais getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(Pais paisDestino) {
        this.paisDestino = paisDestino;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public void agregarAereopuertoDestino(Aereopuerto aeropuertoDestino){
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public void agregarAereopuertoSalida(Aereopuerto aeropuertoSalida){
        this.aeropuertoSalida = aeropuertoSalida;
    }

    public void agregarPaisSalida(Pais paisSalida){
        this.paisSalida = paisSalida;
    }

    public void agregarPaisDestino(Pais paisDestino){
        this.paisDestino = paisDestino;
    }

    @Override
    public String toString() {
        return "NumeroTicket=" + numeroTicket + ", numeroAsiento='" + numeroAsiento + ", precio=" + precio + ", numeroVuelo=" + numeroVuelo + ", tipoAsiento=" + tipoAsiento + '\'' + ", aeropuertoSalida=" + aeropuertoSalida + ", aeropuertoDestino=" + aeropuertoDestino + ", paisSalida= " + paisSalida + ", paisDestino= " + paisDestino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(numeroTicket, ticket.numeroTicket);
    }
}
