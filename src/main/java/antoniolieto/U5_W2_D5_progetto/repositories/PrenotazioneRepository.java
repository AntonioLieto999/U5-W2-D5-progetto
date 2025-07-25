package antoniolieto.U5_W2_D5_progetto.repositories;

import antoniolieto.U5_W2_D5_progetto.entities.Dipendente;
import antoniolieto.U5_W2_D5_progetto.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
    boolean existsByDipendenteAndDataRichiesta(Dipendente dipendente, LocalDate dataRichiesta);
}
