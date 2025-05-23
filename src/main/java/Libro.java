import jakarta.persistence.Entity;

@Entity
public class Libro extends ElementoCatalogo {
    private String autore;
    private String genere;

    // Getters e setters
    public String getAutore() { return autore; }
    public void setAutore(String autore) { this.autore = autore; }

    public String getGenere() { return genere; }
    public void setGenere(String genere) { this.genere = genere; }
}