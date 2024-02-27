package cr.ac.ucenfotec.bl.entities.avion;

import java.util.Objects;

public class Avion {
    private String placa;
    private String marca;
    private String modelo;
    private int capacidad;

    public Avion() {
    }

    public Avion(String placa, String marca, String modelo, int capacidad) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "placa: " + placa + ", marca:" + marca + ", modelo: " + modelo + ", capacidad: " + capacidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avion avion = (Avion) o;
        return Objects.equals(placa, avion.placa);
    }

}
