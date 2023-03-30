
import Interface.DAOCapacitacion;
import Interface.DAOCapacitacionImpl;
import clases.Capacitacion;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yo
 */
public class main {
    public static void main(String[] args) {
        Capacitacion cap1 = new Capacitacion();
        cap1.setIdCapacitacion(11);
        cap1.setCapFecha("2023-02-25");
        cap1.setCapHora("12:00");
        cap1.setCapLugar("Talca");
        cap1.setCapDuracion(60);
        cap1.setCliente_rutCliente(5);
        
        try {
            DAOCapacitacion dao = new DAOCapacitacionImpl();
            dao.listar();
        } catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
