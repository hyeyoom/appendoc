package wiki.appendoc.appendocapi.app.wiki.domain;

import java.util.UUID;

public class WikiDocumentId {
    private final String value;

    private WikiDocumentId(String value) {
        this.value = value;
    }

    public static WikiDocumentId getNewId() {
        return new WikiDocumentId(UUID.randomUUID().toString());
    }

    public String getValue() {
        return value;
    }
}
