package wiki.appendoc.appendocapi.app.wiki.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class WikiDocumentId {
    private final String value;

    private WikiDocumentId(String value) {
        this.value = value;
    }

    public static WikiDocumentId getNewId() {
        return new WikiDocumentId(UUID.randomUUID().toString());
    }

    public static WikiDocumentId of(String value) {
        return new WikiDocumentId(value);
    }
}
