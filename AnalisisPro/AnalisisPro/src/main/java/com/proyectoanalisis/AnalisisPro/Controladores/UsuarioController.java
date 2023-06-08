package com.proyectoanalisis.AnalisisPro.Controladores;

import com.proyectoanalisis.AnalisisPro.Interfaces.InterfaceUsuario;
import com.proyectoanalisis.AnalisisPro.Modelos.ModelUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    @Autowired
    private InterfaceUsuario usuarioRepository;

    @GetMapping
    public List<ModelUsuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelUsuario> getUsuarioById(@PathVariable int id) {
        Optional<ModelUsuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{nombre_usuario}/{contraseña}")
    public ResponseEntity<Integer> validarCredenciales(@PathVariable String nombre_usuario, @PathVariable String contraseña) {
        // Lógica para validar las credenciales
        Optional<ModelUsuario> usuario = usuarioRepository.findByNombreUsuarioAndContraseña(nombre_usuario, contraseña);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(1); // Credenciales válidas
        } else {
            return ResponseEntity.ok(0); // Credenciales inválidas
        }
    }

    @PostMapping("/")
    public ResponseEntity<ModelUsuario> insertUsuario(@RequestBody ModelUsuario usuario) {
        ModelUsuario newUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(newUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelUsuario> updateUsuario(@PathVariable int id, @RequestBody ModelUsuario usuario) {
        Optional<ModelUsuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            ModelUsuario existingUsuario = usuarioOptional.get();
            existingUsuario.setIdIdentificacion(usuario.getIdIdentificacion());
            existingUsuario.setNombreUsuario(usuario.getNombreUsuario());
            existingUsuario.setContraseña(usuario.getContraseña());
            existingUsuario.setNombre(usuario.getNombre());
            existingUsuario.setApellido(usuario.getApellido());
            existingUsuario.setIdRol(usuario.getIdRol());

            ModelUsuario updatedUsuario = usuarioRepository.save(existingUsuario);
            return ResponseEntity.ok(updatedUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuarioById(@PathVariable int id) {
        Optional<ModelUsuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
            return ResponseEntity.ok("Usuario deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
