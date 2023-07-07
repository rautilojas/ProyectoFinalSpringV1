package org.lrojas.springframework.boot.services;

import org.lrojas.springframework.boot.models.Producto;
import org.lrojas.springframework.boot.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public void guardar() {
        Producto producto1 = new Producto();
        producto1.setNombre("Moto Honda Biz 125");
        producto1.setPrecio(15000.0);
        productoRepository.save(producto1);
    }
}