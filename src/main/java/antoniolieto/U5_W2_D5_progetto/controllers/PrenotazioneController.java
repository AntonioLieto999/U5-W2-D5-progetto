package antoniolieto.U5_W2_D5_progetto.controllers;

import antoniolieto.U5_W2_D5_progetto.entities.Prenotazione;
import antoniolieto.U5_W2_D5_progetto.payloads.PrenotazioneDTO;
import antoniolieto.U5_W2_D5_progetto.services.PrenotazioneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {
    @Autowired
    private PrenotazioneService service;

    @PostMapping
    public ResponseEntity<Prenotazione> create(@RequestBody @Valid PrenotazioneDTO request){
        return ResponseEntity.ok(service.creaPrenotazione(request));
    }

    @GetMapping
    public ResponseEntity<List<Prenotazione>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
}
