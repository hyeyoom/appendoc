package wiki.appendoc.appendocapi.app.wiki.domain;

public interface WikiDocumentDomainRepository {

    /**
     * @param title document title
     * @return maybe entity
     */
    WikiDocument getByTitle(String title);

    /**
     * @param wikiDocument document entity
     * @return saved entity
     */
    WikiDocument save(WikiDocument wikiDocument);
}
