package antoniolieto.U5_W2_D5_progetto.payloads;

import jakarta.validation.constraints.NotBlank;

public record StatoViaggioUpdateDTO(
        @NotBlank(message = "Stato obbligatorio")
        String stato) {
}
