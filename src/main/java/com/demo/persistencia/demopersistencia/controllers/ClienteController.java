package com.demo.persistencia.demopersistencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.persistencia.demopersistencia.dto.ClienteDTO;
import com.demo.persistencia.demopersistencia.entidades.Cliente;
import com.demo.persistencia.demopersistencia.services.ClienteServicio;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // pruebas locales
public class ClienteController {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/listarClientes")
    public List<Cliente> consultarClientes() {
        return clienteServicio.obtenerTodos();
    }

    @GetMapping("/cliente/{id}")
    public Cliente consultarClientePorId(@PathVariable Long id) {
        return clienteServicio.obtenerPorId(id);
    }

    @PostMapping("/registrarCliente")
    public Cliente registrarCliente(@RequestBody ClienteDTO clienteJson) {
        Cliente cliente = new Cliente();
        
        cliente.setNombre(clienteJson.getNombre());
        cliente.setDireccion(clienteJson.getDireccion());
        cliente.setNit(clienteJson.getNit());


        System.out.println("Valor a persistir: " + cliente.toString());

        return clienteServicio.crearCliente(cliente);
    }

    @PutMapping("/actualizarCliente/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteJson) {
        Cliente clienteActualizado = clienteServicio.actualizarCliente(id, clienteJson);
        System.out.println("Cliente actualizado: " + clienteActualizado);
        return clienteActualizado;
    }

    @DeleteMapping("/eliminarCliente/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteServicio.eliminarCliente(id);
        System.out.println("Cliente con ID " + id + " eliminado");
    }

}
