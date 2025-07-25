package antoniolieto.U5_W2_D5_progetto.repositories;

import antoniolieto.U5_W2_D5_progetto.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneRepository extends JpaRepository<Viaggio, Integer> {
}
