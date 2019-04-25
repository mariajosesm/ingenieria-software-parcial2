/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.sistemas.parcial2.factura.service;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.DetalleFacturaEntity;
import gt.edu.umg.ingenieria.sistemas.parcial2.factura.dao.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mariajose
 */
@Service
public class DetalleFacturaService {
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
    
    public DetalleFacturaEntity registrar(DetalleFacturaEntity d1){
        return this.detalleFacturaRepository.save(d1);
    }
      
    
}
