package wiki.appendoc.appendocapi.app.wiki.application.dto;

public class CreateDocumentResponse {

    private final String documentId;

    public CreateDocumentResponse(String documentId) {
        this.documentId = documentId;
    }

    public String getDocumentId() {
        return documentId;
    }
}
