/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author pliza
 */
import java.util.List;
import modelo.Cliente;


public interface DAO <T, K>{
    void insertar(T t) throws ExceptionDAO;
    void modificar(T t) throws ExceptionDAO;
    void eliminar(T t) throws ExceptionDAO;
    List<T> obtenerTodos() throws ExceptionDAO;
    T obtener(K id) throws ExceptionDAO;  
}
