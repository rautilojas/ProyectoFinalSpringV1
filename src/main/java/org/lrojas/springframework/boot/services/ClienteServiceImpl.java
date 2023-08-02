package org.lrojas.springframework.boot.services;

import org.lrojas.springframework.boot.models.Cliente;
import org.lrojas.springframework.boot.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("clienteService")
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void guardar() {
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Martin");
        cliente1.setApellido("Garcia");
        cliente1.setDni("37648890");
        cliente1.setEmail("martigarc@gmail.com");
        clienteRepository.save(cliente1);
    }

    @Override
    public Iterable<Cliente> listarClientes(){return clienteRepository.findAll();}

    @Override
    public void eliminarClientes(Integer id) {
        clienteRepository.deleteById(id);
    }

}
