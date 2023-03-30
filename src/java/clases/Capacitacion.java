/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Gronorf
 */
public class Capacitacion {
    int idCapacitacion;
    String capFecha;
    String capHora;
    String capLugar;
    int capDuracion;
    int cliente_rutCliente;

    public Capacitacion(int idCapacitacion, String capFecha, String capHora, String capLugar, int capDuracion, int cliente_rutCliente) {
        this.idCapacitacion = idCapacitacion;
        this.capFecha = capFecha;
        this.capHora = capHora;
        this.capLugar = capLugar;
        this.capDuracion = capDuracion;
        this.cliente_rutCliente = cliente_rutCliente;
    }

    public Capacitacion() {
    }

    public int getIdCapacitacion() {
        return idCapacitacion;
    }

    public void setIdCapacitacion(int idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public String getCapFecha() {
        return capFecha;
    }

    public void setCapFecha(String capFecha) {
        this.capFecha = capFecha;
    }

    public String getCapHora() {
        return capHora;
    }

    public void setCapHora(String capHora) {
        this.capHora = capHora;
    }

    public String getCapLugar() {
        return capLugar;
    }

    public void setCapLugar(String capLugar) {
        this.capLugar = capLugar;
    }

    public int getCapDuracion() {
        return capDuracion;
    }

    public void setCapDuracion(int capDuracion) {
        this.capDuracion = capDuracion;
    }

    public int getCliente_rutCliente() {
        return cliente_rutCliente;
    }

    public void setCliente_rutCliente(int cliente_rutCliente) {
        this.cliente_rutCliente = cliente_rutCliente;
    }
    
    
}
