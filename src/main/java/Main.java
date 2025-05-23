import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();

        Archivio archivio = new Archivio(em);

        // Prova Utente
        Utente utente = new Utente();
        utente.setNome("Mario");
        utente.setCognome("Rossi");
        utente.setDataNascita(LocalDate.of(1990, 1, 1));
        utente.setNumeroTessera("T12345");
        archivio.aggiungiUtente(utente);

        // Prova ElementoCatalogo (Libro)
        Libro libro = new Libro();
        libro.setIsbn("1234567898");
        libro.setTitolo("Harry Potter 2");
        libro.setAnnoPubblicazione(2001);
        libro.setNumeroPagine(450);
        libro.setAutore("J.K. Rowling");
        libro.setGenere("Fantasy");
        archivio.aggiungiElemento(libro);

        // Prova Prestito
        Prestito prestito = new Prestito();
        prestito.setUtente(utente);
        prestito.setElementoPrestato(libro);
        prestito.setDataInizio(LocalDate.now());
        prestito.setDataRestituzionePrevista(LocalDate.now().plusDays(30));
        archivio.aggiungiPrestito(prestito);

        em.close();
        emf.close();
    }
}