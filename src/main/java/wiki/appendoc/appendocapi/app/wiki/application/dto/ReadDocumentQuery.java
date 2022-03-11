package wiki.appendoc.appendocapi.app.wiki.application.dto;

public class ReadDocumentQuery {

    private final String title;

    public ReadDocumentQuery(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
