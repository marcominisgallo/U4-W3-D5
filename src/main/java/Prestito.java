import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Utente utente;

    @ManyToOne
    private ElementoCatalogo elementoPrestato;

    private LocalDate dataInizio;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;

    public Prestito() {}

    public Prestito(Utente utente, ElementoCatalogo elementoPrestato, LocalDate dataInizio) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizio = dataInizio;
        this.dataRestituzionePrevista = dataInizio.plusDays(30);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Utente getUtente() { return utente; }
    public void setUtente(Utente utente) { this.utente = utente; }

    public ElementoCatalogo getElementoPrestato() { return elementoPrestato; }
    public void setElementoPrestato(ElementoCatalogo elementoPrestato) { this.elementoPrestato = elementoPrestato; }

    public LocalDate getDataInizio() { return dataInizio; }
    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
        this.dataRestituzionePrevista = dataInizio.plusDays(30);
    }

    public LocalDate getDataRestituzionePrevista() { return dataRestituzionePrevista; }
    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) { this.dataRestituzionePrevista = dataRestituzionePrevista; }

    public LocalDate getDataRestituzioneEffettiva() { return dataRestituzioneEffettiva; }
    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) { this.dataRestituzioneEffettiva = dataRestituzioneEffettiva; }
}