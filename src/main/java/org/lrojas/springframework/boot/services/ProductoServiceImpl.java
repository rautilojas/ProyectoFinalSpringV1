package org.lrojas.springframework.boot.services;

import org.lrojas.springframework.boot.models.Producto;
import org.lrojas.springframework.boot.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("productoService")
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public void guardar() {
        Producto producto1 = new Producto();
        producto1.setNombre("gabinete lnz40");
        producto1.setPrecio(9000.0);
        productoRepository.save(producto1);
    }

    @Override
    public Iterable<Producto> listar() {
        return productoRepository.findAll();
    }
}