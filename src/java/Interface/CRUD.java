/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import clases.Capacitacion;
import java.util.List;

/**
 *
 * @author Gronorf
 */
public interface CRUD<Generico> {
    
    public void registrar(Generico gen) throws Exception;
    public void modificar(Generico gen) throws Exception;
    public void eliminar(Generico gen) throws Exception;
    public List<Generico> listar() throws Exception;
}
