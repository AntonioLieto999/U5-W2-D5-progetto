package antoniolieto.U5_W2_D5_progetto.exceptions;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ValidationException extends RuntimeException {

    private List<String> errorMessages;

    public ValidationException(List<String> errorMessages) {
        super("Errori vari di validazione!");
        this.errorMessages = errorMessages;
    }
}

