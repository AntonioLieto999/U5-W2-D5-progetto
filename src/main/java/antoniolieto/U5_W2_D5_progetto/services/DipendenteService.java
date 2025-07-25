package antoniolieto.U5_W2_D5_progetto.services;

import antoniolieto.U5_W2_D5_progetto.entities.Dipendente;
import antoniolieto.U5_W2_D5_progetto.exceptions.ResourceNotFoundException;
import antoniolieto.U5_W2_D5_progetto.payloads.DipendenteDTO;
import antoniolieto.U5_W2_D5_progetto.repositories.DipendenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DipendenteService {
    private DipendenteRepository repo;

    public Dipendente create(DipendenteDTO req){
        Dipendente d = new Dipendente();
        d.setUsername(req.username());
        d.setNome(req.cognome());
        d.setEmail(req.email());
        return repo.save(d);
    }
    public Dipendente get(Integer id){
        return repo.findById(id).orElseThrow(() ->
        new ResourceNotFoundException("Dipendente con ID " + id + "non trovato"));
    }
    public List<Dipendente> getAll(){
        return repo.findAll();
    }
    public void delete(Integer id){
        if (!repo.existsById(id)){
            throw new ResourceNotFoundException("Dipendente con ID " + id + " non trovato");
        }
        repo.deleteById(id);
    }
    public Dipendente update(Integer id, DipendenteDTO req){
        Dipendente d = get(id);
        d.setNome(req.nome());
        d.setCognome(req.cognome());
        d.setEmail(req.email());
        return repo.save(d);
    }
}
