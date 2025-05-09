package om;

import java.io.Serializable;

public class BiblioException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Bibliotheque bibliotheque;

    public BiblioException(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public Bibliotheque getBibliotheque() {
        return bibliotheque;
    }
}
