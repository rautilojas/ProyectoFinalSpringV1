package org.lrojas.springframework.boot.controllers;

import org.lrojas.springframework.boot.models.Cliente;
import org.lrojas.springframework.boot.models.Producto;
import org.lrojas.springframework.boot.repositories.ProductoRepository;
import org.lrojas.springframework.boot.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;

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

    @GetMapping(value = "/agregarProducto")
    public String agregarProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "productos/agregar_producto";
    }

    @RequestMapping(value = "/guardarProducto", method = RequestMethod.POST)
    public String guardarProducto(Producto producto){
        productoService.guardar(producto);
        return "redirect:/listarProductos";
    }

    @RequestMapping(value="/listarProductos", method= RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Productos");
        model.addAttribute("productos", productoService.listar());
        return "productos/listarProductos";
    }

    /*Agregar un producto Nuevo*/

    /*Metodo que se ejecuta al presionar el boton Editar para un Producto de la lista
     * Abre el formulario de Edicion*/
    @GetMapping(value="/editarProductos/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model){
        model.addAttribute("producto",productoService.buscarPorId(id).orElse(null));
        return "productos/editar_producto";
    }

    /*import javax.validation.Valid;*/
    /*Ejecutar el guardado de los cambios hechos en el formulario mediante el Boton Guardar*/
    @PostMapping(value = "/editarProductos/{id}")
    public String actualizarProducto(@ModelAttribute Producto producto, BindingResult bindingResult, RedirectAttributes redirectAttrs) {

        productoService.actualizarProducto(producto);
        redirectAttrs
                .addFlashAttribute("mensaje", "Editado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/listarProductos";
    }

    /*Eliminar Producto byID*/
    @RequestMapping(value="/eliminarProductos/{id}", method= RequestMethod.GET)
    public String eliminar(@PathVariable(value = "id") int id){
        if(id > 0){
            productoService.eliminarPorId(id);
        }
        return "redirect:/listarProductos";
    }
}