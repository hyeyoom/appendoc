package wiki.appendoc.appendocapi.app.wiki.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WikiDocument {

    private final WikiDocumentId wikiDocumentId;
    private final String title;
    private final LocalDateTime createdDate;
    private final List<WikiRevision> revisions;

    public WikiDocument(WikiDocumentId wikiDocumentId, String title, LocalDateTime createdDate, List<WikiRevision> revisions) {
        this.wikiDocumentId = wikiDocumentId;
        this.title = title;
        this.createdDate = createdDate;
        this.revisions = revisions;
    }

    public static WikiDocument createNewDocument(
            String title,
            String content,
            String authorId,
            LocalDateTime createdDate
    ) {
        final WikiDocumentId newDocumentId = WikiDocumentId.getNewId();
        final WikiRevision newRevision = WikiRevision.of(
                newDocumentId,
                content,
                createdDate,
                authorId
        );

        final List<WikiRevision> revisions = new ArrayList<>();
        revisions.add(newRevision);

        return new WikiDocument(
                newDocumentId,
                title,
                createdDate,
                revisions
        );
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public WikiDocumentId getWikiDocumentId() {
        return wikiDocumentId;
    }

    public WikiRevision getLatestRevision() {
        final int size = revisions.size();
        if (size != 0) {
            return revisions.get(size - 1);
        }
        return null;
    }
}
