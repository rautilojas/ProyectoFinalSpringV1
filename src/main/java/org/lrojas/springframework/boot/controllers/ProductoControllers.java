package org.lrojas.springframework.boot.controllers;

import org.lrojas.springframework.boot.models.Producto;
import org.lrojas.springframework.boot.repositories.ProductoRepository;
import org.lrojas.springframework.boot.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;


@Controller
public class ProductoControllers {

    //Autowired esta
    @Autowired
    @Qualifier("productoService")
    private ProductoService productoService;


    @RequestMapping("/addProducto")
    //Vamos a agregar la notacion de PathVariable que nos permitira tomar desde la url del navegador un valor.
    public ResponseEntity<String> addProducto(){
        productoService.guardar();
        return new ResponseEntity<>("guardado", HttpStatus.OK);
    }

    @RequestMapping(value="/listarProductos", method= RequestMethod.GET)
    public String listarProductos(Model model){
        model.addAttribute("titulo", "Listado de Productos");
        model.addAttribute("productos", productoService.listarProductos());
        return "listarProductos";
    }

    @RequestMapping(value = "/eliminarProductos/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public ResponseEntity<String> eliminarProductos(@PathVariable("id") Integer id) {
        productoService.eliminarProductos(id);
        return new ResponseEntity<>("Producto eliminado exitosamente.", HttpStatus.OK);
    }

}