package wiki.appendoc.appendocapi.app.wiki.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class WikiRevisionId {

    private final String value;

    private WikiRevisionId(String value) {
        this.value = value;
    }

    public static WikiRevisionId getNewId() {
        return new WikiRevisionId(UUID.randomUUID().toString());
    }
}
