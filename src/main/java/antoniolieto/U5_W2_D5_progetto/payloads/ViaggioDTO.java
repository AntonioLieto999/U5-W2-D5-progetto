package antoniolieto.U5_W2_D5_progetto.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ViaggioDTO(
        @NotBlank(message = "Destinazione obbligatoria")
        String destinazione,
        @NotNull(message = "Data obbligatoria")
        LocalDate data) {
}
