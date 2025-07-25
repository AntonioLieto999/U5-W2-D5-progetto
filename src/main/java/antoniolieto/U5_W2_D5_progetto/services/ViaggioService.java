package antoniolieto.U5_W2_D5_progetto.services;

import antoniolieto.U5_W2_D5_progetto.entities.Viaggio;
import antoniolieto.U5_W2_D5_progetto.enums.StatoViaggio;
import antoniolieto.U5_W2_D5_progetto.exceptions.ResourceNotFoundException;
import antoniolieto.U5_W2_D5_progetto.payloads.ViaggioDTO;
import antoniolieto.U5_W2_D5_progetto.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ViaggioService {
    @Autowired
    private ViaggioRepository repo;
    public Viaggio create(ViaggioDTO req){
        Viaggio v = new Viaggio();
        v.setDestinazione(req.destinazione());
        v.setData(req.data());
        v.setStato(StatoViaggio.IN_PROGRAMMA);
        return repo.save(v);
    }
    public Viaggio get(Integer id){
        return repo.findById(id).orElseThrow(() ->
        new ResourceNotFoundException("Viaggio con ID " + id + "non trovato"));
    }
    public List<Viaggio> getAll(){
        return repo.findAll();
    }
    public void delete(Integer id){
        if (!repo.existsById(id)){
            throw new ResourceNotFoundException("viaggio con ID " + id + "non trovato");
        }
        repo.deleteById(id);
    }
    public Viaggio updateStato(Integer id, StatoViaggio stato){
        Viaggio v = get(id);
        v.setStato(stato);
        return repo.save(v);
    }
}
