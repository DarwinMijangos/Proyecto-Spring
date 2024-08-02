import org.springframework.stereotype.Service;
import com.darwinmijangos.webapp.biblioteca.model.Categoria;
import com.darwinmijangos.webapp.biblioteca.repository.CategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService{
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarCategoriaPorId(Long id){
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Long id){
        categoriaRepository.deleteById(id);
    }
}
