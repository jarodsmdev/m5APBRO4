/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysql;
import conexion.ConexionSingleton;
import DAO.CapacitacionDAO;
import DAO.ClienteDAO;
import DAO.ExceptionDAO;
import DAO.ManagerDAO;
import java.sql.*;
import java.util.List;
import modelo.Capacitacion;
/**
 *
 * @author pliza
 */
public class MySQLManagerDAO implements ManagerDAO{
    private Connection conn;

    private CapacitacionDAO capacitacion = null;
    private ClienteDAO cliente = null;

    public MySQLManagerDAO(){
        conn = ConexionSingleton.getConexion();
    };

    @Override
    public CapacitacionDAO getCapacitacionDAO() {
        if(capacitacion ==  null){
            capacitacion = new MySQLCapacitacionDAO(conn);
        }
        return capacitacion;
    }

    @Override
    public ClienteDAO getClienteDAO() {
        if(cliente == null){
            cliente = new MySQLClienteDAO(conn);
        }
        return cliente;
    }

    /*public static void main(String[] args) throws SQLException, DAOException{
        MySQLDaoManager man = new MySQLDaoManager();
        List<Capacitacion> capacitaciones = man.getCapacitacionDAO().obtenerTodos();
        System.out.println(capacitaciones);
    }
    */
}