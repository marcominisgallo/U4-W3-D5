import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();

        Archivio archivio = new Archivio(em);


        Libro libro = new Libro();
        libro.setIsbn("1234567899");
        libro.setTitolo("Harry Potter");
        libro.setAnnoPubblicazione(2001);
        libro.setNumeroPagine(450);
        libro.setAutore("J.K. Rowling");
        libro.setGenere("Fantasy");
        archivio.aggiungiElemento(libro);


        ElementoCatalogo trovato = archivio.cercaPerIsbn("1234567899");
        if (trovato != null) {
            System.out.println("Trovato: " + trovato.getTitolo());
        }

        // archivio.rimuoviElemento("1234567890");

        em.close();
        emf.close();
    }
}