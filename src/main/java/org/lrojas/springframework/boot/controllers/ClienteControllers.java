package org.lrojas.springframework.boot.controllers;

import org.lrojas.springframework.boot.models.Cliente;
import org.lrojas.springframework.boot.repositories.ClienteRepository;
import org.lrojas.springframework.boot.services.ClienteService;
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
public class ClienteControllers {

    @Autowired
    @Qualifier("clienteService")
    private ClienteService clienteService;

    @RequestMapping("/addCliente")
    public ResponseEntity<String> addCliente(){
        clienteService.guardar();
        return new ResponseEntity<>("guardado", HttpStatus.OK);
    }

    @RequestMapping(value="/listarClientes", method= RequestMethod.GET)
    public String listarClientes(Model model){
        model.addAttribute("titulo", "Listado de Clientes");
        model.addAttribute("clientes", clienteService.listarClientes());
        return "listarClientes";
    }

    @RequestMapping(value = "/eliminarClientes/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public ResponseEntity<String> eliminarClientes(@PathVariable("id") Integer id) {
        clienteService.eliminarClientes(id);
        return new ResponseEntity<>("Cliente eliminado correctamente.", HttpStatus.OK);
    }
}
