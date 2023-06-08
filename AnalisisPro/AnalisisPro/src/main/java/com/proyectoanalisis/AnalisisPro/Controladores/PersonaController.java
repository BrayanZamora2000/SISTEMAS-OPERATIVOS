package com.proyectoanalisis.AnalisisPro.Controladores;

import com.proyectoanalisis.AnalisisPro.Interfaces.InterfacePersona;
import com.proyectoanalisis.AnalisisPro.Modelos.ModelPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired
    private InterfacePersona personaRepository;

    @GetMapping
    public List<ModelPersona> getAllPersonas() {
        return personaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelPersona> getPersonaById(@PathVariable Integer id) {
        Optional<ModelPersona> persona = personaRepository.findByIdIdentificacion(id);
        if (persona.isPresent()) {
            return ResponseEntity.ok(persona.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<ModelPersona> insertPersona(@RequestBody ModelPersona persona) {
        ModelPersona newPersona = personaRepository.save(persona);
        return ResponseEntity.ok(newPersona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelPersona> updatePersona(@PathVariable Integer id, @RequestBody ModelPersona persona) {
        Optional<ModelPersona> personaOptional = personaRepository.findByIdIdentificacion(id);

        if (personaOptional.isPresent()) {
            ModelPersona existingPersona = personaOptional.get();
            existingPersona.setNombre(persona.getNombre());
            existingPersona.setApellido(persona.getApellido());
            existingPersona.setFechaNacimiento(persona.getFechaNacimiento());
            existingPersona.setLugarNacimiento(persona.getLugarNacimiento());
            existingPersona.setTituloPersona(persona.getTituloPersona());

            ModelPersona updatedPersona = personaRepository.save(existingPersona);
            return ResponseEntity.ok(updatedPersona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonaById(@PathVariable Integer id) {
        Optional<ModelPersona> persona = personaRepository.findByIdIdentificacion(id);
        if (persona.isPresent()) {
            personaRepository.delete(persona.get());
            return ResponseEntity.ok("Persona deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
