package antoniolieto.U5_W2_D5_progetto.payloads;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PrenotazioneDTO(
        @NotNull(message = "Id del dipendente obbligatorio")
        Integer dipendenteId,
        @NotNull(message = "Id del viaggio obbligatorio")
        Integer ViaggioId,
        @NotNull(message = "Data richiesta obbligatoria")
        LocalDate dataRichiesta,
        String note) {
}
