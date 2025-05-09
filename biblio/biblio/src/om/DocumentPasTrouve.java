package om;

public class DocumentPasTrouve extends BiblioException {
    private static final long serialVersionUID = 1L;
    private String index;

    public DocumentPasTrouve(Bibliotheque bibliotheque, String index) {
        super(bibliotheque);
        this.index = index;
    }

    @Override
    public String toString() {
        return "Aucun document trouvé pour l'index : \"" + index + "\" dans la bibliothèque \"" + bibliotheque.getNom() + "\".";
    }
}
