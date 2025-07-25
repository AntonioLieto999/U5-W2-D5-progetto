package antoniolieto.U5_W2_D5_progetto.controllers;

import antoniolieto.U5_W2_D5_progetto.entities.Dipendente;
import antoniolieto.U5_W2_D5_progetto.payloads.DipendenteDTO;
import antoniolieto.U5_W2_D5_progetto.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {
    @Autowired
    private DipendenteService service;

    @PostMapping
    public ResponseEntity<Dipendente> create(@RequestBody DipendenteDTO request){
        return ResponseEntity.ok(service.create(request));
    }
    @GetMapping
    public ResponseEntity<List<Dipendente>> getAll(){
        return  ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dipendente> update(@PathVariable Integer id, @RequestBody  DipendenteDTO request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
