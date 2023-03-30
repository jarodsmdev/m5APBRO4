/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import conexion.Singleton;
import Interface.DAOCapacitacion;
import clases.Capacitacion;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Gronorf
 */
public class DAOCapacitacionImpl extends Singleton implements DAOCapacitacion{

    @Override
    public void registrar(Capacitacion cap) throws Exception {
        try {
            this.conectar();
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO `sprint_prev_riesgos`.`capacitacion` (`idCapacitacion`, `capFecha`, `capHora`, `capLugar`, `capDuracion`, `cliente_rutCliente`) VALUES (?, ?, ?, ?, ?, ?);");
            stmt.setInt(1, cap.getIdCapacitacion());
            stmt.setString(2, cap.getCapFecha());
            stmt.setString(3, cap.getCapHora());
            stmt.setString(4, cap.getCapLugar());
            stmt.setInt(5, cap.getCapDuracion());
            stmt.setInt(6, cap.getCliente_rutCliente());
            stmt.executeUpdate();
        } catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Capacitacion cap) throws Exception {
        try {
            this.conectar();
            PreparedStatement stmt = this.conn.prepareStatement("UPDATE capacitacion SET idCapacitacion WHERE id = ?");
            stmt.setInt(1, cap.getIdCapacitacion());
            stmt.executeUpdate();
        } catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Capacitacion cap) throws Exception {
       
    }

    @Override
    public List<Capacitacion> listar() throws Exception {
        return null;
    }

}
