package org.lrojas.springframework.boot.controllers;

import org.lrojas.springframework.boot.models.Producto;
import org.lrojas.springframework.boot.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;

@Controller
public class ProductoControllers {

    @Autowired
    private ProductoRepository productoRepository;

    @RequestMapping("/addProducto")
    //Vamos a agregar la notacion de PathVariable que nos permitira tomar desde la url del navegador un valor.
    public ResponseEntity<String> addProducto(){
        Producto producto1 = new Producto();
        producto1.setNombre("Moto Honda Biz 125");
        producto1.setPrecio(15000.0);

        productoRepository.save(producto1);


        return new ResponseEntity<>("guardado", HttpStatus.OK);
    }

}