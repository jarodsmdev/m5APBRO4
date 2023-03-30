/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import conexion.ConexionSingleton;
import dto.Capacitacion;
import java.sql.*;
import java.util.Calendar;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Yo
 */
@WebServlet(name = "SvListarCapacitacion", urlPatterns = {"/SvListarCapacitacion"})
public class SvListarCapacitacion extends HttpServlet {

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
            out.println("<title>Servlet SvListarCapacitacion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvListarCapacitacion at " + request.getContextPath() + "</h1>");
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
        List<Capacitacion>listaCapacitacion = new ArrayList<>();
       
        HttpSession session = request.getSession();
        
        if(session.getAttribute("nombre") == null){
            response.sendRedirect(request.getContextPath() + "/SvLogin");
        }
        else {
            try {
                //1. CREO U OBTENGO LA CONEXION
                Connection conn = ConexionSingleton.getConexion();
                //2. CREAR OBJETO STATEMENT
                Statement st = conn.createStatement();
                //3. CREAR LA SENTENCIA SQL
                String querySQL = "SELECT * FROM Capacitacion;";
                //4. EJECUTAR 
                ResultSet rs = st.executeQuery(querySQL);
                //5. RECORRER RESULTSET
                while(rs.next()){
                    //LEER CADA CAMPO, PARA CREAR OBJETO CAPACITACION EN CADA ITERACIÓN
                    Capacitacion capacitacion = new Capacitacion();

                    capacitacion.setId(rs.getInt("idCapacitacion"));
                    capacitacion.setFecha(rs.getDate("capFecha"));
                    capacitacion.setHora(rs.getString("capHora"));
                    capacitacion.setLugar(rs.getString("capLugar"));
                    capacitacion.setDuracion(rs.getInt("capDuracion"));
                    capacitacion.setRutCliente(rs.getInt("cliente_rutCliente"));

                    //AÑADIR OBJETO CAPACITACION AL ARRAY
                    listaCapacitacion.add(capacitacion);

                }
                
                //6. ENVIAR EL ARRAYLIST CAPACITACION A LA VISTA COMO PARÁMETRO
                request.setAttribute("listaCapacitacion", listaCapacitacion);
                
                //7. REDIRECCIONAR
                RequestDispatcher dispatcher = request.getRequestDispatcher("SECCIONES/listarCapacitacion.jsp");
                dispatcher.forward(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(SvListarCapacitacion.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                //5. CERRAR LA CONEXION A LA BBDD
                //ConexionSingleton.close();
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
        processRequest(request, response);
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
