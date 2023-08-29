package org.lrojas.springframework.boot.controllers;

import org.lrojas.springframework.boot.models.Cliente;
import org.lrojas.springframework.boot.models.Producto;
import org.lrojas.springframework.boot.repositories.ClienteRepository;
import org.lrojas.springframework.boot.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClienteControllers {
    //Autowired esta
    @Autowired
    @Qualifier("clienteService")
    private ClienteService clienteService;


    @RequestMapping("/addCliente")
    //Vamos a agregar la notacion de PathVariable que nos permitira tomar desde la url del navegador un valor.
    public ResponseEntity<String> addCliente(){
        clienteService.guardar();
        return new ResponseEntity<>("guardado", HttpStatus.OK);
    }

    @RequestMapping(value = "/agregarCliente")
    public String agregarCliente(Model model){
        model.addAttribute("cliente", new Cliente());
        return "clientes/agregar_cliente";
    }

    @RequestMapping(value = "/guardarCliente", method = RequestMethod.POST)
    public String guardarCliente(Cliente cliente){
        clienteService.guardar(cliente);
        return "redirect:/listarClientes";
    }

    @RequestMapping(value="/listarClientes", method= RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Clientes");
        model.addAttribute("clientes", clienteService.listar());
        return "clientes/listarClientes";
    }

    @GetMapping(value="/editarClientes/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model){
        model.addAttribute("cliente",clienteService.buscarPorId(id).orElse(null));
        return "clientes/editar_cliente";
    }

    @PostMapping(value = "/editarClientes/{id}")
    public String actualizarCliente(@ModelAttribute Cliente cliente, BindingResult bindingResult, RedirectAttributes redirectAttrs) {

        clienteService.actualizarCliente(cliente);
        redirectAttrs
                .addFlashAttribute("mensaje", "Editado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/listarClientes";
    }

    @RequestMapping(value="/eliminarClientes/{id}", method= RequestMethod.GET)
    public String eliminar(@PathVariable(value = "id") int id){
        if(id > 0){
            clienteService.eliminarPorId(id);
        }
        return "redirect:/listarClientes";
    }

}