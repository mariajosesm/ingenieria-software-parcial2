package gt.edu.umg.ingenieria.sistemas.parcial2.factura.service;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.CabeceraFacturaEntity;
import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.DetalleFacturaEntity;
import gt.edu.umg.ingenieria.sistemas.parcial2.factura.dao.CabeceraFacturaRepository;
import gt.edu.umg.ingenieria.sistemas.parcial2.factura.dao.DetalleFacturaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class FacturaService {

    @Autowired
    private CabeceraFacturaRepository cabeceraFacturaRepository;
    
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
    
    public List<CabeceraFacturaEntity> buscarTodasCabecerasFactura() {
        return (List<CabeceraFacturaEntity>) this.cabeceraFacturaRepository.findAll();
    }
    
    public List<DetalleFacturaEntity> buscarTodosDetallesFactura() {
        return (List<DetalleFacturaEntity>) this.detalleFacturaRepository.findAll();
    }
    
    public List<DetalleFacturaEntity> buscarTodosDetallesFactura(Long idCabeceraFactura) {
        return this.detalleFacturaRepository.findByHeader(idCabeceraFactura);
    }
    
    public CabeceraFacturaEntity registrar(CabeceraFacturaEntity c1){
        return this.cabeceraFacturaRepository.save(c1);
    }
    
    public CabeceraFacturaEntity buscarPorNit(String nit){
        CabeceraFacturaEntity c1 = this.cabeceraFacturaRepository.findCabeceraByNit(nit);
        return c1;
    }
    
public String imprimirFac(){
        
        List<CabeceraFacturaEntity> lista = (List<CabeceraFacturaEntity>) this.cabeceraFacturaRepository.findAll();
        StringBuilder s1= new StringBuilder();
        s1.append("id \t clientName \t nit \t date");
        for (CabeceraFacturaEntity e1 : lista){
            s1.append(e1.getId());
            s1.append("\t");
            s1.append(e1.getClientName());
            s1.append("\t");
            s1.append(e1.getNit());
            s1.append("\t");
            s1.append(e1.getDate());
            s1.append("\n");
        }
        return s1.toString();  
}

}
