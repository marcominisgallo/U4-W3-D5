import jakarta.persistence.EntityManager;

public class Archivio {
    private EntityManager em;

    public Archivio(EntityManager em) {
        this.em = em;
    }

    public void aggiungiElemento(ElementoCatalogo elemento) {
        em.getTransaction().begin();
        em.persist(elemento);
        em.getTransaction().commit();
    }

    public void rimuoviElemento(String isbn) {
        em.getTransaction().begin();
        ElementoCatalogo elemento = em.find(ElementoCatalogo.class, isbn);
        if (elemento != null) em.remove(elemento);
        em.getTransaction().commit();
    }

    public ElementoCatalogo cercaPerIsbn(String isbn) {
        return em.find(ElementoCatalogo.class, isbn);
    }
}