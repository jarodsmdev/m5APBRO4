/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import conexion.ConexionSingleton;
import java.sql.*;
import dto.Cliente;
import java.time.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jarod
 */
@WebServlet(name = "SvCapacitacion", urlPatterns = {"/SvCapacitacion"})
public class SvCapacitacion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvCapacitacion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvCapacitacion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.getAttribute("nombre") == null){
            response.sendRedirect(request.getContextPath() + "/SvLogin");
        }
        else {
            //MISSION: ENVIAR LOS CLIENTES EXISTENTES AL COMBOBOX
            
            //CREA LISTA DE OBJETOS CLIENTE
            List<Cliente>listaClientes = new ArrayList<>();

            try {
                
                //1. CREAR CONEXION BD
                Connection conn = ConexionSingleton.getConexion();
                //2. CREAR OBJETO STATEMENT
                Statement st = conn.createStatement();
                //3. CREAR LA SENTENCIA SQL
                String querySQL = "SELECT id, rutCliente, CliNombres, CliApellidos FROM Cliente";
                //4. EJECUTAR LA QUERY
                ResultSet rs = st.executeQuery(querySQL);
                //5. RECORRER EL RESULTSET
                while(rs.next()){
                    //5.a LEER CADA CAMPO, PARA CREAR OBJETO CLIENTE EN CADA ITERACIÓN
                    Cliente cliente = new Cliente();

                    cliente.setId(rs.getInt("id"));
                    cliente.setRut(rs.getInt("rutCliente"));
                    cliente.setNombre(rs.getString("CliNombres"));
                    cliente.setApellido(rs.getString("CliApellidos"));

                    //5.a AÑADIR CLIENTE A LA LISTA
                    listaClientes.add(cliente);
                    
                }

                //6. ENVIAR EL ARRAYLIST CLIENTES A LA VISTA COMO PARÁMETRO
                request.setAttribute("listaClientes", listaClientes);

                //7. REDIRECCIONAR
                RequestDispatcher dispatcher = request.getRequestDispatcher("SECCIONES/capacitacion.jsp");
                dispatcher.forward(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(SvCapacitacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //processRequest(request, response);
            
            //1. RESCATAR LOS DATOS DEL REQUEST
            //TODO: CAMBIAR EL TIPO DE DATOS Y VALIDAR
            int rut = Integer.parseInt(request.getParameter("rutCliente"));
            String fecha = request.getParameter("fecha");
            String hora = request.getParameter("hora");
            String lugar = request.getParameter("lugar");
            int duracion = Integer.parseInt(request.getParameter("duracion"));
            String qAsistentes = request.getParameter("cantAsistentes");
            
            //2. CREAR CONEXION
            Connection conn = ConexionSingleton.getConexion();
            //3. CREAR SENTENCIA SQL
            String querySQL = "INSERT INTO Capacitacion(capFecha, capHora, capLugar, capDuracion, cliente_rutCliente) VALUES(?, ?, ?, ? ,?);";
            //4. CREAR OBJETO PREPAREDSTATEMENT
            PreparedStatement st = conn.prepareStatement(querySQL);
            st.setString(1, fecha);
            st.setString(2, hora);
            st.setString(3, lugar);
            st.setInt(4, duracion);
            st.setInt(5, rut);

            //5. EJECUTAR CONSULTA SQL
            int resultado = st.executeUpdate();
            
            if (resultado > 0) {
                System.out.println("El registro ha sido insertado exitosamente");
                request.setAttribute("mensaje", "Registro Guardado exitosamente");
            } else {
                System.out.println("No se ha insertado ningún registro");
            }
            
            //6. REDIRECCIONAR
            RequestDispatcher dispatcher = request.getRequestDispatcher("SECCIONES/capacitacion.jsp");
            dispatcher.forward(request, response);
            System.out.println("REGISTRO GUARDADO CON ÉXITO");
            
        } catch (SQLException ex) {
            Logger.getLogger(SvCapacitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
