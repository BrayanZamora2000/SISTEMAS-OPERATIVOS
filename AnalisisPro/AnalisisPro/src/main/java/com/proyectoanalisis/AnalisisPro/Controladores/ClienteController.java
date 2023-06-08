package com.proyectoanalisis.AnalisisPro.Controladores;


import com.proyectoanalisis.AnalisisPro.Interfaces.InterfaceCliente;
import com.proyectoanalisis.AnalisisPro.Modelos.ModelCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private InterfaceCliente clienteRepository;

    @GetMapping
    public List<ModelCliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelCliente> getClienteById(@PathVariable Integer id) {
        Optional<ModelCliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<ModelCliente> insertCliente(@RequestBody ModelCliente cliente) {
        ModelCliente newCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(newCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelCliente> updateCliente(@PathVariable Integer id, @RequestBody ModelCliente cliente) {
        Optional<ModelCliente> clienteOptional = clienteRepository.findById(id);

        if (clienteOptional.isPresent()) {
            ModelCliente existingCliente = clienteOptional.get();
            existingCliente.setIdIdentificacion(cliente.getIdIdentificacion());
            existingCliente.setNombreCliente(cliente.getNombreCliente());
            existingCliente.setApellidoCliente(cliente.getApellidoCliente());
            existingCliente.setFechaNacimiento(cliente.getFechaNacimiento());
            existingCliente.setLugarNacimiento(cliente.getLugarNacimiento());
            existingCliente.setTelefono(cliente.getTelefono());
            existingCliente.setCorreoElectronico(cliente.getCorreoElectronico());
            existingCliente.setTituloPersona(cliente.getTituloPersona());

            ModelCliente updatedCliente = clienteRepository.save(existingCliente);
            return ResponseEntity.ok(updatedCliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClienteById(@PathVariable Integer id) {
        Optional<ModelCliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            clienteRepository.delete(cliente.get());
            return ResponseEntity.ok("Cliente deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}