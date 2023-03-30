package Interface;

import java.util.List;

public interface CRUD<Generico> {
    
    public void registrar(Generico gen) throws Exception;
    public void modificar(Generico gen) throws Exception;
    public void eliminar(Generico gen) throws Exception;
    public List<Generico> listar() throws Exception;
}
