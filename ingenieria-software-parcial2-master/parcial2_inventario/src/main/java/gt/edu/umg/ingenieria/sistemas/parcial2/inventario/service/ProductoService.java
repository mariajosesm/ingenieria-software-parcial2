package gt.edu.umg.ingenieria.sistemas.parcial2.inventario.service;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.ProductoEntity;
import gt.edu.umg.ingenieria.sistemas.parcial2.inventario.dao.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    
    public ProductoEntity registrar(ProductoEntity p1){
        return this.productoRepository.save(p1);
    }
    
    public List<ProductoEntity> buscarTodos() {
        return (List<ProductoEntity>) this.productoRepository.findAll();
    }

    public ProductoEntity actualizarStock(Long id, Integer stock){
        ProductoEntity p1 = this.productoRepository.findById(id).get();
        p1.setStock(stock);
        return this.productoRepository.save(p1);
    }    
}
