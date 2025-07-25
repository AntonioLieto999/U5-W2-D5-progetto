package antoniolieto.U5_W2_D5_progetto.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DipendenteDTO(
        @NotBlank(message = "Username obbligatorio")
        String username,
        @NotBlank(message = "Nome obbligatorio")
        String nome,
        @NotBlank(message = "Cognome obbligatorio")
        String cognome,
        @Email
        @NotBlank(message = "Email obbligatoria")
        String email) {
}
