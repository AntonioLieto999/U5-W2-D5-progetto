package antoniolieto.U5_W2_D5_progetto.repositories;

import antoniolieto.U5_W2_D5_progetto.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DipendenteRepository extends JpaRepository<Dipendente, Integer> {
    Optional<Dipendente> findByUsername(String username);
}
