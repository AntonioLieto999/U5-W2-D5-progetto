package antoniolieto.U5_W2_D5_progetto.services;

import antoniolieto.U5_W2_D5_progetto.entities.Dipendente;
import antoniolieto.U5_W2_D5_progetto.entities.Prenotazione;
import antoniolieto.U5_W2_D5_progetto.entities.Viaggio;
import antoniolieto.U5_W2_D5_progetto.exceptions.BadRequestException;
import antoniolieto.U5_W2_D5_progetto.payloads.PrenotazioneDTO;
import antoniolieto.U5_W2_D5_progetto.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository repo;

    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    ViaggioService viaggioService;

    public Prenotazione creaPrenotazione(PrenotazioneDTO req) {
        Dipendente dip = dipendenteService.get(req.dipendenteId());
        Viaggio viaggio = viaggioService.get(req.ViaggioId());

        if(repo.existsByDipendenteAndDataRichiesta(dip, req.dataRichiesta())){
            throw new BadRequestException("Il dipendente ha gia una prenotazione per il giorno " + req.dataRichiesta());
        }
        Prenotazione p = new Prenotazione();
        p.setDipendente(dip);
        p.setViaggio(viaggio);
        p.setDataRichiesta(req.dataRichiesta());
        p.setNote(req.note());
        return repo.save(p);
    }
    public List<Prenotazione> getAll(){
        return repo.findAll();
    }

}
