import java.util.List;
import com.darwinmijangos.webapp.biblioteca.model;

public interface ICategoriaService {
    
    public List<Categoria> listarCategorias();
    
    public Categoria buscarCategoriaPorId();

    public void guardarCategoria(Categoria categoria);

    public void eliminarCategoria(Categoria categoria);
}
