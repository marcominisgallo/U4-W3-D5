import jakarta.persistence.EntityManager;

public class Archivio {
    private ElementoCatalogoDAO elementoDAO;
    private UtenteDAO utenteDAO;
    private PrestitoDAO prestitoDAO;

    public Archivio(EntityManager em) {
        this.elementoDAO = new ElementoCatalogoDAO(em);
        this.utenteDAO = new UtenteDAO(em);
        this.prestitoDAO = new PrestitoDAO(em);
    }

    public void aggiungiElemento(ElementoCatalogo elemento) {
        elementoDAO.save(elemento);
    }

    public void rimuoviElemento(String isbn) {
        elementoDAO.deleteByIsbn(isbn);
    }

    public ElementoCatalogo cercaPerIsbn(String isbn) {
        return elementoDAO.findByIsbn(isbn);
    }

    public void aggiungiUtente(Utente utente) {
        utenteDAO.save(utente);
    }

    public Utente cercaUtente(Long id) {
        return utenteDAO.findById(id);
    }

    public void aggiungiPrestito(Prestito prestito) {
        prestitoDAO.save(prestito);
    }

    public Prestito cercaPrestito(Long id) {
        return prestitoDAO.findById(id);
    }
}