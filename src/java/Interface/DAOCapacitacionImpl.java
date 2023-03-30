package Interface;

import conexion.Singleton;
import Interface.DAOCapacitacion;
import clases.Capacitacion;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class DAOCapacitacionImpl implements DAOCapacitacion{

    @Override
    public void registrar(Capacitacion cap) throws Exception {
        try {
            Connection conn = Singleton.conectar();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO `sprint_prev_riesgos`.`capacitacion` (`idCapacitacion`, `capFecha`, `capHora`, `capLugar`, `capDuracion`, `cliente_rutCliente`) VALUES (?, ?, ?, ?, ?, ?);");
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
            //Singleton.cerrar();
        }
    }

    @Override
    public void modificar(Capacitacion cap) throws Exception {
        try {
            Connection conn = Singleton.conectar();
            PreparedStatement stmt = conn.prepareStatement("UPDATE `sprint_prev_riesgos`.`capacitacion` SET `idCapacitacion` = '?', `capFecha` = '?', `capHora` = '?', `capLugar` = '?', `capDuracion` = '?', `cliente_rutCliente` = '?' WHERE (`idCapacitacion` = '?')");
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
            Singleton.cerrar();
        }
    }

    @Override
    public void eliminar(Capacitacion cap) throws Exception {
        try {
            Connection conn = Singleton.conectar();
            PreparedStatement stmt = conn.prepareStatement("DELETE `sprint_prev_riesgos`.`capacitacion` SET `idCapacitacion` = '?', `capFecha` = '?', `capHora` = '?', `capLugar` = '?', `capDuracion` = '?', `cliente_rutCliente` = '?' WHERE (`idCapacitacion` = '?')");
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
            Singleton.cerrar();
        }
    }

    @Override
    public List<Capacitacion> listar() throws Exception {
        List<Capacitacion> lista = null;
        try {
            Connection conn = Singleton.conectar();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM capacitacion");
            
            lista = new ArrayList();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Capacitacion cap = new Capacitacion();
                cap.setIdCapacitacion(rs.getInt("idCapacitacion")); //agregar los metodos get para imprimir. 
                cap.setCapFecha(rs.getString("capFecha"));
                cap.setCapHora(rs.getString("capHora"));
                cap.setCapLugar(rs.getString("capLugar"));
                cap.setCapDuracion(rs.getInt("capDuracion"));
                cap.setCliente_rutCliente(rs.getInt("cliente_rutCliente"));
                lista.add(cap);
            }
            //rs.close();
            //stmt.close();
            
        } catch (Exception e){
            throw e;
        } finally {
            Singleton.cerrar();
        }
        return lista;
    }

}
