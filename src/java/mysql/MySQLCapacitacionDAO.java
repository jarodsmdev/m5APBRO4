/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysql;
import conexion.ConexionSingleton;
import DAO.ExceptionDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Capacitacion;
import DAO.CapacitacionDAO;

/**
 *
 * @author pliza
 */
public class MySQLCapacitacionDAO implements CapacitacionDAO{

    final String INSERT = "INSERT INTO Capacitacion(capFecha, capHora, capLugar, capDuracion, cliente_rutCliente) VALUES(?, ?, ?, ? ,?);";
    final String UPDATE = "UPDATE Capacitacion SET capFecha = ?, capHora = ?, capLugar = ?, capDuracion = ?, cliente_rutCliente = ? WHERE idCapacitacion = ?;";
    final String DELETE = "DELETE FROM Capacitacion WHERE idCapacitacion = ?;";
    final String GETALL = "SELECT * FROM Capacitacion;";
    final String GETONE = "SELECT * FROM Capacitacion WHERE idCapacitacion = ?;";

    private Connection conn;

    public MySQLCapacitacionDAO(Connection conn){
        this.conn = ConexionSingleton.getConexion();
    }

    @Override
    public void insertar(Capacitacion c) throws ExceptionDAO {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(INSERT);
            st.setDate(1, new Date(c.getFecha().getTime()));
            st.setString(2, c.getHora());
            st.setString(3, c.getLugar());
            st.setInt(4, c.getDuracion());
            st.setInt(5, c.getRutCliente());

            if(st.executeUpdate() == 0){
                throw new ExceptionDAO("No se ha guardado el Registro.");
            }

        }catch(SQLException ex){
            throw new ExceptionDAO("Error en SQL", ex);
        } finally{
            if(st != null){
                try{
                    st.close();
                }catch(SQLException ex){
                    throw new ExceptionDAO("Error en SQL", ex);
                }
            }
        }
    }

    @Override
    public void modificar(Capacitacion c) {

    }

    @Override
    public void eliminar(Capacitacion c) {

    }

    private Capacitacion convertirObjeto(ResultSet rs) throws SQLException{

        Capacitacion capacitacion = new Capacitacion();

        capacitacion.setId(rs.getInt("idCapacitacion"));
        capacitacion.setFecha(rs.getDate("capFecha"));
        capacitacion.setHora(rs.getString("capHora"));
        capacitacion.setLugar(rs.getString("capLugar"));
        capacitacion.setDuracion(rs.getInt("capDuracion"));
        capacitacion.setRutCliente(rs.getInt("cliente_rutCliente"));

        return capacitacion;
    }

    @Override
    public List<Capacitacion> obtenerTodos() throws ExceptionDAO{
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Capacitacion> listaCapacitacion = new ArrayList<>();
        try{
            st = conn.prepareStatement(GETALL);
            rs = st.executeQuery();
            while(rs.next()){
                listaCapacitacion.add(convertirObjeto(rs));
            }


        }catch(SQLException ex){
            throw new ExceptionDAO("Error en SQL", ex);
        }finally{
            if(rs != null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    new ExceptionDAO("Error en SQL", ex);
                }
            }
            if(st != null){
                try {
                    st.close();
                } catch (SQLException ex) {
                   new ExceptionDAO("Error en SQL", ex);
                }
            }
        }
        return listaCapacitacion;
    }

    @Override
    public Capacitacion obtener(Integer id) throws ExceptionDAO {
        PreparedStatement st = null;
        ResultSet rs = null;
        Capacitacion c = null;
        try{
            st = conn.prepareStatement(GETONE);
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                c = convertirObjeto(rs);
            }else{
                throw new ExceptionDAO("No se ha encontrado ese registro.");
            }
        }catch(SQLException ex){
            throw new ExceptionDAO("Error en SQL", ex);
        }finally{
            if(rs != null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    new ExceptionDAO("Error en SQL", ex);
                }
            }
            if(st != null){
                try {
                    st.close();
                } catch (SQLException ex) {
                   new ExceptionDAO("Error en SQL", ex);
                }
            }
        }
        return c;
    }

}
