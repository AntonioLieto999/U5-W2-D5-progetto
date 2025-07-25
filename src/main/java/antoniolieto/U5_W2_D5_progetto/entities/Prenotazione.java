package antoniolieto.U5_W2_D5_progetto.entities;

import jakarta.persistence.*;
import org.springframework.context.annotation.EnableMBeanExport;

import java.time.LocalDate;

@Entity
public class Prenotazione {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_viaggio")
    private Dipendente dipendente;
    @ManyToOne
    @JoinColumn(name = "id_prenotazione")
    private Viaggio viaggio;
    private LocalDate dataRichiesta;
    private String note;

    public Prenotazione(Dipendente dipendente, Viaggio viaggio, LocalDate dataRichiesta, String note) {
        this.dipendente = dipendente;
        this.viaggio = viaggio;
        this.dataRichiesta = dataRichiesta;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public Viaggio getViaggio() {
        return viaggio;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }

    public LocalDate getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(LocalDate dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
