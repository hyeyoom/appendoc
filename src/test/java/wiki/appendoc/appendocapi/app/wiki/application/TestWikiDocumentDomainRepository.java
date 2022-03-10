package wiki.appendoc.appendocapi.app.wiki.application;

import wiki.appendoc.appendocapi.app.wiki.domain.WikiDocument;
import wiki.appendoc.appendocapi.app.wiki.domain.WikiDocumentDomainRepository;
import wiki.appendoc.appendocapi.app.wiki.domain.WikiDocumentId;

import java.util.HashMap;
import java.util.Map;

public class TestWikiDocumentDomainRepository implements WikiDocumentDomainRepository {

    private final Map<WikiDocumentId, WikiDocument> db = new HashMap<>();

    @Override
    public WikiDocument getByTitle(String title) {
        for (Map.Entry<WikiDocumentId, WikiDocument> entry : db.entrySet()) {
            if (entry.getValue().getTitle().equals(title)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public WikiDocument save(WikiDocument wikiDocument) {
        return db.put(wikiDocument.getWikiDocumentId(), wikiDocument);
    }
}
