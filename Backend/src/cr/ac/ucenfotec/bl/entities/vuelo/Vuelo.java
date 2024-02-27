package cr.ac.ucenfotec.bl.entities.vuelo;

import cr.ac.ucenfotec.bl.entities.aereopuerto.Aereopuerto;
import cr.ac.ucenfotec.bl.entities.avion.Avion;
import cr.ac.ucenfotec.bl.entities.lineaAerea.LineaAerea;
import cr.ac.ucenfotec.bl.entities.pais.Pais;
import cr.ac.ucenfotec.bl.entities.sala.Sala;
import cr.ac.ucenfotec.bl.entities.tripulacion.Tripulacion;
import cr.ac.ucenfotec.bl.logic.*;

import javax.sound.sampled.Line;

public class Vuelo {
    private String numeroVuelo;
    private int horaLlegada;
    private int horaSalida;
    private String estado;
    private String lineaAerea;
    private String aeropuertoSalida;
    private String aeropuertoDestino;
    private String avion;
    private String salaSalida;
    private String salaDestino;
    private String paisSalida;
    private String paisDestino;
    private String tripulacion;

    public Vuelo() {
    }

    public Vuelo(String numeroVuelo,int horaLlegada, int horaSalida, String estado) {
        this.numeroVuelo = numeroVuelo;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        this.estado = estado;
    }

    public Vuelo(String numeroVuelo,int horaLlegada, int horaSalida, String estado,String lineaAerea,String aereopuertoSalida,String aereopuertoDestino,String avion,String salaSalida,String salaDestino,String tripulacion,String paisSalida, String paisDestino) throws Exception {
        this.numeroVuelo = numeroVuelo;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        this.estado = estado;
        this.lineaAerea = lineaAerea;
        this.aeropuertoSalida = aereopuertoSalida;
        this.aeropuertoDestino = aereopuertoDestino;
        this.avion = avion;
        this.salaDestino= salaDestino;
        this.salaSalida = salaSalida;
        this.tripulacion = tripulacion;
        this.paisDestino =paisDestino;
        this.paisSalida = paisSalida;
    }



    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public int getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(int horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLineaAerea() {
        return lineaAerea;
    }

    public void setLineaAerea(String lineaAerea) {
        this.lineaAerea = lineaAerea;
    }

    public String getAeropuertoSalida() {
        return aeropuertoSalida;
    }

    public void setAeropuertoSalida(String aeropuertoSalida) {
        this.aeropuertoSalida = aeropuertoSalida;
    }

    public String getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(String aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public String getAvion() {
        return avion;
    }

    public void setAvion(String avion) {
        this.avion = avion;
    }

    public String getSalaSalida() {
        return salaSalida;
    }

    public void setSalaSalida(String salaSalida) {
        this.salaSalida = salaSalida;
    }

    public String getSalaDestino() {
        return salaDestino;
    }

    public void setSalaDestino(String salaDestino) {
        this.salaDestino = salaDestino;
    }

    public String getPaisSalida() {
        return paisSalida;
    }

    public void setPaisSalida(String paisSalida) {
        this.paisSalida = paisSalida;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public String getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(String tripulacion) {
        this.tripulacion = tripulacion;
    }

    @Override
    public String toString() {
        return "NumeroVuelo='" + numeroVuelo +
                ", horaLlegada=" + horaLlegada +
                ", horaSalida=" + horaSalida +
                ", estado=" + estado +
                ", lineaAerea=" + lineaAerea +
                ", aeropuertoSalida=" + aeropuertoSalida + ", aeropuertoDestino=" + aeropuertoDestino + ", avion=" + avion + ", salaSalida=" + salaSalida + ", salaDestino=" + salaDestino + ", paisSalida=" + paisSalida + ", paisDestino=" + paisDestino + ", tripulacion=" + tripulacion;
    }
}
