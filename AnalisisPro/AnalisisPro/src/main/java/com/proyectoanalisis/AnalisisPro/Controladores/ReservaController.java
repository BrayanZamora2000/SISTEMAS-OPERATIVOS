package com.proyectoanalisis.AnalisisPro.Controladores;

import com.proyectoanalisis.AnalisisPro.Interfaces.InterfaceReserva;
import com.proyectoanalisis.AnalisisPro.Modelos.ModelReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private InterfaceReserva reservaRepository;

    @GetMapping
    public List<ModelReserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelReserva> getReservaById(@PathVariable Integer id) {
        Optional<ModelReserva> reserva = reservaRepository.findById(id);
        if (reserva.isPresent()) {
            return ResponseEntity.ok(reserva.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<ModelReserva> insertReserva(@RequestBody ModelReserva reserva) {
        ModelReserva newReserva = reservaRepository.save(reserva);
        return ResponseEntity.ok(newReserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelReserva> updateReserva(@PathVariable Integer id, @RequestBody ModelReserva reserva) {
        Optional<ModelReserva> reservaOptional = reservaRepository.findById(id);

        if (reservaOptional.isPresent()) {
            ModelReserva existingReserva = reservaOptional.get();
            existingReserva.setIdCliente(reserva.getIdCliente());
            existingReserva.setNumReserva(reserva.getNumReserva());
            existingReserva.setNumVuelo(reserva.getNumVuelo());
            existingReserva.setNumSalida(reserva.getNumSalida());
            existingReserva.setDestino(reserva.getDestino());
            existingReserva.setHoraSalida(reserva.getHoraSalida());
            existingReserva.setHoraLlegada(reserva.getHoraLlegada());
            existingReserva.setFechaSalida(reserva.getFechaSalida());
            existingReserva.setFechaLlegada(reserva.getFechaLlegada());

            ModelReserva updatedReserva = reservaRepository.save(existingReserva);
            return ResponseEntity.ok(updatedReserva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservaById(@PathVariable Integer id) {
        Optional<ModelReserva> reserva = reservaRepository.findById(id);
        if (reserva.isPresent()) {
            reservaRepository.delete(reserva.get());
            return ResponseEntity.ok("Reserva deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
