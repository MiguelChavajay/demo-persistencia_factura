package com.demo.persistencia.demopersistencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.persistencia.demopersistencia.dto.ClienteDTO;
import com.demo.persistencia.demopersistencia.entidades.Cliente;
import com.demo.persistencia.demopersistencia.repositorio.ClienteRepository;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Consulta todos los clientes.
     * 
     * @return lista de clientes.
     */
    public List<Cliente> obtenerTodos() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    /**
     * Consulta un cliente por su ID.
     * 
     * @param id
     * @return cliente encontrado o null.
     */
    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    /**
     * Registra un nuevo cliente.
     * 
     * @param cliente
     * @return cliente registrado.
     */
    public Cliente crearCliente(Cliente cliente) {
        System.out.println("Servicio trae: " + cliente.toString());
        return clienteRepository.save(cliente);
    }

    /**
     * Actualiza un cliente existente.
     * 
     * @param id
     * @param clienteNuevo
     * @return cliente actualizado o null.
     */
    public Cliente actualizarCliente(Long id, ClienteDTO clienteNuevo) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNombre(clienteNuevo.getNombre());
            cliente.setDireccion(clienteNuevo.getDireccion());
            cliente.setNit(clienteNuevo.getNit());
            System.out.println("Cliente actualizado: " + cliente);
            return clienteRepository.save(cliente);
        }).orElse(null);
    }

    /**
     * Elimina un cliente por su ID.
     * 
     * @param id
     */
    public void eliminarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            System.out.println("Cliente con ID " + id + " eliminado");
        }
    }

}
