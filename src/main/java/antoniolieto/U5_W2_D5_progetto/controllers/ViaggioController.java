package antoniolieto.U5_W2_D5_progetto.controllers;

import antoniolieto.U5_W2_D5_progetto.entities.Viaggio;
import antoniolieto.U5_W2_D5_progetto.enums.StatoViaggio;
import antoniolieto.U5_W2_D5_progetto.payloads.StatoViaggioUpdateDTO;
import antoniolieto.U5_W2_D5_progetto.payloads.ViaggioDTO;
import antoniolieto.U5_W2_D5_progetto.services.ViaggioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService service;

    @PostMapping
    public ResponseEntity<Viaggio> create(@RequestBody ViaggioDTO request){
        return ResponseEntity.ok(service.create(request));
    }
    @GetMapping
    public ResponseEntity<List<Viaggio>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viaggio> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PatchMapping("/{id}/stato")
    public ResponseEntity<Viaggio> updateStato(
            @PathVariable Integer id,
            @RequestBody StatoViaggioUpdateDTO request
    ) {
        StatoViaggio stato;
        try {
            stato = StatoViaggio.valueOf(request.stato().toUpperCase());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(service.updateStato(id, stato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
