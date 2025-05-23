import jakarta.persistence.EntityManager;

public class ElementoCatalogoDAO {
    private EntityManager em;

    public ElementoCatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(ElementoCatalogo elemento) {
        em.getTransaction().begin();
        em.persist(elemento);
        em.getTransaction().commit();
    }

    public ElementoCatalogo findByIsbn(String isbn) {
        return em.find(ElementoCatalogo.class, isbn);
    }

    public void deleteByIsbn(String isbn) {
        em.getTransaction().begin();
        ElementoCatalogo elemento = em.find(ElementoCatalogo.class, isbn);
        if (elemento != null) em.remove(elemento);
        em.getTransaction().commit();
    }
}