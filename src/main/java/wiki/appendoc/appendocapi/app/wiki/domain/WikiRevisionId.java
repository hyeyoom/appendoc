package wiki.appendoc.appendocapi.app.wiki.domain;

import java.util.UUID;

public class WikiRevisionId {

    private final String value;

    private WikiRevisionId(String value) {
        this.value = value;
    }

    public static WikiRevisionId getNewId() {
        return new WikiRevisionId(UUID.randomUUID().toString());
    }
}
