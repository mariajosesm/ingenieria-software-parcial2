package gt.edu.umg.ingenieria.sistemas.parcial2.factura.controller;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.CabeceraFacturaEntity;
import gt.edu.umg.ingenieria.sistemas.parcial2.factura.service.FacturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cabeceraFactura")
public class CabeceraFacturaController {

    @Autowired
    private FacturaService facturaService;
    
    @GetMapping("/buscarTodas")
    public List<CabeceraFacturaEntity> buscarTodas() {
        return this.facturaService.buscarTodasCabecerasFactura();
    }
    
    @PostMapping("/crearFactura")
    public CabeceraFacturaEntity registrar(@RequestBody(required = true) CabeceraFacturaEntity c1){
        return this.facturaService.registrar(c1);
    }
    
    @GetMapping("/buscarPorNit")
    public CabeceraFacturaEntity buscarPorNit(String nit){
        return this.facturaService.buscarPorNit(nit);
    }
    
    @GetMapping("/imprimir")
    public String reporte(){
        return this.facturaService.imprimirFac();
    }
    
}
