package wiki.appendoc.appendocapi.app.wiki.domain;

import java.time.LocalDateTime;


public class WikiRevision {

    /**
     * 위키 문서 id
     */
    private final WikiDocumentId wikiDocumentId;

    /**
     * 위키 revision id
     */
    private final WikiRevisionId wikiRevisionId;

    /**
     * 작성된 문서
     */
    private final String content;

    /**
     * 문서 작성 시각
     */
    private final LocalDateTime createdDate;

    /**
     * 저자 id
     */
    private final String authorId;

    private WikiRevision(WikiDocumentId wikiDocumentId, WikiRevisionId wikiRevisionId, String content, LocalDateTime createdDate, String authorId) {
        this.wikiDocumentId = wikiDocumentId;
        this.wikiRevisionId = wikiRevisionId;
        this.content = content;
        this.createdDate = createdDate;
        this.authorId = authorId;
    }

    public static WikiRevision of(
            WikiDocumentId wikiDocumentId,
            String content,
            LocalDateTime createdDate,
            String authorId
    ) {
        return new WikiRevision(
                wikiDocumentId,
                WikiRevisionId.getNewId(),
                content,
                createdDate,
                authorId
        );
    }

    public String getContent() {
        return content;
    }

    public String getAuthorId() {
        return authorId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}
